package com.go2it.misc;

import com.go2it.stack.HomeMadeLinkedListBasedStack;

import java.util.Iterator;

/**
 * There is no way to get the element from the sequence.
 * Only Iterator() is available
 * @param <T>
 */
public class Bag<T> implements Iterable<T>{
    private int size = 0;
    private HomeMadeLinkedListBasedStack.Node topNode;
    private HomeMadeLinkedListBasedStack.Node startNode;


    public Bag() {
    }

    /**
     * is used for both Queue and Stack
     * @param elem
     */
    public void push(T elem) {
        if (topNode == null) {
            topNode = new HomeMadeLinkedListBasedStack.Node(elem, null, null);
            startNode = topNode;
        } else {
            HomeMadeLinkedListBasedStack.Node newTop = new HomeMadeLinkedListBasedStack.Node(elem, null, topNode);
            topNode.setNext(newTop);
            topNode = newTop;
        }
        size++;
    }

    public int size() {
        int size = 0;
        HomeMadeLinkedListBasedStack.Node node = topNode;
        if (node != null) {
            size++;
            while (node.getPrevious() != null) {
                size++;
                node = node.getPrevious();
            }
        }
        return size;
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            HomeMadeLinkedListBasedStack.Node currentNode = startNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                HomeMadeLinkedListBasedStack.Node nodeToShow =  currentNode;
                currentNode = currentNode.getNext();
                return (T) nodeToShow.getValue();
            }
        };
    }
}
