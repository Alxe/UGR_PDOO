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
public class Prize {
    private int treasures;
    private int level;
    
    public Prize(int treasures, int level) {
        this.treasures = treasures;
        this.level = level;
    }
    
    public int getTreasures() {
        return treasures;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Prize{" + "treasures=" + treasures + ", level=" + level + '}';
    }
    
}