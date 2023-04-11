package lectures._21.webshop;

import com.mysql.cj.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class StoreDatabase
{
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
