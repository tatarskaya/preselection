package task4.exceptions;

public class WrongIngredientName extends Exception {

    public WrongIngredientName (String ingredientName) {
        super("The ingredient with name \"" + ingredientName + "\" is absent");
    }

    public WrongIngredientName (String ingredientName, Throwable cause) {
        super("The ingredient with name \"" + ingredientName + "\" is absent", cause);
    }
}
