package lectures._08;

public class Cat extends Animal
{
    public Cat(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println("Mjau");
    }

    @Override
    public String toString() {
        return "Jeg er en katt som heter " + this.getName();
    }
}
