package findingKInDataSet;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trees.Node;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchingKHighInTreeTest {

    @Test
    public void findMaxValueRecursionTest() {
        final Node root = new Node(4);
        final Node node1 = new Node(1);
        root.addNode(node1);

        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(10);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(9));
        assertEquals(10, SearchingKHighInTree.findMaxValueRecursion(root));
    }

    @Test
    public void findMaxValueIterationTest() {
        final Node root = new Node(4);
        final Node node1 = new Node(1);
        root.addNode(node1);

        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(10);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(9));
        assertEquals(10, SearchingKHighInTree.findMaxValueStack(root));
    }

    @Test
    public void findThreeMaxValuesTest() {
        List<Integer> result = Stream.of(10, 9, 8).collect(Collectors.toList());

        final Node root = new Node(4);
        final Node node1 = new Node(1);
        root.addNode(node1);
        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(10);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(9));

        assertEquals(result, SearchingKHighInTree.getMaxElementsFromTheTree(root, 3));
    }

    @Test
    public void findThreeMaxValuesFirstIsTheHighestTest() {
        List<Integer> result = Stream.of(10, 9, 8).collect(Collectors.toList());

        final Node root = new Node(10);
        final Node node1 = new Node(1);
        root.addNode(node1);
        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(9);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(7));

        assertEquals(result, SearchingKHighInTree.getMaxElementsFromTheTree(root, 3));
    }


    @Test
    public void findThreeMaxValueSixHighestTest() {
        List<Integer> result = Stream.of(10, 9, 8, 5, 2 ,1).collect(Collectors.toList());

        final Node root = new Node(10);
        final Node node1 = new Node(1);
        root.addNode(node1);
        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(9);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(7));

        assertEquals(result, SearchingKHighInTree.getMaxElementsFromTheTree(root, 6));
    }

    @Ignore
    @DisplayName("Binary heap will not work for >3 elements since the ordering is not guaranteed")
    @Test
    public void findMaxValueBinaryHeapIterationTest() {
        final Node root = new Node(4);
        final Node node1 = new Node(1);
        root.addNode(node1);

        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(10);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(9));
        assertEquals(10, SearchingKHighInTree.findMaxValueStack(root));
    }

    @Test
    public void findThreeMaxValuesBinaryHeapTest() {
        List<Integer> result = Stream.of(10, 9, 8).collect(Collectors.toList());

        final Node root = new Node(4);
        final Node node1 = new Node(1);
        root.addNode(node1);
        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(10);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(9));

        assertEquals(result, SearchingKHighInTree.getMaxElementsFromTheTreeBinaryHeap(root, 3));
    }

    @Test
    public void findThreeMaxValuesFirstIsTheHighestBinaryHeapTest() {
        List<Integer> result = Stream.of(10, 9, 8).collect(Collectors.toList());

        final Node root = new Node(10);
        final Node node1 = new Node(1);
        root.addNode(node1);
        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(9);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(7));

        assertEquals(result, SearchingKHighInTree.getMaxElementsFromTheTreeBinaryHeap(root, 3));
    }


    @Test
    public void findThreeMaxValueSixHighestBinaryHeapTest() {
        List<Integer> result = Stream.of(10, 9, 8, 5, 2 ,1).collect(Collectors.toList());

        final Node root = new Node(10);
        final Node node1 = new Node(1);
        root.addNode(node1);
        final Node n8 = new Node(8);
        root.addNode(n8);
        final Node n2 = new Node(2);
        n8.addNode(n2);
        final Node n3 = new Node(-2);
        n2.addNode(n3);
        final Node n10 = new Node(9);
        n8.addNode(n10);
        n3.addNode(new Node(5));
        n10.addNode(new Node(1));
        node1.addNode(new Node(7));

        assertEquals(result, SearchingKHighInTree.getMaxElementsFromTheTreeBinaryHeap(root, 6));
    }
}
