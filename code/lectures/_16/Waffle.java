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
    private void setGlutenFree(boolean value) {
        this.glutenFree = value;
    }

    private void setLactoseFree(boolean value) {
        this.lactoseFree = value;
    }

    public void setToppings(ArrayList<WaffleTopping> value) {
        this.toppings = value;
    }

    //# Methods
    @Override
    public String toString() {
        return "Waffle[gluten=%s; lactose=%s; toppings=%s;]".formatted(
                this.isGlutenFree(),
                this.isLactoseFree(),
                this.getToppings()
        );
    }
}
