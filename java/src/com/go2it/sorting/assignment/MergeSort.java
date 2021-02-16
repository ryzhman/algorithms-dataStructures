package sorting.assignment;

import static sorting.assignment.SortingTask.copy;

public class MergeSort {

    /**
     * Merge sort benchmarking
     *
     * @param coreData
     * @param sizeOfDataSet
     */
    public static void mergeSort(int[][] coreData, int sizeOfDataSet) {
        for (int i = 0; i < coreData.length; i++) {
            int[] copy = copy(coreData[i]);

            long start = System.nanoTime();
            int[] sortedArr = mergeSort(copy);

            long end = System.nanoTime();

            String suffixMessage;
            if (sizeOfDataSet < 1000000) {
                suffixMessage = (end - start) + " nanoseconds";
            } else {
                suffixMessage = (end - start) / 1000 + " milliseconds";
            }
            System.out.println("The run #" + i + " for the DateSet of:" + sizeOfDataSet + " took " + suffixMessage);
//            System.out.println(Arrays.toString(sortedArr));
            System.out.println();
        }
    }

    public static int[] mergeSort(int[] arrToSort) {
        mergeSortWorker(0, arrToSort.length - 1, arrToSort);
        return arrToSort;
    }

    private static void mergeSortWorker(int lowerBound, int upperBound, int[] arrToSort) {
        int mid;
        if (lowerBound < upperBound) {
            mid = (lowerBound + upperBound) / 2;
            mergeSortWorker(lowerBound, mid, arrToSort);
            mergeSortWorker(mid + 1, upperBound, arrToSort);
            merge(lowerBound, mid, upperBound, arrToSort);
        }
    }

    private static void merge(int low, int mid, int upper, int[] arrToSort) {
        int i, j, k;
        int[] temp = new int[upper - low + 1];
        i = low;
        k = 0;
        j = mid + 1;
        while (i <= mid && j <= upper) {
            if (arrToSort[i] < arrToSort[j]) {
                temp[k] = arrToSort[i];
                i++;
            } else {
                temp[k] = arrToSort[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arrToSort[i];
            k++;
            i++;
        }
        while (j <= upper) {
            temp[k] = arrToSort[j];
            k++;
            j++;
        }
        // copy back
        for (i = low; i <= upper; i++) {
            arrToSort[i] = temp[i - low];
        }
    }

}
