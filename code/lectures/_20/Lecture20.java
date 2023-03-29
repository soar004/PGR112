package lectures._20;

import java.sql.Connection;
import java.sql.SQLException;

public class Lecture20
{
    public static void main(String[] args) {

        Library library = new Library();

        Book book1 = new Book(
                "Navnet på boken",
                "Forfatteren av boken",
                "Beskrivelse av boken",
                123,
                900030023123L,
                5
        );

        System.out.println(book1.name());
        System.out.println(book1.author());
        System.out.println(book1.description());
        System.out.println(book1.amountOfPages());
        System.out.println(book1.ISBN());
        System.out.println(book1.rating());

        library.addBook(book1);

        Book book2 = new Book(
                "Navnet på bok 2",
                "Forfatteren av bok 2",
                "Beskrrivelse av bok 2",
                321,
                1273012731263L,
                6
        );

        if (library.addBook(book2)) {
            System.out.println("Bok 2 ble lagt til i databasen!");
        }
        else {
            System.out.println("Bok 2 eksisterer nok i databasen fra før av");
        }

    }
}
