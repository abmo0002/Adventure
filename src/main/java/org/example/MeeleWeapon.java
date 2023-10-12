package org.example;

public class MeeleWeapon extends Weapon {
    public int damage;

    MeeleWeapon(String itemName, int damage) {
        super(itemName, damage);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "\n" + " " + "MeleeWeapon:" + "damage=" + damage + '}';
    }




}

