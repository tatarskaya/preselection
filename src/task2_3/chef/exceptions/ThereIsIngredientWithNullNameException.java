package task2_3.chef.exceptions;

public class ThereIsIngredientWithNullNameException extends Exception {

    public ThereIsIngredientWithNullNameException(){

        super("There is an ingredient with Null name");
    }
}
