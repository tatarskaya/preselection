package task4;

import task4.db.IngredientDB;
import task4.ingredients.Cucumber;
import task4.ingredients.Paprika;
import task4.ingredients.Tomato;
import task4.json.IngredientJson;

import java.util.Arrays;
import java.util.List;

public class Kitchen {

    public static void main(String[] args) {
        List<Class> ingredientsName = Arrays.asList(Tomato.class, Paprika.class, Cucumber.class);

        IngredientJson ingredientJson = new IngredientJson();
        List<Ingredient> ingredientsFromJson = ingredientJson.getIngredients(ingredientsName);

        IngredientDB ingredientDB = new IngredientDB();
        List<Ingredient> ingredientsFromDB = ingredientDB.getIngredients(ingredientsName);
    }
}
