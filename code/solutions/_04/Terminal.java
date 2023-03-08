package solutions._04;

import java.util.ArrayList;

//# Oppgave 3
/*
 *  - Lag en klasse som heter Terminal med tilhørende konstruktør
 */
/**
 * Oppgave 3.1
 *  - Klassen skal ha følgende felt: options, av typen ArrayList<String>
 *  - Klassen skal ha følgende metoder:
 *  -- void addOption(String value)
 *  -- void clearOptions()
 *  -- void displayMenu()
 */
public class Terminal
{
    // Felter
    private ArrayList<String> options;

    // Konstruktør
    public Terminal() {
        // Vi trenger ikke å oppgi typen her, da Java klarer
        // å finne ut av hvilken type det er fra feltet "options"
        this.options = new ArrayList<>();
    }

    // Metoder
    public void addOption(String value) {
        this.options.add(value);
    }

    public void clearOptions() {
        this.options.clear();
    }

    public void displayMenu() {
        System.out.println("Menu:");

        for (int i = 0; i < this.options.size(); i ++) {
            System.out.println((i + 1) + ". " + this.options.get(i));
        }
    }

    //# Alternativ løsning til måten vi kan loope igjennom valgene
    public void displayMenuAlternativeLoop() {
        System.out.println("Menu: ");

        int i = 1;

        for (String option : options) {
            System.out.println(i + ". " + option);

            i += 1;
        }
    }
}