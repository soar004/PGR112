package solutions._03;

//# Oppgave 3
public class Book
{
    // Felter
    private String title;
    private String author;
    private int numberOfPages;

    //# Oppgave 9
    private BookGenre genre;


    // Konstruktør
    //# Oppgave 5
    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }


    // Gettere og settere
    //# Oppgave 7
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public BookGenre getGenre() {
        return this.genre;
    }


    public void setTitle(String value) {
        this.title = value;
    }

    public void setAuthor(String value) {
        this.author = value;
    }

    //# Oppgave 9
    public void setNumberOfPages(int value) {
        this.numberOfPages = value;
    }

    public void setGenre(BookGenre value) {
        this.genre = value;
    }


    // Metoder
    //# Oppgave 4
    public void printState() {
        System.out.println(
                "Title of the book: " + this.getTitle()
        );

        System.out.println(
                "Author of the book: " + this.getAuthor()
        );

        System.out.println(
                "Number of pages within the book: " + this.getNumberOfPages()
        );

        System.out.println(
                "Genre of the book: " + this.getGenre()
        );
    }


    // Main-metode
    //# Oppgave 6
    public static void main(String[] args) {
        Book book = new Book("Hva er programkode?", "Marcus A. Dahl", 42);

        book.setGenre(BookGenre.OTHER);

        book.printState();
    }
}
