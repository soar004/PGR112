package solutions._09;

public class Rectangle extends Shape
{
    //# Fields
    private double width;
    private double height;

    private MovablePoint topCorner;         // top left
    private MovablePoint bottomCorner;      // bottom right

    //# Constructors
    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double width, double height) {
        this(width, height, new MovablePoint(0.0, 0.0), new MovablePoint(width, height));
    }

    public Rectangle(double width, double height, MovablePoint topCorner, MovablePoint bottomCorner) {
        this.setWidth(width);
        this.setHeight(height);

        this.setTopCorner(topCorner);
        this.setBottomCorner(bottomCorner);
    }


    //# Getter-methods
    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public MovablePoint getTopCorner() {
        return this.topCorner;
    }

    public MovablePoint getBottomCorner() {
        return this.bottomCorner;
    }

    //# Setter-methods
    protected void setWidth(double value) {
        this.width = value;
    }

    protected void setHeight(double value) {
        this.height = value;
    }

    private void setTopCorner(MovablePoint point) {
        this.topCorner = point;
    }

    private void setBottomCorner(MovablePoint point) {
        this.bottomCorner = point;
    }

    //# Methods
    @Override
    public double getArea() {
        return this.getWidth()*this.getHeight();
    }

    @Override
    public double getPerimeter() {
        return 2*(this.getWidth() + this.getHeight());
    }

    @Override
    public String toString() {
        return String.format(
            "%s => Rectangle[width=%f; height=%f; topCorner=%s; bottomCorner=%s;]",
            super.toString(), this.getWidth(), this.getWidth(), this.getTopCorner(), this.getBottomCorner()
        );
    }

    @Override
    public void moveUp(double distance) {
        this.getTopCorner().moveUp(distance);
        this.getBottomCorner().moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        this.getTopCorner().moveDown(distance);
        this.getBottomCorner().moveDown(distance);
    }

    @Override
    public void moveLeft(double distance) {
        this.getTopCorner().moveLeft(distance);
        this.getBottomCorner().moveLeft(distance);
    }

    @Override
    public void moveRight(double distance) {
        this.getTopCorner().moveRight(distance);
        this.getBottomCorner().moveRight(distance);
    }

    //# Unik metode for rektangler
    public void uniqueRectangleMethod() {
        System.out.println("Jeg er et rektangel (firkant)!");
    }
}
