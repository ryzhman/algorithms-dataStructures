package com.go2it.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResizableStackTest {

    @Test
    public void testAutoResizableStack() {
        DejkstraExpressionStack.Stack stack = new DejkstraExpressionStack.Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
}
