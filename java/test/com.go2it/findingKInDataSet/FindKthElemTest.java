package findingKInDataSet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindKthElemTest {
    private final Integer[] INTEGERS = {3, 1, 0, -1, 9, 7, 4};

    @Test
    public void test() {
        assertEquals(1, FindKthElem.findKthSmallestElem(INTEGERS, 3 - 1, 1, INTEGERS.length - 1, 0));
    }

    @Test
    public void testTwo() {
        assertEquals(3, FindKthElem.findKthSmallestElem(INTEGERS, 4 - 1, 1, INTEGERS.length - 1, 0));
    }

    @Test
    public void testThree() {
        assertEquals(7, FindKthElem.findKthSmallestElem(INTEGERS, 6 - 1, 1, INTEGERS.length - 1, 0));
    }

    @Test
    public void test4() {
        Integer[] testArr = {7, 10, 4, 3, 20, 15};
        assertEquals(10, FindKthElem.findKthSmallestElem(testArr, 4 - 1, 1, testArr.length - 1, 0));
    }

    @Test
    public void test5() {
        Integer[] testArr = {7, 10, 4, 3, 20, 15};
        assertEquals(7, FindKthElem.findKthSmallestElem(testArr, 3 - 1, 1, testArr.length - 1, 0));
    }

}
