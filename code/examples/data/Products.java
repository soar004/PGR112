package examples.data;

import examples.entity.Product;

import java.util.HashMap;

public class Products
{
    private final static HashMap<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(
                "1 stk Mango",
                14.90
        ));

        products.put(2, new Product(
                "2 stk Avokado",
                24.90
        ));

        products.put(3, new Product(
                "1kg Ost",
                94.00
        ));

        products.put(4, new Product(
                "650g Kyllingfilet",
                75.20
        ));

        products.put(5, new Product(
                "200g Havsalt Chips",
                24.90
        ));

        products.put(6, new Product(
                "12 stk Egg",
                42.90
        ));

        products.put(7, new Product(
                "400g Jordbærsyltetøy",
                24.20
        ));

        products.put(8, new Product(
                "3x160g Maiskorn",
                33.90
        ));

        products.put(9, new Product(
                "1kg Kjøttdeig",
                99.00
        ));

        products.put(10, new Product(
                "1L Appelsinjuice",
                14.90
        ));

        products.put(11, new Product(
                "1L Eplejuice",
                14.90
        ));

        products.put(12, new Product(
                "1kg Ytrefilet Storfe",
                329.00
        ));

        products.put(13, new Product(
                "1kg Skrei",
                119.00
        ));

        products.put(14, new Product(
                "1 stk Vaffeljern",
                349.00
        ));

        products.put(15, new Product(
                "1 stk Airfryer",
                1190.00
        ));
    }

    public static HashMap<Integer, Product> getData() {
        return Products.products;
    }

    // Gjør konstruktøren privat da vi ikke ønsker instanser av denne klassen
    private Products() {}
}
