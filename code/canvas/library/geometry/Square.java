package canvas.library.geometry;

public class Square extends Rectangle
{
    public Square() {
        super();
    }

    public Square(int width, int height) {
        this(0, 0, width, height);
    }

    public Square(Point point, Dimension dimension) {
        this(point.x, point.y, dimension.width, dimension.height);
    }

    public Square(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
