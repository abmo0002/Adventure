package org.example;

import org.example.Item;

public class Food extends Item {

    public int healthPoints;


    public Food(String itemName, String description, int healthPoints) {
        super(itemName,description);
        this.healthPoints = healthPoints;

    }
    public int getHealthPoints(){

        return healthPoints;
    }


    @Override
    public String toString() {
        return getDescription()+" "+ getItemName() +" Health points: "+ healthPoints;
    }


}

