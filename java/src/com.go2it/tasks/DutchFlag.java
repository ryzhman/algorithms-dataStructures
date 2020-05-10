package tasks;

import java.util.HashMap;
import java.util.Map;

public class DutchFlag {

    /**
     * Time complexity - O(1/4*N)
     * Space complexity - O(N)
     *
     * @param arr
     */
    public static void formTheDutchFlag(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int current = i;
            int j = current - 1;
            while (j >= 0 && arr[j].compareTo(arr[current]) > 0) {
                swap(arr, j, current);
                current--;
                j--;
            }
        }
    }

    /**
     * Sorting using the three-way partitioning
     * Iterate over the array until the last index of middle color is not equals to the first index of the bottom color
     * Time complexity - O(N)
     * Space complexity - O(N)
     *
     * @param arr
     */
    public static void formTheDutchFlagThreeWayPartitioning(String[] arr) {
        int lastIndexOfBlue = 0;
        int lastIndexOfRed = 0;
        int lastIndexOfWhite = arr.length - 1;

        while(lastIndexOfRed < lastIndexOfWhite) {
            String color = color(arr, lastIndexOfRed);
            if (color.equalsIgnoreCase("B")) {
                swap(arr, lastIndexOfRed++, lastIndexOfBlue++);
            } else if (color.equalsIgnoreCase("R")) {
                lastIndexOfRed++;
            } else {
                swap(arr, lastIndexOfRed, lastIndexOfWhite--);
            }
        }
    }

    /**
     * Overhead solution
     * Space complexity - O(2*n) + ~2 maps
     * Time complexity - O(1/4 * N^2)
     *
     * @param arr
     */
    public static void formTheDutchFlagViaNumbers(String[] arr) {
        Map<String, Integer> colorToIndex = new HashMap<>();
        colorToIndex.put("B", 0);
        colorToIndex.put("R", 1);
        colorToIndex.put("W", 2);

        Map<Integer, String> indexToColor = new HashMap<>();
        indexToColor.put(0, "B");
        indexToColor.put(1, "R");
        indexToColor.put(2, "W");

        int[] indexedColors = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexedColors[i] = colorToIndex.get(arr[i]);
        }

        for (int i = 0; i < indexedColors.length; i++) {
            int currentIndex = i;
            int j = currentIndex - 1;
            while (j >= 0 && indexedColors[currentIndex] < indexedColors[j]) {
                int temp = indexedColors[j];
                indexedColors[j] = indexedColors[currentIndex];
                indexedColors[currentIndex] = temp;
                j--;
                currentIndex--;
            }
        }

        for (int i = 0; i < indexedColors.length; i++) {
            arr[i] = indexToColor.get(indexedColors[i]);
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static String color(String[] arr, int i) {
        return arr[i];
    }


}
