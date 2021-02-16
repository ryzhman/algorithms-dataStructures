package sorting.assignment;

import java.util.Random;

import static sorting.assignment.InsertionSort.insertionSort;
import static sorting.assignment.MergeSort.mergeSort;
import static sorting.assignment.QuickSort.quickSort;
import static sorting.assignment.SelectionSort.selectionSort;

/**
 * Elik
 * Student number - 101274713
 */
public class SortingTask {
    public static void main(String[] args) {
        benchmark(50);
        System.out.println();

        benchmark(1000);
        System.out.println();

        benchmark(10000);
        System.out.println();

        benchmark(100000);
        System.out.println();

        benchmark(1000000);
        System.out.println();
    }

    /**
     * Conduct the benchmarking of sorting int array using 4 selection. insertion, merge and quick sorts
     *
     * @param sizeOfDataSet
     */
    private static void benchmark(int sizeOfDataSet) {
        System.out.println("*********************Working with " + sizeOfDataSet + " elements*********************");
        int[][] dataSet = createCoreData(5, sizeOfDataSet);
        System.out.println("========== Selection sort ==============");
        selectionSort(dataSet, sizeOfDataSet);
        System.out.println("==========");
        System.out.println();

        System.out.println("========== Insertion sort ==============");
        insertionSort(dataSet, sizeOfDataSet);
        System.out.println("==========");
        System.out.println();

        System.out.println("========== Merge sort ==============");
        mergeSort(dataSet, sizeOfDataSet);
        System.out.println("==========");
        System.out.println("*********************Finished working with " + sizeOfDataSet + " elements*********************");
        System.out.println();

        System.out.println("========== Quick sort ==============");
        quickSort(dataSet, sizeOfDataSet);
        System.out.println("==========");
        System.out.println("*********************Finished working with " + sizeOfDataSet + " elements*********************");
    }

    /**
     * Method creates a DataSet of arrays of a defined length.
     * Arrays are copied over to avoid using them by reference
     *
     * @param numberOfDataSets
     * @param size
     * @return
     */
    public static int[][] createCoreData(int numberOfDataSets, int size) {
        int[][] dataSet = new int[numberOfDataSets][];
        int[] coreData1 = createDataSet(size);
        dataSet[0] = coreData1;
        for (int i = 1; i < numberOfDataSets; i++) {
            int[] coreDataCopy = copy(coreData1);
            dataSet[i] = coreDataCopy;
        }
        return dataSet;
    }

    /**
     * Creation of array of a defined length with elems from 1 to 3,000,000
     *
     * @param numberOfElems
     * @return
     */
    public static int[] createDataSet(int numberOfElems) {
        Random random = new Random();
        int[] coreData = new int[numberOfElems];
        for (int i = 0; i < numberOfElems; i++) {
            int randomNum = random.nextInt(3000000);
            coreData[i] = randomNum;
        }
        return coreData;
    }

    public static int[] copy(int[] data) {
        int[] copy = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            copy[i] = data[i];
        }
        return copy;
    }
}
