package task1.calculator;

import java.math.BigDecimal;

public class Calculator {

    private int scale =  20;

    public void add(Arguments arguments) {
        arguments.setArithmeticOperation("+");
        arguments.setResult(arguments.getArg1().add(arguments.getArg2()));
    }

    public void subtract(Arguments arguments) {
        arguments.setArithmeticOperation("-");
        arguments.setResult(arguments.getArg1().subtract(arguments.getArg2()));
    }

    public void multiply(Arguments arguments) {
        arguments.setArithmeticOperation("*");
        arguments.setResult((arguments.getArg1().multiply(arguments.getArg2())).setScale(scale, BigDecimal.ROUND_HALF_UP));
    }

    public void divide(Arguments arguments) {
        arguments.setArithmeticOperation("/");
        arguments.setResult((arguments.getArg1().divide(arguments.getArg2(), scale, BigDecimal.ROUND_HALF_UP)));
    }

}
