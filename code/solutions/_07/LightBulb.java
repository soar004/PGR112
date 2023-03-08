package solutions._07;

public class LightBulb
{
    private boolean state = false;

    public boolean getState() {
        return this.state;
    }

    void turnOn() {
        this.state = true;
    }

    void turnOff() {
        this.state = false;
    }

    void toggle() {
        this.state = !this.state;
    }
}