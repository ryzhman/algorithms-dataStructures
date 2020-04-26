package dynamicConnectivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of *quick find* data structure
 *
 */
public class QuickFind implements DataStructure {
    private int[] elements;

    public QuickFind(int size) {
        elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = i;
        }
    }

    /**
     * Eager union representation
     * 0 1 2 3 4 5
     * 1 1 3 1 3 5
     * second array represents the common root element
     *
     * @param i1
     * @param i2
     */
    public void union(int i1, int i2) {
        final int oldValue = elements[i1];
        final int newValue = elements[i2];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == oldValue) {
                elements[i] = newValue;
            }
        }
    }

    @Override
    public boolean areConnected(int i1, int i2) {
        return elements[i1] == elements[i2];
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

    @Override
    public int root(int i) {
        return 0;
    }
}
