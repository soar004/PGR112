package lectures._19;

import java.util.HashMap;

public record Inventory(
        HashMap<Product, Integer> stock
) {}
