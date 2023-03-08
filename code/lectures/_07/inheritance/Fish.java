package lectures._07.inheritance;

public class Fish
{
    private String type;

    public Fish(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    private void setType(String value) {
        this.type = value;
    }

    public void makeFishSay(String phrase) {
        System.out.println(this.getType() + " says: " + phrase);
    }
}