package canvas.sandbox;

import canvas.API;
import canvas.Plugin;
import canvas.library.resource.Color;


public class Example extends Plugin
{
    public void render(API canvas) {
        canvas.setColor(Color.RED);
        canvas.drawText("Kristiania", canvas.getCenterPoint());
    }
}
