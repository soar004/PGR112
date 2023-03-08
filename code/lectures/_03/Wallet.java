package lectures._03;

public class Wallet
{
    //# Felter
    private int coins;

    //# Konstruktør
    public Wallet() {
        this.coins = 0;
    }

    public int getCoins() {
        return this.coins;
    }

    private void setCoins(int value) {
        this.coins = value;
    }

    //# Metoder
    public void printCoins() {
        System.out.println("Du har " + this.getCoins() + " mynter.");
    }
}
