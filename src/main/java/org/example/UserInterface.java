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
        System.out.println("\n" + ConsoleColors.RED_BOLD_BRIGHT + "WELCOME TO A'S DOLLHOUSE #A!" + ConsoleColors.RESET);
        System.out.println("\n" + ConsoleColors.RED_BOLD_BRIGHT + "Write help for a list of instructions" + ConsoleColors.RESET);


        do {
            System.out.print("You are in the following room: ");
            System.out.println(controller.getCurrentRoom());
            System.out.println("In this room I see the following items:\n" + controller.showItemsInRoom());
            System.out.println("\n" + ConsoleColors.RED_BOLD_BRIGHT + "In this room I see this enemy:\n" + controller.getCurrentRoom().getListOfEnemies() + "\n" + ConsoleColors.RESET);

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
                case "south", "s" -> controller.moveAround(input);
                case "east", "e" -> controller.moveAround(input);
                case "west", "w" -> controller.moveAround(input);
                case "inventory" ->
                        System.out.println("\nIn your inventory there is following: \n" + controller.showInventory() + "\n");

                case "take" -> controller.takeItemToInventory(userChoice);


                case "drop" -> controller.dropItemFromInventory(userChoice);

                case "eat" -> {
                    ReturnMessage returnValueOfFood = controller.tryToEatFood(userChoice);

                    String answer = "";
                    if (returnValueOfFood == ReturnMessage.REALLY_EAT) {
                        System.out.println("That does not look healthy do you really want to eat it? [yes/no]");
                        while (!scanner.hasNextLine()) {
                            System.out.println("You cant enter anything but characters");
                            scanner.nextLine();
                        }
                        answer = scanner.nextLine();

                    }
                    if (answer.equalsIgnoreCase("yes")) {
                        controller.eatFood(userChoice);
                        System.out.println("*you have now eaten " + userChoice + " ");
                    } else if (returnValueOfFood == ReturnMessage.REALLY_EAT)
                        System.out.println("okay i wont eat it");


                    if (returnValueOfFood == ReturnMessage.EATABLE) {
                        System.out.println("You have now eaten " + userChoice + " ");
                    } else if (returnValueOfFood == ReturnMessage.NOT_FOUND) {
                        System.out.println("I can't find " + userChoice + " in the inventory");
                    } else if (returnValueOfFood == ReturnMessage.NOT_EATABLE) {
                        System.out.println(userChoice + " is not edible\n");
                    }
                }
                case "drink" -> {
                    ReturnMessage returnValueOfLiquid = controller.tryToDrinkLiquid(userChoice);


                    String answer = "";
                    if (returnValueOfLiquid == ReturnMessage.REALLY_DRINK) {
                        System.out.println("That does not look healthy do you really want to drink that? [yes/no]");
                        while (!scanner.hasNextLine()) {
                            System.out.println("You cant enter anything but characters");
                            scanner.nextLine();
                        }
                        answer = scanner.nextLine();
                    }
                    if (answer.equalsIgnoreCase("yes")) {
                        controller.drink(userChoice);
                        System.out.println("*drinking " + userChoice + "*");
                    } else if (returnValueOfLiquid == ReturnMessage.REALLY_DRINK)
                        System.out.println("okay i won't drink it anyway...");


                    if (returnValueOfLiquid == ReturnMessage.EATABLE) {
                        System.out.println("*drinking " + userChoice + "*");
                    } else if (returnValueOfLiquid == ReturnMessage.NOT_EATABLE) {
                        System.out.println("I can't find " + userChoice + " in the inventory");
                    } else if (returnValueOfLiquid == ReturnMessage.NOT_DRINKABLE) {
                        System.out.println(userChoice + " is not drinkable...\n");
                    }
                }

                case "equip" -> {

                    ReturnMessage isEquipped = controller.equipWeapon(userChoice);
                    if (isEquipped == ReturnMessage.IS_EQUIPPED) {
                        System.out.println("\nYou have equipped " + controller.equipWeapon(userChoice) + "\n");
                    }
                    if (isEquipped == ReturnMessage.NOT_A_WEAPON) {
                        System.out.println("\nYou can not equip " + controller.equipWeapon(userChoice) + " because it's not a weapon\n");
                    }
                    if (isEquipped == ReturnMessage.NOT_FOUND) {
                        System.out.println("\nNo weapon was found with the name " + userChoice + " in the inventory\n");
                    }

                }
                case "health" -> {

                    int playerHealth = controller.getPlayerHealth();
                    if (playerHealth == 100 && playerHealth > 50) {
                        System.out.println("Health: " + playerHealth + " - you are in good health, but avoid fighting for right now.\n");
                    } else if (playerHealth <= 50 && playerHealth > 35) {
                        System.out.println("Health: " + playerHealth + " - you are not in the best of shape. You should eat better foods\n");
                    } else if (playerHealth <= 35 && playerHealth > 20) {
                        System.out.println("Health: " + playerHealth + " - you are in poor condition, consider eating some food and resting\n");
                    } else if (playerHealth <= 20 && playerHealth > 0) {
                        System.out.println("Health: " + playerHealth + " - you are in extremely poor condition, eat tons of food \n");
                    }
                    System.out.println("Player's health after eating is:  " + playerHealth);

                }

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

