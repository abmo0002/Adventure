package org.example;

public class Item {
    private String itemName;
    private String description;

    public Item() {
    }

    public Item(String itemName, String description) {
        this.itemName = itemName;
        this.description = description;
    }

    public Item(String itemName) {

    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }
public Item(String itemName, int healthPoints){

}
    public String toString() {

        return description + " " + itemName ;
    }


}
