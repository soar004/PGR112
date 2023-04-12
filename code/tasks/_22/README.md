# Oppgavesett 22

## Del 1: Fortsettelse på kode fra forelesningen

Begynn med å ta utgangspunkt i koden som befinner seg her:
`code/lectures/_22/library/*`

I denne mappen, åpne `Library`-klassen og identifiser de ulike metodene kategorisert utifra CRUD:

- Create
  - addBook(Book book)
- Read
  - getBook(long ISBN)
- Update
  - updateBook(Book book)
- Delete
  - deleteBook(Book book) 
  - deleteBook(long ISBN)

Les igjennom disse og gjør deg selv kjent med hvorfor akkurat disse metodene er i hver sin kategori.

Når bøker returneres fra en metode, returner disse som et `HashMap<Long, Book>`

### Oppgave 1

Opprett en metode som heter `getBooksByAuthor(String author)`

Denne metoden skal hente ut alle bøkene fra databasen med den spesifikke forfatteren.

### Oppgave 2

Opprett fem metoder som heter:
- `getBooksWithRating(int rating)`
- `getBooksWithRatingHigherThan(int rating)`
- `getBooksWithRatingHighterThanOrEqualTo(int rating)`
- `getBooksWithRatingLessThan(int rating)`
- `getBooksWithRatingLessThanOrEqualTo(int rating)`

---

## Del 2: Deck of Cards


