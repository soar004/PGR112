package lectures._08;

import java.util.HashMap;

public class JavaProgram
{
    public static void main(String[] args) {
        Cat cat1 = new Cat("Alice");
        Cat cat2 = new Cat("Bob");

        Dog dog1 = new Dog("Charlie");

        HashMap<String, Animal> animals = new HashMap<>();

        animals.put("cat1", cat1);
        animals.put("cat2", cat2);

        animals.put("cat3", cat1);
        animals.put("cat4", cat2);

        animals.put("cat5", cat1);
        animals.put("cat6", cat2);

        animals.put("cat7", cat1);
        animals.put("cat8", cat2);

        animals.put("cat9", cat1);
        animals.put("cat10", cat2);


        for (int i = 1; i <= 10; i ++) {
            System.out.println(animals.get("cat" + i));
        }
    }
}
