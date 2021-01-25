package com.go2it.queue;

import stack.HomeMadeLinkedListBasedStack;

public class Queue implements iQueue {
    private HomeMadeLinkedListBasedStack<Integer> queue;

    public Queue(HomeMadeLinkedListBasedStack<Integer> queue) {
        this.queue = queue;
    }

    public Queue() {
        this.queue = new HomeMadeLinkedListBasedStack<Integer>();
    }

    public void enqueue(int i) {
        this.queue.push(i);
    }

    public int dequeue(){
        return this.queue.dequeue();
    }
}
