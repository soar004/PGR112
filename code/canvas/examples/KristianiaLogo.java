package canvas.examples;

import canvas.API;
import canvas.Plugin;
import canvas.Program;
import canvas.library.geometry.Anchor;


public class KristianiaLogo extends Plugin
{
    public static void main(String[] args) {
        Program.run(new KristianiaLogo());
    }

    public void render(API canvas) {
        canvas.drawImage("files/kristiania/logo.png", canvas.getCenterPoint(), Anchor.CENTER);
    }
}
