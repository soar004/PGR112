package lectures._16;

import java.util.ArrayList;

public class Waffle
{
    //# Fields
    private boolean glutenFree;
    private boolean lactoseFree;
    private ArrayList<WaffleTopping> toppings;

    //# Constructor
    public Waffle(boolean glutenFree, boolean lactoseFree, ArrayList<WaffleTopping> toppings) {
        this.setGlutenFree(glutenFree);
        this.setLactoseFree(lactoseFree);
        this.setToppings(toppings);
    }

    //# Getter-methods
    public boolean isGlutenFree() {
        return  this.glutenFree;
    }

    public boolean isLactoseFree() {
        return this.lactoseFree;
    }

    public ArrayList<WaffleTopping> getToppings() {
        return toppings;
    }

    //# Setter-methods
    void setGlutenFree(boolean value) {
        this.glutenFree = value;
    }

    void setLactoseFree(boolean value) {
        this.lactoseFree = value;
    }

    public void setToppings(ArrayList<WaffleTopping> value) {
        this.toppings = value;
    }

    //# Methods
    @Override
    public String toString() {
        StringBuilder toppings = new StringBuilder();

        for (WaffleTopping topping : this.getToppings()) {
            toppings.append(topping.getName()).append(";");
        }

        return "Waffle[gluten=%s; lactose=%s; toppings=\"%s\"]".formatted(
                this.isGlutenFree(),
                this.isLactoseFree(),
                toppings
        );
    }
}
