package com.bodmas;

import java.util.List;
import java.util.Set;

public class Evaluator {

    private final Calculator calculator;

    public Evaluator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int evaluate(Parser parser, String expression) {
        List<String> elements = parser.parseExpression(expression);
        int total = Integer.parseInt(elements.get(0));
        for (int i = 1; i < elements.size(); i+=2) {
            total = calculator.evaluateOperation(total, Integer.parseInt(elements.get(i+1)), elements.get(i).charAt(0));
        }
        return total;
    }
}
