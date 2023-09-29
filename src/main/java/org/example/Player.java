package org.example;

import java.util.ArrayList;

public class Player {
    Item item = new Item();

    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>(5);

    public Player() {

    }

    public void moveAround(String direction) {

        if (direction.equalsIgnoreCase("go north")) {

            if (currentRoom.getNorth() == null) {
                System.out.println("You can not go that way");
            } else
                currentRoom = currentRoom.getNorth();

        } else if (direction.equalsIgnoreCase("go south")) {
            if (currentRoom.getSouth() == null) {
                System.out.println("You can not go that way");
            } else
                currentRoom = currentRoom.getSouth();

        } else if (direction.equalsIgnoreCase("go east")) {
            if (currentRoom.getEast() == null) {
                System.out.println("You can not go that way");
            } else
                currentRoom = currentRoom.getEast();

        } else if (direction.equalsIgnoreCase("go west")) {
            if (currentRoom.getWest() == null) {
                System.out.println("You can not go that way");
            } else
                currentRoom = currentRoom.getWest();
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void getMoveAround(String input) {
        moveAround(input);
    }

    public void setCurrentRoom(Room setRoom) {
        this.currentRoom = setRoom;

    }

    public boolean takeItem(String takeItem) {
        for (Item item : currentRoom.getItems()) {
            if (item.getItemName().toLowerCase().equals(takeItem)) {
                inventory.add(item);
                currentRoom.getItems().remove(item);
                return true;
            }
        }
        return false;
    }

    public Item dropItem(String dropItem) {
        for (Item item : inventory) {
            if (item.getItemName().contains(dropItem)) {
                inventory.remove(new Item(dropItem));
                currentRoom.leftedItem(dropItem);
                return item;
            } else
                System.out.println("I can not find " + dropItem + "in the inventory...");
        }
        return null;
    }

    public ArrayList<Item> showInventory() {
        return inventory;
    }

}



