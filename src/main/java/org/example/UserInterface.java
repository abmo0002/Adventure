package org.example;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    String userChoice;
    Adventure controller = new Adventure();

    public UserInterface(Adventure adventure) {

    }

    public void startGame() {
        controller.buildMap();
        controller.setCurrentRoom();
        System.out.println("\nWELCOME TO A'S DOLLHOUSE #A!");

        command();
    }

    public void command() {
        System.out.println("Write help for a list of instructions\n");

        try {
            System.out.println("\nWhere do you wish to go?");
            boolean player = true;

            System.out.print("You are in the following room:");
            System.out.println(controller.getCurrentRoom());

            while (player) {
                userChoice = scanner.nextLine();
                String input = scanner.nextLine();
                String[] userInputs = input.split(" ");
                String command = userInputs[0];
                String userChoice = " ";
                if (userInputs.length > 1) {
                    userChoice = userInputs[1];
                }

                switch (command) {
                    case "go north" -> controller.moveAround(userChoice);
                    case "go south" -> controller.moveAround(userChoice);
                    case "go east" -> controller.moveAround(userChoice);
                    case "go west" -> controller.moveAround(userChoice);
                    case "inventory" -> controller.showInventory();
                    case "take" -> controller.takeItemToInventory(userChoice);
                    case "drop" -> controller.dropItemFromInventory(userChoice);
                    case "help" -> System.out.println("If you want to move North, write: \"go north\"\n" +
                            "If you want to move East, then write \"go East\"\n" +
                            "If you want to move South, then write \"go south\"\n" +
                            "If you want to move West, then write \"go west\"\n" +
                            "If you want to know what room you're in write: \"look \"\n" +
                            "If you want to pick up an item, then write \"take *item*\"\n" +
                            "If you want to drop an item, then write \"drop *item*)\"\n" +
                            "If you want to check what is in you inventory, then write \"drop *item*\"\n" +
                            "If you wish to end the game write: \"exit\"");
                    case "look" -> {
                        System.out.println(controller.look());
                    }
                    case "exit" -> System.out.println("Thank you for playing in A's Dollhouse!");
                    default -> System.out.println("Not a known command!. Write help for instructions");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

