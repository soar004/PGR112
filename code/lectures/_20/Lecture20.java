package lectures._20;

import java.sql.Connection;
import java.sql.SQLException;

public class Lecture20
{
    public static void main(String[] args) {

        Library library = new Library();

        try (Connection connection = Library.database.getConnection()) {

            System.out.println("Tilkoblingen fungerer!");

        } catch(SQLException e) {
            e.printStackTrace();
        }

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

    }
}
