package org.example;

import java.util.ArrayList;

public class Room {
    private final String name;
    private final String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private final ArrayList<Item> itemInRoom = new ArrayList<>(5);

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }


    public void setNorth(Room newRoom) {
        this.north = newRoom;
    }

    public void setSouth(Room newRoom) {
        this.south = newRoom;
    }

    public void setEast(Room newRoom) {
        this.east = newRoom;
    }

    public void setWest(Room newRoom) {
        this.west = newRoom;
    }

    public void dropItemInRoom(Item dropedItem) {
        itemInRoom.add(dropedItem);
    }

    public void addItemToRoom(Item addItem) {
        itemInRoom.add(addItem);
    }

    public Item removeItemFromRoom(String removeItem) {
        for (Item item : itemInRoom) {
            if (item.getItemName().toLowerCase().contains(removeItem.toLowerCase())) {
                itemInRoom.remove(item);
                return item;
            } else
                System.out.println(removeItem + " doesn't exist");
        }
        System.out.println("I can't take the following item");
        return null;
    }

    public ArrayList<Item> showItemsInRoom() {
        return itemInRoom;
    }


    public String toString() {
        return name + "\n" +
                "Room description: " + description + "\n";
    }

}
