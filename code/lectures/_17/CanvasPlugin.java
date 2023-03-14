package lectures._17;

import canvas.API;
import canvas.Plugin;
import canvas.Program;

public class CanvasPlugin  extends Plugin {

    public static void main(String[] args) {
        Program.run(new CanvasPlugin());
    }

    public void render(API canvas) {
        canvas.drawText("Forelesning 17", 100, 100);
    }
}
