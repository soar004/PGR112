package lectures._22;

import lectures._22.library.Book;
import lectures._22.library.Library;

public class Lecture22
{
    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book(
                "Dette er en bok",
                "Marcus",
                "Marcus brukte lang tid på å skrive denne boken",
                100,
                192837465L,
                10
        );

        library.updateBook(book);
    }
}
