package task2_3.chef.exceptions;

public class NegativeCaloricityException extends Exception {

    public NegativeCaloricityException(){

        super("There is a negative caloricity");
    }
}
