package solutions._06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//# Oppgave 1
public class NumbersAddedTogether
{
    // Main-metode
    public static void main(String[] args) {
        /*
         * Opprett en variabel som heter "sum" av typen int
         * som starter med verdien 0
         */
        int sum = 0;
        
        /*
         * Les tekstfilen "tall.txt" linje for linje
         * 
         * PS: Det brukes .nextInt() da vi vet strukturen
         * på filen, da den ble opprettet innledningsvis med
         * 10 ulike heltall, en per linje
         * 
         * Vi vil lære senere hvordan vi bedre kan håndtere
         * filer vi ikke har noen kontroll over,
         * som kan ha blitt lastet opp av en kunde eller kollega osv.
         */
        try {
            File numbers = new File("files/task06/tall.txt");
            Scanner input = new Scanner(numbers);
            
            // Følgende antar at filen er riktig satt
            // opp med kun heltall, vanligvis burde en
            // sjekke for at dette stemmer, det lærer vi mer om senere
            while (input.hasNextInt()) {
                /*
                 * Øk verdien til variabelen "sum" slik at denne
                 * variabelen representerer summen av alle
                 * tallene i tekstfilen
                 */
                sum += input.nextInt();
            }
            
            // Her lukker vi "ressursen" vi har brukt,
            // da vi har brukt systemressurser for å åpne en fil
            // på filsystemet, og operativ systemet ønsker gjerne
            // å vite at vi er ferdig med filen
            input.close();
            
            /*
             * Print ut til terminalen summen av alle tallene
             */
            System.out.println("Summen av alle tallene: " + sum);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}