package findingKInDataSet;

import trees.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Given the root of the binary tree, find the third max in the tree.
 */
public class SearchingKHighInTree {
    private static List<Node> nodeList = new ArrayList<>();

    /**
     * Finding the max value in the tree
     * O(n) - traversing the tree and finding the biggest elem
     *
     * @param root
     * @return
     */
    static int findMaxValue(Node root) {
//        Deque<Integer> maxElems = new LinkedBlockingDeque<Integer>(3);
//        maxElems.add(root.getValue());
//        maxElems.add(root.getValue());
//        maxElems.add(root.getValue());
        return traverseRecursivelyOverTree(root, root.getValue());
    }

    private static int traverseRecursivelyOverTree(Node root, int max) {
        if (root != null) {
            if (root.getValue() > max) {
                max = root.getValue();
            }
            max = traverseRecursivelyOverTree(root.getLeft(), max);
            max = traverseRecursivelyOverTree(root.getRight(), max);
            return max;
        }
        return max;
    }

    private static Deque<Integer> traverseRecursivelyOverTree(Node node, Deque<Integer> maxElems) {
        int numberOfNodes = 0;
        int thirdMax = maxElems.peekLast();
//        int secondMax = maxElems.peek(1);
        int firstMax = maxElems.peekFirst();

        if (node != null) {
//            nodeList.add(node);
//            if (node.getValue() > thirdMax && node.getValue() > secondMax && node.getValue() > firstMax) {
//                maxElems[0] = node.getValue();
//            } else if (node.getValue() > thirdMax && node.getValue() < secondMax) {
//                maxElems[2] = node.getValue();
//            } else if (node.getValue() > thirdMax && node.getValue() > secondMax) {
//
//            }


            ++numberOfNodes;
            System.out.println("Current node: " + node.getValue());
            System.out.println("Moving to the next node");
//            numberOfNodes += traverseRecursivelyOverTree(node.getLeft());
//            numberOfNodes += traverseRecursivelyOverTree(node.getRight());
        }
        return maxElems;
    }
}
