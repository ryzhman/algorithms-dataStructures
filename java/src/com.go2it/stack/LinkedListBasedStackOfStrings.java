package stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListBasedStackOfStrings {
    private List<String> strings;

    public LinkedListBasedStackOfStrings() {
        this.strings = new LinkedList<>();
    }

    public void push(String elem) {
        strings.add(0, elem);
    }

    public String pop() {
        if (strings.isEmpty()) {
            return null;
        }
        return strings.remove(0);
    }

    public int size() {
        return strings.size();
    }

    public boolean isEmpty() {
        return strings.isEmpty();
    }
}
