package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sorting.SortingUtils.isLess;

public class DecimalDominants {

    /**
     * Find all elem in the array that occurs more than arr.length/10 times
     * Map solution
     * <p>
     * Time complexity - O(n)
     * Space complexity - O(n)
     *
     * @param arr
     * @return
     */
    public static int[] findEntriesOccurringMoreThanKTimes(int[] arr) {
        final int requiredNumberOfOccurance = arr.length / 10;
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer occurance = result.get(arr[i]);
            if (occurance != null) {
                occurance = ++occurance;
            } else {
                occurance = 1;
            }
            result.put(arr[i], occurance);
        }
        result.entrySet().removeIf((entry) -> entry.getValue() < requiredNumberOfOccurance);
        return result.entrySet().stream().mapToInt(entry -> entry.getKey()).toArray();
    }


    /**
     * Sort an array first using the merge sort and then iterate over and find all elems that occur > n/10 times inside
     * <p>
     * Time complexity = O(n log n)
     * Space = O(m) - number of elems occurring > n/10 times
     *
     * @param arr
     * @return
     */
    public static Comparable[] findEntriesOccurringMoreThanKTimesMergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        mergeSortBottomUp(arr, aux, 0, arr.length - 1);

        int requiredNumOfOccurance = arr.length / 10;
        List<Comparable> result = new ArrayList<>();

        int currentIndex = 0;
        int currentElemCounter = 0;
        while (true) {
            if (currentIndex >= arr.length - 1) {
                break;
            }
            Comparable currentElem = arr[currentIndex++];
            currentElemCounter++;
            Comparable nextElem = arr[currentIndex];
            if (currentElem.equals(nextElem)) {
                ++currentElemCounter;
                if (currentElemCounter == requiredNumOfOccurance) {
                    result.add(currentElem);
                } else if (currentElemCounter > requiredNumOfOccurance) {
                    continue;
                }
            } else {
                currentElemCounter = 0;
            }
        }

        Comparable[] resultComp = new Comparable[result.size()];
        for (int i=0; i< result.size(); i++) {
            resultComp[i] = result.get(i);
        }
        return resultComp;
    }

    private static void mergeSortBottomUp(Comparable[] original, Comparable[] aux, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        mergeSortBottomUp(original, aux, low, middle);
        mergeSortBottomUp(original, aux, middle + 1, high);
        merge(original, aux, low, middle, high);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
//        assert isSorted(a, lo, mid); // precondition: a[lo..mid] sorted
//        assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (isLess(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
//        assert isSorted(a, lo, hi); // postcondition: a[lo..hi] sorted
    }

    /**
     * Three way partitioning implementation
     * https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pdf/05DemoQuick.pdf
     * <p>
     * Compare elements with the pivot point, place to the left element. Iterate over the left subarray and check on placing new elem if it is present there.
     * If yes, remove the elem from the left array
     *
     * @param arr
     * @return
     */


}
