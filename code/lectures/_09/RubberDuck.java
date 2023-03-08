package lectures._09;

public class RubberDuck implements Animal
{
    //# Fields
    private String color;
    private boolean eyelashes;
    private boolean makesSound;

    //# Constructors
    public RubberDuck() {
        this("yellow", true, true);
    }

    public RubberDuck(boolean eyelashes) {
        this("yellow", eyelashes, true);
    }

    public RubberDuck(String color, boolean eyelashes, boolean makesSound) {
        this.setColor(color);
        this.setEyelashes(eyelashes);
        this.setMakesSound(makesSound);
    }

    //# Getter-methods
    public String getColor() {
        return this.color;
    }

    public boolean hasEyelashes() {
        return this.eyelashes;
    }

    public boolean doesMakeSound() {
        return this.makesSound;
    }

    //# Setter-methods
    private void setEyelashes(boolean value) {
        this.eyelashes = value;
    }

    private void setColor(String value) {
        this.color = value;
    }

    private void setMakesSound(boolean value) {
        this.makesSound = value;
    }

    //# Methods
    @Override
    public String toString() {
        return "Duck";
    }

    @Override
    public void makesSound() {
        System.out.println("Jeg er en and");

        System.out.println();
    }


}
