package com.bodmas;

public class Calculator {

    private int add(int x, int y){
        return x + y;
    }

    private int subtract(int x, int y){
        return x - y;
    }

    private int multiply(int x, int y) {
        return x * y;
    }

    private int divide(int x, int y) {
        return x / y;
    }

    public int evaluateOperation(int x, int y, char o) {
        switch (o) {
            case '+':
                return add(x, y);

            case '-':
                return subtract(x, y);

            case '*':
                return multiply(x, y);

            case '/':
                return divide(x, y);
        }
        throw new RuntimeException("Encountered invalid operand");
    }
}
