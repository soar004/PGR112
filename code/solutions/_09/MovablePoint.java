package solutions._09;

public class MovablePoint implements Movable
{
    //# Fields
    private double x;
    private double y;

    //# Constructors
    public MovablePoint() {
        this(0.0, 0.0);
    }

    public MovablePoint(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    //# Getter-methods
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    //# Setter-methods
    private void setX(double value) {
        this.x = value;
    }

    private void setY(double value) {
        this.y = value;
    }

    //# Methods
    @Override
    public void moveUp(double distance) {
        this.setY(this.getY() + distance);
    }

    @Override
    public void moveDown(double distance) {
        this.setY(this.getY() - distance);
    }

    @Override
    public void moveLeft(double distance) {
        this.setX(this.getX() - distance);
    }

    @Override
    public void moveRight(double distance) {
        this.setY(this.getX() + distance);
    }

    @Override
    public String toString() {
        return String.format(
            "MovablePoint[x=%f; y=%f;]",
            this.getX(), this.getY()
        );
    }
}
