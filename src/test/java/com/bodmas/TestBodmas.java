package com.bodmas;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestBodmas {

    private static final Set<Character> OPERANDS = new HashSet<>();
    static  {
        OPERANDS.add('+');
        OPERANDS.add('-');
        OPERANDS.add('*');
        OPERANDS.add('/');
    }

    private static final String VALID_EXPRESSION = "5+3-4*2/8";
    private static final String INVALID_EXPRESSION = "(5+3-4)*2/8";

    private static final List<String> PARSED = new ArrayList<>();
    static {
        PARSED.add("5");
        PARSED.add("+");
        PARSED.add("3");
        PARSED.add("-");
        PARSED.add("4");
        PARSED.add("*");
        PARSED.add("2");
        PARSED.add("/");
        PARSED.add("8");
    }

    @Test
    public void testCalculator() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.evaluateOperation(5, 3, '+'), "Addition not working correctly");
        assertEquals(2, calculator.evaluateOperation(5, 3, '-'), "Subtraction not working correctly");
        assertEquals(8, calculator.evaluateOperation(4, 2, '*'), "Multiplication not working correctly");
        assertEquals(2, calculator.evaluateOperation(4, 2, '/'), "Division not working correctly");
    }

    @Test
    public void testParser() {
        Parser parser = new Parser(OPERANDS);
        List<String> parsed = parser.parseExpression(VALID_EXPRESSION);
        assertIterableEquals(parsed, PARSED);
        assertThrows(InputMismatchException.class, () -> parser.parseExpression(INVALID_EXPRESSION));
    }

    @Test
    public void testEvaluator() {
        Calculator calculator = mock(Calculator.class);
        Evaluator evaluator = new Evaluator(calculator);
        Parser parser = mock(Parser.class);

        when(parser.parseExpression(VALID_EXPRESSION)).thenReturn(PARSED);
        when(parser.parseExpression(INVALID_EXPRESSION)).thenThrow(new InputMismatchException("Invalid expression"));

        when(calculator.evaluateOperation(5, 3, '+')).thenReturn(8);
        when(calculator.evaluateOperation(8, 4, '-')).thenReturn(4);
        when(calculator.evaluateOperation(4, 2, '*')).thenReturn(8);
        when(calculator.evaluateOperation(8, 8, '/')).thenReturn(1);

        assertEquals(evaluator.evaluate(parser, VALID_EXPRESSION), 1, "Evaluation should return the same result as calculation");
        assertThrows(InputMismatchException.class, () -> evaluator.evaluate(parser, INVALID_EXPRESSION));
    }
}
