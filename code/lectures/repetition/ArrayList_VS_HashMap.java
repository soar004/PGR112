package lectures.repetition;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayList_VS_HashMap {
    public static void main(String[] args) {
        // En ArrayList er en dynamisk liste (array)
        // som tilpasser størrelsen når vi legger til elementer

        // En HashMap er system for å linke verdier opp mot en nøkkel

        // ArrayList er en List
        // HashMap er et Map

        // En variabel inneholder én verdi

        // List: En liste inneholder flere verdier
        // Set: Et sett inneholder flere verdier, men ingen duplikater

        // Map: Et map er en kombinasjon av en liste (verdier) og et sett (nøkler)

        ArrayList<Integer> listOfIntegers = new ArrayList<>();

        HashMap<String, Integer> persons = new HashMap<>();

        persons.put("Marcus", 29);
        persons.put("Alice", 30);
        persons.put("Bob", 30);

        System.out.println("Alderen til Marcus er: " + persons.get("Marcus"));

        HashMap<String, ArrayList<String>> quotes = new HashMap<>();

        ArrayList<String> thingsThatMarcusSays = new ArrayList<>();

        thingsThatMarcusSays.add("Men, ja");
        thingsThatMarcusSays.add("indeed");

        quotes.put("Marcus", thingsThatMarcusSays);

        // -- Så lenge vi oppfyller kravene til typene spesifisert,
        // så vil det å bruke ArrayList og HashMap være greit å forholde seg til
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();

        listOfLists.add(thingsThatMarcusSays);
    }
}
