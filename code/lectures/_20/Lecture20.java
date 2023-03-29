package lectures._20;

public class Lecture20
{
    public static void main(String[] args) {

        Book book1 = new Book(
                "Navnet på boken",
                "Forfatteren av boken",
                "Beskrivelse av boken",
                123,
                900030023123L,
                5
        );

        System.out.println(book1.name());
        System.out.println(book1.author());
        System.out.println(book1.description());
        System.out.println(book1.amountOfPages());
        System.out.println(book1.ISBN());
        System.out.println(book1.rating());

    }
}
