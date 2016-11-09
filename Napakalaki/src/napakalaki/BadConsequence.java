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
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private List<TreasureKind> specificVisibleTreasure = new ArrayList<>();
    private List<TreasureKind> specificHiddenTreasure = new ArrayList<>();

    public BadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
    }

    public BadConsequence(String text, int levels, List<TreasureKind> specificVisibleTreasure, List<TreasureKind> specificHiddenTreasure) {
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasure = (specificVisibleTreasure != null) ? specificVisibleTreasure : new ArrayList<>();
        this.specificHiddenTreasure = (specificHiddenTreasure != null) ? specificHiddenTreasure : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "BadConsequence{" + "text=" + text + ", levels=" + levels + ", nVisibleTreasures=" + nVisibleTreasures + ", nHiddenTreasures=" + nHiddenTreasures + ", death=" + death + ", specificVisibleTreasure=" + specificVisibleTreasure + ", specificHiddenTreasures=" + specificHiddenTreasure + '}';
    }

    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }

    public List<TreasureKind> getSpecificVisibleTreasure() {
        return specificVisibleTreasure;
    }

    public List<TreasureKind> getSpecificHiddenTreasure() {
        return specificHiddenTreasure;
    }
    
    
}