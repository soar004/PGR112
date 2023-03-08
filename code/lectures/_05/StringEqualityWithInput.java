package lectures._05;

import java.util.Scanner;

public class StringEqualityWithInput
{
    public static void main(String[] args) {
        String A = new String("Test 123");
        String B = new String("Test 123");

        String C = "Test 123";
        String D = "Test 123";

        // For å sammenligne String-verdier bruk .equals(...) istedenfor!
        if (A == B) {
            System.out.println("A and B are equal");
        }
        else {
            System.out.println("A and B are not equal");
        }

        if (C == D) {
            System.out.println("C and D are equal");
        }
        else {
            System.out.println("C and D are not equal");
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Type the same thing twice:");

        String E = input.nextLine();
        String F = input.nextLine();

        if (E == F) {
            System.out.println("E and F are equal");
        }
        else {
            System.out.println("E and F are not equal");

            if (E.equals(F)) {
                System.out.println(" - Correction: E and F is actually equal");
            }
            else {
                System.out.println(" - Confirmed, E and F is indeed not equal");
            }
        }
    }
}
