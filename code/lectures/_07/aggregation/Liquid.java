package lectures._07.aggregation;

public class Liquid
{
    private String name;
    private double volume; // liter

    public Liquid(String name) {
        this(name, 1.0);
    }

    public Liquid(String name, double volume) {
        this.setName(name);
        this.setVolume(volume);
    }

    public String getName() {
        return this.name;
    }

    public double getVolume() {
        return this.volume;
    }

    private void setName(String value) {
        this.name = value;
    }

    protected void setVolume(double value) {
        this.volume = value;
    }

    public boolean merge(Liquid liquid) {
        if (this.getName().equals(liquid.getName())) {
            this.setVolume(this.getVolume() + liquid.getVolume());

            return true;
        }

        return false;
    }
}
