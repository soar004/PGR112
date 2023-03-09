package examples.project.bank;

public class Account
{
    private String name;
    private long number;

    public Account(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public long getNumber() {
        return this.number;
    }
}
