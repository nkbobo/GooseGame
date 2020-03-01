/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

import java.util.Random;

/**
 *
 * @author n.mosca
 */
public class Dice {
    private static final Random RAND = new Random();
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 6;
    
    public static int roll(){
        return RAND.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
    }
}
