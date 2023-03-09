package examples.oop.polymorphism;

import java.util.ArrayList;

public abstract class Animal {
    abstract void eatFood();


    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(cat);
        animals.add(dog);

        //# Det er på runtime vi finner ut av hvilken implementasjon av eatFood() som brukes
        for (Animal animal : animals) {
            animal.eatFood();
        }
    }
}
