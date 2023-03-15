package lectures._18.code;

import lectures._18.database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TerminalLogin
{
    private static final Database database = new Database(
    "Lecture18",
    "lecture18",
    "password18"
    );

    private String loggedInUser = null;

    public TerminalLogin() {

    }

    public boolean userExists(String username) {
        try (Connection connection = TerminalLogin.database.getConnection()) {

            String query = "SELECT * FROM users WHERE username = '%s';".formatted(username);

            Statement statement = connection.createStatement();

            return statement.executeQuery(query).next();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Terminal Login Application");

        TerminalLogin terminal = new TerminalLogin();

        String username = "admin123";

        if (terminal.userExists(username)) {
            System.out.println("Brukernavnet eksisterer!");
        }
        else {
            System.out.println("Brukernavnet eksisterer ikke!");
        }

        //# TODO get user input from terminal
    }
}
