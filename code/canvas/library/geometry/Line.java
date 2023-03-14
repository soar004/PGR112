package canvas.library.geometry;

public class Line extends Shape
{
    public Line() {
        super(2);
    }

    public Line(int x0, int y0, int x1, int y1) {
        this(new Point(x0, y0), new Point(x1, y1));
    }

    public Line(Point A, Point B) {
        super(A, B);
    }

    public double getLength() {
        return Math.sqrt(this.getLengthSquared());
    }

    public double getLengthSquared() {
        return (this.points[1].x - this.points[0].x)*2 + (this.points[1].y - this.points[0].y)*2;
    }

    @Override
    public void draw(java.awt.Graphics2D graphics) {
        graphics.drawLine(
                this.points[0].x, this.points[0].y,
                this.points[1].x, this.points[1].y
        );
    }
}
