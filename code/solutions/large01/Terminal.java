package solutions.large01;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

//# Oppgave 0
public class Terminal
{
    private static final Scanner input = new Scanner(System.in);

    /**
     * Privat konstruktør da vi ikke ønsker flere instanser av en terminal
     */
    private Terminal() {}

    /**
     * Printer ut en beskjed til terminalen som inneholder dato, tidsstempel og kontekst
     *
     * @param context Hva er det som printer ut denne teksten til terminalen
     * @param message Hvilken beskjed som skal faktisk vises
     */
    public static void log(String context, String message) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.printf("[%s][%s][%s]: %s%n", date, time, context, message);
    }

    /**
     * Printer ut en nummerert meny til terminalen gitt
     * navnet på menyen og en liste med valgmuligheter
     *
     * @param menu Navnet på menyen
     * @param options En ArrayList med valgmuligheter av typen String
     */
    public static void printMenu(String menu, ArrayList<String> options) {
        System.out.printf("%n%s:%n", menu);

        for (int i = 0; i < options.size(); i ++) {
            System.out.printf(" - %d) %s%n", i + 1, options.get(i));
        }
    }

    /**
     * Printer ut en meny og returnerer hvilket valg som et tall
     *
     * @param menu Navnet på menyen
     * @param options En ArrayList med valgmuligheter av typen String
     */
    public static int printMenuAndReturnChoice(String menu, ArrayList<String> options) {
        Terminal.printMenu(menu, options);

        int choice = 0;

        while(true) {
            System.out.println();

            try {
                choice = Terminal.getInteger("Ditt valg (1 - %d):".formatted(options.size()));

                if (choice > 0 && choice <= options.size()) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                Terminal.log("Terminal::printMenuAndReturnChoice", "Brukeren skrev inn et ikke-tall!");
            }

            System.out.println("Prøv igjen med et riktig valg!");
        }
    }

    /**
     * Henter tekst som brukeren skriver inn i terminalen
     *
     * @param prompt Meldingen som skal vises før brukeren bes om å skrive  inn noe
     * @return Hva brukeren skriver inn
     */
    public static String getText(String prompt) {
        System.out.printf("%s ", prompt);

        return Terminal.input.nextLine();
    }

    public static int getInteger(String prompt) {
        while(true) {
            try {
                return Integer.parseInt(Terminal.getText(prompt));
            } catch (NumberFormatException e) {
                Terminal.log("Terminal::getInteger", "NumberFormatException oppstod!");
            }

            System.out.println("Du må skrive inn et heltall!");
        }
    }
}