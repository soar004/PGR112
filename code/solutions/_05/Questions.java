package solutions._05;

import java.util.ArrayList;
import java.util.Scanner;

public class Questions
{
    public static void main(String[] args) {
        // Oppretter en tom liste
        ArrayList<String> questions = new ArrayList<>();
        
        // Legger til et par spørsmål
        questions.add("Hva er 2 + 2?");
        questions.add("Hva får du hvis blander fargene blå og rød?");
        questions.add("Hvor lang tid tar det med tog mellom Bergen og Oslo?");
        
        // Oppretter et Scanner-objekt slik at vi kan hente inn svar
        Scanner input = new Scanner(System.in);
        
        System.out.println("Nå stilles " + questions.size() + " spørsmål!");
        
        // Looper igjennom spørsmålene og printer ut svar per spørsmål
        for (String question : questions) {
            System.out.println("Spørsmål: " + question);
            System.out.print("Svar: ");
            
            String answer;
            
            if (input.hasNextLine()) {
                answer = input.nextLine();
            }
            
            // I BlueJ så printes ut det som skrives inn som svar i blått
            // Ved å kjøre manuelt i terminalen ville du ikke sett svarene,
            // og måtte printet ut svarene manuelt:
            
            // System.out.println(answer);
            
            // Lager et skille så det er enklere å lese i terminalen
            System.out.println("---");
        }
        
        System.out.println("Ferdig å stille spørsmålene!");
    }
}