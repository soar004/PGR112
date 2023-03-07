package solutions._08;



public class Square extends Rectangle
{
    //# Constructors
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
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
    /*
     * På lik linje som vi gjorde i Circle og Rectangle,
     * bruker vi her super for å hente Rectangle sin toString() metode.
     *
     * I og med at kvadrater kan teknisk sett sees på som et rektangel
     * hvor både bredde og høyde er den samme, så kan vi bruke
     * tekstrepresentasjonen til Rectangle, hvor vi kan gjøre en liten endring:
     *
     * .replaceWith(...) som du ser under bruker jeg her
     * for å "pynte" på outputten, slik at vi justerer Rectangle sin toString()
     * til å vise til at Square arvet fra Rectangle.
     *
     *
     */
    @Override
    public String toString() {
        return super.toString()
                .replaceFirst("Rectangle", "Rectangle => Square");
    }
}
