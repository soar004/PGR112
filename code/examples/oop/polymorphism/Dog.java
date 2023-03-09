package examples.oop.polymorphism;

public class Dog extends Animal {

    @Override
    public void eatFood() {
        System.out.println("Hunden spiser mat ved å få eieren til å mate de");
    }
}
