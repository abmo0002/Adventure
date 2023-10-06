package org.example;

public class MeeleWeapon extends Weapon {

    MeeleWeapon(String itemName, int damage, int remainingUses) {
        super(itemName, damage, remainingUses);
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getRemainingUses() {
        return remainingUses;
    }

    @Override
    public void setRemainingUses(int remainingUses) {
        this.remainingUses = remainingUses;
    }
}

