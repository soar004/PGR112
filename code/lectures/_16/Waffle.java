package lectures._16;

import java.util.ArrayList;

public class Waffle
{
    //# Fields
    private boolean glutenFree;
    private ArrayList<WaffleTopping> toppings;

    //# Constructor
    public Waffle(boolean glutenFree, ArrayList<WaffleTopping> toppings) {
        this.setGlutenFree(glutenFree);
        this.setToppings(toppings);
    }

    //# Getter-methods
    public boolean isGlutenFree() {
        return  this.glutenFree;
    }

    public ArrayList<WaffleTopping> getToppings() {
        return toppings;
    }

    //# Setter-methods
    private void setGlutenFree(boolean value) {
        this.glutenFree = value;
    }

    public void setToppings(ArrayList<WaffleTopping> value) {
        this.toppings = value;
    }
}
