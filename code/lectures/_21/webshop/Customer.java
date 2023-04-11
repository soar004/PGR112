package lectures._21.webshop;

public record Customer(
        String email,
        String name,
        Customer.Type type
) {
    public enum Type {
        Customer,
        Partner
    }
}
