package lectures._07.aggregation;

import java.util.ArrayList;

public class Aquarium
{
    //# Felter
    private ArrayList<Fish> fish;
    private Liquid water;
    private ArrayList<Plant> plants;

    //# Konstruktør
    public Aquarium(double volume) {
        this.fish = new ArrayList<>();
        this.water = new Liquid("Water", volume);
        this.plants = new ArrayList<>();
    }

    //# Getter-metoder
    public ArrayList<Fish> getAllFish() {
        return this.fish;
    }

    private Liquid getLiquid() {
        return this.water;
    }

    public ArrayList<Plant> getAllPlants() {
        return this.plants;
    }

    //# Metoder
    public void addFish(Fish fish) {
        this.fish.add(fish);
    }

    public void removeAllFish() {
        this.fish.clear();
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    //# Main-metode - starter Java-programmet vårt som heter Aquarium
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium(3.0);

        Fish fish1 = new Fish("Marcus");
        Fish fish2 = new Fish("Alexander");

        aquarium.addFish(fish1);
        aquarium.addFish(fish2);

        System.out.println("Antall fisker i akvariet: " + aquarium.getAllFish().size());

        Plant plant1 = new Plant("Java Moss");
        Plant plant2 = new Plant("Java Fern");

        aquarium.addPlant(plant1);
        aquarium.addPlant(plant2);
    }
}