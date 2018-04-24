package task2_3.chef.ingredients;

import task2_3.chef.exceptions.NegativeCaloricityException;

public class Paprika extends Ingredient {

    public Paprika () throws NegativeCaloricityException {
        super("Paprika", "Yellow", "Spain", 30);
    }
}
