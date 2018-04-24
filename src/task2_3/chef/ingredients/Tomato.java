package task2_3.chef.ingredients;

import task2_3.chef.exceptions.NegativeCaloricityException;

public class Tomato extends Ingredient {

    public Tomato () throws NegativeCaloricityException {
        super("Tomato", "Red", "Italy", 20);
    }
}
