package examples.java.array;

public class ArrayOneDimensional {
    public static void main(String[] args) {
        // Ingen størrelse er gitt her til å starte med, så størrelsen
        // settes utifra hvilken verdier som gies direkte

        // implisitt så er størrelsen satt til 10
        int[] integers = {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };

        if (integers[1] + integers[9] == 10) {
            System.out.println("The length was correctly set to 10");
        }

        // implicitly size 2
        String[] strings = {
                "Alice",
                "Bob"
        };

        System.out.println(integers.length);
        System.out.println(strings.length);

        try {
            strings[2] = "Funker dette?";
        } catch (Exception e) {
            System.out.println("Om du ser dette, så nei :)");

            // Lengden er satt implisitt! Dette vil ikke fungere da lengden er låst
            // og ikke dynamisk, og er gjerne hvorfor ArrayList brukes som en dynamisk liste
        }
    }
}
