package lectures.repetition;

public class Book {
    /*
        1. Felter           (data)
        2. Metoder
        3. Konstruktører

        ---

        Så har vi det som er statisk eller ikke-statisk
     */

    //# Fields
    private String name;
    private int amountOfPages;

    public Book(String name, int amountOfPages) {
        this.name = name;
        this.amountOfPages = amountOfPages;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Bok 1", 100);
        Book book2 = new Book("Bok 2", 200);

        System.out.println(book1);
        System.out.println(book2);

        System.out.println(book1.name);
        System.out.println(book2.name);

        System.out.println(book1.amountOfPages);
        System.out.println(book2.amountOfPages);

        // Innkapsling (encapsulation) ville da vært å bruke getter-metoder
        // istedenfor å referere til feltene direkte
    }

}
