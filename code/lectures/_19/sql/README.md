# MySQL JDBC-driver

I Java trenger vi en driver for å kunne snakke med en MySQL-server.

For å få tilgang til klassene vi trenger, så trenger vi å laste inn en pakke som heter Connector/J.

---

## For å innstallere manuelt:

> Lastes ned fra: https://dev.mysql.com/downloads/connector/j/

> Innstallasjonsguide: https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-installing.html

---

I et prosjekt ellers, som ikke er satt opp med Gradle eller Maven, så må vi laste inn Connector/J manuelt.

Dette gjøres ved å laste ned en plattform-uavhengig .zip mappe, og så legges denne .zip filen inn her i IntelliJ:

`File` --> `Project Structure ...` og så ved å navigere til `Libraries` under `Project Settings` klikker du på `+`, velger `Java` og så finner du .ZIP-filen du lastet ned og legger denne til.

---

I et Maven-prosjekt (som dette prosjektet er satt opp som), så legger vi inn en dependency i `pom.xml`:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>x.y.z</version>
    <exclusions>
        <exclusion>
            <groupId>com.google.protobuf</groupId>
            <artifactId>protobuf-java</artifactId>
        </exclusion>
    </exclusions> 
</dependency>
```

Her velger vi å ikke inkludere noe som heter `protobuf` som omhandler serialisering og deserialisering av data, da vi ikke kommer til å bruke det og det tar opp unødvendig plass.


