package com.go2it.sorting;

public class WorldCupSingleLinkedList {
    static ResultNode head;
    static ResultNode current;
    static ResultNode previous;

    public static void main(String[] args) {
        addNode(new ResultNode("Ukraine", 10, 29));

        addNode(new ResultNode("USA", 9, 20));
        addNode(new ResultNode("Spain", 11, 30));
        addNode(new ResultNode("Canada", 2, 10));
        addNode(new ResultNode("Grenada", 4, 1));
        addNode(new ResultNode("Germany", 11, 29));
        addNode(new ResultNode("France", 6, 21));
        System.out.println(head);
    }

    public static void addNode(ResultNode newNode) {
        // the very first node added
        if (head == null) {
            head = newNode;
            return;
        }
        // handling the second node addition
        // both previous and head are not set yet
        if (previous == null) {
            previous = head;
            current = head;
        }
        // placing the node before the current and after previous
        if (current.maxGoalScored < newNode.maxGoalScored) {
            // the second node entry
            if (previous == head) {
                head = newNode;
                newNode.next = previous;
            } else {
                // common case
                previous.next = newNode;
                newNode.next = current;
            }
            // clean up not to mess with the following iterations
            previous = null;
            current = null;
            return;
        } else {
            // when the recursion reached the end of the list and previous.next is null
            if (current.next == null) {
                current.next = newNode;
                previous = null;
                current = null;
                return;
            }
        }

        previous = current;
        current = current.next;
        // diving to the next element
        addNode(newNode);
    }

    static class ResultNode {
        String country;
        int gamesPlayed;
        int maxGoalScored;
        ResultNode next;

        public ResultNode(String country, int gamesPlayed, int maxGoalScored) {
            this.country = country;
            this.gamesPlayed = gamesPlayed;
            this.maxGoalScored = maxGoalScored;
        }

        @Override
        public String toString() {
            return "Current country: " + this.country + ":" + this.gamesPlayed + ":" + this.maxGoalScored
                    + ". Next is: " + (next != null ? next.country + "\r\n" + next.toString(): "null");
        }
    }
}
