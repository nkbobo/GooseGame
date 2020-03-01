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
public class Board {

    private static final int FINAL_SPACE = 63;
    private static final int BRIDGE_SPACE = 12;
    private static final String START = "Start";
    private static final String THE_BRIDGE = "The Bridge";
    private static final String THE_GOOSE = "The Goose";

    private static Map<Integer, String> specialSpaces;

    public Board() {
        specialSpacesInit();
    }

    private void specialSpacesInit() {
        specialSpaces = new HashMap<>();
        specialSpaces.put(0, START);
        specialSpaces.put(6, THE_BRIDGE);
        //init 5, 9, 14, 18, 23, 27 to The Goose
        int delta = 1;
        for (int i = 5; i <= 27; i = i + 4 + delta) {
            specialSpaces.put(i, THE_GOOSE);
            delta = (delta == 1 ? 0 : 1);
        }
    }

    public String nameOfTheSpace(int position) {
        if (specialSpaces.containsKey(position)) {
            String name = specialSpaces.get(position);
            if (THE_GOOSE.equals(name)){
                return position + ", "+name;
            }
            return name;
        }
        return Integer.toString(position);
    }

    public boolean win(int position) {
        return position == FINAL_SPACE;
    }

    public boolean needBounce(int position) {
        return position > FINAL_SPACE;
    }

    public int bounce(int wrongPosition) {
        int numberOfSpaces = wrongPosition - FINAL_SPACE;
        return FINAL_SPACE - numberOfSpaces;
    }

    public boolean needBridge(int position) {
        String space = specialSpaces.get(position);
        return (THE_BRIDGE.equals(space));
    }
    
    public boolean needGoose(int position) {
        String space = specialSpaces.get(position);
        return (THE_GOOSE.equals(space));
    }

    public int bridge() {
        return BRIDGE_SPACE;
    }

    public int goose(int position, int lastRoll1, int lastRoll2) {
        return position + (lastRoll1 + lastRoll2);
    }

}
