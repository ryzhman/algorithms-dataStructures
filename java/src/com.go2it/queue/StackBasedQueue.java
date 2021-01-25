package com.go2it.queue;

import stack.DejkstraExpressionStack;

/**
 * Using double queue to create a stack by another stack.
 * The result is the queue
 *
 */
public class StackBasedQueue {
    private DejkstraExpressionStack.Stack inStack;
    private DejkstraExpressionStack.Stack resultingStack;

    public StackBasedQueue() {
        this.inStack = new DejkstraExpressionStack.Stack();
    }

    public void enqueue(int elem) {
        inStack.push(elem);
    }

    public int dequeue() {
        if (resultingStack == null) {
            resultingStack = new DejkstraExpressionStack.Stack();
            int i;
            while ((i = (int) inStack.pop()) != Integer.MIN_VALUE) {
                resultingStack.push(i);
            }
        }
        return (int) resultingStack.pop();
    }
}
