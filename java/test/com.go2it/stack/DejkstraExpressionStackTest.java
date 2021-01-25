package com.go2it.stack;

import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DejkstraExpressionStackTest {

    @Test
    public void testExpressionCalculation() throws ScriptException {
        String expr = "(1 + ((2 + 3) * (4 * 5)))";
        final DejkstraExpressionStack dejkstraExpressionStack = new DejkstraExpressionStack();

        assertEquals(101, dejkstraExpressionStack.calculate(expr));
    }
}
