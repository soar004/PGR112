package solutions._09;

public class Square extends Rectangle
{
    //# Constructors
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    //# Getter
    public double getSide() {
        return this.getWidth();
    }

    //# Setter
    private void setSide(double side) {
        this.setWidth(side);
        this.setHeight(side);
    }

    //# Methods
    @Override
    public String toString() {
        return super.toString().replaceFirst("Rectangle", "Rectangle => Square");
    }

    //# Unik metode for kvadrater
    public void uniqueSquareMethod() {
        System.out.println("Jeg er et kvadrat (firkant)!");
    }
}
