package lectures._16;

import java.util.ArrayList;

public class WaffleObjectBuilder
{
    private boolean glutenFree;
    private boolean lactoseFree;
    private ArrayList<WaffleTopping> toppings = new ArrayList<>();

    public WaffleObjectBuilder setGlutenFree(boolean value) {
        this.glutenFree = value;

        return this;
    }

    public WaffleObjectBuilder setLactoseFree(boolean value) {
        this.lactoseFree = value;

        return this;
    }

    public WaffleObjectBuilder addTopping(WaffleTopping topping) {
        this.toppings.add(topping);

        return this;
    }

    public Waffle build() {
        return new Waffle(this.glutenFree, this.lactoseFree, this.toppings);
    }
}
