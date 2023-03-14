package canvas.library.geometry;

public class Polygon extends Shape
{
    public Polygon(int vertices) {
        super(vertices);
    }

    public Polygon(Point... points) {
        super(points);
    }
}
