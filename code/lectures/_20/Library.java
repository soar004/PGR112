package lectures._20;

import lectures._18.database.Database;

import java.util.HashMap;

public class Library
{
    //# Static
    static final Database database = new Database(
            "Lecture20",
            "lecture20",
            "password20"
    );

    //# Fields
    private final HashMap<Long, Book> books = new HashMap<>();

    //# Methods
    // Create
    public void addBook(Book book) {

    }

    // Read
    public Book getBook(long ISBN) {
        return null;
    }

    // Update
    public void updateBook(long ISBN, Book book) {
        // så lenge ISBN numrene samsvarer
    }

    // Delete
    public void removeBook(Book book) {

    }

    public void removeBook(long ISBN) {

    }




}
