package solutions._19;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Storage {
    //# Static
    static {
        try {
            DriverManager.registerDriver(new Driver());

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/task19?allowPublicKeyRetrieval=true&useSSL=false",
                    "task19username",
                    "task19password"
            );

            String query = "CREATE TABLE IF NOT EXISTS product"
                + "("
                    + "id INT, "
                    + "name varchar(255) UNIQUE, "
                    + "price DOUBLE, "
                    + "PRIMARY KEY(id)"
                + ");"
            ;

            Statement statement = Storage.connection.createStatement();

            statement.execute(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Storage instance = new Storage();
    private static final Connection connection;

    //# Fields
    private Inventory inventory = new Inventory();
    private int products;

    //# Constructor
    private Storage() {

    }

    //# Methods
    public void addProduct(String name, double price) {
        this.addProduct(1, name, price);
    }

    public void addProduct(int quantity, String name, double price) {
        if (this.productExists(name)) {
            Product product = this.getProduct(name);

            this.inventory.getStock().put(
                    product,
                    this.inventory.getStock().get(product) + quantity
            );
        }
        else {
            this.inventory.getStock().put(
                    new Product(this.inventory.getNextId(), name, price), quantity
            );
        }
    }

    public void removeProduct(Product product) {
        this.removeProduct(1, product);
    }

    public void removeProduct(String name) {
        if (this.productExists(name)) {
            this.removeProduct(this.getProduct(name));
        }
    }

    public void removeProduct(int quantity, Product product) {
        this.inventory.getStock().put(product, this.inventory.getStock().get(product) - quantity);

        if (this.inventory.getStock().get(product) <= 0) {
            this.inventory.getStock().remove(product);
        }
    }

    public void removeProduct(int quantity, String name) {
        if (this.productExists(name)) {
            this.removeProduct(quantity, this.getProduct(name));
        }
    }

    Inventory getInventory() {
        return this.inventory;
    }

    //# Helper functions
    private boolean productExists(String name) {
        for (Product product : this.inventory.getStock().keySet()) {
            if (product.name().equals(name)) {
                return true;
            }
        }

        return false;
    }

    private Product getProduct(String name) {
        for (Product product : this.inventory.getStock().keySet()) {
            if (product.name().equals(name)) {
                return product;
            }
        }

        return null;
    }

    //# Static methods
    static Storage getStorage() {
        return Storage.instance;
    }
}
