package task2_3.chef;

import task2_3.chef.exceptions.ThereIsIngredientWithNullNameException;
import task2_3.chef.exceptions.ThereIsNoCaloricityLessValueException;
import task2_3.chef.ingredients.Ingredient;

import java.io.*;
import java.util.*;

public class Action {
    private List<Ingredient> salad;

    public Action(List<Ingredient> salad) {
        this.salad = salad;
    }

    protected List<Ingredient> sortByName() {
        salad.sort(new NameComparator());
        return salad;
    }

    protected HashMap<String, Double> getCaloricityLessValue(double targetCaloricity) {
        HashMap<String, Double> caloricityLessValue = new HashMap<>();
        try {
            for (Ingredient ingredient : salad) {
                if (ingredient.getCaloricity() < targetCaloricity) {
                    caloricityLessValue.put(ingredient.getName(), ingredient.getCaloricity());
                }
            }
            if (caloricityLessValue.size() == 0) {
                throw new ThereIsNoCaloricityLessValueException(targetCaloricity);
            }
        } catch (ThereIsNoCaloricityLessValueException ex) {
            ex.printStackTrace();
        }
        return caloricityLessValue;
    }

    protected double getSaladCaloricity() {
        double saladCaloricity = 0;
        for (Ingredient ingredient : salad) {
            saladCaloricity = saladCaloricity + ingredient.getCaloricity();
        }
        return saladCaloricity;
    }

    protected void printNameIngredients() {
        System.out.println("IngredientJson: " + getIngredientsName());
    }

    protected void printRecipeInFile() {
        try (
            InputStream inputStream = new FileInputStream("src/task2_3/chef/files/inputFile.txt");
            PrintStream outputStream = new PrintStream("src/task2_3/chef/files/outputFile.txt");
        ) {
            outputStream.print("Salad Recipe\n\n");
            outputStream.print("ingredients:\n");
            for (String name : getIngredientsName()) {
                outputStream.print((name+"\n"));
            }
            outputStream.print("\n");
            outputStream.print("Spices:\n");
            int size = inputStream.available();
            for (int i = 0; i < size; i++) {
                outputStream.write(inputStream.read());
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<String> getIngredientsName() {
        List<String> ingredientsListName = new ArrayList<>();
        try {
            for (Ingredient ingredient : salad) {
                if (ingredient.getName() == null) {
                    throw new ThereIsIngredientWithNullNameException();
                }
                else {
                    ingredientsListName.add(ingredient.getName());
                }
            }
            return ingredientsListName;
        }
        catch (NullPointerException ex) {
            System.out.println("There is Null. Getting of the ingredient name is impossible.");
            ex.printStackTrace();
        }
        catch (ThereIsIngredientWithNullNameException ex) {
            ex.printStackTrace();
        }
        finally {
            return ingredientsListName;
        }
    }
}
