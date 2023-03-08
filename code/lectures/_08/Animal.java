package lectures._08;

public abstract class Animal
{
    private static int counter = 0;

    public static int getAnimalCount() {
        return Animal.counter;
    }

    //# Felter
    private int id;
    private String name;

    public Animal(String name) {
        this.setName(name);

        this.id = Animal.counter;

        Animal.counter += 1;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String value) {
        this.name = value;
    }

    //# Abstrakte metoder
    public abstract void makeSound();
}
