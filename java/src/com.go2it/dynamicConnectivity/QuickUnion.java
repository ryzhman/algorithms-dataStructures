package com.go2it.dynamicConnectivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of *quick union* data structure
 *
 */
public class QuickUnion implements DataStructure {
    private int[] elements;

    public QuickUnion(int size) {
        elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = i;
        }
    }

    /**
     * Eager union representation
     * 0 1 2 3 4 5
     * 1 1 3 0 2 5
     * second array shows the chain of unions
     *
     * @param i1
     * @param i2
     */
    public void union(int i1, int i2) {
        //combine branches by their roots
        int i1Root = root(i1);
        int i2Root = root(i2);
        elements[i1Root] = i2Root;
    }

    @Override
    public int root(int i) {
        while (elements[i] != i) {
            i = elements[i];
        }
        return i;
    }

    @Override
    public boolean areConnected(int i1, int i2) {
        int rootForI1 = root(i1);
        int rootForI2 = root(i2);
        return rootForI1 == rootForI2;
    }

    /**
     * Returns the component both elements are
     * or empty if they are in different components
     *
     * @param i1
     * @param i2
     * @return
     */
    @Override
    public List<Integer> findComponent(int i1, int i2) {
        if (areConnected(i1, i2)) {
            int root = elements[i1];
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == root) {
                    result.add(i);
                }
            }
            return result;
        }
        return Collections.emptyList();
    }

    @Override
    public int count() {
        return elements.length;
    }
}
