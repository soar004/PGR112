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

#### Hint og tips

> **Når bøker returneres fra en metode, returner disse som et `HashMap<Long, Book>`**

> Før du begynner å løse en oppgave, kan det være lurt å lage SQL-querien først som du mener henter ut det du trenger fra databasen.
> Deretter kan du basere Java-koden din rundt dette med tanke på bruk av PreparedStatement.

---

### Oppgave 1

Opprett en metode som heter `getBooksByAuthor(String author)`

Denne metoden skal hente ut alle bøkene fra databasen med den spesifikke forfatteren.

---

> Her kan det virke som det er mange metoder å implementere i de neste 2 oppgavene,
hvor det kan være greit å legge merke til at koden fra en måte å gjøre det vil ligne mye på de andre måtene å gjøre det på.

---


### Oppgave 2

Opprett 5 metoder som heter:
- `getBooksWithRating(int rating)`
- `getBooksWithRatingHigherThan(int rating)`
- `getBooksWithRatingHighterThanOrEqualTo(int rating)`
- `getBooksWithRatingLessThan(int rating)`
- `getBooksWithRatingLessThanOrEqualTo(int rating)`

### Oppgave 3

Opprett 3 metoder som heter:
- `getBooksWithExactAmountOfPages(int pages)`
- `getBooksWithAmountOfPagesMoreThan(int pages)`
- `getBooksWithAmountOfPagesLessThan(int pages)`

### Oppgave 4

- `findBookByName(String name)`

Denne metoden skal søke gjennom navnene til bøkene og se om String-verdien i parameteret name er en del av navnet til en eller flere bøker lagret i databasen.

Hint:
- I SQL har vi en `LIKE`-operator som kan brukes i `WHERE`-uttrykket - bruk gjerne denne for å søke etter tekst

Målet er at vi ikke skal være låst til å måtte søke etter bøker ved navn med å måtte oppgi en eksakt kopi av navnet på en bok, men kunne søke etter deler av navnet på en bok.

Ressurs:
- https://www.w3schools.com/sql/sql_like.asp

#### Oppgave 4.1 (ekstra)

Gjør det slik at denne metoden vi nettopp laget ikke er avhengig av små eller store bokstaver (altså at metoden er case-insensitive)

#### Oppgave 4.2 (ekstra, veldig vanskelig)

Denne er for de som ønsker en veldig vanskelig oppgave:
Les om Levenshtein algoritmen for å regne ut "avstanden" mellom to tekst-verdier, og se om du klarer å implementere en metode som heter `searchBooksByName(String name)` som gir deg bøker som har navn som ligner veldig på navnet det søkes om.

---

## Del 2: Deck of Cards

### Oppgave 1

Opprett en metode som heter `void shuffle()`.

Denne metoden skal plassere kortene i en tilfeldig rekkefølge.

Hint:
- Opprett en ArrayList som inneholder kortene i en tilfeldig rekkefølge først
- Etter du har den opprette listen med kortene i tilfeldig rekkefølge, tøm kortene i `this.cards` og legg til kortene fra den nye listen
- Lag en egen hjelpemetode for å hente ut at random tall mellom 0 og 51 (indeksverdier)

### Oppgave 2

Opprett en metode som heter `void cut(int index)`

Denne metoden skal ta alle kortene som er etter indeks-verdien oppgitt og plassere disse kortene på indeks 0.

Dette er sammenlignbart med å plukke opp en tilfeldig mengde kort fra kortstokken, legge disse i en egen haug, og plassere resten av kortene oppå denne nye haugen med kort.

### Oppgave 3 (kan ta lang tid)

Lag kortspillet "Krig".

Spillet baserer seg på at kortstokken stokkes tilfeldig (.shuffle()) og at det er 2 spillere.

Hver spiller får 26 kort hver til å begynne med.

Hver runde så skal hver spiller ta et kort fra bunken sin og legge disse fram på bordet.

Spilleren som legger fram kortet med høyest verdi vinner kortene og plassere disse i en egen bunke.

Om kortene som spilles fra hver spiller har lik verdi, oppstår situasjonen "krig":
- 3 kort legges fjernes fra hver spiller sin bunke og blir en del av utbyttet som kan vinnes
- Det neste kortet som spilles bestemmer hvem som vinner
- Om kortene her er like, fortsettes denne prosessen som beskrives til det er en vinner
- Vinneren får alle kortene involvert i krigen

Spillet fortsetter helt til en av spillerne sitter igjen med alle kortene.

Hint:
- Følgende klasser med nevnte felter kan brukes som et utgangspunkt:
  - Player
    - ArrayList<Card> card `Kortene spilleren har`
  - WarGame
    - Player playerOne `Spiller nr 1`
    - Player playerTwo `Spiller nr 2`
    - int round `Hvilket runde spillet er i` 
    - ArrayList<Card> cardsInPlay `De nåværende kortene som er i spill`
    - ArrayList<Card> bounty `Kortene som kan vinnes per runde`

Målet er at spillet spilles "automatisk", det vil si at spillet starter og så vil spillet printe ut hva som skjer underveis, og til slutt da print ut:
- Spilleren som vant
- Antall runder det tok
