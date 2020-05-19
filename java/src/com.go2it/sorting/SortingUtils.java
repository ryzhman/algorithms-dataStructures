package sorting;

public class SortingUtils {

    public static void exchange(Comparable[] array, int i1, int i2) {
        Comparable temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static boolean isLess(Comparable i, Comparable j) {
        if (j == null) {
            return false;
        } else {
            return i != null && i.compareTo(j) < 0;
        }
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (isLess(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
