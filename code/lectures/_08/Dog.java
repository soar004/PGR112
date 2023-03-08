package lectures._08;

public class Dog extends Animal
{
    public Dog(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println("Bjæff");
    }

    public void makeOwnerTakeMeForAWalk() {
        System.out.println("Bjeff bjæff");
    }
}