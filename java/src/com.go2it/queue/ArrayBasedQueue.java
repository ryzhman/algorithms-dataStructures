package queue;

import stack.ResizingArray;

/**
 * No way to make this as a Generic one
 * Only casting from Object is feasible here
 */
public class ArrayBasedQueue implements iQueue {
    private ResizingArray queue;

    public ArrayBasedQueue() {
        this.queue = new ResizingArray(1);
    }

    @Override
    public void enqueue(int i) {
        this.queue.addItem(i);
    }

    @Override
    public int dequeue(){
        return this.queue.dequeue();
    }
}
