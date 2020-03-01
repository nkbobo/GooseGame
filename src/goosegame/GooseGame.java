/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

import java.util.Scanner;

/**
 *
 * @author n.mosca
 */
public class GooseGame {

    private static final Scanner MY_SCAN = new Scanner(System.in);
    private static final String EXIT = "exit";
    private static final String ERROR = "This is not a valid command!";

    private final static GameState CURRENT_GAME = new GameState();
    private final static Board CURRENT_BOARD = new Board();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String command;

        System.out.println(">>Hello! This is The Goose Game!");
        do {
            System.out.println(">>Insert a command or write help:");
            command = MY_SCAN.nextLine();
            command = command.toLowerCase();
            if (command.equals(EXIT)) {
                break;
            }
            System.out.println(">>"+execute(command));
        } while (true);
        System.out.println(">>See you later!");
    }

    private static String execute(String command) {
        
        if (command.isEmpty()) {
            return ERROR;
        }
        if (command.startsWith("add player ")) {
            return Commands.addPlayerCommand(CURRENT_GAME,command);
        }
        if (command.startsWith("move ")){
            return Commands.moveAPlayer(CURRENT_GAME, CURRENT_BOARD, command);
        }
        if (command.equals("help")){
            return "Available commands are:\n"
                    + "1) add player <PLAYER_NAME> to add a player (e.g. add player pippo)\n"
                    + "2) move <PLAYER_NAME> to automatically roll the dice for him (e.g. move pippo)\n"
                    + "3) move <PLAYER_NAME> <N1>, <N2> to move him of the sum of those numbers (e.g. move pippo 2, 3)"
                    + "4) exit to quit playing";
        }
        return ERROR;
    }

    

}
