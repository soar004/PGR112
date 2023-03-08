package lectures._05;

import java.util.Scanner;

public class TerminalPassword
{
    public static void main(String[] args) {
        String correctPassword = "abc123";

        Scanner input = new Scanner(System.in);

        System.out.println("Input your password: ");

        String password = input.nextLine();

        if (password.equals(correctPassword)) {
            System.out.println("Password is correct");
        }
        else {
            System.out.println("Password is not correct");
        }
    }
}
