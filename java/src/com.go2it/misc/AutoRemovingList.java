package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList where the data can be added to both ends + in the middle
 * Adding new element will remove the last element automatically so the list remains of the same size
 */
public class AutoRemovingList<T extends Comparable> {
    private List<Integer> array;
    private int size;

    public AutoRemovingList(int size) {
        array = new ArrayList<Integer>(size);
        this.size = size;
    }

    public void add(Integer newElem) {
        if (array.isEmpty()) {
            for (int i = 0; i < size; i++) {
                array.add(Integer.MIN_VALUE);
            }
        }
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).compareTo(newElem) < 0) {
                array.add(i, newElem);
                break;
            }
        }
//        if (array.get(0).compareTo(newElem) < 0) {
//            //new highest elem
//            addMax(newElem);
//        } else if (array.get(1).compareTo(newElem) < 0) {
//            //put on the middle place
//            array.add(1, newElem);
//        } else if (array.get(2).compareTo(newElem) < 0) {
//            addMin(newElem);
//        }
        trimToSize();
    }

    private void addMax(Integer i) {
        array.add(0, i);
    }

    private void addMin(Integer i) {
        array.add(2, i);
    }

    private void trimToSize() {
        if (array.size() > this.size) {
            for (int i = this.size; i < array.size(); i++) {
                array.remove(i);
            }
        }
    }

    public List<Integer> getArray() {
        return array;
    }
}
