package task2_3.chef.exceptions;

public class ThereIsNoCaloricityLessValueException extends Exception {

    public ThereIsNoCaloricityLessValueException(double targetCaloricity ){

        super("There is no salad with the caloricity less " + targetCaloricity);
    }
}
