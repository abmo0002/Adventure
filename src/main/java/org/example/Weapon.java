package org.example;

public abstract class Weapon extends Item {
    protected int damage;
    int remainingUses;


    public Weapon(String itemName, int damage, int remainingUses) {
        super(itemName);
        this.damage = damage;
        this.remainingUses = remainingUses;
    }

    public abstract int getDamage();

    public abstract int getRemainingUses();

    public abstract void setRemainingUses(int remainingUses);


}
