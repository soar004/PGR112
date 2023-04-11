package lectures._21.webshop;

import java.util.ArrayList;

public record Transaction(
        Customer customer,
        ArrayList<ProductLine> products,
        double total
) {
    public record ProductLine(
            Product product,
            int quantity
    ) {}
}
