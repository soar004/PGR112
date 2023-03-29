package lectures._20;

import lectures._18.code.TerminalLogin;
import lectures._18.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Library
{
    //# Static
    static final Database database = new Database(
            "Lecture20",
            "lecture20",
            "password20"
    );

    static {
        String createBooksTable = "CREATE TABLE IF NOT EXISTS books"
            + "("
                + "isbn BIGINT, "
                + "name VARCHAR(64), "
                + "author VARCHAR(128), "
                + "description VARCHAR(256), "
                + "amountOfPages INT, "
                + "rating INT, "
                + "PRIMARY KEY(isbn)"
            + ")";

        try (Connection connection = database.getConnection()) {

            Statement statement =  connection.createStatement();

            statement.execute(createBooksTable);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    //# Fields
    private final HashMap<Long, Book> books = new HashMap<>();



    public boolean bookExistsInDatabase(Book book) {
        return this.bookExistsInDatabase(book.ISBN());
    }

    public boolean bookExistsInDatabase(long ISBN) {
        try (Connection connection = Library.database.getConnection()) {

            String query = "SELECT * FROM books WHERE isbn = '%d';".formatted(ISBN);

            Statement statement = connection.createStatement();

            return statement.executeQuery(query).next();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
