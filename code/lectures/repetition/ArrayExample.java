package lectures.repetition;

import java.util.ArrayList;

public class ArrayExample {
    public static void main(String[] args) {

        String line = "Dette er en linje tekst";

        String[] lines = new String[] {
                "Dette er linje 1",
                "Dette er linje 2"
        };

        System.out.println(lines[0]);
        System.out.println(lines[1]);

        ArrayList<String> listOfLines = new ArrayList<>();

        listOfLines.add("Dette er linje 1");
        listOfLines.add("Dette er linje 2");

        System.out.println(listOfLines.get(0));
        System.out.println(listOfLines.get(1));
    }
}
