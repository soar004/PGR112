package lectures._21.webshop;

import java.util.HashMap;

public class Store
{
    protected final static HashMap<Integer, Store.Registration> registrations = new HashMap<>();

    //# Fields
    private Store.Registration registration;
    private final Inventory inventory = new Inventory();
    private final HashMap<Integer, Customer> customers = new HashMap<>();

    private int customerCount = 0;

    public record Registration(
            int id,
            String name,
            long orgNumber,
            Store.Type type
    ) {}

    public enum Type {
        Physical,
        Digital
    }

    public Store(Store.Registration registration) throws Exception {
        if (Store.registrations.containsValue(registration)) {
            this.registration = registration;
        }
        else {
            throw new Exception("Store is not registered!");
        }
    }

    void addCustomer(Customer customer) {
        if (!this.customers.containsValue(customer)) {
            this.customers.put(++this.customerCount, customer);
        }
    }

    void removeCustomer(int customerId) {
        this.customers.remove(customerId);
    }

    boolean productQuantityInStock(Product product, int quantity) {
        return quantity <= this.inventory.stock.get(product);
    }

    void buyProduct(int customerId, Product product, int quantity) {
        Customer customer = this.customers.get(customerId);

        if (this.productQuantityInStock(product, quantity)) {
            System.out.printf("Customer bought %d of the following product: %s%n", quantity, product);

            this.inventory.stock.replace(product, this.inventory.stock.get(product) - quantity);
        }
    }
}
