/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author n.mosca
 */
public class GameState {

    private final Map<String, Player> players;

    public GameState() {
        this.players = new HashMap<String, Player>();
    }

    public void addPlayer(String name) {
        Player newPlayer = new Player(name);
        players.put(newPlayer.getName(), newPlayer);
    }

    public boolean checkIfPlayerExist(String name) {
        return players.containsKey(name);
    }

    public Player move(Player currentPlayer, int num1, int num2) {
        int startingPosition = currentPlayer.getPosition();
        currentPlayer.setOldPosition(startingPosition);
        if (num1 == 0) {
            num1 = Dice.roll();
            num2 = Dice.roll();
        }
        currentPlayer.setLastRoll1(num1);
        currentPlayer.setLastRoll2(num2);
        currentPlayer.setPosition(startingPosition+num1+num2);
        players.put(currentPlayer.getName(), currentPlayer);
        return currentPlayer;
    }
    
    public Player getAPlayer(String name){
        return players.get(name);
    }
    
    public void updateAPlayer(Player player){
        players.put(player.getName(), player);
    }

}
