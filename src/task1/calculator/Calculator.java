package task1.calculator;

import java.math.BigDecimal;

public class Calculator {

    private int scale =  20;

    protected void add(Arguments arguments) {
        arguments.setArithmeticOperation("+");
        arguments.setResult(arguments.getArg1().add(arguments.getArg2()));
    }

    protected void subtract(Arguments arguments) {
        arguments.setArithmeticOperation("-");
        arguments.setResult(arguments.getArg1().subtract(arguments.getArg2()));
    }

    protected void multiply(Arguments arguments) {
        arguments.setArithmeticOperation("*");
        arguments.setResult((arguments.getArg1().multiply(arguments.getArg2())).setScale(scale, BigDecimal.ROUND_HALF_UP));
    }

    protected void divide(Arguments arguments) {
        arguments.setArithmeticOperation("/");
        arguments.setResult((arguments.getArg1().divide(arguments.getArg2(), scale, BigDecimal.ROUND_HALF_UP)));
    }

}
