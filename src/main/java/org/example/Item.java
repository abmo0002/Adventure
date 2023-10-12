package org.example;

public class Item {
    private String itemName;
    private String description;


    public Item(String itemName, String description) {
        this.itemName = itemName;
        this.description = description;
    }

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }


    public String getDescription() {
        return description;
    }


    public String toString() {

        return itemName;
    }


}
