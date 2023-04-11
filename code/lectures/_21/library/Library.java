package lectures._21.library;

import lectures._18.database.Database;

import java.sql.*;
import java.util.HashMap;

public class Library
{
    //# Static
    static final Database database = new Database(
            "Lecture21Library",
            "library",
            "librarypassword"
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
