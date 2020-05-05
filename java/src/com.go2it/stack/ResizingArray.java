package stack;

public class ResizingArray {
    private int[] array;
    private int currentSize;
    private int firstElemIndex = 0;

    public ResizingArray(int size) {
        this.array = new int[size];

    }

    public ResizingArray(int[] elems) {
        this.array = elems;
        this.currentSize = elems.length;
    }

    /**
     * When the max size is reached, double the size
     *
     * @param i
     */
    public void addItem(int i) {
        final int maxSize = array.length;
        if (currentSize == maxSize) {
           resize();
        }
        array[currentSize++] = i;
    }

    public int get(int i) {
        return array[i];
    }

    public int get() {
        if (currentSize == 0) {
            return -1;
        }
        int result = array[--currentSize];
        array[currentSize] = 0;
        if (currentSize == (array.length / 4)) {
            resize();
        }
        return result;
    }

    private void resize() {
        int[] newArray = new int[currentSize * 2];
        for (int i = 0; i < currentSize; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void resizeFromBeginning() {
        int[] newArray = new int[currentSize];
        for (int i = firstElemIndex; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int dequeue() {
        int result = array[firstElemIndex++];
        if (firstElemIndex == (array.length / 4)) {
            resizeFromBeginning();
        }
        return result;
    }

    public int size() {
        return currentSize;
    }
}
