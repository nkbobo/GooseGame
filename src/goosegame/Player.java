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
public class Player {

    private String name;
    private int position;
    private int oldPosition;
    private int lastRoll1;
    private int lastRoll2;

    public Player(String name) {
        this.name = name;
        int postion = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLastRoll1() {
        return lastRoll1;
    }

    public void setLastRoll1(int lastRoll1) {
        this.lastRoll1 = lastRoll1;
    }

    public int getLastRoll2() {
        return lastRoll2;
    }

    public void setLastRoll2(int lastRoll2) {
        this.lastRoll2 = lastRoll2;
    }

    public int getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(int oldPosition) {
        this.oldPosition = oldPosition;
    }

}
