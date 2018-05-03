package task2_3.chef;

import task2_3.chef.exceptions.NegativeCaloricityException;
import task2_3.chef.ingredients.Cucumber;
import task2_3.chef.ingredients.Ingredient;
import task2_3.chef.ingredients.Paprika;
import task2_3.chef.ingredients.Tomato;

import java.util.Arrays;
import java.util.List;

public class KitchenRunner {

    public static void main(String[] args) {
        try {
            List<Ingredient> salad = Arrays.asList(new Paprika(), new Tomato(), new Cucumber());
            Action action = new Action(salad);

            System.out.println("Salad:");
            action.printNameIngredients();

            System.out.println("Caloricity: " + action.getSaladCaloricity() + " Kkal");

            salad = action.sortByName();
            action = new Action(salad);
            System.out.println("Sorted salad by Name : ");
            action.printNameIngredients();

            Double caloricityValue = 30.0;
            System.out.println(String.format("Vegitables with caloricity less %s Kkal: %s", caloricityValue, action.getCaloricityLessValue(caloricityValue)));

            action.printRecipeInFile();

        } catch (NegativeCaloricityException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
