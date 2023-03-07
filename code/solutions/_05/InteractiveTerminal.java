package solutions._05;

import java.util.Scanner;

public class InteractiveTerminal
{
    public static void main(String[] args) {
        System.out.println("Meny:");
        
        System.out.println("  1. Valgmulighet #1");
        System.out.println("  2. Valgmulighet #2");
        System.out.println("  3. Valgmulighet #3");
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("---");
        System.out.println("Hva velger du?");
        
        // Kan også gjøres med nextInt()
        // Men da må en sjekke om brukeren ikke skriver
        // inn noe annet enn et tall
        String choice = input.nextLine();
        
        switch (choice) {
            case "1":
            case "2":
            case "3":
                System.out.println("Du valgte: " + choice);
                break;
            default:
                System.out.println("Ukjent valg, prøv å kjøre programmet på nytt!");
        }
        
    }
}