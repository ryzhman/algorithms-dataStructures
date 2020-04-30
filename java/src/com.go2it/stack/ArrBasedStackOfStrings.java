package stack;

public class ArrBasedStackOfStrings {
    private String[] strings;
    private int size;

    public ArrBasedStackOfStrings(int capacity) {
        this.strings = new String[capacity];
    }

    public void push(String elem) {
//        if ((size + 1) >= strings.length) {
//            return;
//        }
        strings[size++] = elem;
    }

    public String pop() {
        if (size == 0) {
            return null;
        }
        String value = strings[--size];
        strings[size] = "0";
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
