package canvas.library.geometry;

public class Triangle extends Shape
{
    public Triangle() {
        super(3);
    }

    public Triangle(Point A, Point B, Point C) {
        super(A, B, C);
    }
}
