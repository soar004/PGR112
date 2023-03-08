package lectures._10;

public class CompileTimePolymorphism
{
    private String data;

    //# Constructors
    public CompileTimePolymorphism() {
        this("value");
    }

    public CompileTimePolymorphism(String value) {
        this.setData(value);
    }

    private void setData(String value) {
        this.data = value;
    }


    //# Methods
    // Hvilken metode som bruke bestemmes ved compile-time
    void saySomething() {
        this.saySomething("Dette er standardverdien som jeg da snakker om");
    }

    void saySomething(String specific) {
        this.saySomething(specific, "!");
    }

    void saySomething(String specific, String suffix) {
        System.out.println(specific + suffix);
    }
}

