package org.example;
public class RangedWeapon extends Weapon {
    public int ammunition;
    int remainingUses;

    public RangedWeapon(String itemName, int damage, int ammunition, int remainingUses) {
        super(itemName, damage);
        this.ammunition = ammunition;
        this.remainingUses = remainingUses;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public int getRemainingUses() {
        return remainingUses;
    }



    @Override
    public String toString() {
        return "\n" +  "Ranged Weapon:" + " " + getItemName() + "," + "\n" +
                "Ammunition" + " " + "=" + " " + " " + ammunition +
                ", Use left:" + " " + "=" + " " + remainingUses +
                ',';
    }
}