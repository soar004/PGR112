package examples.java.collection;

import java.util.HashSet;

public class ExampleHashSet {
    public static void main(String[] args) {
        // Oppretter et HashSet med String-verdier
        HashSet<String> setOfStrings = new HashSet<>();

        /*
            Et Set inneholder kun unike verdier. Et HashSet bruker .hashCode() for å sjekke unikhet blant annet
         */

        // Legg til (unike) elementer til settet
        setOfStrings.add("foo");
        setOfStrings.add("bar");
        setOfStrings.add("baz");

        // Fjern et element fra settet
        setOfStrings.remove("bar");

        // Om settet inneholder bax, fjern foo
        if (setOfStrings.contains("baz")) {
            setOfStrings.remove("foo");
        }

        // om størrelsen på settet er 1, tøm det
        if (setOfStrings.size() == 1) {
            setOfStrings.clear();
        }

        // om settet er tomt, legg til foo
        if (setOfStrings.isEmpty()) {
            setOfStrings.add("foo");
        }
    }
}

