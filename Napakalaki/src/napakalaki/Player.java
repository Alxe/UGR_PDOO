package napakalaki;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexnp
 */
class Player {
    protected static int MAXLEVEL = 10;
    
    private String name;
    
    private Player enemy;
    
    private List<Treasure> visibleTreasures;
    
    private List<Treasure> hiddenTreasures;
    
    private BadConsequence pendingBadConsequence;
    
    private int level;
    
    private boolean dead = true;
    
    private boolean canISteal = true;
    
    public Player(String name) {
        this.name = name;
        
        this.visibleTreasures = new ArrayList<>();
        this.hiddenTreasures = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    private void bringToLife() {
        dead = false;  
    }
    
    private int getCombatLevel() {
        int combatLevel = level;
        
        for(Treasure t : visibleTreasures) {
            combatLevel += t.getBonus();
        }
        
        return combatLevel;
    }
    
    private void incrementLevels(int l) {
        level += l;
    }
    
    private void decrementLevels(int l) {
        level -= l;  
    }
    
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;  
    }
    
    private void applyPrize(Monster m) {
        throw new UnsupportedOperationException();    
    }
    
    private void applyBadConsequence(Monster m) {
        throw new UnsupportedOperationException();    
    }
    
    private boolean canMakeTreasureVisible(Treasure t) {
        throw new UnsupportedOperationException();    
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind) {
        return (int) visibleTreasures
                .stream()
                .filter((t) -> t.getType() == tKind)
                .count();
    }
    
    private void dieIfNoTreasures() {
        if(visibleTreasures.isEmpty()
                || hiddenTreasures.isEmpty()) { dead = true; }  
    }
    
    public boolean isDead() {
        return dead;
    }
    
    public Treasure[] getHiddenTreasures() {
        throw new UnsupportedOperationException();
    }
    
    public Treasure[] getVisibleTreasures() {
        throw new UnsupportedOperationException();
    }
    
    public CombatResult combat(Monster m) {
        throw new UnsupportedOperationException();    
    }
    
    public void makeTreasureVisible(Treasure t) {
        throw new UnsupportedOperationException();    
    }
    
    public void discardVisibleTreasure(Treasure t) {
        throw new UnsupportedOperationException();    
    }
    
    public void discardHiddenTreasure(Treasure t) {
        throw new UnsupportedOperationException();    
    }
    
    public boolean validState() {
        return (pendingBadConsequence == null) 
                &&  (hiddenTreasures.size() <= 4);
    }
    
    public void initTreasures() {
        throw new UnsupportedOperationException();    
    }
    
    public int getLevels() {
        return level;
    }
    
    public Treasure stealTrasure() {
        throw new UnsupportedOperationException();    
    }
    
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure() {
        throw new UnsupportedOperationException();    
    }
    
    public boolean canISteal() {
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure() {
        return !visibleTreasures.isEmpty()
                || !hiddenTreasures.isEmpty();
    }
    
    private void haveStolen() {
        canISteal = false;    
    }
    
    public void discardAllTreasures() {
        throw new UnsupportedOperationException();
    }
}