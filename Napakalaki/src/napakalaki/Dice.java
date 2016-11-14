/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author alexnp
 */
public class Dice {
    private static Dice instance = null;
    
    public static Dice getInstance() {
        if(instance == null) { instance = new Dice(); }
        
        return instance;
    }
    
    private final Random r;
    
    private Dice() {
        this.r = new Random();
    }
    
    public int nextNumber() {
        return (1 + r.nextInt(5));
    }
}