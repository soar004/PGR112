package lectures._21.webshop;

public record Product(
    int id,
    String name,
    double price,
    Product.Type type
) {
    public enum Type {
        Physical,
        Digital
    }
}
