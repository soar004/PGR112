package solutions._08;

public class Circle extends Shape
{
    //# Fields
    private double radius;

    //# Constructors
    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        super();

        this.setRadius(radius);
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);

        this.setRadius(radius);
    }

    //# Getter-methods
    public double getRadius() {
        return this.radius;
    }

    //# Setter-methods
    protected void setRadius(double value) {
        this.radius = value;
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

    /*
     * Her brukes super.toString() for å hente ut tekst-representasjonen
     * fra klassen som det arves fra, i dette tilfelle: Shape
     *
     * Selv om vi overskriver toString() her, så kan vi alltids
     * referere til metoden vi originalt arvet fra ved å referere
     * dirkete til denne hos klassen vi arvet fra via super
     */
    @Override
    public String toString() {
        return String.format(
                "%s => Circle[radius=%f;]",
                super.toString(), this.getRadius()
        );
    }
}

