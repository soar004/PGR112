package lectures._19;

public class WebShop {
    public static void main(String[] args) {
        Product apple = new Product(
                "Red Apple",
                "Et saftig rødt eple!",
                11,
                Product.Type.PHYSICAL
        );

        for (Store store : Store.registry.values()) {
            System.out.println(store.getName());
        }

        Store store = Store.registry.get("Butikkvegen 123");

        store.addCustomer(new Customer(
                "MarcusAlexander.Dahl@kristiania.no",
                "Marcus"
        ));

        if (store.customerExists("MarcusAlexander.Dahl@kristiania.no")) {
            System.out.println("Customer exists!");
        }
        else {
            System.out.println("Customer does not exist!");
        }

    }
}
