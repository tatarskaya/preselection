package task1.calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Arguments {

    private BigDecimal arg1;
    private BigDecimal arg2;
    private String arithmeticOperation;
    private BigDecimal result;

    public BigDecimal getArg1() {
        return arg1;
    }

    public void setArg1(BigDecimal arg1) {
        this.arg1 = arg1;
    }

    public BigDecimal getArg2() {
        return arg2;
    }

    public void setArg2(BigDecimal arg2) {
        this.arg2 = arg2;
    }

    public String getArithmeticOperation() {
        return arithmeticOperation;
    }

    public void setArithmeticOperation(String arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

}
