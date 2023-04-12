package lectures._22;

import lectures._22.library.Book;
import lectures._22.library.Library;

import java.util.HashMap;

public class Lecture22
{
    public static void main(String[] args) {
        Library library = new Library();

        Book bookToAdd = new Book(
                "Book 42",
                "Unknown",
                "Vanskelig å lese",
                100,
                1923382323L,
                9
        );

        library.addBook(bookToAdd);

        HashMap<Long, Book> books = library.getAllBooks();

        for (Book book : books.values()) {
            System.out.println(book.name());
        }
    }
}
