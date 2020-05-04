package stack;

/**
 * ResizingStack with getMax() method based on two stacks
 *
 * Two stacks are maintained:
 *  - one for conventional values
 *  - second - for max values
 *
 *  After new element is pushed, we check what is in the current max value and if it is bigger than the previous one,
 *  push it to the stack.
 *  Does not guarantee to have the real set of maximums. Everything depends on the first digit in the stack
 */
public class ResizingStackWithMaxStacks {
    private Object[] stack;
    private int currentNumberOfElems = 0;

    private Object[] maxStack;
    private int currentNumberOfMaxElems = 0;

    private int max = Integer.MIN_VALUE;
    private int maxIndex = 0;

    public ResizingStackWithMaxStacks() {
        stack = new Object[1];
        maxStack = new Object[1];
    }

    public void push(Object value) {
        if (currentNumberOfElems == stack.length) {
            increaseSize();
        }
        stack[currentNumberOfElems++] = value;

        if ((int) value > max) {
            max = (int) value;
            pushToMax(max);
            maxIndex = currentNumberOfElems - 1;
        }
    }

    private void pushToMax(int max) {
        if (currentNumberOfMaxElems == maxStack.length) {
            increaseMaxSize();
        }
        maxStack[currentNumberOfMaxElems++] = max;
    }

    public Object pop() {
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

    private void increaseMaxSize() {
        Object[] newStack = new Object[maxStack.length * 2];
        for (int i = 0; i < maxStack.length; i++) {
            newStack[i] = maxStack[i];
        }
        maxStack = newStack;
    }

    public int getMax() {
        Object value = maxStack[--currentNumberOfMaxElems];
        maxStack[currentNumberOfMaxElems] = 0;
        return (int) value;
    }

}
