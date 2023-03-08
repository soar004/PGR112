package lectures._10;

import java.util.ArrayList;

public class RuntimePolymorphism {

    @Override
    public String toString() {
        return "It is time to run code at runtime!";
    }

    public static void main(String[] args) {
        Cat animal1 = new Cat();
        Cat animal2 = new Cat();

        Dog animal3 = new Dog();

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);

        for (Animal animal : animals) {

            // Hvilken implementasjon av toString() metoden som brukes velges ved runtime
            System.out.println(animal.toString());

            // Her må vi upcaste til riktig type for å få tilgang til
            // egne spesielle implementasjoner per klasse
            if (animal instanceof Cat) {
                ((Cat) animal).makeSpecialCatNoise();
            }
            else if (animal instanceof Dog) {
                ((Dog) animal).makeSpecialDogNoise();
            }
        }
    }

}

class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Animal sound here!");
    }

    @Override
    public String toString() {
        return "An Animal";
    }
}

class Cat extends Animal {
    public Cat() {
        super("Alice");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public void makeSpecialCatNoise() {
        System.out.println("purr purrrr purr");
    }

    @Override
    public String toString() {
        return "A Cat";
    }
}

class Dog extends Animal {
    public Dog() {
        super("Bob");
    }

    @Override
    public void makeSound() {
        System.out.println("Bjeff!");
    }

    public void makeSpecialDogNoise() {
        System.out.println("BJEFF BJEFF");
    }

    @Override
    public String toString() {
        return "A Dog";
    }
}
