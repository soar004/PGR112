package examples.java;

import java.util.HashMap;

public class ExampleHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> phoneBook = new HashMap<>();

        // Husk at vi kan bruke understrek for å splitte opp store tall for lesbarhetens skyld!
        // int oneMillion = 1_000_000;

        // HashMap er lagring av nøkler <-> verdier,
        // hvor hver verdi er lagret opp mot en spesifik nøkkel

        phoneBook.put(22_59_60_00, "Høyskolen Kristiania");

        // Ved å bruke nøkkelen kan vi hente ut informasjon
        int phone = 22596000;
        System.out.printf("The owner of the phone number %d is %s%n", phone, phoneBook.get(phone));

        // Et HashMap består av to ulike kolleksjoner, en for nøklene og en for verdiene
        // Nøklene er lagret som et Set da ingen nøkler skal lagres med duplikater

        for (int phoneKey : phoneBook.keySet()) {
            System.out.println(phoneKey);
        }

        for (String phoneOwner  : phoneBook.values()) {
            System.out.println(phoneOwner);
        }
    }
}