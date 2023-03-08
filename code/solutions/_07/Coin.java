package solutions._07;


import java.util.ArrayList;

public class Coin
{
    private final int value;

    public Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        // Opprett et par mynter med ulik verdi
        Coin copper = new Coin(1);
        Coin silver = new Coin(10);
        Coin gold = new Coin(100);

        // Opprett noe som kan holde på flere mynter
        ArrayList<Coin> bag = new ArrayList<>();

        bag.add(gold);
        bag.add(silver);
        bag.add(silver);
        bag.add(copper);
        bag.add(copper);
        bag.add(copper);

        // Den totale verdien av myntene i baggen
        int total = 0;

        for (Coin coin : bag) {
            total += coin.getValue();
        }

        System.out.println("Den totale verdien er: " + total);
    }
}