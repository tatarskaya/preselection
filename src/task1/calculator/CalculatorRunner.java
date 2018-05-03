package task1.calculator;

import java.util.Arrays;
import java.util.List;

public class Runner {

    private static final List<String> CONTINUE_FLAGS = Arrays.asList("No", "no", "N", "n");

    public static void main(String[] args) {

        boolean proceed = true;
        String quit;

        while (proceed) {
            Arguments arguments = new Arguments();
            Calculator calculator = new Calculator();
            ArgumentsScanner argumentsScanner = new ArgumentsScanner();

            argumentsScanner.inputFirstArgument(arguments);
            argumentsScanner.inputArithmeticOperation(arguments);
            argumentsScanner.inputSecondArgument(arguments);

            switch (arguments.getArithmeticOperation()) {
                case "+":
                    calculator.add(arguments);
                    break;
                case "-":
                    calculator.subtract(arguments);
                    break;
                case "*":
                    calculator.multiply(arguments);
                    break;
                case "/":
                    calculator.divide(arguments);
                    break;
            }

            System.out.println(String.format("Result: %s %s %s = %s", arguments.getArg1(), arguments.getArithmeticOperation(), arguments.getArg2(), arguments.getResult()));
            System.out.println("Type 'Yes' to continue or type 'No' to exit: ");
            if (argumentsScanner.getInput().hasNext()) {
                quit = argumentsScanner.getInput().next();
                if (CONTINUE_FLAGS.contains(quit)) {
                    proceed = false;
                }
            }
        }
    }
}
