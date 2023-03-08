package lectures._06;

import java.io.File;
import java.io.IOException;

public class FileCreateTest {
    public static void main(String[] args) {
        try {
            File file = new File("files/example/06.txt");

            if (file.createNewFile()) {
                System.out.println("Filen ble opprettet!");
            } else {
                System.out.println("Filen eksisterer allerede!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
