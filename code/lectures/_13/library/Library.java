package lectures._13.library;

import java.util.HashMap;


public class Library
{
    private String name;
    private String address;

    private static HashMap<Long, Book> books = new HashMap<>();
    private HashMap<Long, Integer> inventory = new HashMap<>();

    static {
        Library.books.put(9781250879516L, new PaperBook(
                "Nothing but blackened teeth",
                "Cassandra Khaw",
                9781250879516L
        ));

        Library.books.put(9788282821988L, new PaperBook(
                "12 Rules of Life",
                "Jordan Peterson",
                9788282821988L
        ));

        Library.books.put(94911915616L, new AudioBook(
                "Ready Player One",
                "Ernest Cline",
                9780307913142L
        ));
    }


    static abstract class GenericBook implements Book {
        private String name;
        private String author;
        private long isbn;

        public GenericBook(String name, String author, long isbn) {
            this.name = name;
            this.author = author;
            this.isbn = isbn;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getAuthor() {
            return this.author;
        }

        @Override
        public long getISBN() {
            return this.isbn;
        }

        public abstract String getDescription();
    }

    static class PaperBook extends GenericBook {
        private int pages;

        public PaperBook(String name, String author, long isbn) {
            super(name, author, isbn);
        }

        public int getPages() {
            return this.pages;
        }

        private void setPages(int value) {
            this.pages = value;
        }

        @Override
        public String getDescription() {
            return "Dette er en papirbok";
        }
    }

    static class AudioBook extends GenericBook {
        private String narrator;
        private int length; // seconds

        public AudioBook(String name, String author, long isbn) {
            super(name, author, isbn);
        }

        public String getNarrator() {
            return this.narrator;
        }

        public int getLength() {
            return this.length;
        }

        private void setLength(int value) {
            this.length = value;
        }
        private void setNarrator(String value) {
            this.narrator = value;
        }

        @Override
        public String getDescription() {
            return "Dette er en lydbok";
        }
    }

    public static void main(String[] args) {
        for (Book book : Library.books.values()) {
            System.out.printf("%s: %s", book.getName(), book.getDescription());
        }
    }
}

