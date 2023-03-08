package examples.entity;

public class Product {
    //# Fields
    private String name;
    private double price;

    //# Constructor
    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    //# Getter
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    //# Setter
    public void setName(String value) {
        this.name = value;
    }

    private void setPrice(double value) {
        this.price = value;
    }

    //# Methods
    @Override
    public String toString() {
        return "Product[name=\"%s\"; price=%.2f;]".formatted(
                this.getName(),
                this.getPrice()
        );
    }
}
