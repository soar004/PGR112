package lectures._12;

import java.util.HashMap;

public class ExampleHashMapOrder {
    public static void main(String[] args) {

        HashMap<String, String> lines = new HashMap<>();

        for (int i = 0; i < 10000; i ++) {
            lines.put("#" + i, "Linje " + i);
        }

        // Legg merke til at de ikke printes ut helt i "riktig" rekkefølge
        for (String key : lines.keySet()) {
            System.out.println(key);
        }
    }
}
