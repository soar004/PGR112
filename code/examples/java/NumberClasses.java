package examples.java;

public class NumberClasses {
    public static void main(String[] args) {
        Number[] numberArray = new Number[] {
                1,      // int
                2.0f,   // float
                3.0d,   // double
        };

        /*
            Number-klassen her er en generalisering for tall, som i at det kan representerer alle tall, om det så
            er et heltall, flyttall, byte osv.here is a generalization of numbers, as in, it

            Sjekk primitive datatyper for en referanse til hvilken typer som menes
         */

        //---

        // De følgende to arrayene er identiske da Integer-klassen er en "wrapper"-klasse rundt
        // den primitive datatypen "int"

        // "Wrapper" vil si at den her fungerer som en ikke-primitiv datatype som representerer en
        // en verdi som er en primitiv datatype

        Integer[] integers1 = new Integer[] {
                1, 2, 3
        };

        int[] integers2 = new int[] {
                1, 2, 3
        };

        // Det finnes andre slike klasser, som for eksempel: Float, Double, Long, osv.
        // Relevant når vi skal spesifisere typer i opprettelsen av ArrayList og HashMap
    }
}