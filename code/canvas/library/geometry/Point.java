package canvas.library.geometry;

public class Point extends java.awt.Point implements Movable
{
    //# Constructors
    public Point() {
        super(0, 0);
    }

    public Point(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void moveX(int x) {
        this.move(x, 0);
    }

    public void moveY(int y) {
        this.move(0, y);
    }
}
