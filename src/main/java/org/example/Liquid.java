package org.example;

public class Liquid extends Item {
    private int healthPoints;


    public Liquid(String name, String description, int healthPoints) {
        super(name, description);
        this.healthPoints = healthPoints;

    }


    @Override
    public String toString() {
        return getDescription()+" "+ getItemName() +" Health points: "+ healthPoints;
    }




    public int getHealthPoints() {
        return healthPoints;
    }

    public int HealthPoints() {
        return healthPoints;
    }

}
