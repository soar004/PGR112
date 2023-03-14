package canvas.library.geometry;

public class Ellipse extends Rectangle
{
    public Ellipse() {
        super();
    }

    public Ellipse(int width, int height) {
        this(0, 0, width, height);
    }

    public Ellipse(Point point, Dimension dimension) {
        this(point.x, point.y, dimension.width, dimension.height);
    }

    public Ellipse(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(java.awt.Graphics2D graphics, boolean filled) {
        if (filled) {
            graphics.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
        else {
            graphics.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }
}
