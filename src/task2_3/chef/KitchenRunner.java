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
            SaladProcessor saladProcessor = new SaladProcessor(salad);

            System.out.println("Salad:");
            saladProcessor.printNameIngredients();

            System.out.println("Caloricity of Salad: " + saladProcessor.getSaladCaloricity() + " Kkal");

            salad = saladProcessor.sortByName();
            saladProcessor = new SaladProcessor(salad);
            System.out.println("Sorted salad by Name : ");
            saladProcessor.printNameIngredients();

            Double caloricityValue = 30.0;
            System.out.println(String.format("Vegitables with caloricity less %s Kkal: %s", caloricityValue, saladProcessor.getCaloricityLessValue(caloricityValue)));

            saladProcessor.readSpicesPrintRecipeInFile();

        } catch (NegativeCaloricityException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
