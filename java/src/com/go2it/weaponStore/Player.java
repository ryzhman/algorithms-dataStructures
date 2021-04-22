package com.go2it.weaponStore;


class Player {
    public String name;
    public int money;
    public Backpack backpack;

    public Player(String n, int m) {
        name = n;
        money = m;
        backpack = new Backpack();
    }

    public boolean buy(Weapon w) {
        if (money - w.cost < 0) {
            System.out.println("You don't have enough money");
            return false;
        }
        boolean isAdded = backpack.add(w);
        if (!isAdded) {
            return false;
        }
        System.out.println(backpack.numItems);
        return true;
    }

    public void withdraw(int amt) {
        money = money - amt;
    }

    public boolean inventoryFull() {
        return (backpack.size() == this.backpack.maxItems);
    }

    public void printCharacter() {
        System.out.println(" Name:" + name + "\n Money:" + money);
        printBackpack();
    }

    public void printBackpack() {
        System.out.println(" " + name + ", you own " + backpack.numItems + ". Total weight: " + backpack.currentWeight +
                ", number of items: " + backpack.numItems + " Weapons:");

        for (Backpack.WeaponNode node : backpack.hashTable) {
            if (node == null) {
                // unpopulated node
                continue;
            }
            // show the first node
            System.out.println(" " + node.value.weaponName);
            while (node.next != null) {
                node = node.next;
                // show each node in the bucket
                System.out.println(" - " + node.value.weaponName);
            }
        }
    }
}

