package lectures._06;

import java.io.*;
import java.util.Scanner;

public class FileReadTest
{
    public static void main(String[] args) {

        Terminal.clear();

        try {
            File fileObject = new File("files/example/06.txt");
            Scanner input = new Scanner(fileObject);

            Terminal.log("FileReadTest", "Filen er lastet inn!");

            int n = 1;

            while(input.hasNextLine()) {
                String line = input.nextLine();

                if (line.contains("8")) {
                    Terminal.log(
                            "FileReadTest",
                            "fant tallet 8 på linje " + n + "!"
                    );

                    System.out.println("Jeg fant tallet 8 på linje " + n + "!");
                }

                n += 1;
            }

            input.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}