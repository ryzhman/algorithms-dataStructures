package com.go2it.weaponStore;

import java.util.Objects;

class Weapon {
    public String weaponName;
    public int range;
    public int damage;
    public double weight;
    public int cost;

    public Weapon(String n, int rang, int dam, double w, int c) {
        weaponName = n;
        damage = dam;
        range = rang;
        weight = w;
        cost = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return range == weapon.range &&
                damage == weapon.damage &&
                Double.compare(weapon.weight, weight) == 0 &&
                cost == weapon.cost &&
                Objects.equals(weaponName, weapon.weaponName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponName, range, damage, weight, cost);
    }
}

