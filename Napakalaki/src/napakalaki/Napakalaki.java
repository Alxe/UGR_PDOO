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
        int idx_player = (currentPlayer != null) 
                ? ((players.indexOf(currentPlayer) + 1) % players.size())
                : (int) Math.round(Math.random() *  (players.size() - 1));
        
        return currentPlayer = players.get(idx_player);
    }
    
    private boolean nextTurnAllowed() {
        return (currentPlayer == null) || currentPlayer.validState();
    }
    
    private void setEnemies() {
        for(Player p : players) {
            Player pe;
            
            do {
                pe = players.get(
                        (int) Math.round(Math.random() *  (players.size() - 1)));
            } while(p == pe);
            
            p.setEnemy(pe);
        }
    }
    
    public CombatResult developCombat() {
        CombatResult cr = currentPlayer.combat(currentMonster);
        
        dealer.giveMonsterBack(currentMonster);
        
        return cr;
    }
    
    public void discardVisibleTreasures(Treasure... treasures) {
       for(Treasure t : treasures) {
           currentPlayer.discardVisibleTreasure(t);
           
           dealer.giveTreasureBack(t);
           
       }  
    }
    
    public void discardHiddenTreasures(Treasure... treasures) {
          for(Treasure t : treasures) {
           currentPlayer.discardHiddenTreasure(t);
           
           dealer.giveTreasureBack(t);
           
       }   
    }
    
    public void makeTreasuresVisibles(Treasure... treasures) {
        for(Treasure t : treasures) {
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public void initGame(String... names) {
        initPlayers(names);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    public boolean nextTurn() {
       boolean stateOk = nextTurnAllowed() 
                         && currentPlayer.validState();
       
       if(stateOk) {
           Monster currentMonster = dealer.nextMonster();
           
           currentPlayer = nextPlayer();
           
           if(currentPlayer.isDead()) { currentPlayer.initTreasures(); }
       }
               
       return stateOk;
    }
    
    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WINGAME; 
    }
}
