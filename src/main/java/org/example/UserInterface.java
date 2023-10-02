package org.example;

import java.util.Scanner;

public class UserInterface {


    Scanner scanner = new Scanner(System.in);
    String input;

    Adventure controller;

    public UserInterface(Adventure controller) {
        this.controller = controller;
    }

    public void startGame() {

        controller.buildMap();
        controller.setCurrentRoom();
        System.out.println("\nWELCOME TO A'S DOLLHOUSE #A!");
        System.out.println("Write help for a list of instructions\n");


        do {
            System.out.print("You are in the following room: ");
            System.out.println(controller.getCurrentRoom());
            System.out.println("In this room I see the following items:\n" + controller.showItemsInRoom());

            System.out.println("\nWhat is your next move? ");
            input = scanner.nextLine();


            String userInputs = "";
            String userChoice = "";
            String[] commands = input.split("\\s+");
            if (commands.length == 1) {
                userInputs = commands[0];
            } else if (commands.length == 2) {
                userInputs = commands[0];
                userChoice = commands[1];
            } else if (commands.length == 3) {
                userInputs = commands[0];
                userChoice = commands[1] + " " + commands[2];
            }

            switch (userInputs.toLowerCase()) {
                case "north", "n" -> controller.moveAround(input);
                case "south", "s"-> controller.moveAround(input);
                case "east", "e" -> controller.moveAround(input);
                case "west", "w" -> controller.moveAround(input);
                case "inventory" ->
                        System.out.println("\nIn your inventory there is following: \n" + controller.showInventory() + "\n");
                case "take" -> controller.takeItemToInventory(userChoice);
                case "drop" -> controller.dropItemFromInventory(userChoice);
                case "help" -> System.out.println("""
                        If you want to go North, write: "North"
                        If you want to go East, write: "East"
                        If you want to go South, write "South"
                        If you want to go West,write "West"
                        If you want to take an item,write "take item"
                        If you want to drop an item, write "drop item"
                        If you would like to check what is in you inventory, then write "inventory"
                        If you would like to know what room you're, write: "look"
                        If you would like to end the game, write: "exit"
                        """);
                case "look" ->
                        System.out.println("In this room are the following items: \n" + controller.showItemsInRoom());
                case "exit" -> System.out.println("Thank you for playing in A's dollhouse #A!");
                default -> System.out.println("Not a known command!.");
            }
        } while (!input.equalsIgnoreCase("exit"));
    }
}

