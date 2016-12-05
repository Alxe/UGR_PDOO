package napakalaki;

import com.sun.org.apache.bcel.internal.util.BCELifier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexnp
 */
public class Player {
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
        int nLevels = m.getLevelsIsGained();
        
        incrementLevels(nLevels);
        
        int nTreasures = m.getTreasuresGained();
        
        if(nTreasures > 0) {
            CardDealer dealer = CardDealer.getInstance();
            
            for(int i = 0; i < nTreasures; i++) {
                Treasure t = dealer.nextTreasure();
                
                hiddenTreasures.add(t);
            }
        }
    }
    
    private void applyBadConsequence(Monster m) {
        BadConsequence badConsequence = m.getBc();
        
        int nLevels = badConsequence.getLevels();
    }
    
    private boolean canMakeTreasureVisible(Treasure t) {
        return visibleTreasures.stream()
                               .noneMatch((treasure) -> 
                                    { return (treasure.getType() == t.getType()); }
                               );
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
    
    public List<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
    public List<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m) {
        int myLevel = getCombatLevel(),
            monsterLevel = m.getCombatLevel();
        
        if(!canISteal()) {
            Dice dice = Dice.getInstance();
            
            int number = dice.nextNumber();
            
            if(number < 3) {
                monsterLevel += enemy.getCombatLevel();
            }
        }
        
        if(myLevel > monsterLevel) {
            applyPrize(m);
            
            return (level >= MAXLEVEL) 
                    ? CombatResult.WINGAME 
                    : CombatResult.WIN;
        } else {
            applyBadConsequence(m);
            
            return CombatResult.LOSE;
        }
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", level=" + level + ", dead=" + dead + '}';
    }
    
    public void makeTreasureVisible(Treasure t) {
        boolean canI = canMakeTreasureVisible(t);
        
        if(canI) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        
        if((pendingBadConsequence != null) 
                && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t);
        
        if((pendingBadConsequence != null) 
                && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        
        dieIfNoTreasures(); 
    }
    
    public boolean validState() {
        return (pendingBadConsequence == null) 
                &&  (hiddenTreasures.size() <= 4);
    }
    
    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        
        bringToLife();
        
        hiddenTreasures.add(dealer.nextTreasure());
        
        int number = dice.nextNumber();
        
        if(number > 1) {
            hiddenTreasures.add(dealer.nextTreasure());
        }
        
        if(number == 6) {
            hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    
    public int getLevels() {
        return level;
    }
    
    public Treasure stealTreasure() {
        Treasure treasure = null;
        
        boolean canI = canISteal();
        
        if(canI) {
            boolean canYou = enemy.canYouGiveMeATreasure();
            
            if(canYou) {
                treasure = enemy.giveMeATreasure();
                
                hiddenTreasures.add(treasure);
                
                haveStolen();
            }
        }
        
        return treasure;
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
        for(Treasure t : visibleTreasures) { discardVisibleTreasure(t); }
        for(Treasure t : hiddenTreasures) { discardHiddenTreasure(t); }
    }
}