package com.go2it.weaponStore;

public class ArrayManager {
    private int maxItems;    // records the max size of the table
    private int numItems;       // records number of items in the list
    private int[] hashes;
    private ShopItem[] values;
    private double loadFactor;

    public ArrayManager(int size) {
        maxItems = size;
        numItems = 0;
        values = new ShopItem[maxItems];
        hashes = new int[maxItems];
        loadFactor = 0.75;
    }

    // calculating the hash
    private int hash(String weaponName) {
        int value = 0;
        int weight = 1;
        for (int x = 0; x < weaponName.length(); x++) {
            // using a weapon name to creat hash
            value += (weaponName.charAt(x) + 1) * weight;
            weight++;
        }
        return value % this.maxItems;
    }

    // in case there is a collision of hash codes, use quadratic probing to allocate new items
    public boolean put(Weapon item, int quantity) {
        ShopItem newItem = new ShopItem(item, quantity);
        int hash = hash(newItem.item.weaponName);
        int i = hash;
        int h = 1;
        do {
            // no collisions
            if (hashes[i] == 0) {
                hashes[i] = hash;
                values[i] = newItem;
                this.numItems++;
                return true;
            }
            if (hashes[i] == hash) {
                // item already exist, update the quantity
                ShopItem existingItem = values[i];
                existingItem.numberInStock += quantity;
                values[i] = existingItem;
                return true;
            }
            // there is a collision, calculate next index
            i = (i + h * h++) % this.maxItems;
        } while (i != hash);
        return false;
    }

    public boolean update(Weapon item, int quantity) {
        ShopItem existingEntry = get(item.weaponName);
        existingEntry.numberInStock += quantity;
        // get the hashCode for existing value and replace the value in value[]
        int hashCodeForExistingValue = hash(item.weaponName);
        values[hashCodeForExistingValue] = existingEntry;
        return true;
    }

    public ShopItem get(String weaponName) {
        int tempKey = hash(weaponName);
        int h = 1;
        while (hashes[tempKey] != 0) {
            ShopItem foundWeapon = values[tempKey];
            if (foundWeapon.item.weaponName.equals(weaponName)) {
                return foundWeapon;
            }
            // calculate next index using quadratic probing
            tempKey = (tempKey + h * h++) % this.maxItems;
        }
        return null;
    }

    public boolean delete(String weaponName) {
        ShopItem fetchedItem = get(weaponName);
        if (fetchedItem == null) {
            // no entry set found
            return false;
        }

        int i = hash(weaponName);
        int h = 1;
        while (i != hashes[i]) {
            i = (i + h * h++) % this.maxItems;
        }
        hashes[i] = 0;
        values[i] = null;

        for (i = (i + h * h++) % this.maxItems; hashes[i] != 0; i = (i + h * h++) % this.maxItems) {
            // remove the first met key-value
            ShopItem tempValue = values[i];
            hashes[i] = 0;
            values[i] = null;
            this.numItems--;
            put(fetchedItem.item, fetchedItem.numberInStock);
        }
        this.numItems--;
        return true;
    }

    public void printTable() {
        for (int x = 0; x < maxItems; x++) {
            if (values[x] != null && values[x].numberInStock > 0) {
                System.out.println("Name: " + values[x].item.weaponName + "   Damage:" + values[x].item.damage
                        + "    Cost:" + values[x].item.cost + "     Quantity in stock:" + values[x].numberInStock
                        + "    Weight:" + values[x].item.weight
                );
            }
        }
    }
}

