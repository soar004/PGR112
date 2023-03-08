package lectures._05.bank;

public class Bank
{
    // Felter med data
    private double balance;

    // Konstruktør for å sette opp objekter
    // av typen Bank
    public Bank() {
        this.balance = 0.0;

        Bank.log("Ny bank opprettet");
    }


    // Metoder  (funksjoner alle objekter av typen Bank har)
    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double value) {
        Bank.log("Overskriver saldo fra  " + this.getBalance() + " til " + value);

        this.balance = value;
    }

    public void deposit(double value) {
        this.setBalance(this.getBalance() + value);
    }

    public void withdraw(double value) {
        double newBalance = this.getBalance() - value;

        if (newBalance >= 0) {
            this.setBalance(newBalance);
        }
    }


    private static void log(String message) {
        Terminal.info("Bank", message);
    }

    public static void main(String[] args) {
        Terminal.clear();

        Bank bank = new Bank();

        bank.setBalance(900);

        bank.deposit(100);

        Bank.log("Saldo: " + bank.getBalance());
    }
}
