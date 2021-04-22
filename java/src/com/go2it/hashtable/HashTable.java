package com.go2it.hashtable;

public class HashTable {
    private int tableSize;
    private int maxSize;
    private int[] hashes;
    private LocationData[] values;
    private double loadFactor;

    private static class LocationData {
        public String name;
        public int latitude;
        public int longtitude;
        public int waterLevel;

        @Override
        public String toString() {
            return "LocationData{" +
                    "name='" + name + '\'' +
                    ", latitude=" + latitude +
                    ", longtitude=" + longtitude +
                    ", waterLevel=" + waterLevel +
                    '}';
        }
    }

    public HashTable(int capacity) {
        tableSize = 0;
        maxSize = capacity;
        hashes = new int[maxSize];
        values = new LocationData[maxSize];
        loadFactor = 0.75;
    }

    private int hash(LocationData valueToInser) {
        int value = 0;
        int weight = 1;
        for (int x = 0; x < valueToInser.name.length(); x++) {
            // using several properties ot the LocationData to create a hash
            value += (valueToInser.name.charAt(x) + 1) * weight + (valueToInser.latitude % maxSize) + (valueToInser.longtitude % maxSize - 1) + (valueToInser.waterLevel % maxSize);
            weight++;
        }
        return value % maxSize;
    }

    public boolean add(LocationData val) {
        int hash = hash(val);
        int i = hash;
        int h = 1;
        do {
            // no collisions
            if (hashes[i] == 0) {
                hashes[i] = hash;
                values[i] = val;
                tableSize++;
                return true;
            }
            if (hashes[i] == hash) {
                values[i] = val;
                // overwrite an existing value
                return true;
            }
            // there is a collision, calculate next index
            i = (i + h * h++) % maxSize;
        } while (i != hash);
        return false;
    }

    public LocationData retrieve(int key) {
        int tempKey = key;
        int h = 1;
        while (hashes[key] != 0) {
            if (hashes[tempKey] == key) {
                return values[tempKey];
            }
            tempKey = (tempKey + h * h++) % maxSize;
        }
        return null;
    }

    public boolean update(int key, LocationData updateData) {
        LocationData retrievedValue = retrieve(key);
        if (retrievedValue == null) {
            return false;
        }
        // get the hashCode for existing value and replace the value in value[]
        int hashCodeForExistingValue = hash(retrievedValue);
        values[hashCodeForExistingValue] = updateData;
        return true;
    }

    public boolean delete(int key) {
        if (retrieve(key) == null) {
            // no entry set found
            return false;
        }

        int i = key;
        int h = 1;
        while (key != hashes[i]) {
            i = (i + h * h++) % maxSize;
        }
        hashes[i] = 0;
        values[i] = null;

        for (i = (i + h * h++) % maxSize; hashes[i] != 0; i = (i + h * h++) % maxSize) {
            // remove the first met key-value
            LocationData tempValue = values[i];
            hashes[i] = 0;
            values[i] = null;
            tableSize--;
            add(tempValue);
        }
        tableSize--;
        return true;
    }

    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (hashes[i] != 0) {
                System.out.println(hashes[i] + " " + values[i]);
            }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(100);
        // two equals data
        LocationData locationData1 = new LocationData();
        locationData1.longtitude = 1;
        locationData1.longtitude = 33;
        locationData1.name = "AaA";
        locationData1.waterLevel = 100;
        LocationData locationData2 = new LocationData();
        locationData2.longtitude = 1;
        locationData2.longtitude = 33;
        locationData2.name = "AaA";
        locationData2.waterLevel = 100;

        LocationData locationData3 = new LocationData();
        locationData3.longtitude = 10;
        locationData3.longtitude = 330;
        locationData3.name = "BbB";
        locationData3.waterLevel = 33;

        hashTable.add(locationData1);
        hashTable.add(locationData2);
        hashTable.add(locationData3);
        hashTable.printHashTable();

        System.out.println();
        System.out.println(hashTable.retrieve(56));

        hashTable.delete(52);
        hashTable.printHashTable();

        locationData3.waterLevel = 524;
        hashTable.update(56, locationData3);
        hashTable.printHashTable();

    }
}
