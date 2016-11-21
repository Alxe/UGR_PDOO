/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        unusedTreasures.clear();
        unusedTreasures.add(null);
    }
    
    private void initMonsterCardDeck() {
        unusedMonsters.clear();
        
        unusedMonsters.add(
                new Monster("3 Byakhees de bonanza", 8,
                        new Prize(2, 1),
                        new BadConsequence(
                                "Pierdes tu armadura visible y otra oculta", 0,
                                Arrays.asList(TreasureKind.ARMOR),
                                Arrays.asList(TreasureKind.ARMOR))));
        unusedMonsters.add(
                new Monster("Tenochtitlan", 2,
                        new Prize(1, 1),
                        new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
                                Arrays.asList(TreasureKind.HELMET),
                                Collections.<TreasureKind>emptyList())));
        unusedMonsters.add(
                new Monster("El sopor de Dunwich", 2,
                        new Prize(1, 1),
                        new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
                                Arrays.asList(TreasureKind.SHOES),
                                Collections.<TreasureKind>emptyList())));
        unusedMonsters.add(
                new Monster("Demonios de Magaluf", 2,
                        new Prize(4, 1),
                        new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, 1, 1)));
        unusedMonsters.add(
                new Monster("El gorrón en el umbral", 13,
                        new Prize(3, 1),
                        new BadConsequence("Pierdes todos tus tesoros visibles", 0, Integer.MAX_VALUE, 0)));
        unusedMonsters.add(
                new Monster("H.P. Munchcraft", 6, 
                        new Prize(2, 1), 
                        new BadConsequence("Pierdes la armadura visible", 0,
                                Arrays.asList(TreasureKind.ARMOR), 
                                Collections.<TreasureKind>emptyList())));
        
        unusedMonsters.add(
                new Monster("Necrófago", 13, 
                        new Prize(1, 1), 
                        new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, 
                                Arrays.asList(TreasureKind.ARMOR), Collections.<TreasureKind>emptyList())));
        
        unusedMonsters.add(
                new Monster("El rey de rosado", 11, 
                        new Prize(3, 2), 
                        new BadConsequence("Pierdes 5 niveles de 3 tesoros visibles", 5, 3, 0)));
        
        unusedMonsters.add(
                new Monster("Flecher", 2, 
                        new Prize(1, 1), 
                        new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)));
        
        unusedMonsters.add(
                new Monster("Los hondos", 8, 
                        new Prize(2, 1), 
                        new BadConsequence("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estas muerto", true)));
        
        unusedMonsters.add(
                new Monster("Semillas Cthulhu", 4, 
                        new Prize(2, 1), 
                        new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2)));
        
        unusedMonsters.add(
                new Monster("Dameargo", 1, 
                        new Prize(2, 1), 
                        new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0,
                                Arrays.asList(TreasureKind.ONEHAND), 
                                Collections.<TreasureKind>emptyList())));
        unusedMonsters.add(
                new Monster("Pollipólipo volante", 3, 
                        new Prize(2, 1), 
                        new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)));
        unusedMonsters.add(
                new Monster("Yskhtihyssg-Goth", 14, 
                        new Prize(3, 1), 
                        new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true)));
        unusedMonsters.add(
                new Monster("Familia feliz", 1, 
                        new Prize(3, 1), 
                        new BadConsequence("La familia te atrapa. Estás muerto.", true)));
        unusedMonsters.add(
                new Monster("Roboggoth", 8, 
                        new Prize(2, 1), 
                        new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, Arrays.asList(TreasureKind.BOTHHANDS), Collections.<TreasureKind>emptyList())));
        unusedMonsters.add(
                new Monster("El espía sordo", 5, 
                        new Prize(1, 1), 
                        new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,
                                Arrays.asList(TreasureKind.HELMET), Collections.<TreasureKind>emptyList())));
        unusedMonsters.add(
                new Monster("Tongue", 19, 
                        new Prize(2, 1), 
                        new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)));
        unusedMonsters.add(
                new Monster("Bicéfalo", 21, 
                        new Prize(2, 1), 
                        new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, Integer.MAX_VALUE, 0)));
    
    }
    
    private void shuffleTreasures() {
            Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonster() {
            Collections.shuffle(unusedMonsters);
    }
    
    public Treasure nextTreasure() {
            throw new UnsupportedOperationException();
    }
    
    public Monster nextMonster() {
            throw new UnsupportedOperationException();
    }
    
    public void giveTreasureBack(Treasure t) {
            usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m) {
            usedMonsters.add(m);
    }
    
    public void initCards() {
            throw new UnsupportedOperationException();
    }
}
