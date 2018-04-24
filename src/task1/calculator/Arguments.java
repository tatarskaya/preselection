package task1.calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Arguments {

    private BigDecimal arg1;
    private BigDecimal arg2;
    private String arithmeticOperation;
    private BigDecimal result;

    protected BigDecimal getArg1() {
        return arg1;
    }

    protected void setArg1(BigDecimal arg1) {
        this.arg1 = arg1;
    }

    protected BigDecimal getArg2() {
        return arg2;
    }

    protected void setArg2(BigDecimal arg2) {
        this.arg2 = arg2;
    }

    protected String getArithmeticOperation() {
        return arithmeticOperation;
    }

    protected void setArithmeticOperation(String arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    protected BigDecimal getResult() {
        return result;
    }

    protected void setResult(BigDecimal result) {
        this.result = result;
    }

}
