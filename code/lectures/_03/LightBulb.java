package lectures._03;

public class LightBulb
{
    //# Felter
    private boolean on = false;

    //# Metoder
    private boolean emitsLight() {
        return this.on;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void toggle() {
        this.on = !this.on;
    }

    public static void main(String[] args) {
        LightBulb lightbulb1 = new LightBulb();
        LightBulb lightbulb2 = new LightBulb();

        lightbulb1.turnOn();
        lightbulb2.turnOn();

        if (lightbulb1.emitsLight() && lightbulb2.emitsLight()) {
            System.out.println("Begge lyspærene er på!");
        }
        else {
            System.out.println("Begge lyspærene lyser ikke!");
        }
    }
}
