package lectures._16;

import java.util.ArrayList;
import java.util.HashMap;

public class WaffleFactory {

    final static HashMap<String, WaffleTopping> waffleToppings = new HashMap<>();

    static {
        String[] toppings = new String[] {
                "Jordbærsyltetøy",
                "Nugatti",
                "Rømme",
                "Brunost",
                "Ananas",
                "Smør",
                "Cottage Cheese",
                "Pølse",
                "Sukker"
        };

        for (String topping : toppings) {
            waffleToppings.put(topping, new WaffleTopping(topping));
        }
    }

    public static Waffle createWaffleWithStrawberryJam(boolean gluten, boolean lactose) {
        ArrayList<WaffleTopping> toppings = new ArrayList<>();

        toppings.add(waffleToppings.get("Jordbærsyltetøy"));

        return new Waffle(gluten, lactose, toppings);
    }

    public static Waffle createWaffleWithSausage(boolean gluten, boolean lactose) {
        ArrayList<WaffleTopping> toppings = new ArrayList<>();

        toppings.add(waffleToppings.get("Pølse"));

        return new Waffle(gluten, lactose, toppings);
    }

    public static Waffle createWaffleWithStrawberryJamSugarAndBrownCheese(boolean gluten, boolean lactose) {
        ArrayList<WaffleTopping> toppings = new ArrayList<>();

        toppings.add(waffleToppings.get("Jordbærsyltetøy"));
        toppings.add(waffleToppings.get("Sukker"));
        toppings.add(waffleToppings.get("Brunost"));

        return new Waffle(gluten, lactose, toppings);
    }
}
