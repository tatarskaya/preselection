package task1.calculator;

import java.math.BigDecimal;
import java.util.Scanner;


public class ArgumentsScanner {

    private Scanner input = new Scanner(System.in);

    public Scanner getInput() {
        return input;
    }

    public void inputFirstArgument(Arguments arguments) {
        System.out.print("Input a first argument: ");
        String inputString;
        BigDecimal arg1;
        boolean firstArgumentProceed = false;

        do {
            if (input.hasNext()) {
                inputString = input.next();
                try {
                    arg1 = new BigDecimal(inputString);
                    arguments.setArg1(arg1);
                    firstArgumentProceed = false;
                }
                catch (NumberFormatException e) {
                    System.out.println("It is possible only numbers, '.', '-'. Input the first argument one more time: ");
                    firstArgumentProceed = true;
                }
            }
        } while (firstArgumentProceed);
    }

    public void inputSecondArgument(Arguments arguments) {
        String inputString;
        BigDecimal arg2;
        boolean secondArgumentProceed = false;

        System.out.print("Input a second argument: ");
        do {
            if (input.hasNext()) {
                inputString = input.next();
                try {
                    arg2 = new BigDecimal(inputString);
                    if ((arg2.compareTo(BigDecimal.ZERO) == 0) && (arguments.getArithmeticOperation().equals("/"))) {
                        System.out.println("It is impossible to divide by 0. Input the second argument one more time: ");
                        secondArgumentProceed = true;
                    }
                    else {
                        arguments.setArg2(arg2);
                        secondArgumentProceed = false;
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("It is possible only numbers, '.', '-'. Input the second argument one more time: ");
                }
            }
        } while (secondArgumentProceed);
    }

    public void inputArithmeticOperation(Arguments arguments) {
        boolean arithmetic_operation_proceed = true;
        String operation = "";
        System.out.print("Input an arithmetic operation (+, -, *, /): ");
        do {
            if (input.hasNext()) {
                operation = input.next();
                arithmetic_operation_proceed = isArithmeticOperationString(arguments, operation);
            }
        } while(arithmetic_operation_proceed);
    }

    private boolean isArithmeticOperationString(Arguments arguments, String inputArgument) {
        switch (inputArgument) {
            case "+":
                arguments.setArithmeticOperation(inputArgument);
                return false;
            case "-":
                arguments.setArithmeticOperation(inputArgument);
                return false;
            case "*":
                arguments.setArithmeticOperation(inputArgument);
                return false;
            case "/":
                arguments.setArithmeticOperation(inputArgument);
                return false;
            default:
                System.out.print("It is possible only +, -, *, /. Input an arithmetic operation one more time: ");
                return true;
        }
    }
}
