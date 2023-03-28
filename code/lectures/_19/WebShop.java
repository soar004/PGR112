package lectures._19;

public class WebShop {
    public static void main(String[] args) {
        Product apple = new Product(
                "Red Apple",
                "Et saftig rødt eple!",
                11,
                Product.Type.PHYSICAL
        );

        System.out.println(
                Store.registry.get("Butikkvegen 123").getLocation().address()
        );

        System.out.println(apple.description());
    }
}
