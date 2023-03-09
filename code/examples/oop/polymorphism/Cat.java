package examples.oop.polymorphism;

public class Cat extends Animal {

    @Override
    public void eatFood() {
        System.out.println("Katten går ut i skogen for å finne mat og spise den");
    }
}
