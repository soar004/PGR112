package canvas;

import canvas.library.geometry.Anchor;
import canvas.library.geometry.Point;
import canvas.library.geometry.Shape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class API {
    //# Fields
    private Frame window;
    Canvas canvas;
    private Graphics2D graphics = null;
    private Cache<BufferedImage> images = new Cache<>();

    public static Font defaultFont = new Font(
            "Consolas",
            Font.PLAIN,
            24
    );
    public static Color defaultTextColor = Color.BLACK;
    public static Color defaultBackgroundColor = Color.WHITE;

    public static void setDefaultFont(Font font) {
        API.defaultFont = font;
    }

    public static void setDefaultTextColor(Color color) {
        API.defaultTextColor = color;
    }


    public API(Frame window, Canvas canvas) {
        this.window = window;
        this.canvas = canvas;

        Program.log("API", "Initialized API for Window containing Canvas");
    }

    //# State
    private boolean fillMode = false;

    public Graphics2D getGraphics() {
        return this.graphics;
    }

    public void setGraphics(Graphics2D value) {
        this.graphics = value;
    }

    //# Canvas-related helper methods

    public int getWidth() {
        return this.canvas.getWidth();
    }

    public int getHeight() {
        return this.canvas.getHeight();
    }

    public int getHalfWidth() {
        return (int)(this.getWidth()/2.0f);
    }

    public int getHalfHeight() {
        return (int)(this.getHeight()/2.0f);
    }

    public Point getCenterPoint() {
        return new Point(this.getHalfWidth(), this.getHalfHeight());
    }

    public Point getRandomPoint() {
        return new Point(
                (int)(Math.random()*(this.getWidth() + 1)),
                (int)(Math.random()*(this.getHeight() + 1))
        );
    }

    //-------------------------------------------------------------------------
    public void setFillMode() {
        this.fillMode = true;
    }

    public void setFillMode(boolean value) {
        this.fillMode = value;
    }

    public void clearFillMode() {
        this.fillMode = false;
    }

    //-------------------------------------------------------------------------
    public void draw(Shape shape) {
        shape.draw(this.getGraphics(), this.fillMode);
    }


    public BufferedImage getImage(String fileName) {
        if (!images.data.containsKey(fileName)) {
            try {
                images.data.put(
                        fileName,
                        ImageIO.read(
                                new File("%s".formatted(fileName))
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return images.data.get(fileName);
    }

    //# IMAGE (PART)
    public void drawImagePart(String fileName, java.awt.Point point, Rectangle part, Anchor anchor) {
        this.drawImagePart(this.getImage(fileName), point, part, anchor);
    }

    public void drawImagePart(BufferedImage image, java.awt.Point point, Rectangle part, Anchor anchor) {
        float[] scale = Anchor.transform(anchor);

        int offsetX = (int)(part.width  * scale[0]);
        int offsetY = (int)(part.height * scale[1]);

        System.out.println(part);

        this.graphics.drawImage(
                image,
                point.x - offsetX,
                point.y - offsetY,
                point.x - offsetX + part.width,
                point.y - offsetY + part.height,

                part.x,
                part.y,
                part.x + part.width,
                part.y + part.height,

                null
        );
    }

    //# IMAGE
    public void drawImage(String fileName, java.awt.Point point, Anchor anchor) {
        BufferedImage image = this.getImage(fileName);

        float[] transform = Anchor.transform(anchor);

        int imageX = Math.max(0, point.x - (int)(image.getWidth()*transform[0]));
        int imageY = Math.max(0, point.y - (int)(image.getHeight()*transform[1]));

        this.graphics.drawImage(
                image,
                imageX,
                imageY,
                null
        );
    }

    public void drawImage(String fileName, int x, int y, Anchor anchor) {
        this.drawImage(fileName, new Point(x, y), anchor);
    }

    public void drawImage(String fileName, int x, int y) {
        this.drawImage(fileName, x, y, Anchor.TOP_LEFT);
    }

    //# IMAGE RELATIVE
    public void drawImage(String fileName, float x, float y, Anchor anchor) {
        this.drawImage(
                fileName,
                (int)(this.canvas.getWidth()*x),
                (int)(this.canvas.getHeight()*y), anchor);
    }

    public void drawImage(String fileName, float x, float y) {
        this.drawImage(fileName, x, y, Anchor.TOP_LEFT);
    }

    //# TEXT
    public void drawText(Font font, String text, int x, int y, Anchor anchor) {
        this.drawText(font, text, new Point(x, y), anchor);
    }

    public void drawText(String text, Point point) {
        this.drawText(text, point, Anchor.CENTER);
    }

    public void drawText(Font font, String text, Point point, Anchor anchor) {
        float[] transform = Anchor.transform(anchor);

        this.graphics.setFont(font);

        int textWidth = this.graphics.getFontMetrics().stringWidth(text);
        int textX = Math.max(0, point.x - (int)(textWidth*transform[0]));

        this.graphics.drawString(text, textX, point.y);

        this.graphics.setFont(API.defaultFont);
    }

    public void drawText(Font font, String text, int x, int y) {
        this.drawText(font, text, x, y, Anchor.CENTER);
    }

    public void drawText(String text, Point point, Anchor anchor) {
        this.drawText(API.defaultFont, text, point, anchor);
    }

    public void drawText(String text, int x, int y, Anchor anchor) {
        drawText(API.defaultFont, text, x, y, anchor);
    }

    public void drawText(String text, int x, int y) {
        this.drawText(API.defaultFont, text, x, y);
    }

    //# TEXT RELATIVE
    public void drawText(Font font, String text, float x, float y, Anchor anchor) {
        this.drawText(font, text, (int)(this.canvas.getWidth()*x), (int)(this.canvas.getHeight()*y), anchor);
    }

    public void drawText(Font font, String text, float x, float y) {
        this.drawText(font, text, x, y, Anchor.CENTER);
    }

    public void drawText(String text, float x, float y) {
        this.drawText(API.defaultFont, text, x, y);
    }


    //-------------------------------------------------------------------------
    //# Cache
    private static class Cache<T> {
        private HashMap<String, T> data = new HashMap<>();
    }
}
