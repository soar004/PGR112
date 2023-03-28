package lectures._19;

public record Product(
        String name,
        String description,
        double price,
        Product.Type type
) {
    public enum Type {
        PHYSICAL,
        DIGITAL
    }
}