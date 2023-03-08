package examples.java.optional;

import examples.data.Products;
import examples.entity.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class OptionalStreamFilter
{
    public static void main(String[] args) {
        HashMap<Integer, Product> productsMap = Products.getData();

        // Her lagrer vi verdiene fra HashMap i en Optional for å brukes videre
        // da vi kun er interessert i verdiene akkurat nå
        Optional<Collection<Product>> products = Optional.of(productsMap.values());

        System.out.println();
        System.out.println("Produkter med en pris på over kr 100,-:");
        //# Filtrerer slik at vi kun har produkter som koster mer enn kr 100,-
        products.get().stream()
                .filter(product -> product.getPrice() > 100)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Produkter uten øre som en del av prisen:");
        // Filtrerer slik at vi sammenligner pris med og uten desimaltall,
        // og beholder de som er like utifra sammenligningen
        products.get().stream()
                .filter(product -> product.getPrice() == Math.floor(product.getPrice()))
                .forEach(System.out::println);
    }
}
