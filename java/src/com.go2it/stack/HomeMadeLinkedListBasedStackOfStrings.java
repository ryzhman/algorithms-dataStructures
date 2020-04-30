package stack;

/**
 * Implementation of a double linked-list with previous and next elem in each node
 *
 * Any operation - O(1)
 * Memory consumption - each field of the Node requires memory => 50 x N b  of elems
 */
public class HomeMadeLinkedListBasedStackOfStrings {
    private Node topNode;

    public HomeMadeLinkedListBasedStackOfStrings() {
    }

    public void push(String elem) {
        if (topNode == null) {
            topNode = new Node(elem, null, null);
        } else {
            topNode = new Node(elem, topNode, null);
        }
    }

    public String pop() {
        if (topNode == null) {
            return null;
        }
        final String value = topNode.getValue();
        final Node next = topNode.getNext();
        if (next != null) {
            next.setPrevious(null);
            topNode = next;
        } else {
            topNode = null;
        }
        return value;
    }

    public int size() {
        int size = 0;
        Node node = topNode;
        if (node != null) {
            size++;
            while (node.getNext() != null) {
                size++;
                node = node.getNext();
            }
        }
        return size;
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    private class Node {
        private String value;
        private Node next;
        private Node previous;

        public Node(String value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public String getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}
