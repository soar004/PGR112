package lectures.repetition;

import java.util.ArrayList;

public class TryCatchExample {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1); // 0
        numbers.add(2); // 1
        numbers.add(3); // 2


        try {
            int number = numbers.get(3);
        } catch (IndexOutOfBoundsException e) {
            // e.printStackTrace();

            System.out.println("Vi forsøkte å hente ut noe som ikke eksisterer!");
        }

        System.out.println("Kode vår fortsatte!");
    }
}
