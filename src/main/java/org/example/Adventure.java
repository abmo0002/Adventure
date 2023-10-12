package org.example;

import java.util.ArrayList;

public class Adventure {

    Map map = new Map();
    Player player = new Player();


    public Adventure() {
    }

    public void buildMap() {
        map.getMap();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void setCurrentRoom() {
        player.setCurrentRoom(map.getCurrentRoom());
    }

    public void moveAround(String input) {
        player.getMoveAround(input);
    }


    public void takeItemToInventory(String input) {
        player.takeItem(input);

    }

    public void dropItemFromInventory(String input) {
        player.dropItem(input);

    }

    public ArrayList<Item> showItemsInRoom() {
        return player.getCurrentRoom().showItemsInRoom();
    }

    public ArrayList<Item> showInventory() {
        return player.showInventory();
    }


    public ReturnMessage eatFood(String foodToEat) {
        return player.eatFood(foodToEat);
    }

    public ReturnMessage tryToEatFood(String tryToEatFood) {
        return player.tryToEatFood(tryToEatFood);
    }

    public ReturnMessage drink(String liquidToDrink) {
        return player.drinkLiquid(liquidToDrink);
    }

    public ReturnMessage tryToDrinkLiquid(String tryToDrinkLiquid) {
        return player.tryTodrinkLiquid(tryToDrinkLiquid);
    }

    public int getPlayerHealth() {
        return player.getHealth();
    }

    public ReturnMessage equipWeapon(String weaponToEquip) {
      return  player.equipWeapon(weaponToEquip);

    }
    public Weapon getEquippedWeapon() {
        return player.getEquippedWeapon();
    }
    public int getAmmunition() {
        return player.getAmmunition();
    }
    public int getRemainingUses() {
        return player.remainingUses();
    }
    public int getDamage(){
        return player.damage();
    }


}
