package canvas;

import canvas.library.geometry.Anchor;
import canvas.library.geometry.Point;
import canvas.library.geometry.Shape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
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

    //# COLOR
    public void setColor(Color color) {
        this.graphics.setColor(color);
    }

    public void clearColor() {
        this.graphics.setColor(API.defaultTextColor);
    }

    public void setBackgroundColor(Color color) {
        API.defaultBackgroundColor = color;
    }

    //# SHAPES
    public void drawTriangle(int... coordinates) {
        assert coordinates.length == 6;

        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(coordinates[0], coordinates[1]));
        points.add(new Point(coordinates[2], coordinates[3]));
        points.add(new Point(coordinates[4], coordinates[5]));

        this.drawTriangle(points);
    }

    public void drawTriangle(ArrayList<? extends Point> points) {
        if (this.isFillMode()) {
            this.graphics.drawPolygon(
                    new int[] {
                            points.get(0).x,
                            points.get(1).x,
                            points.get(2).x,
                            points.get(0).x
                    },
                    new int[] {
                            points.get(0).y,
                            points.get(1).y,
                            points.get(2).y,
                            points.get(0).y
                    },
                    4
            );
        }
        else {
            this.graphics.drawPolyline(
                    new int[]{
                            points.get(0).x,
                            points.get(1).x,
                            points.get(2).x,
                            points.get(0).x
                    },
                    new int[]{
                            points.get(0).y,
                            points.get(1).y,
                            points.get(2).y,
                            points.get(0).y
                    },
                    4
            );
        }
    }

    public void drawSquare(Point point, int size, Anchor anchor) {
        this.drawRectangle(point, new Dimension(size, size), anchor);
    }

    public void drawSquare(Point point, int size) {
        this.drawRectangle(point, new Dimension(size, size));
    }

    public void drawRectangle(Rectangle r, Anchor anchor) {
        this.drawRectangle(new Point(r.x, r.y), new Dimension(r.width, r.height), anchor);
    }

    public void drawRectangle(Rectangle r) {
        this.drawRectangle(new Point(r.x, r.y), new Dimension(r.width, r.height), Anchor.CENTER);
    }

    public void drawRectangle(Point point, Dimension size) {
        this.drawRectangle(point, size, Anchor.CENTER);
    }

    public void drawRectangle(Point point, int w, int h) {
        this.drawRectangle(point, new Dimension(w, h));
    }

    public void drawRectangle(int x, int y, int w, int h) {
        this.drawRectangle(new Point(x, y), new Dimension(w, h), Anchor.CENTER);
    }

    public void drawRectangle(Point point, Dimension size, Anchor anchor) {
        float[] transform = Anchor.transform(anchor);

        if (this.isFillMode()) {
            this.graphics.fillRect(
                    (int)(point.x - (size.width*transform[0])),
                    (int)(point.y - (size.height*transform[1])),
                    size.width,
                    size.height
            );
        }
        else {
            this.graphics.drawRect(
                    (int)(point.x - (size.width*transform[0])),
                    (int)(point.y - (size.height*transform[1])),
                    size.width,
                    size.height
            );
        }
    }

    public void drawCross(int x, int y, float r) {
        this.drawCross(new Point(x, y), r);
    }

    public void drawCross(Point p, float r) {
        this.drawCross(p, r, Anchor.CENTER);
    }

    public void drawCross(Point p, float r, Anchor anchor) {
        double angle = Math.PI/4.0d;

        this.drawLine(
                p.x - (int)(Math.cos(angle)*r),
                p.y - (int)(Math.sin(angle)*r),

                p.x - (int)(Math.cos(angle + Math.PI)*r),
                p.y - (int)(Math.sin(angle + Math.PI)*r)
        );

        this.drawLine(
                p.x - (int)(Math.cos(angle + Math.PI/2)*r),
                p.y - (int)(Math.sin(angle + Math.PI/2)*r),

                p.x - (int)(Math.cos(angle - Math.PI/2)*r),
                p.y - (int)(Math.sin(angle - Math.PI/2)*r)
        );
    }


    public void drawCircle(int x, int y, float r) {
        this.drawCircle(new Point(x, y), r);
    }

    public void drawCircle(Point p, float r) {
        this.drawCircle(p, r, Anchor.CENTER);
    }

    public void drawCircle(Point p, float r, Anchor anchor) {
        float[] transform = Anchor.transform(anchor);

        if (this.isFillMode()) {
            this.graphics.fillOval(
                    (int)(p.x - ((r*2)*transform[0])),
                    (int)(p.y - ((r*2)*transform[1])),
                    (int)(r * 2),
                    (int)(r * 2)
            );
        }
        else {
            this.graphics.drawOval(
                    (int)(p.x - ((r*2)*transform[0])),
                    (int)(p.y - ((r*2)*transform[1])),
                    (int)(r * 2),
                    (int)(r * 2)
            );
        }
    }

    private boolean isFillMode() {
        return this.fillMode;
    }

    public void drawLine(int startX, int startY, int endX, int endY) {
        this.drawLine(new Point(startX, startY), new Point(endX, endY));
    }

    public void drawLine(float startX, float startY, float endX, float endY) {
        this.drawLine(
                (int)(this.getWidth()*startX),
                (int)(this.getHeight()*startY),
                (int)(this.getWidth()*endX),
                (int)(this.getHeight()*endY)
        );
    }

    public void drawLine(java.awt.Point start, java.awt.Point end) {
        this.graphics.drawLine(
                start.x,
                start.y,
                end.x,
                end.y
        );
    }


    public void drawArrow(int startX, int startY, int endX, int endY) {
        this.drawArrow(new Point(startX, startY), new Point(endX, endY));
    }

    public void drawArrow(Point start, Point end) {
        this.drawLine(start, end);

        float angle = this.getAngle(end, start);
        ArrayList<Point> triangle = new ArrayList<>();

        triangle.add(end);
        triangle.add(new Point(
                (int)(end.x - Math.cos(angle + Math.PI/4.0d)*16),
                (int)(end.y - Math.sin(angle + Math.PI/4.0d)*16)
        ));
        triangle.add(new Point(
                (int)(end.x - Math.cos(angle - Math.PI/4.0d)*16),
                (int)(end.y - Math.sin(angle - Math.PI/4.0d)*16)
        ));

        this.setFillMode();
        this.drawTriangle(triangle);
        this.clearFillMode();
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

    //# Helper methods
    public float getAngle(java.awt.Point A, java.awt.Point B) {
        return (float) Math.atan2(A.y - B.y, A.x - B.x);
    }

    //-------------------------------------------------------------------------
    //# Cache
    private static class Cache<T> {
        private HashMap<String, T> data = new HashMap<>();
    }
}
