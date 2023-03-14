package canvas.library.geometry;

import java.util.Arrays;

public class Rectangle extends Shape
{
    public Point position;
    public Dimension size;

    public Rectangle() {
        super(4);

        this.position = new Point();
        this.size = new Dimension();
    }

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle(Point point, Dimension dimension) {
        this(point.x, point.y, dimension.width, dimension.height);
    }

    public Rectangle(int x, int y, int width, int height) {
        super(
                new Point(x, y),
                new Point(x + width, y),
                new Point(x + width, y + height),
                new Point(x, y + height)
        );

        this.position = this.points[0];
        this.size = new Dimension(width, height);
    }

    public int getX() {
        return this.position.x;
    }

    public int getY() {
        return this.position.y;
    }

    public int getWidth() {
        return this.size.width;
    }

    public int getHeight() {
        return this.size.height;
    }

    @Override
    public void draw(java.awt.Graphics2D graphics, boolean filled) {
        if (filled) {
            graphics.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }
}
