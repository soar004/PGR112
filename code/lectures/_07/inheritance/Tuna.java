package lectures._07.inheritance;

public class Tuna extends Fish
{
    private String name;

    public Tuna(String name) {
        super("Tuna");

        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String value) {
        this.name = value;
    }

    public void sayName() {
        this.makeFishSay("My name is " + this.getName() + "!");
    }

    public static void main(String[] args) {
        Fish tuna1 = new Tuna("Marcus");

        tuna1.makeFishSay("Hmm");

        Tuna tuna2 = new Tuna("Alexander");

        tuna2.sayName();
    }
}
