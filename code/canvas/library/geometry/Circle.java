package canvas.library.geometry;

public class Circle extends Shape
{
    private static Anchor anchor = Anchor.CENTER;

    public Point position;
    public int radius;

    public Circle() {
        super(1);

        this.position = this.points[0];
        this.radius = 0;
    }

    public Circle(Point point, int radius) {
        super(point);

        this.position = point;
        this.radius = radius;
    }

    @Override
    public void draw(java.awt.Graphics2D graphics, boolean filled) {
        float[] transform = Anchor.transform(Circle.anchor);

        if (filled) {
            graphics.fillOval(
                    (int)(this.position.x - (this.radius*2)*transform[0]),
                    (int)(this.position.y - (this.radius*2)*transform[1]),
                    this.radius*2,
                    this.radius*2
            );
        }
        else {
            graphics.drawOval(
                    (int)(this.position.x - (this.radius*2)*transform[0]),
                    (int)(this.position.y - (this.radius*2)*transform[1]),
                    this.radius*2,
                    this.radius*2
            );
        }
    }
}
