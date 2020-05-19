package priorityQueues;

import org.junit.jupiter.api.Test;

public class BinaryHeapTest {

    @Test
    public void testBinaryHeap() {
        BinaryHeap binaryHeap = new BinaryHeap(5);
        binaryHeap.addElement(5);
        binaryHeap.addElement(6);
        binaryHeap.addElement(7);
        binaryHeap.addElement(8);
        binaryHeap.addElement(1);


    }
}
