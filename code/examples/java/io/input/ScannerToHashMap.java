package examples.java.io.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ScannerToHashMap {

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> quotes = new HashMap<>();

        Scanner input = new Scanner(System.in);

        System.out.println("Hva er navnet på personen?");
        String name = input.nextLine();

        ArrayList<String> thingsTheySay = new ArrayList<>();

        while(true) {
            System.out.println("Hva er noe denne personen sier ofte?");
            String quote = input.nextLine();

            if (quote.equals("EXIT")) {
                break;
            }

            thingsTheySay.add(quote);
        }

        quotes.put(name, thingsTheySay);
    }
}
