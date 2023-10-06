package org.example;

import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private final ArrayList<Item> inventory = new ArrayList<>();
    private int health = 50;
    private Weapon equippedWeapon;
    private ReturnMessage checkWeapon;

    public void moveAround(String direction) {

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

    public void getMoveAround(String input) {
        moveAround(input);
    }

    public int getHealth() {
        return health;
    }

    public void setCurrentRoom(Room setRoom) {
        this.currentRoom = setRoom;
    }

    public ReturnMessage eatFood(String food) {
        if (inventory.isEmpty()) {
            Item temp;
            for (Item item : inventory) {
                if (item.getItemName().toLowerCase().contains(food.toLowerCase())) {
                    temp = item;
                    if (temp instanceof Food) {
                        health += ((Food) temp).getHealthPoints();
                        inventory.remove(food);

                    } else
                        return ReturnMessage.EATABLE;

                } else
                    return ReturnMessage.NOT_EATABLE;
            }
        }
        return ReturnMessage.NOT_FOUND;
    }


    public ReturnMessage drinkLiquid(String drinkLiquid) {
        if (inventory.isEmpty()) {
            return ReturnMessage.NOT_FOUND;

        } else {
            for (Item item : inventory) {
                if (item.getItemName().toLowerCase().contains(drinkLiquid.toLowerCase())) {
                    if (item instanceof Liquid) {
                        Liquid liquid = (Liquid) item;
                        health += liquid.getHealthPoints();
                        inventory.remove(liquid);
                    } else return ReturnMessage.EATABLE;
                } else return ReturnMessage.NOT_DRINKABLE;
            }
        }
        return ReturnMessage.NOT_FOUND;
    }

    public ReturnMessage tryToEatFood(String eatFood) {
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
                            inventory.remove(food);
                            return ReturnMessage.EATABLE;
                        }
                    } else
                        return ReturnMessage.NOT_EATABLE;
                }
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

    @Override
    public String toString() {
        return "Player{" + "currentRoom=" + currentRoom + '}';
    }


    public ArrayList<Item> getItemName() {
        return getItemName();
    }

    public ReturnMessage attack() {
        if (checkWeapon == ReturnMessage.IS_EQUIPPED) {
            if (equippedWeapon.getRemainingUses() > 0) {
                equippedWeapon.getDamage();
                equippedWeapon.setRemainingUses(equippedWeapon.getRemainingUses() - 1);
                return ReturnMessage.ATTACK;
            } else if (equippedWeapon.getRemainingUses() == 0) {
                return ReturnMessage.NO_AMMO;
            }
        }
        return ReturnMessage.IS_NOT_EQUIPPED;
    }

    public int getDamageDone() {
        return equippedWeapon.getDamage();
    }

    public ReturnMessage equipWeapon(String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().toLowerCase().contains(itemName.toLowerCase())) {
                if (item instanceof Weapon) {
                    equippedWeapon = (Weapon) item;
                    checkWeapon = ReturnMessage.IS_EQUIPPED;
                    return ReturnMessage.IS_EQUIPPED;
                } else
                    return ReturnMessage.IS_NOT_A_WEAPON;
            }
        }
        return ReturnMessage.NOT_FOUND;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }


}

