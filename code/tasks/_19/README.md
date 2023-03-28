# Oppgavesett 19

> Du er nå inne i pakken `tasks._19` og filen `README.md`

Inne i denne pakken, opprett en ny pakke som heter `code` - hvor det er inne i denne pakken du løser oppgavene.

---

## Oppgave 1

Lag en klasse som heter `Inventory`.

Denne klassen skal ha et felt som er av typen HashMap, hvor nøkkeltypen er `Product` og verditypen er `Integer`.

Vi får nå en feilmeldingen i koden vår om at klassen `Product` ikke eksisterer, hvor vi nå går videre til neste oppgave for å fikse dette!

---

## Oppgave 2

Opprett klassen `Product` ved bruk av `record` nøkkelordet istedenfor `class`.

Klassen skal ha følgende felter:
- `int` id
- `String` name
- `double` price

Se gjerne på eksempelet under:

```java
public class Data {
    private final Object value;
    
    public Data(Object value) {
        this.value = value;
    }
    
    public Object value() {
        return this.value;
    }
}
```

vs. 

```java
public record Data(Object value) {}
```

Disse to kodesnuttene gjør akkurat det samme. `record` brukes gjerne for å lagre data om noe, hvor vi kun trenger å spesifisere feltene, og så får vi getter-metoder tilgjengelig.

Det som er viktig å få med seg med tanke på `record` er at vi får tilgang til getter-metoder, men ikke setter-metoder, da disse referansene ikke kan endres i etterkant. Verdiene kan kun endres om typen et felt har er en ikke-primitiv datatype, som da har metoder som lar deg endre på objektet (_alt_ er objekter i Java!!) som er lagret som en verdi.

---

## Oppgave 3

Opprett en klasse som heter `Storage`.

Denne klassen skal ha 2 felter:
- `Inventory` inventory
- `int` products

Valgfritt, men kan anbefales: Bruk Singleton-konseptet slik at vi kun kan ha èn instans av klassen Storage.
- Gjør konstruktøren `private`
- Lagre én instans av klassen i et `static`-felt
- Opprett en `static` getter-metode som henter ut instansen av Storage-klassen som er lagret i `static`-feltet i oppret

Singleton hadde vi om i forelesning 13.

---

## Oppgave 4

Inne i klassen `Storage`, opprett følgende metode:
- public `void` addProduct(String name, double price) { ... }

Denne metoden skal gjøre følgende:

1. Sjekke om `inventory`-feltet (HashMap) inneholder et produkt med samme navn. Her kan vi anta at navnene på produktene er unike.
2. Dersom produktet ikke eksisterer: Legg til produktet og sett antallet til 1.
3. Dersom produktet eksisterer: Finn produktet og øk antallet med 1.

---

## Oppgave 5

Lag en alternativ `addProduct(...)`-metode med følgende signatur:
- public `void` addProduct(int quantity, String name, double price) { ... }

Istedenfor å øke antallet med 1 eller sette antallet til 1, skal du nå bruke parameterer `quantity` istedenfor 1-tallet brukt i oppgave 4.

---

## Oppgave 6

Lag følgende to metoder:
- public `void` removeProduct(Product product) { ... }
- public `void` removeProduct(String name)

Disse skal enten: senke antallet med 1 eller fjerne produktet helt fra HashMap-et dersom antallet blir 0.

---

## Oppgave 7

Lag følgende to metoder:
- public `void` removeProduct(int quantity, Product product) { ... }
- public `void` removeProduct(int quantity, String name) { ... }

På lik linje i oppgave 6, senk antallet med parameteret `quantity` og dersom antallet blir 0 eller mindre, fjerne produktet helt fra HashMap-et.

---

## Oppgave 8

I klassen Storage:

- Opprett et `private final static` felt som inneholder en database-tilkobling. Her anbefales det å sjekke ut koden fra forelesning 18 for å se hvordan det kan gjøres.

- Opprett en static block

```java
static {
    // kode her
}
```

Hvor du oppretter følgende tabell om den ikke allerede eksisterer i databasen:

- product

Her er det viktig at tabellen i databasen har nok informasjon slik at vi kan opprette disse på nytt igjen dersom vi skal starte progammet på nytt og laste inn data fra databasen.

Dette vil si at kolonnene i databasen må samsvare med feltene i klassen, hvor en må også se på bruken av nøkler. Her kan det for eksempelvis for nå være lurt å ikke ha `id`-kolonnen i databasen som `AUTO_INCREMENT` slik at vi kan håndtere denne verdien manuelt istedenfor.

---

## Oppgave 9

Opprett en klasse `Shop`.

Denne klassen skal kun ha én main-metode.

Inne i denne main-metoden, skriv kode slik at vi har en instans av `Storage`-klassen å jobbe videre med.

Opprett 3-5 ulike produkter, og legg disse produktene til i `Storage`-instansen sin oversikt over produkter og sett antallet til å være mer enn 1.

Lag ikke-statiske metoder i klassene `Inventory` og `Product` som printer ut informasjon om instansen.
Dette kan gjøres ved å overskrive `toString`-metoden eller ved å lage en egen metode som heter for eksempelvis `printInfo` eller noe i den duren.

---

## Oppgave 10

I klassen Storage, endre metodene som legger til produkter slik at føgende skjer:

- Dersom produktet ikke eksisterer i databasen, legg til produktet i databasen

`product`-tabellen i databasen har kun informasjon om produktet i seg selv, og ingenting om antall eller lignende.

Målet er at databasen vil ha en oversikt av alle produkter som eksisterer.

---
