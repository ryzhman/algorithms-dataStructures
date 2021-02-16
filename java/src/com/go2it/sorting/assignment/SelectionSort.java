package sorting.assignment;

import static sorting.assignment.SortingTask.copy;

public class SelectionSort {

    /**
     * Selection sort benchmarking
     *
     * @param dataSet
     * @param sizeOfDataSet
     */
    public static void selectionSort(int[][] dataSet, int sizeOfDataSet) {
        for (int i = 0; i < dataSet.length; i++) {
            int[] copy = copy(dataSet[i]);

            long start = System.nanoTime();
            int[] sortedArr = selectionSort(copy);
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

    private static int[] selectionSort(int[] arrToSort) {
        int biggestLoc;
        int temp;
        for (int start = 0; start < arrToSort.length - 1; start++) {
            biggestLoc = start;
            for (int index = start + 1; index < arrToSort.length; index++) {
                if (arrToSort[index] < arrToSort[biggestLoc]) {
                    biggestLoc = index;
                }
            }
            temp = arrToSort[start];
            arrToSort[start] = arrToSort[biggestLoc];
            arrToSort[biggestLoc] = temp;
        }
        return arrToSort;
    }
}
