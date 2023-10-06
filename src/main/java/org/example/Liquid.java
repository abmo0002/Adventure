package org.example;

public class Liquid extends Item {
    public int healthPoints;


    public Liquid(String name, String description, int healthPoints) {
        super(name,description);
        this.healthPoints = healthPoints;

    }

    @Override
    public String toString() {
        return this.getDescription()+" "+ this.getItemName() +" Health points: "+ healthPoints;
    }




    public int getHealthPoints() {
        return getHealthPoints();
    }

    public int HealthPoints() {
        return HealthPoints();
    }

}
