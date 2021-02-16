package sorting.assignment;

import static sorting.assignment.SortingTask.copy;

public class InsertionSort {

    /**
     * Insertion sort benchmarking
     *
     * @param coreData
     * @param sizeOfDataSet
     */
    public static void insertionSort(int[][] coreData, int sizeOfDataSet) {
        for (int i = 0; i < coreData.length; i++) {
            int[] copy = copy(coreData[i]);

            long start = System.nanoTime();
            int[] sortedArr = insertionSort(copy);
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

    private static int[] insertionSort(int[] m_array) {
        int n = m_array.length - 1;
        for (int currentIndex = 1; currentIndex < n; ++currentIndex) {
            int value = m_array[currentIndex];
            int previousElemIndex = currentIndex - 1;

            while (previousElemIndex >= 0 && m_array[previousElemIndex] > value) {
                m_array[previousElemIndex + 1] = m_array[previousElemIndex];
                previousElemIndex = previousElemIndex - 1;
            }
            m_array[previousElemIndex + 1] = value;
        }
        return m_array;
    }
}
