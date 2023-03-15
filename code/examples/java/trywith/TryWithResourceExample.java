package examples.java.trywith;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResourceExample
{

    public static void main(String[] args) {
        File file = new File("files/task06/composers.txt");

        try (Scanner input = new Scanner(file)) {

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
