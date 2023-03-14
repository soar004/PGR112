package canvas;

import canvas.library.geometry.Dimension;
import canvas.library.gui.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Program implements Runnable
{
    public static Dimension size = new Dimension(640, 480);

    private BufferStrategy buffer;
    private API outerface;
    private final HashMap<String, Plugin> plugins = new HashMap<>();
    private boolean active;

    private Program() {
        // Folders to load classes from
        ArrayList<String> folders = new ArrayList<>();

        folders.add("code/canvas/sandbox");

        // Get student username and add personal student folder
        File settings = new File("files/local/student.txt");

        if (!settings.exists()) {
            Scanner input = new Scanner(System.in);

            System.out.println("Hva er student brukernavnet ditt?");
            String username = input.nextLine();

            try {
                if (settings.createNewFile()) {
                    FileWriter writer = new FileWriter(settings);

                    writer.write(username);

                    writer.close();
                }
            } catch (IOException e) {
                Program.log("Launcher", "Could not create settings file to store student username");

                throw new RuntimeException(e);
            }
        }

        try (Scanner file = new Scanner(settings)) {
            if (file.hasNextLine()) {
                String student = file.nextLine();

                if (student.length() > 0) {
                    File folder = new File("student/%s/canvas".formatted(student));

                    if (!folder.exists()) {
                        if (folder.mkdir()) {
                            File example = new File("student/%s/canvas/Example.java");

                            if (example.createNewFile()) {
                                FileWriter java = new FileWriter(example);

                                String[] lines = new String[]{
                                        "package %s.canvas;".formatted(student),
                                        "",
                                        "import canvas.API;",
                                        "import canvas.Plugin;",
                                        "",
                                        "",
                                        "public class Example extends Plugin",
                                        "{",
                                        "    public render(API canvas) {",
                                        "        // programkode skrevet av %s".formatted(student),
                                        "    }",
                                        "}"
                                };

                                for (String line : lines) {
                                    java.write("%s%n".formatted(line));
                                }

                                java.close();
                            }
                        }
                    }

                    folders.add(folder.getPath().replaceAll("\\\\", "/"));
                }
            }
        } catch (FileNotFoundException e) {
            Program.log("Launcher", "Could not locate student username from disk");

            e.printStackTrace();
        } catch (IOException e) {
            Program.log("Launcher", "Could not create example file in student canvas folder");

            e.printStackTrace();
        }

        Program.log("Launcher", "Loading classes from following directories:");

        // Load classes to be rendered
        for (String folder : folders) {
            Program.log("Launcher", "-- %s".formatted(folder));

            try {
                File classes = new File(folder);

                Optional<File[]> files = Optional.ofNullable(classes.listFiles());

                if (files.isPresent()) {
                    for (File file : files.get()) {
                        if (file.isFile()) {
                            String fileName = file.getName();

                            if (fileName.endsWith(".java")) {
                                String className = fileName.substring(0, fileName.length() - 5);
                                String packageName = folder
                                        .replaceAll("code.", "")
                                        .replaceAll("student.", "")
                                        .replaceAll("/", ".");

                                Class<?> cls = Class.forName(
                                        "%s.%s".formatted(
                                                packageName,
                                                className
                                        )
                                );

                                Object plugin = cls.getDeclaredConstructor().newInstance();

                                Program.log(
                                        "Plugin",
                                        "- Loaded class \"%s\" from \"%s\"".formatted(
                                                className, packageName
                                        ));

                                this.plugins.put(
                                        "%s.%s".formatted(packageName, className),
                                        (Plugin) plugin
                                );
                            }
                        } else {
                            Program.log("Launcher", "Found sub-folder that may contain plugins");

                            // TODO: add support for sub-folders containing classes
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        this.GUI();
    }

    private Program(Plugin plugin) {
        this.plugins.put(plugin.toString(), plugin);

        this.GUI();
    }

    private void GUI() {
        Frame window = new Window("PGR112 23V", this);
        window.setVisible(true);
        window.setAlwaysOnTop(true);
        window.setSize(Program.size);

        Insets margin = window.getInsets();

        window.setSize(
                Program.size.width + margin.left + margin.right,
                window.getSize().height + margin.top + margin.bottom
        );

        Canvas canvas = new Canvas();
        canvas.setIgnoreRepaint(true);
        canvas.setPreferredSize(Program.size);
        canvas.setSize(Program.size);

        window.add(canvas);

        canvas.createBufferStrategy(2);
        this.buffer = canvas.getBufferStrategy();

        canvas.requestFocus();

        Program.log("Launcher", "Displaying GUI ...");

        this.outerface = new API(window, canvas);

        this.start();
    }

    public void run() {
        while (this.active) {
           this.render();

           try {
               // TODO better looping, currently -ish 10 FPS
               // make use of EventQueue, sync lock and delta time
               Thread.sleep(100);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        }
    }

    public void pause() {
        this.active = false;
    }

    public void start() {
        this.active = true;
    }

    private void render() {
        Graphics2D graphics = (Graphics2D) this.buffer.getDrawGraphics();

        this.render(graphics);

        graphics.dispose();
        this.buffer.show();
    }

    private void render(Graphics2D graphics) {
        this.outerface.setGraphics(graphics);

        graphics.clearRect(
                0,
                0,
                this.outerface.canvas.getWidth(),
                this.outerface.canvas.getHeight()
        );

        for (Plugin plugin : this.plugins.values()) {
            plugin.render(this.outerface);
        }
    }

    public static void run(Plugin plugin) {
        Program program = new Program(plugin);

        new Thread(program).start();
    }

    public static void main(String[] args) {
        Program program = new Program();

        new Thread(program).start();
    }

    //# Helper methods
    public static void log(String context, String message) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        String timestamp = time.toString();

        System.out.printf(
                "[%s][%s][%s]: %s%n",
                date,
                timestamp.substring(0, timestamp.indexOf('.')),
                context,
                message
        );
    }
}
