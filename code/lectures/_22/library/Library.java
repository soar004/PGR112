package lectures._22.library;

import lectures._18.database.Database;

import java.sql.*;
import java.util.HashMap;

public class Library
{
    //# Static
    static final Database database = new Database(
            "Lecture22",
            "lecture22",
            "password22"
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


    //# Helper  methods
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
    public boolean addBook(Book book) {
        // query = "INSERT INTO users(username, password) VALUES('admin', 'admin');";

        if (!this.bookExistsInDatabase(book)) {
            String query = "INSERT INTO books(isbn, name, author, description, amountOfPages, rating) VALUES(?, ?, ?, ?, ?, ?)";

            try (Connection connection = Library.database.getConnection()) {

                PreparedStatement statement = connection.prepareStatement(query);

                statement.setLong(1, book.ISBN());
                statement.setString(2, book.name());
                statement.setString(3, book.author());
                statement.setString(4, book.description());
                statement.setInt(5, book.amountOfPages());
                statement.setInt(6, book.rating());

                statement.execute();

                this.books.put(book.ISBN(), book);

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return false;
    }

    // Read
    public Book getBook(long ISBN) {
        if (this.books.containsKey(ISBN)) {
            return this.books.get(ISBN);
        }
        else if (this.bookExistsInDatabase(ISBN)) {
            String query = "SELECT * FROM books WHERE isbn = '%d';".formatted(ISBN);

            try (Connection connection = Library.database.getConnection()) {

                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery(query);

                Book output = new Book(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("author"),
                        rs.getInt("amountOfPages"),
                        rs.getLong("isbn"),
                        rs.getInt("rating")
                );

                this.books.put(output.ISBN(), output);

                return output;

            } catch (SQLException e) {
               e.printStackTrace();
            }
        }

        return null;
    }

    public HashMap<Long, Book> getAllBooks() {
        HashMap<Long, Book> output = new HashMap<>();

        try (Connection connection = Library.database.getConnection()) {

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM books;");

            while (results.next()) {
                Book book = new Book(
                        results.getString("name"),
                        results.getString("author"),
                        results.getString("description"),
                        results.getInt("amountOfPages"),
                        results.getLong("isbn"),
                        results.getInt("rating")
                );

                output.put(book.ISBN(), book);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    // Update
    public void updateBook(Book book) {
        // Query: "UPDATE books SET name = 'Dette er et nytt navn på boken' WHERE isbn = '9812389172';

        String query = ""
            + "UPDATE books SET "
                + "name = ?, "
                + "description = ?, "
                + "author = ?, "
                + "amountOfPages = ?, "
                + "rating = ? "
            + "WHERE ISBN = ?;"
        ;

        try (Connection connection = Library.database.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, book.name());
            statement.setString(2, book.description());
            statement.setString(3, book.author());
            statement.setInt(4, book.amountOfPages());
            statement.setInt(5, book.rating());

            statement.setLong(6, book.ISBN());

            statement.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void removeBook(Book book) {
        this.removeBook(book.ISBN());
    }

    public void removeBook(long ISBN) {
        // Query: "DELETE FROM books WHERE isbn = '?';"

        if (this.bookExistsInDatabase(ISBN)) {
            String query = "DELETE FROM books WHERE isbn = ?;";

            try (Connection connection = Library.database.getConnection()) {

                PreparedStatement statement = connection.prepareStatement(query);

                statement.setLong(1, ISBN);

                statement.execute();

            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }




}
