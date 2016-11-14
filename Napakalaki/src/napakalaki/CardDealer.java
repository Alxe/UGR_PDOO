/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexnp
 */
public class CardDealer {
    public static CardDealer instance = null;
    
    public static CardDealer getInstance() {
        if(instance == null) { instance = new CardDealer(); }
        
        return instance;
    }
    
    private List<Treasure> unusedTreasures,
            usedTreasures;
    
    private List<Monster> unusedMonsters,
            usedMonsters;
    
    private CardDealer() {
        usedTreasures = new ArrayList<>();
        unusedTreasures = new ArrayList<>();
        usedMonsters = new ArrayList<>();
        unusedMonsters = new ArrayList<>();
    }
    
    private void initTreasureCardDeck() {
        throw new UnsupportedOperationException();
    }
    
    private void initMonsterCardDeck() {
        throw new UnsupportedOperationException();    
    }
    
    private void shuffleTreasures() {
            throw new UnsupportedOperationException();
    }
    
    private void shuffleMonster() {
            throw new UnsupportedOperationException();
    }
    
    public Treasure nextTreasure() {
            throw new UnsupportedOperationException();
    }
    
    public Monster nextMonster() {
            throw new UnsupportedOperationException();
    }
    
    public void giveTreasureBack(Treasure t) {
            throw new UnsupportedOperationException();
    }
    
    public void giveMonsterBack(Monster m) {
            throw new UnsupportedOperationException();
    }
    
    public void initCards() {
            throw new UnsupportedOperationException();
    }
}
