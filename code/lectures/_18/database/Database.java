package lectures._18.database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final String host;
    private final String port;
    private final String name;
    private final String user;
    private final String pass;

    public Database(String database, String username, String password) {
        this("localhost", "3306", database, username, password);
    }

    public Database(String host, String port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.name = database;
        this.user = username;
        this.pass = password;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false".formatted(
                            this.host, this.port, this.name
                    ),
                    this.user,
                    this.pass
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
