package dynamicConnectivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of *weightened quick union* data structure
 * Find is O(lg(n))
 * Union - O(1)
 *
 */
public class WeightenedQuickUnion implements DataStructure {
    private int[] elements;
    private int[] treeSizeForEachElem;

    public WeightenedQuickUnion(int size) {
        elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = i;
        }
        //all are set to 0
        treeSizeForEachElem = new int[size];
    }

    /**
     * @param i1
     * @param i2
     */
    public void union(int i1, int i2) {
        //combine branches by their roots
        //check what branch is bigger before union
        int i = root(i1);
        int j = root(i2);
        if (i == j) {
            return;
        }
        //check the size of the trees to determine what will be the new root
        //a root with smaller tree will be the child of the bigger one
        if (treeSizeForEachElem[i] < treeSizeForEachElem[j]) {
            //assign the root
            elements[i] = j;
            //increase the tree size for the new root
            treeSizeForEachElem[j] += treeSizeForEachElem[i];
        } else {
            elements[j] = i;
            treeSizeForEachElem[i] += treeSizeForEachElem[j];
        }
    }

    @Override
    public int root(int i) {
        int depth = 0;
        while (elements[i] != i) {
            i = elements[i];
            depth++;
        }
        treeSizeForEachElem[i] = depth;
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
