package task2_3.chef;

import task2_3.chef.exceptions.ThereIsIngredientWithNullNameException;
import task2_3.chef.exceptions.ThereIsNoCaloricityLessValueException;
import task2_3.chef.ingredients.Ingredient;

import java.io.*;
import java.util.*;

public class SaladProcessor {
    private List<Ingredient> salad;

    public SaladProcessor(List<Ingredient> salad) {
        this.salad = salad;
    }

    public List<Ingredient> sortByName() {
        salad.sort(new NameComparator());
        return salad;
    }

    public HashMap<String, Double> getCaloricityLessValue(double targetCaloricity) {
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

    public double getSaladCaloricity() {
        double saladCaloricity = 0;
        for (Ingredient ingredient : salad) {
            saladCaloricity = saladCaloricity + ingredient.getCaloricity();
        }
        return saladCaloricity;
    }

    public void printNameIngredients() {
        System.out.println(getIngredientsName());
    }

    public byte[] readSpicesFromFile() {
        byte[] spiceByte = null;
        try (
                InputStream inputStream = new FileInputStream("src/task2_3/chef/files/inputFile.txt");
        ) {
            int size = inputStream.available();
            spiceByte = new byte[size];
            for (int i = 0; i < size; i++) {
                inputStream.read(spiceByte);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return spiceByte;
    }

    public void readSpicesPrintRecipeInFile() {
        try (
            PrintStream outputStream = new PrintStream("src/task2_3/chef/files/outputFile.txt");
        ) {
            outputStream.print("Salad Recipe\n\n");
            outputStream.print("ingredients:\n");
            for (String name : getIngredientsName()) {
                outputStream.print((name+"\n"));
            }
            outputStream.print("\n");
            outputStream.print("Spices:\n");
            outputStream.write(readSpicesFromFile());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            System.out.println("It is impossible to read Spices form file");
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
