package solutions._05;

import java.util.Scanner;

//# Oppgave 1
public class TerminalPassword
{
    public static void main(String[] args) {
        String correctPassword = "abc123";
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Skriv inn passordet: ");
        
        String passwordGiven = input.nextLine();
        
        if (passwordGiven.equals(correctPassword)) {
            System.out.println("Passordet var korrekt!");
        }
        else {
            System.out.println("Feil passord!");
        }
    }
}