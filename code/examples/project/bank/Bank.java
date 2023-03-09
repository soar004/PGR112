package examples.project.bank;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank
{
    private HashMap<Customer, ArrayList<Account>> customers;

    public Bank() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(String name, long securityNumber) {
        Customer customer = new Customer(name, securityNumber);

        customers.put(customer, customer.getAccounts());
    }

    public static void main(String[] args) {
        Customer marcus = new Customer("Marcus", 123654789);

        marcus.addAccount("Sparekonto", 321654987);
    }
}
