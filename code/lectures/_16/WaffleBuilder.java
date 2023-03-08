package lectures._16;

import java.sql.Array;
import java.util.ArrayList;

public class WaffleBuilder {
    private final Waffle waffle;

    public WaffleBuilder() {
        this.waffle = new Waffle(false, false, new ArrayList<WaffleTopping>());
    }

    public WaffleBuilder setGlutenFree(boolean value) {
        this.waffle.setGlutenFree(value);

        return this;
    }

    public WaffleBuilder setLactoseFree(boolean value) {
        this.waffle.setLactoseFree(value);

        return this;
    }

    public WaffleBuilder addTopping(WaffleTopping topping) {
        this.waffle.getToppings().add(topping);

        return this;
    }

    public Waffle build() {
        return this.waffle;
    }
}
