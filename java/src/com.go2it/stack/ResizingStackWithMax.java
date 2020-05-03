package stack;

/**
 * ResizingStack with getMax() method
 */
public class ResizingStackWithMax {
    private Object[] stack;
    private int currentNumberOfElems = 0;
    private int max = Integer.MIN_VALUE;
    private int maxIndex = 0;

    public ResizingStackWithMax() {
        stack = new Object[1];
    }

    public void push(Object value) {
        if (currentNumberOfElems == stack.length) {
            increaseSize();
        }
        stack[currentNumberOfElems++] = value;

        if ((int) value > max) {
            max = (int)value;
            maxIndex = currentNumberOfElems -1;
        }
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

    public Object getMax() {
        return max;
    }

    public Object getMaxByIndex() {
        return stack[maxIndex];
    }


}
