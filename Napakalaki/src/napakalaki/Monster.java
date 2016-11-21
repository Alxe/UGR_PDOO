/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author alexnp
 */
public class Monster {
    private String name;
    private int combatLevel;
    
    private Prize prize;
    private BadConsequence bc;

    public Monster(String name, int combatLevel, Prize prize, BadConsequence bc) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.bc = bc;
    }

    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public Prize getPrize() {
        return prize;
    }

    public BadConsequence getBc() {
        return bc;
    }
    
    public int getLevelsIsGained() {
        return prize.getLevel();
    }
    
    public int getTreasuresGained() {
        return prize.getTreasures();
    }

    @Override
    public String toString() {
        return "Monster{" + "name=" + name + ", combatLevel=" + combatLevel + ", prize=" + prize + ", bc=" + bc + '}';
    }
    
   
    
    
}
