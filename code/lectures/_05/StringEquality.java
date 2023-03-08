package lectures._05;

public class StringEquality
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
    }
}
