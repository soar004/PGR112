package solutions._06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// PS: Det er mange kommentarer i denne filen
// Om det blir uoversiktlig, så kan det lages en
// kopi av denne klassen (Composer2, ComposerCopy, osv),
// hvor du limer inn koden og fjerner kommentarene

//# Oppgave 2
/*
 * Opprett en klasse som heter Composer
 */
public class Composer
{
    /*
     * Klassen skal ha følgende felter:
     */
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
    
    /*
     * Klassen skal ha en konstruktør som tar imot navn og fødselsår,
     * for å så lagre denne dataen i feltene nevnt over
     */
    public Composer(String name, int year) {
        this.name = name;
        this.birthYear = year;
    }
    
    /*
     * Klassen skal ha en main-metode som gjøre følgende:
     */
    public static void main(String[] args) {
        /*
         * Oppretter en variabel av typen ArrayList<Composer>
         */
        ArrayList<Composer> composers = new ArrayList<>();
        
        /*
         * Les filen "composers.txt" linje for linje, og:
         */
        try {
            File file = new File("files/task06/composers.txt");
            Scanner input = new Scanner(file);
            
            // Dette er én måte å gjøre det på ved hjelp av ArrayList,
            // og kan teknisk sett utvides senere til å håndtere
            // flere linjer med data før "---" linjen i filen
            
            // Listen vil ha følgende struktur:
            // navn, alder
            // hvor begge er String verdier, hvor vi må huske
            // å gjøre om string til int når vi henter ut alder senere
            ArrayList<String> data = new ArrayList<>();
            
            while (input.hasNextLine()) {
                String line = input.nextLine();
                
                /*
                 * Bruk if-setninger for å vite når et objekt
                 * av Composer-klassen skal oppretess
                 */
                if (!line.equals("---")) {
                    data.add(line);
                }
                // Vi har nådd en "seperator", og er klar for å opprette
                // Composer-objektet og legge det til i listen over alle
                // komponister
                else {
                    Composer composer = new Composer(
                        data.get(0),
                        Integer.parseInt(data.get(1))
                    );
                    
                    /*
                     * Bruken av Integer.parseInt() bør helst
                     * gjøres i en try-catch som sjekker om
                     * NumberFormatException oppstår!
                     * 
                     * _Spesielt_ dersom du ikke har kontroll over filen,
                     * det vil si at du ikke lagde filen selv
                     */
                    
                    /*
                     * For hvert objekt som opprettes, legg objektet til i
                     * "composers"-variabelen av typen ArrayList<Composer>
                     */
                    composers.add(composer);
                    
                    // Tømmer data slik at vi kan legge inn data for
                    // neste komponist
                    data.clear();
                }
                
            }
            
            // Her rydder vi opp etter oss, da vi har brukt
            // operativ systemet for å få tilgang til en fil fra filsystemet
            // (dette gjøres i bakgrunnen ved bruk av File- og Scanner-klassene)
            input.close();
            
            /*
             * Etter du har opprettet alle objektene (og lagt de til i "composers"),
             * lag en loop som går igjennom hver Composer-objekt lagt til i "composesers"-listen,
             * og print ut navn og fødselsår per komponist til terminalen.
             */
            System.out.println("Liste over komponister med navn og fødselsalder:");
            
            for (Composer composer : composers) {
                System.out.println(
                    " - " + composer.getName() + " (" + composer.getBirthYear() + ")"
                );
                
                // Alternativt:
                // System.out.printf(" - %s (%d)%n", composer.getName(), composer.getBirthYear());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Kunne ikke finne filen 'composers.txt'!");
            
            e.printStackTrace();
        }
        
        
        
        
    }
}