package examples.project.bank;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends Person
{
    //# Fields
    private final ArrayList<Account> accounts;

    //# Constructor
    public Customer(String name, long securityNumber) {
        super(name, securityNumber);

        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    //# Methods
    public void addAccount(String accountName, long accountNumber) {
        this.accounts.add(new Account(accountName, accountNumber));
    }
}
