package org.example;

import java.util.ArrayList;


public class Player {
    private Room currentRoom;
    private final ArrayList<Item> inventory = new ArrayList<>();
    private int health = 50;
    private RangedWeapon rangedWeapon;
    private Item pickedUpItem;
    private Weapon equippedWeapon;
    private ReturnMessage checkWeapon;
    private int Ammunition;
    private int remainingUses;
    private int damage;
    private String enemykilled;
   private int enemyHealth;

    public void
    moveAround(String direction) {

        if (direction.equalsIgnoreCase("north") || direction.equalsIgnoreCase("n")) {
            if (currentRoom.getNorth() == null) {
                System.out.println("You cannot go that way");
            } else currentRoom = currentRoom.getNorth();

        } else if (direction.equalsIgnoreCase("south") || direction.equalsIgnoreCase("s")) {
            if (currentRoom.getSouth() == null) {
                System.out.println("You cannot go that way");
            } else currentRoom = currentRoom.getSouth();

        } else if (direction.equalsIgnoreCase("east") || direction.equalsIgnoreCase("e")) {
            if (currentRoom.getEast() == null) {
                System.out.println("You cannot go that way");
            } else currentRoom = currentRoom.getEast();

        } else if (direction.equalsIgnoreCase("west") || direction.equalsIgnoreCase("w")) {
            if (currentRoom.getWest() == null) {
                System.out.println("You cannot go that way");
            } else currentRoom = currentRoom.getWest();
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int remainingUses() {
        return remainingUses;
    }

    public int damage() {
        return damage();
    }

    public void getMoveAround(String input) {
        moveAround(input);
    }

    public int getHealth() {
        return health;
    }

    public void setCurrentRoom(Room setRoom) {
        this.currentRoom = setRoom;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public int getAmmunition() {
        return Ammunition;
    }

    public ReturnMessage eatFood(String eatfood) {
        if (inventory.isEmpty()) {
            return ReturnMessage.NOT_FOUND;
        } else {

            for (Item item : inventory) {
                if (item.getItemName().toLowerCase().contains(eatfood.toLowerCase())) {
                    if (item instanceof Food food) {
                        health += food.getHealthPoints();
                        inventory.remove(food);
                        return ReturnMessage.EATABLE;

                    } else
                        return ReturnMessage.NOT_EATABLE;
                }
            }
        }
        return ReturnMessage.NOT_FOUND;
    }


    public ReturnMessage drinkLiquid(String drinkLiquid) {
        Item itemfound = null;

        if (inventory.isEmpty()) {
            return ReturnMessage.NOT_FOUND;
        } else {
            for (Item item : inventory) {
                if (item.getItemName().toLowerCase().contains(drinkLiquid.toLowerCase())) {
                    if (item instanceof Liquid) {
                        Liquid liquid = (Liquid) item;
                        System.out.println(liquid.getHealthPoints());
                        System.out.println(health);
                        health += liquid.getHealthPoints();
                        itemfound = item; // Add item to itemsToRemove list.

                    } else {
                        return ReturnMessage.REALLY_DRINK;
                    }
                } else {
                    return ReturnMessage.NOT_DRINKABLE;
                }
            }

            // Remove items after finishing iteration.
            inventory.remove(itemfound);
        }
        return ReturnMessage.NOT_FOUND;
    }


    public ReturnMessage tryToEatFood(String eatFood) {
        boolean removeItem = false;
        Item itemfound = null;

        if (inventory.isEmpty()) {
            return ReturnMessage.NOT_FOUND;
        } else {
            for (Item item : inventory) {
                if (item.getItemName().toLowerCase().contains(eatFood.toLowerCase())) {
                    if (item instanceof Food food) {
                        if (food.getHealthPoints() < 0) {
                            return ReturnMessage.REALLY_EAT;
                        } else {
                            health += food.getHealthPoints();
                            itemfound = item;
                            removeItem = true;

                        }

                    } else
                        return ReturnMessage.NOT_EATABLE;
                }
            }
            if (removeItem == true) {
                inventory.remove(itemfound);
                return ReturnMessage.EATABLE;
            }
        }
        return ReturnMessage.NOT_FOUND;
    }

    public ReturnMessage tryTodrinkLiquid(String drinkLiquid) {
        if (inventory.isEmpty()) {
            return ReturnMessage.NOT_FOUND;
        } else {
            for (Item item : inventory) {
                if (item.getItemName().toLowerCase().contains(drinkLiquid.toLowerCase())) {
                    if (item instanceof Liquid) {
                        Liquid liquid = (Liquid) item;
                        if (liquid.HealthPoints() < 0) {
                            return ReturnMessage.REALLY_DRINK;
                        } else {
                            health += liquid.getHealthPoints();
                            inventory.remove(liquid);
                            return ReturnMessage.EATABLE;
                        }
                    } else
                        return ReturnMessage.NOT_DRINKABLE;
                }
            }
        }
        return ReturnMessage.NOT_FOUND;
    }

    public void takeItem(String takeItem) {
        Item itemToTake = currentRoom.removeItemFromRoom(takeItem);
        if (itemToTake != null) {
            inventory.add(itemToTake);
            System.out.println("\nYou picked up " + itemToTake);

        }
    }

    public Item getPickedUpItem() {
        return pickedUpItem;
    }

    public void dropItem(String dropItem) {
        Item dropItemInRoom = null;
        for (Item item : inventory) {
            if (item.getItemName().toLowerCase().contains(dropItem.toLowerCase())) {
                dropItemInRoom = item;
                currentRoom.dropItemInRoom(item);
                System.out.println("\nYou have dropped: " + dropItemInRoom);

            } else System.out.println("You don't have anything like" + dropItem + " in your inventory...");
        }

        if (inventory.isEmpty()) {

        }
    }


    public ArrayList<Item> showInventory() {
        return inventory;
    }

    public ArrayList<Item> showItemsInRoom() {
        return currentRoom.showItemsInRoom();
    }


    public Item findItem(String name) {
        for (Item item : inventory) {
            if (item.getItemName().startsWith(name)) {
                return item;
            }
        }
        return null;

    }

    public Item FindItemInRoom(String itemName) {
        for (Item item : currentRoom.showItemsInRoom()) {

            if (item.getItemName().equalsIgnoreCase(itemName)) {

            }
            return item;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Player{" + "currentRoom=" + currentRoom + '}';
    }}
