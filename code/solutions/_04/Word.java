package solutions._04;

import java.util.ArrayList;

//# Oppgave 4
/*
 * - Lag en klasse som heter Word
 */

/**
 * Oppgave 4.1
 * - Klassen skal ha følgende private felter:
 * -- String data
 * -- ArrayList<String> synonyms
 */

/**
 * Oppgave 4.2
 * - Klassen skal ha følgende public metoder:
 * -- String getWord()
 * -- ArrayList<String> getSynonyms()
 * -- void addSynonym()
 */
public class Word
{
    // Felter
    private String data;
    private ArrayList<String> synonyms;

    // Konstruktør
    public Word(String value) {
        this.data = value;
        this.synonyms = new ArrayList<>();
    }

    // Metoder
    public String getWord() {
        return this.data;
    }

    public ArrayList<String> getSynonyms() {
        return this.synonyms;
    }

    public void addSynonym(String word) {
        this.synonyms.add(word);
    }
}
