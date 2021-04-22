package com.go2it.weaponStore;

public class Backpack {
    int numItems;
    int maxItems;
    double currentWeight;
    double maxWeight;
    WeaponNode[] hashTable;
    int numBuckets;

    public Backpack() {
        this.numItems = 0;
        this.maxItems = 30;
        this.currentWeight = 0;
        this.maxWeight = 90;
        this.hashTable = new WeaponNode[this.maxItems];
        this.numBuckets = 10;
    }

    // separate chaining-based hash table to store the items
    public boolean add(Weapon weapon) {
        //weight validation
        if (this.currentWeight + weapon.weight > this.maxWeight) {
            System.out.println("You cannot have a backpack over " + this.maxWeight);
            return false;
        }
        //max number validation
        if (this.numItems + 1 > this.maxItems) {
            System.out.println("You cannot have more than " + this.maxItems + "in your backpack");
            return false;
        }
        //weapon is present validation
        if (get(weapon.hashCode()) != null) {
            System.out.println("Weapon is already in your backpack");
            return false;
        }

        // Find head of chain for given key
        int hashCode = weapon.hashCode();
        int bucketIndex = getTableIndex(hashCode);
        WeaponNode head = hashTable[bucketIndex];

        // Check if key is already present
        while (head != null) {
            // if this weapon is already present
            if (head.key == hashCode) {
                head.value = weapon;
                return false;
            }
            head = head.next;
        }
        // weapon doesn't exist
        this.numItems++;
        this.currentWeight += weapon.weight;
        head = hashTable[bucketIndex];
        WeaponNode newNode = new WeaponNode(hashCode, weapon);
        newNode.next = head;
        hashTable[bucketIndex] = newNode;
        System.out.println(weapon.weaponName + " bought...");
        return true;
    }

    public Weapon get(int key) {
        // Find head of chain for given key
        int bucketIndex = getTableIndex(key);
        WeaponNode head = hashTable[bucketIndex];

        // Search key in chain
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        // key not found
        return null;
    }

    private int getTableIndex(int key) {
        int index = key % this.maxItems;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public Weapon remove(int key) {
        int bucketIndex = getTableIndex(key);

        // Get head of chain
        WeaponNode head = hashTable[bucketIndex];
        // Search for key in its chain
        WeaponNode prev = null;
        while (head != null) {
            // If Key found
            if (head.key == key) {
                break;
            }
            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // Key was not found
        if (head == null) {
            return null;
        }
        // Key was found
        // Reduce size and weight
        this.numItems--;
        this.currentWeight -= head.value.weight;

        // Remove key
        if (prev != null) {
            // point the previous to next and skip the found item
            prev.next = head.next;
        } else {
            // no items in the bucket found
            hashTable[bucketIndex] = head.next;
        }
        return head.value;
    }

    public int size() {
        return this.numItems;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Weapon for the bucket
    class WeaponNode {
        int key;
        Weapon value;
        WeaponNode next;

        public WeaponNode(int key, Weapon value) {
            this.key = key;
            this.value = value;
        }
    }

}
