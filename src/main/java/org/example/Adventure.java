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
    public void showInventory() {
        player.showInventory();

    }

    public void takeItemToInventory(String input) {
        player.takeItem(input);

    }

    public void dropItemFromInventory(String input) {
        player.dropItem(input);

    }


    public String look() {
        return map.look();
    }
}

