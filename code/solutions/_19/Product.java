package solutions._19;

public record Product(int id, String name, double price) {
    public String toSring() {
        return "Product[id=%d; name=%s; price=%f;]".formatted(this.id(), this.name(), this.price());
    }
}
