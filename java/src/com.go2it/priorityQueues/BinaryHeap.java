package priorityQueues;

import sorting.SortingUtils;

public class BinaryHeap {
    private Comparable[] arr;
    private int lastIndex = 0;

    public BinaryHeap(int size) {
        arr = new Comparable[size];
    }

    public void addElement(Comparable newElem) {
        arr[lastIndex] = newElem;
        swim(lastIndex);
        lastIndex++;
    }

    /**
     * Promote the child element to the top until the proper index is found
     *
     * @param index
     * @return
     */
    private void swim(int index) {
        while (true) {
            //swap the parent and child if child is bigger than parrent
            if (SortingUtils.isLess(arr[index / 2], arr[index])) {
                SortingUtils.exchange(arr, index / 2, index);
                index = index/2;
            } else {
                return;
            }
        }
    }
}
