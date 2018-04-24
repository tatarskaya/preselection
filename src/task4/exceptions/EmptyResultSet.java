package task4.exceptions;

public class EmptyResultSet extends Exception{

    public EmptyResultSet (String ingredient) {
        super("The result set is empty for Ingredient = " + ingredient);
    }
}
