package task4.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import task4.Ingredient;
import task4.IngredientDataSource;
import task4.exceptions.WrongIngredientName;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientJson implements IngredientDataSource {

    public List<Ingredient> getIngredients(List<Class> ingredientsName) {
        List<Ingredient> ingredients = new ArrayList<>();
        try {
            for (Class name : ingredientsName) {
                ingredients.add(chooseIngredient(name));
            }
        }
        catch (WrongIngredientName ex) {
            ex.printStackTrace();
        }
        return ingredients;
    }

    private Ingredient chooseIngredient (Class className) throws WrongIngredientName {
        Ingredient ingr = getSingleIngredient("src/task4/json/sources/" + className.getSimpleName().toLowerCase() + ".json", className);
        if (ingr == null) {
            throw new WrongIngredientName(className.getSimpleName());
        }
        return ingr;
    }

    private <T extends Ingredient> T getSingleIngredient(String filename, Class<T> ingredientClass) {
        Ingredient ingredient = null;
        try {
            InputStream inputStream = new FileInputStream(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                stringBuilder.append(row);
            }
            String ingredientsString = stringBuilder.toString();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ingredient = gson.fromJson(ingredientsString, ingredientClass);
            System.out.println(gson.toJson(ingredient));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return (T)ingredient;
    }
}
