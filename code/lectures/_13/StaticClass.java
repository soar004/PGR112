package lectures._13;

import java.util.ArrayList;

public class StaticClass {
    //# Fields
    public static ArrayList<String> days = new ArrayList<>();

    //# Static block
    static {
        System.out.println("Static block");

        days.add("monday");
        days.add("tuesday");
        days.add("wednesday");
        days.add("thursday");
        days.add("friday");
        days.add("saturday");
        days.add("sunday");
    }

    public StaticClass() {
        System.out.println("Constructor");
    }

    //# Methods
    public void testMethod() {
        System.out.println(StaticClass.days);
    }

    //# Main-method
    public static void main(String[] args) {
        StaticClass sclass1 = new StaticClass();
        StaticClass sclass2 = new StaticClass();
        StaticClass sclass3 = new StaticClass();

        // Hva som markeres som static av felter og metoder er til felles
        // for alle instansene, lagret kun ét sted i minne!

        // Disse to neste linjene med kode er "identiske"
        // Legg merke til hva IntelliJ nevner i den gule framhevingen under
        System.out.println(sclass1.days);
        System.out.println(StaticClass.days);
    }
}
