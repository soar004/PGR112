package solutions._06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//# Oppgave 2 -- alternativ løsning
public class ComposerAlternative
{
    private String name;
    private int birthYear;
    
    /*
     * Opprett getter-metoder for disse feltene
     */
    public String getName() {
        return this.name;
    }
    
    public int getBirthYear() {
        return this.birthYear;
    }
    
    public ComposerAlternative(String name, int year) {
        this.name = name;
        this.birthYear = year;
    }
    
    public static void main(String[] args) {
        ArrayList<ComposerAlternative> composers = new ArrayList<>();

        try {
            File file = new File("task06/composers.txt");
            Scanner input = new Scanner(file);
            
            // Her antar vi at filen har følgende struktur:
            // navn
            // alder
            // --- (seperator)
            //
            // og at hver komponist i filen har akkurat denne strukturen,
            // og at _hele_ filen har denne strukturen for hver komponist,
            // ellers vil koden feile
            
            while(true) {
                String name = input.nextLine();
                int year = input.nextInt();
                
                ComposerAlternative composerObject = new ComposerAlternative(
                    name, year
                );
                
                composers.add(composerObject);
                
                // Her er det veldig viktig å legge merke til:
                // nextInt() vil hente ut tallet, men ignorerer linjehoppet
                // rett etter tallet (husk: konteksten her er en tekstfil med linjer)
                
                // Denne linjen ber Scanner gå videre og "bruke opp" linjehoppet etter
                // tallet i tekstfilen
                input.nextLine();       
                
                // Denne linjen bruker opp "---" slik at neste
                // kall til nextLine() (på linje 48) vil gi riktig linje for 
                // navnet på neste komponist i tekstfilen
                input.nextLine();
                
                if (!input.hasNextLine()) {
                    // Her bryter vi ut av loopen
                    // så fort vi har lest av den siste linjen med "---"
                    break;
                }
            }
            
            System.out.println("Liste over komponister med navn og fødselsalder:");
            
            for (ComposerAlternative composer : composers) {
                System.out.printf(" - %s (%d)%n", composer.getName(), composer.getBirthYear());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Kunne ikke finne filen 'composers.txt'!");
            
            e.printStackTrace();
        }
    }
}