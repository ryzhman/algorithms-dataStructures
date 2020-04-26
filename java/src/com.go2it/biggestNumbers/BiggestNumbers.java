package main.com.go2it.biggestNumbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Get an array of unordered numbers
 * Find three biggest
 */
public class BiggestNumbers {
    static final List<Integer> RESULT = Stream.of(44,37,23).collect(Collectors.toList());

    public static void main(String[] args) {
        Integer[] testArray = {0, 44, -12, 4, 8, 1, -5, 37, 12, 10, 23};

        List<Integer> res1 = getBySorting(testArray);
        System.out.println("Result: " + RESULT.equals(res1));

    }

    /*
     * Sort an array and get the last three elems
     */
    static List<Integer> getBySorting(Integer[] arr) {
        //copy of n elems => n
        List<Integer> sortedArr = Arrays.asList(arr);
        //n OR n log(n) => n + n OR n + n log(n)
        Collections.sort(sortedArr);
        //constant speed
        return Stream.of(sortedArr.get(sortedArr.size() - 1), sortedArr.get(sortedArr.size() - 2), sortedArr.get(sortedArr.size() - 3)).collect(Collectors.toList());
    }




}
