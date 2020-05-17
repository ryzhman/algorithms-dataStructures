package findingKInDataSet;

import org.junit.jupiter.api.Test;
import trees.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchingKHighInTreeTest {

    @Test
    public void findMaxValueTest() {
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
        assertEquals(10, SearchingKHighInTree.findMaxValue(root));
    }
}
