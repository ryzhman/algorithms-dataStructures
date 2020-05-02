package stack;

public class ResizingArray {
    private int[] array;
    private int currentSize;

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
            int[] newArr = new int[currentSize * 2];
            for (int j = 0; j < array.length; j++) {
                newArr[j] = array[j];
            }
            array = newArr;
        }
        array[currentSize++] = i;
    }

    public int get(int i) {
        return array[i];
    }

    public int get() {
        int result = array[--currentSize];
        array[currentSize] = 0;
        if (currentSize == (array.length / 4)) {
            int[] newArray = new int[currentSize];
            for (int i = 0; i < currentSize; i++) {
                newArray[i] = array[i];
            }
        }
        return result;
    }
}
