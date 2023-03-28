package lectures._19;

import java.util.HashMap;

public class Store
{
    //# Static
    public static HashMap<String, Store> registry = new HashMap<>();

    static {
        System.out.println("Static block is run");

        registry.put("Butikkvegen 123", new Store(
                "PGRButikken",
                "Butikkvegen 123",
                "6543",
                "BUTIKKLAND"
        ));
    }

    //# Fields
    private String name;
    private Store.Address address;

    //# Constructors
    public Store(
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

    //# Setter-methods
    public void setName(String value) {
        this.name = value;
    }

    public void setAddress(Store.Address value) {
        this.address = value;
    }

    record Address(
            String address,
            String postalCode,
            String postalArea
    ) {}
}
