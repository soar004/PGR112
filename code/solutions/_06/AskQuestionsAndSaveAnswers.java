package solutions._06;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

//# Oppgave 3

/*
 * Opprett en klasse ved navn "AskQuestionsAndSaveAnswers"
 */
public class AskQuestionsAndSaveAnswers
{
    /*
     * Denne klassen skal ha en main-metode som gjør følgende:
     */
    public static void main(String[] args) {
        // Opprett en ArrayList<String>
        ArrayList<String> questions = new ArrayList<>();
        
        // Her legger vi til et par spørsmål, slik at loopen under
        // har noe å jobbe med
        
        questions.add("Hva er 2 + 2?");
        questions.add("Hva får du om du blander fargene gul og blå?");
        questions.add("Er tallet 16 mindre enn (1 + 2 + 4 + 8)?");
        
        /*
         * Finn en måte å lagre svarene på: Bruker en ArrayList!
         */
        ArrayList<String> answers = new ArrayList<>();
        
        // Oppretter en Scanner slik at vi kan hente inn svar fra terminalen
        Scanner input = new Scanner(System.in);
        
        System.out.println("Spørsmål og svar:");
        
        /*
         * Lag en loop, og for hvert spørsmål spør brukeren om et svar på spørsmålet
         */
        for (String question : questions) {
            System.out.println(" - Spørsmål: " + question);
            
            System.out.print(" - Svar: ");
            
            answers.add(input.nextLine());
            
            // Linjehopp etter brukeren skriver inn et svar
            // gjøres kun for at det skal se litt ryddigere ut i terminalen
            System.out.print("\n");
        }
        
        /*
         * Opprett et FileWriter-objekt, og:
         */
        try {
            FileWriter file = new FileWriter("answers.txt");
            
            /*
             * Lag en loop som tar spørsmålet og svaret på spørsmålet,
             * og lagrer dette i en tekstfil som heter "answers.txt"
             */
            
            // Legg merke til at vi legger til \n på slutten manuelt for
            // linjehopp når vi skriver til filen!
            
            file.write("Spørsmål og svar!\n");
            
            for (int i = 0; i < questions.size(); i ++) {
                file.write("Spørsmål: " + questions.get(i) + "\n");
                
                // Her gjøres det en antagelse om at listene "questions" og "answers"
                // har like mange elementer med tekst i seg, da det hentes inn et svar per spørsmål
                file.write("Svar: " + answers.get(i) + "\n");
                
                file.write("---\n");
            }
            
            // Her lukker vi ressursen vi har brukt!
            file.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}