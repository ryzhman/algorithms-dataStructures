package stack;

/**
 * Implementation of a double linked-list with previous and next elem in each node
 * <p>
 * Any operation - O(1)
 * Memory consumption - each field of the Node requires memory => 50 x N b  of elems
 */
public class HomeMadeLinkedListBasedStack<T> {
    private Node topNode;
    private Node startNode;

    public HomeMadeLinkedListBasedStack() {
    }

    /**
     * is used for both Queue and Stack
     * @param elem
     */
    public void push(T elem) {
        if (topNode == null) {
            topNode = new Node(elem, null, null);
            startNode = topNode;
        } else {
            Node newTop = new Node(elem, null, topNode);
            topNode.setNext(newTop);
            topNode = newTop;
        }
    }

    public T pop() {
        if (topNode == null) {
            return null;
        }
        final T value = (T) topNode.getValue();
        final Node previous = topNode.getPrevious();
        if (previous != null) {
            previous.setNext(null);
            topNode = previous;
        } else {
            topNode = null;
        }
        return value;
    }

    public T dequeue() {
        if (startNode == null) {
            return null;
        }
        T value = (T) startNode.getValue();
        startNode = startNode.getNext();
        if (this.isEmpty()) {
            topNode = null;
        }
        return value;
    }

    public int size() {
        int size = 0;
        Node node = topNode;
        if (node != null) {
            size++;
            while (node.getPrevious() != null) {
                size++;
                node = node.getPrevious();
            }
        }
        return size;
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    private class Node<T> {
        private T value;
        private Node next;
        private Node previous;

        public Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
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

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
