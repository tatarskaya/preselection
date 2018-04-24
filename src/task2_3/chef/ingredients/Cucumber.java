package task2_3.chef.ingredients;

import task2_3.chef.exceptions.NegativeCaloricityException;

public class Cucumber extends Ingredient {

    public Cucumber () throws NegativeCaloricityException {
        super("cucumber", "Green", "Belarus", 15);
    }
}
