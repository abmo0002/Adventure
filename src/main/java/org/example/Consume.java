package org.example;

public class Consume extends Item{

    protected int healthPoints;

    public Consume(String itemName, int healthPoints){
        super(itemName);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
