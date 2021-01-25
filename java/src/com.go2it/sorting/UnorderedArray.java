package com.go2it.sorting;

import java.util.Random;

public class UnorderedArray {
    private int[] m_array;
    private int maxSize;
    private int numElements;

    public UnorderedArray(int size) {
        this.maxSize = size;
        m_array = new int[size];
    }

    public boolean addLast(int item) {
        if (numElements >= maxSize) {
            return false;
        }
        m_array[numElements++] = item;
        return true;
    }

    public void removeLast() {
        m_array[numElements--] = 0;
    }

    public boolean efficientRemove(int index) {
        if (index > numElements) {
            return false;
        }
        m_array[index] = m_array[--numElements];
        return true;
    }

    public boolean removeByIndex(int index) {
        for (int i = index; i < numElements-1; i++) {
            m_array[i] = m_array[i + 1];
        }
        numElements--;
        return true;
    }

    public int linearSearch(int item) {
        for (int i = 0; i < numElements; i++) {
            if (m_array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public boolean exists(int key) {
        return linearSearch(key) != -1;
    }

    public void insertionSortAsc() {
        int n = m_array.length;
        for (int currentIndex = 1; currentIndex < n; ++currentIndex) {
            int value = m_array[currentIndex];
            int previousElemIndex = currentIndex - 1;

            /* Move elements of arr[0..currentIndex-1], that are
               greater than value, to one position ahead
               of their current position */
            while (previousElemIndex >= 0 && m_array[previousElemIndex] > value) {
                m_array[previousElemIndex + 1] = m_array[previousElemIndex];
                previousElemIndex = previousElemIndex - 1;
            }
            m_array[previousElemIndex + 1] = value;
        }
    }

    public void selectionSortAsc() {
        int biggestLoc;
        int temp;
        for (int start = 0; start < numElements - 1; start++) {
            biggestLoc = start;
            for (int index = start + 1; index < numElements; index++) {
                if (m_array[index] > m_array[biggestLoc]) {
                    biggestLoc = index;
                }
            }
            temp = m_array[start];
            m_array[start] = m_array[biggestLoc];
            m_array[biggestLoc] = temp;
        }
    }

    public String listItems() {
        String output = " List :";
        for (int index = 0; index < numElements; index++) {
            output += " " + m_array[index];
        }
        return output;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        UnorderedArray ul = new UnorderedArray(5);
        for (int x = 0; x < 10; x++) {
            ul.addLast(rand.nextInt(90));
        }

        System.out.println("Loading done.....Sorting started.");
        System.out.println(ul.listItems());
        long start = System.nanoTime();
//        ul.selectionSortAsc();
//        ul.insertionSortAsc();
//        ul.efficientRemove(0);
        ul.removeByIndex(1);
        long end = System.nanoTime();
        System.out.println("Sorting done..... Took :" + (end - start) + " nanoseconds");
        System.out.println(ul.listItems());

    }
}
