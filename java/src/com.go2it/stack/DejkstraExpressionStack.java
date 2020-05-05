package stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Maintain two stacks to operate the Dejkstra-style expression calculation
 * (1 + ((2 + 3) * (4 * 5))) --> 101
 */
public class DejkstraExpressionStack {
    private Stack stackOperands;
    private Stack stackOperations;

    public DejkstraExpressionStack() {
        stackOperands = new Stack();
        stackOperations = new Stack();
    }

    public int calculate(String expression) throws ScriptException {
        final char[] expressionChars = expression.toCharArray();

        for (int i = 0; i < expressionChars.length; i++) {
            final char elem = expressionChars[i];
            if (elem == '(' || elem == ' ') {
                continue;
            } else if (String.valueOf(elem).matches("[0-9]")) {
                //digit clause
                stackOperands.push(Character.getNumericValue(elem));
            } else if (String.valueOf(elem).matches("[+*/-]")) {
                //operator clause
                stackOperations.push(String.valueOf(elem));
            } else if (elem == ')') {
                //calculate
                final int operand1 = (int)stackOperands.pop();
                final int operand2 = (int)stackOperands.pop();
                final String operation = (String)stackOperations.pop();

                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                String expr = operand1 + operation + operand2;
                int result = (int) engine.eval(expr);
                stackOperands.push(result);
            }
        }
        return (int)stackOperands.pop();
    }


    public static class Stack {
        private Object[] stack;
        private int currentNumberOfElems = 0;

        public Stack() {
            stack = new Object[1];
        }

        public void push(Object value) {
            if (currentNumberOfElems == stack.length) {
                increaseSize();
            }
            stack[currentNumberOfElems++] = value;
        }

        public Object pop() {
            if (currentNumberOfElems == 0) {
                return Integer.MIN_VALUE;
            }
            Object value = stack[--currentNumberOfElems];
            stack[currentNumberOfElems] = 0;
            if (currentNumberOfElems != 0 && (stack.length / 4) == currentNumberOfElems) {
                decreaseSize();
            }
            return value;
        }

        private void decreaseSize() {
            Object[] newStack = new Object[stack.length / 4];
            for (int i = 0; i < currentNumberOfElems; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }


        private void increaseSize() {
            Object[] newStack = new Object[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }

        public int size() {
            return currentNumberOfElems;
        }
    }

}
