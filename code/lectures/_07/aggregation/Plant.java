package lectures._07.aggregation;

/*
 * Eksempler på planter som kan passe i et akvarium for småfisker
 * - Java Moss (Taxiphyllum barbieri / Vesicularia dubyana)
 * - Java Fern (Microsorum pteropus)
 */

public class Plant
{
    private String name;

    public Plant(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String value) {
        this.name = value;
    }
}