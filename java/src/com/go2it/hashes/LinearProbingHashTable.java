package com.go2it.hashes;

public class LinearProbingHashTable {

    // Member variables of this class
    private int currentSize, maxSize;
    private int[] keys;
    private int[] vals;

    // Constructor of this class
    public LinearProbingHashTable(int capacity) {
        currentSize = 0;
        maxSize = capacity;
        keys = new int[maxSize];
        vals = new int[maxSize];
    }

    // Method 1
    // Function to clear hash table
    public void makeEmpty() {
        currentSize = 0;
        keys = new int[maxSize];
        vals = new int[maxSize];
    }

    // Method 2
    // Function to get size of hash table
    public int getSize() {
        return currentSize;
    }

    // Method 3
    // Function to check if hash table is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Method 4
    // Function to check if hash table is empty
    public boolean isEmpty() {
        return getSize() == 0;
    }

    // Method 5
    // Fucntion to check if hash table contains a key
//    public boolean contains(String key) {
//        return get(key) != null;
//    }

    // Method 6
    // Functiont to get hash code of a given key
    private int hash(int key) {
        // TODO make operation
        return key % 13;
    }

    // Method 7
    // Function to insert key-value pair
    public void insert(int val) {
        int tmp = hash(val);
        int i = tmp;

        // Do-while loop
        // Do part for performing actions
        do {
            if (keys[i] == 0) {
                keys[i] = hash(val);
                vals[i] = val;
                currentSize++;
                return;
            }

            if (keys[i] == hash(val)) {
                vals[i] = val;
                return;
            }

            i = (i + 1) % maxSize;

        }

        // Do-while loop
        // while part for condition check
        while (i != tmp);
    }

    // Method 8
    // Function to get value for a given key
//    public String get(String key) {
//        int i = hash(key);
//        while (keys[i] != null) {
//            if (keys[i].equals(key))
//                return vals[i];
//            i = (i + 1) % maxSize;
//        }
//        return null;
//    }

    // Method 9
    // Function to remove key and its value
//    public void remove(String key) {
//        if (!contains(key))
//            return;
//
//        // Find position key and delete
//        int i = hash(key);
//        while (!key.equals(keys[i]))
//            i = (i + 1) % maxSize;
//        keys[i] = vals[i] = null;
//
//        // rehash all keys
//        for (i = (i + 1) % maxSize; keys[i] != null;
//             i = (i + 1) % maxSize) {
//            String tmp1 = keys[i], tmp2 = vals[i];
//            keys[i] = vals[i] = null;
//            currentSize--;
//            insert(tmp1, tmp2);
//        }
//        currentSize--;
//    }

    // Method 10
    // Function to print HashTable
    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != 0)
                System.out.println(keys[i] + " " + vals[i]);
            else
                System.out.println(i + " -1");
        System.out.println();
    }

    // Main driver method
    public static void main(String[] args) {

        //TODO change size
        LinearProbingHashTable lpht = new LinearProbingHashTable(13);

        // TODO enter value
        lpht.insert(81);
        lpht.insert(51);
        lpht.insert(59);
        lpht.insert(68);
        lpht.insert(54);
        lpht.insert(79);
        lpht.insert(30);
        lpht.insert(55);
        lpht.printHashTable();


    }
}
