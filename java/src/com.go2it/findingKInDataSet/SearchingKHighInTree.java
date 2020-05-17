package findingKInDataSet;

import trees.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of the binary tree, find the third max in the tree.
 */
public class SearchingKHighInTree {
    private static List<Node> nodeList = new ArrayList<>();

    /**
     * Finding the max value in the tree
     * O(n) - traversing the tree and finding the biggest elem
     * Recursion
     *
     * @param root
     * @return
     */
    static int findMaxValueRecursion(Node root) {
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

    /**
     * Finding the max value in the tree
     * O(n) - traversing the tree and finding the biggest elem
     * Stack
     *
     * @param root
     * @return
     */
    static int findMaxValueStack(Node root) {
        return iterateOverTree(root);
    }

    private static int iterateOverTree(Node root) {
        Stack<Node> stack = new Stack<>();
        int max = root.getValue();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current != null && current.getValue() > max) {
                max = current.getValue();
            }
            if (current == null) {
                continue;
            }
            stack.push(current.getRight());
            stack.push(current.getLeft());
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
