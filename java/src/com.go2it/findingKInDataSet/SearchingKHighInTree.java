package findingKInDataSet;

import misc.AutoRemovingList;
import sorting.SortingUtils;
import trees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static List<Integer> getMaxElementsFromTheTree(Node root, int numberOfMaxElems) {
        return findHighestElems(root, new AutoRemovingList<Integer>(numberOfMaxElems));
    }

    public static List<Comparable> getMaxElementsFromTheTreeBinaryHeap(Node root, int numberOfMaxElems) {
        BinaryHeap heap = new BinaryHeap(numberOfMaxElems);

        Node current = root;
        Stack<Node> stack = new Stack<>();
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current == null) {
                continue;
            }
            heap.addElem(current.getValue());
            stack.push(current.getRight());
            stack.push(current.getLeft());
        }
        return Stream.of(heap.getArr()).collect(Collectors.toList());
    }

    private static List<Integer> findHighestElems(Node root, AutoRemovingList<Integer> maxElems) {
        //iterate over the tree
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current == null) {
                continue;
            }

            maxElems.add(current.getValue());

            stack.push(current.getRight());
            stack.push(current.getLeft());
        }
        return maxElems.getArray();
    }


    private static class BinaryHeap {
        private Comparable[] arr;
        private int lastIndex = 0;

        public BinaryHeap(int maxSize) {
            this.arr = new Comparable[maxSize];
        }

        private void addElem(Comparable elem) {
            if (SortingUtils.isLess(elem, arr[lastIndex])) {
                //new entry is smaller than the smallest in the heap
                return;
            } else {
                //replace the smallest elem with the new one and swim it to the proper place
                arr[lastIndex] = elem;
                swim(lastIndex);
                if (lastIndex < arr.length - 1) {
                    lastIndex++;
                }
            }
        }

        private void swim(int index) {
            while (SortingUtils.isLess(arr[index / 2], arr[index])) {
                SortingUtils.exchange(arr, index / 2, index);
                index = index / 2;
            }
        }

        public Comparable[] getArr() {
            return arr;
        }

        public Comparable getMax() {
            return arr[0];
        }
    }
}
