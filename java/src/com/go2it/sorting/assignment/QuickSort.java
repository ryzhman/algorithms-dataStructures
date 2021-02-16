package sorting.assignment;

import static sorting.assignment.SortingTask.copy;

/**
 * Elik
 * Student number - 101274713
 */
public class QuickSort {
    /**
     * Quick sort benchmarking
     *
     * @param coreData
     * @param sizeOfDataSet
     */
    public static void quickSort(int[][] coreData, int sizeOfDataSet) {
        for (int i = 0; i < coreData.length; i++) {
            int[] copy = copy(coreData[i]);

            long start = System.nanoTime();
            quickSort(copy, 0, copy.length - 1);
            long end = System.nanoTime();

            String suffixMessage;
            if (sizeOfDataSet < 1000000) {
                suffixMessage = (end - start) + " nanoseconds";
            } else {
                suffixMessage = (end - start) / 1000 + " milliseconds";
            }
            System.out.println("The run #" + i + " for the DateSet of:" + sizeOfDataSet + " took " + suffixMessage);
//            System.out.println(Arrays.toString(copy));
            System.out.println();
        }
    }

    private static int partitionForQuickSort(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int partitionIndex = partitionForQuickSort(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

}
