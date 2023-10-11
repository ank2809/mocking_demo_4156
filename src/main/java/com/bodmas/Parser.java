package com.bodmas;

import java.util.*;

public class Parser {

    private final Set<Character> operands;
    public Parser(Set<Character> operands) {
        this.operands = operands;
    }

    public List<String> parseExpression(String expression) {
        int index = 0;
        ArrayList<String> elements = new ArrayList<>();
        while (index < expression.length()) {
            int end = index;
            while(end < expression.length() && Character.isDigit(expression.charAt(end))) {
                end ++;
            }
            if (end == index) {
                throw new InputMismatchException("Expected valid mathematical expression");
            }
            elements.add(expression.substring(index, end));
            if (end == expression.length()) {
                break;
            }
            if (operands.contains(expression.charAt(end))) {
                elements.add(String.valueOf(expression.charAt(end)));
            }
            else {
                throw new InputMismatchException("Expected valid operands");
            }
            index = end + 1;
        }
        if (elements.size() % 2 == 0) {
            throw new InputMismatchException("Expected valid mathematical expression");
        }
        return elements;
    }
}
