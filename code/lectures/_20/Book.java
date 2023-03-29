package lectures._20;

public record Book(
        String name,
        String author,
        String description,
        int amountOfPages,
        long ISBN,
        int rating
) {}
