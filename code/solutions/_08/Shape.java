package solutions._08;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Optional;

public abstract class Shape
{
    //# Static fields
    private static int shapes = 0;  // antall figurer

    //# Fields
    private String color;           // hvilken farge figuren har
    private boolean filled;         // om kantlinjen eller hele figuren er fargelagt

    public final int id;            // et tall som identifiserer hver figur

    //# Constructor
    public Shape() {
        this("red", true);
    }

    public Shape(String color, boolean filled) {
        this.setColor(color);
        this.setFilled(filled);

        // For hver figur vi lager, øker vi antall figurer med én
        Shape.shapes += 1;

        // Vi lagrer nåværende antall figurer som id-nummer
        // som lar oss gi et unikt tall per figur når de opprettes
        this.id = Shape.shapes;
    }

    //# Getter-methods
    public String getColor() {
        return this.color;
    }

    public boolean getFilled() {
        return this.filled;
    }

    // Denne getter-metoden trengs egentlig ikke,
    // da feltet er satt til å være public og kan leses av direkte
    public int getId() {
        return this.id;
    }

    //# Setter-methods
    protected void setColor(String value) {
        this.color = value;
    }

    protected void setFilled(boolean value) {
        this.filled = value;
    }

    //# Methods
    @Override
    public String toString() {
        return String.format(
                "Shape[id=%d; color=%s; filled=%s]",
                this.getId(), this.getColor(), this.getFilled()
        );
    }

    //# Abstracts
    abstract public double getArea();
    abstract public double getPerimeter();


}
