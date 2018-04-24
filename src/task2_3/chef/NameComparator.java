package task2_3.chef;

import task2_3.chef.ingredients.Ingredient;

import java.util.Comparator;

public class NameComparator implements Comparator<Ingredient> {

    @Override
    public int compare(Ingredient ingr1, Ingredient ingr2) {
        try {
            return ingr1.getName().compareTo(ingr2.getName());
        }
        catch (NullPointerException ex) {
            return 1;
        }
    }
}
