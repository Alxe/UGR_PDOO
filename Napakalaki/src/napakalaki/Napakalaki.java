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
public class Napakalaki {
    private static Napakalaki instance = null;
    
    public static Napakalaki getInstance() {
        if(instance == null) { instance = new Napakalaki(); }
        
        return instance;
    }
    
    private List<Player> players;
    
    private CardDealer dealer;
    
    private Player currentPlayer;
    
    private Monster currentMonster;
    
    private int playerIndex;
    
    private Napakalaki() {
        this.dealer = CardDealer.getInstance();
        this.players = new ArrayList<>();
    }
    
    private void initPlayers(String... names) {
        for(String s : names) {
            players.add(new Player(s));
        }
    }
    
    private Player nextPlayer() {
        throw new UnsupportedOperationException();        
    }
    
    private boolean nextTurnAllowed() {
        throw new UnsupportedOperationException();    
    }
    
    private void setEnemies() {
        throw new UnsupportedOperationException();    
    }
    
    public CombatResult developCombat() {
        throw new UnsupportedOperationException();    
    }
    
    public void discardVisibleTreasures(Treasure... treasures) {
        throw new UnsupportedOperationException();    
    }
    
    public void discardHiddenTreasures(Treasure... treasures) {
        throw new UnsupportedOperationException();    
    }
    
    public void makeTreasuresVisibles(Treasure... treasures) {
        throw new UnsupportedOperationException();    
    }
    
    public void initGame(String... players) {
        throw new UnsupportedOperationException();    
    }
    
    public Player getCurrentPlayer() {
        throw new UnsupportedOperationException();    
    }
    
    public Monster getCurrentMonster() {
        throw new UnsupportedOperationException();
    }
    
    public boolean nextTurn() {
        throw new UnsupportedOperationException();    
    }
    
    public boolean endOfGame(CombatResult result) {
        throw new UnsupportedOperationException();    
    }
}
