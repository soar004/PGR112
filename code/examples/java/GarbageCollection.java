package examples.java;

import java.lang.ref.Cleaner;

import examples.entity.Person;

public class GarbageCollection
{
    private final String name;

    public GarbageCollection(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    static void example() {
        Person person = new Person("Sucram", 29);

        /**
         * Vi setter referansen til null
         */
        person = null;

        Person personOne = new Person("Alice", 30);
        Person personTwo = new Person("Bob", 30);

        /**
         * nå er objekt referansen "personOne" tilgjengelig for å bli plukket opp
         * via Java sin garbage collector
         */
        personOne = personTwo;

        personOne.setName("Charlie");

        System.out.println(personTwo.getName());
    }

    public static void main(String args[]) {
        System.out.println("Start garbage collection example ...");

        Cleaner cleaner = Cleaner.create();

        // Vi kan tvinge JVM til å garbage collecte myObject initialization.
        System.out.println("Setter opp vår egen garbage collection ...");

        for (int i = 0; i < 10; i++) {
            String id = Integer.toString(i);

            GarbageCollection GC = new GarbageCollection(id);
            Cleaner.Cleanable cleanUp = cleaner.register(GC, new CleanUp(GC.getName()));

            // cleanUp.clean();
        }

        System.out.println("Gjør noe intensivt med tanke på minnebruk ...");
        for (int i = 1; i <= 100000; i++) {
            int[] a = new int[10000];
            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored) {}
        }
    }

    private static class CleanUp implements Runnable {
        private String name;

        public CleanUp(String name) {
            this.name = name;
        }
        public void run() {
            System.out.println("Cleaner cleaning action executed for "+ this.name);
        }
    }

}




