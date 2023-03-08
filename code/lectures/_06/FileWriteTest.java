package lectures._06;

import java.io.*;
public class FileWriteTest
{
    public static void main(String[] args) {
        try {
            FileWriter file = new FileWriter("files/example/06.txt");

            file.write("Dette er en linje på begynnelsen av filen 1 2 3!");
            file.write("Dette er en linje som inneholder tallet 8 på slutten av filen!!!");
            file.close();

            System.out.println("Du har skrevet til filen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
