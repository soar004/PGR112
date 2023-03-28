package lectures._19;

import lectures._18.code.TerminalLogin;
import lectures._18.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class Store
{
    //# Static
    public static HashMap<String, Store> registry = new HashMap<>();
    private static final Database database = new Database(
            "Lecture19",
            "lecture19",
            "password19"
    );


    static {
        System.out.println("Static block is run");

        //# Stores
        registry.put("Butikkvegen 123", new Store(
                "PGRButikken",
                "Butikkvegen 123",
                "6543",
                "BUTIKKLAND"
        ));

        //# Database setup
        String storeQuery = "CREATE TABLE IF NOT EXISTS store"
                + "("
                + "id INT AUTO_INCREMENT, "
                + "name VARCHAR(64), "
                + "address VARCHAR(256), "
                + "postalCode VARCHAR(8), "
                + "postalArea VARCHAR(128), "
                + "PRIMARY KEY(id)"
                +")";

        String customerQuery = "CREATE TABLE IF NOT EXISTS customer"
                + "("
                + "id INT AUTO_INCREMENT, "
                + "email VARCHAR(64), "
                + "name VARCHAR(256), "
                + "PRIMARY KEY(id)"
                +")";

        try (Connection connection = database.getConnection()) {
            System.out.println("Vi fikk en database-tilkobling!");

            Statement statement = connection.createStatement();

            statement.execute(storeQuery);
            statement.execute(customerQuery);

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }


    //# Fields
    private String name;
    private Store.Address address;

    private final Inventory inventory = new Inventory(new HashMap<>());
    private final HashMap<Integer, Customer> customers = new HashMap<>();

    private int customerCount = 0;


    //# Constructors
    private Store(
            String name,
            String address,
            String postalCode,
            String postalArea
    ) {
        this.setName(name);
        this.setAddress(new Address(address, postalCode, postalArea));
    }


    //# Getter-methods
    public String getName() {
        return this.name;
    }

    public Store.Address getLocation() {
        return this.address;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public int getCustomerCount() {
        return this.customerCount;
    }

    //# Setter-methods
    public void setName(String value) {
        this.name = value;
    }

    public void setAddress(Store.Address value) {
        this.address = value;
    }


    //# Methods
    public void addCustomer(Customer customer) {
        this.customers.put(5000 + this.customerCount, customer);

        try (Connection connection = Store.database.getConnection()) {

            String addCustomerQuery = "INSERT INTO customer(email, name) VALUES(?, ?);";

            PreparedStatement statement = connection.prepareStatement(addCustomerQuery);

            statement.setString(1, customer.email());
            statement.setString(2, customer.name());

            statement.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        }


        this.customerCount ++;
    }

    public boolean customerExists(String email) {
        try (Connection connection = Store.database.getConnection()) {

            String query = "SELECT * FROM customer WHERE email = '%s';".formatted(email);

            Statement statement = connection.createStatement();

            return statement.executeQuery(query).next();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeCustomer(Customer customer) {

    }

    public void removeCustomer(String email) {
        for (Map.Entry<Integer, Customer> customer : this.customers.entrySet()) {
            if (customer.getValue().email().equals(email)) {
                customers.remove(customer.getKey());
            }
        }
    }


    //# Inner record
    record Address(
            String address,
            String postalCode,
            String postalArea
    ) {}
}
