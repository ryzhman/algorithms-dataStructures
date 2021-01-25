package com.go2it.misc;

public class Stack {
    private int[] elems;
    private int currentSize = 0;
    private int maxSize;

    public Stack(int[] elems) {
        this.elems = elems;
        this.maxSize = elems.length;
    }

    public Stack(int size) {
        this.elems = new int[size];
        this.maxSize = size;
    }

    public void push(int i) {
        if ((currentSize + 1) > maxSize) {
            return;
        }
        elems[currentSize++] = i;
    }

    public int pop() {
        if (currentSize <= 0) {
            throw new RuntimeException("Stack is empty");
        }
        int itemToReturn = elems[--currentSize];
        elems[currentSize] = 0;
        return itemToReturn;
    }


    public static void main(String[] args) {
        final Stack stack = new Stack(3);
        stack.push(3);
        stack.push(6);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public int[] getElems() {
        return elems;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
