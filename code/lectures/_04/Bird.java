package lectures._04;

public class Bird {
    // Fields
    private String name;
    private String description = "";

    private String species;
    private String habitat;

    private double wingSpan;
    private boolean canFly;

    // Constructor
    public Bird(String name, String species, String habitat) {
        this.name = name;

        this.species = species;
        this.habitat = habitat;

        this.wingSpan = 0;
        this.canFly = true;

        System.out.println("Nå ble det opprettet en ny fugl!");
    }

    // Getter / Setter methods
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}