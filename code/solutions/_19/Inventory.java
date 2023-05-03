package solutions._19;

import java.util.HashMap;

public class Inventory {
    private HashMap<Product, Integer> stock = new HashMap<>();

    HashMap<Product, Integer> getStock() {
        return this.stock;
    }

    int getHighestId() {
        int output = -1;

        for (Product product : this.stock.keySet()) {
            if (product.id() > output) {
                output = product.id();
            }
        }

        return output;
    }

    int getNextId() {
        return this.getHighestId() + 1;
    }

    void printInformation() {
        System.out.println("Oversikt over produkter og antall per produkt:");

        for (Product product : this.stock.keySet()) {
            System.out.printf("- %s (x%d): %s%n", product.name(), this.stock.get(product), product);
        }
    }
}
