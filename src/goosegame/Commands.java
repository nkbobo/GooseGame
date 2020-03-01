/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

/**
 *
 * @author n.mosca
 */
public class Commands {
    
    private static final String REGEX_NUMBER_COMMA_NUMBER = "\\s[1-6]\\,\\s[1-6]";
    private static final String ERROR = "This is not a valid command!";

    public static String addPlayerCommand(GameState currentGame, String command) {
        String currentPlayer = command.replace("add player ", "");
        if(currentPlayer.isEmpty()){
            return ERROR;
        }
        if (currentGame.checkIfPlayerExist(currentPlayer)) {
            return currentPlayer + ": already existing player";
        }
        currentGame.addPlayer(currentPlayer);
        return "players: " + currentPlayer;
    }

    static String moveAPlayer(GameState currentGame, Board currentBoard, String command) {
        String currentPlayerName;
        Player currentPlayer;
        String partialCommand = command.replace("move ", "");
        String lastFive = "";
        int num1=0;
        int num2=0;
        String out="";
        
        if (partialCommand.isEmpty()){
            return ERROR;
        }
        if(partialCommand.length()<4){
            currentPlayerName = partialCommand;
        }
        else{            
            lastFive = partialCommand.substring(partialCommand.length()-5,partialCommand.length());
            if (!lastFive.matches(REGEX_NUMBER_COMMA_NUMBER)){
                currentPlayerName = partialCommand;
            }
            else{
                currentPlayerName = partialCommand.substring(0,partialCommand.length()-5);
                num1 = Integer.parseInt(partialCommand.substring(partialCommand.length()-4,partialCommand.length()-3));
                num2 = Integer.parseInt(partialCommand.substring(partialCommand.length()-1,partialCommand.length()));
            }
        }
        if(!currentGame.checkIfPlayerExist(currentPlayerName)){
            return currentPlayerName + ": is not an existing player";
        }
        
        //MOVEMENT
        
        currentPlayer = currentGame.getAPlayer(currentPlayerName);
        //currentPlayer will be updated from a move
        currentPlayer = currentGame.move(currentPlayer, num1, num2);
        out= currentPlayerName + " rolls " + currentPlayer.getLastRoll1() + ", " 
                + currentPlayer.getLastRoll2()+ ". "
                + currentPlayerName 
                + " moves from " + currentBoard.nameOfTheSpace(currentPlayer.getOldPosition())
                + " to " + currentBoard.nameOfTheSpace(currentPlayer.getPosition());
        
        //CHECK BOUNCE
        
        if (currentBoard.needBounce(currentPlayer.getPosition())){
            int rightPosition = (currentBoard.bounce(currentPlayer.getPosition()));
            currentPlayer.setPosition(rightPosition);
            currentGame.updateAPlayer(currentPlayer);
            out= out +". "+currentPlayerName+" bounces! "+currentPlayerName+" returns to "+rightPosition;
        }
        
        //CHECK WIN
        
        if (currentBoard.win(currentPlayer.getPosition())){
            out= out +". "+currentPlayerName+" Wins!!";
        }
        
        //CHECK BRIDGE
        
        if (currentBoard.needBridge(currentPlayer.getPosition())){
            int rightPosition = (currentBoard.bridge());
            currentPlayer.setPosition(rightPosition);
            currentGame.updateAPlayer(currentPlayer);
            out= out +". "+currentPlayerName+" jumps to "+rightPosition;
        }
        
        //CHECK GOOSE
        
        if (currentBoard.needGoose(currentPlayer.getPosition())){
            int rightPosition = (currentBoard.goose(currentPlayer.getPosition(), currentPlayer.getLastRoll1(), currentPlayer.getLastRoll2()));
            currentPlayer.setPosition(rightPosition);
            currentGame.updateAPlayer(currentPlayer);
            out= out +". "+currentPlayerName +" moves again and goes to "+currentBoard.nameOfTheSpace(rightPosition);
            if (currentBoard.needGoose(currentPlayer.getPosition())){
                rightPosition = (currentBoard.goose(currentPlayer.getPosition(), currentPlayer.getLastRoll1(), currentPlayer.getLastRoll2()));
                currentPlayer.setPosition(rightPosition);
                currentGame.updateAPlayer(currentPlayer);
                out= out +". "+currentPlayerName +" moves again and goes to "+currentBoard.nameOfTheSpace(rightPosition);
            }
        }
        
        return out;
    }

}
