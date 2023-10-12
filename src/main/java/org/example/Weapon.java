package org.example;

public class Weapon extends Item {
    protected int damage;
    protected int remainingUses;
    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getRemainingUses() {
        return remainingUses;
    }
    public int setRemainingUses(int i){
        return remainingUses;
    }

    public int getDamage() {
        return damage;
    }


}