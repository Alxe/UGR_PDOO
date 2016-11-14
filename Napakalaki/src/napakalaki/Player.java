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
        throw new UnsupportedOperationException();    
    }
    
    private int getCombatLevel() {
        throw new UnsupportedOperationException();    
    }
    
    private void incrementLevels(int l) {
        throw new UnsupportedOperationException();    
    }
    
    private void decrementLevels(int l) {
        throw new UnsupportedOperationException();    
    }
    
    private void setPendingBadConsequence(BadConsequence b) {
        throw new UnsupportedOperationException();    
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
        throw new UnsupportedOperationException();    
    }
    
    private void dieIfNoTreasures() {
        throw new UnsupportedOperationException();    
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
        throw new UnsupportedOperationException();    
    }
    
    public void initTreasures() {
        throw new UnsupportedOperationException();    
    }
    
    public int getLevels() {
        throw new UnsupportedOperationException();    
    }
    
    public Treasure stealTrasure() {
        throw new UnsupportedOperationException();    
    }
    
    public void setEnemy(Player enemy) {
        throw new UnsupportedOperationException();    
    }
    
    private Treasure giveMeATreasure() {
        throw new UnsupportedOperationException();    
    }
    
    public boolean CanISteal() {
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure() {
        throw new UnsupportedOperationException();    
    }
    
    private void haveStolen() {
        throw new UnsupportedOperationException();    
    }
    
    public void discardAllTreasures() {
        throw new UnsupportedOperationException();
    }
}