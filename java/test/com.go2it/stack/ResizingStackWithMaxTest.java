package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResizingStackWithMaxTest {

    @Test
    public void testAutoResizableStack() {
        ResizingStackWithMax stack = new ResizingStackWithMax();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void getMaxValue() {
        ResizingStackWithMax stack = new ResizingStackWithMax();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(10);
        stack.push(-9);
        stack.push(0);
        stack.push(1);

        assertEquals(10, stack.getMax());
        assertEquals(10, stack.getMaxByIndex());
    }

}
