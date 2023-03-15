package canvas.examples;

import canvas.API;
import canvas.Plugin;
import canvas.Program;
import canvas.library.resource.Color;

public class BackgroundColor extends Plugin
{
    public static void main(String[] args) {
        Program.run(new BackgroundColor());
    }

    public void render(API canvas) {
        canvas.setBackgroundColor(Color.RED);
    }
}
