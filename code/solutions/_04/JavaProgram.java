package solutions._04;

import java.util.ArrayList;

//# Oppgave 2
/*
 * - Lag en klasse som heter Program
 *
 * - Klassen skal kun ha én metode som heter runProgram()
 * -- Metoden printer ut "Programmet starter ..." til terminalen
 *
 * - Opprett en main-metode som oppretter et Program-objekt
 * -- Kall på metoden runProgram() tilgjengelig på objektet vi har opprettet
 */
public class JavaProgram
{
    public void runProgram() {
        System.out.println("Programmet starter ...");
    }

    public static void main(String[] args) {
        JavaProgram program = new JavaProgram();

        program.runProgram();

        //# Oppgave 5
        // Opprett listen med ord
        ArrayList<Word> words = new ArrayList<>();

        // Opprett flere ord ved å bruke Word-klassen
        Word fantastisk = new Word("fantastisk");

        fantastisk.addSynonym("imponerende");
        fantastisk.addSynonym("utmerket");
        fantastisk.addSynonym("utrolig");

        Word programkode = new Word("programkode");

        programkode.addSynonym("kildekode");
        programkode.addSynonym("dataprogram");
        programkode.addSynonym("applikasjon");

        Word relevant = new Word("relevant");

        relevant.addSynonym("aktuelt");
        relevant.addSynonym("treffende");

        // Legg til ordene i listen over ord
        words.add(fantastisk);
        words.add(programkode);
        words.add(relevant);

        System.out.println("Liste over ord og tilhørende synonymer:");

        // Loop igjennom ordene og print ut ordet og tilhørende synonymer
        for (Word word : words) {
            System.out.println(word.getWord() + ":");

            // Her bruker vi getSynonyms() for å få tak i listen over synonymer
            // slik at vi kan gå igjennom denne for å printe ut synonymene
            for (String synonym : word.getSynonyms()) {
                System.out.println(" - " + synonym);
            }
        }
    }
}
