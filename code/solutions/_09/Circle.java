package solutions._09;

public class Circle extends Shape
{
    //# Fields
    private double radius;
    private MovablePoint center;

    //# Constructors
    public Circle() {
        this(1.0, new MovablePoint(0.0, 0.0));
    }

    public Circle(double radius, MovablePoint center) {
        super();

        this.setRadius(radius);
        this.setCenter(center);
    }

    //# Getter-methods
    public double getRadius() {
        return this.radius;
    }

    public MovablePoint getCenter() {
        return this.center;
    }

    //# Setter-methods
    private void setRadius(double value) {
        this.radius = value;
    }

    private void setCenter(MovablePoint point) {
        this.center = point;
    }

    //# Methods
    @Override
    public double getArea() {
        return (2*radius)*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*this.getRadius();
    }

    @Override
    public String toString() {
        return String.format(
                "%s => Circle[radius=%f; center=%s;]",
                super.toString(), this.getRadius(), this.getCenter()
        );
    }

    @Override
    public void moveUp(double distance) {
        this.getCenter().moveUp(distance);
    }

    @Override
    public void moveDown(double distance) {
        this.getCenter().moveDown(distance);
    }

    @Override
    public void moveLeft(double distance) {
        this.getCenter().moveLeft(distance);
    }

    @Override
    public void moveRight(double distance) {
        this.getCenter().moveRight(distance);
    }


    //# Unik metode for sirkler
    public void uniqueCircleMethod() {
        System.out.println("Jeg er en sirkel!");
    }
}
