    package napakalaki;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author alexnp
 */
public class PruebaNapakalaki {
    
    static CardDealer dealer = CardDealer.getInstance();

    static List<Monster> monstruos = dealer.unusedMonsters;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        dealer.initCards();
        
        monstruosConNivelMayorADiez().stream().forEach(System.out::println); 
        monstruosConMalRolloNiveles().stream().forEach(System.out::println);
        monstruosConBuenRolloDeNivelUno().stream().forEach(System.out::println);
        monstruosConsulta4(TreasureKind.ONEHAND).stream().forEach(System.out::println);
        monstruosConsulta4(TreasureKind.BOTHHANDS).stream().forEach(System.out::println);
        monstruosConsulta4(TreasureKind.HELMET).stream().forEach(System.out::println);
        monstruosConsulta4(TreasureKind.SHOES).stream().forEach(System.out::println);
        monstruosConsulta4(TreasureKind.ARMOR).stream().forEach(System.out::println);
        
        
    }
    
    public static List<Monster> monstruosConNivelMayorADiez() {
        return monstruos.stream()
                .filter(m -> m.getCombatLevel() > 10)
                .collect(Collectors.toList());
    }
    
    public static List<Monster> monstruosConMalRolloNiveles() {
        return monstruos.stream()
                .filter(m ->
                    !m.getBc().isDeath()
                        && m.getBc().getnVisibleTreasures() == 0
                        && m.getBc().getnHiddenTreasures() == 0
                        && m.getBc().getSpecificVisibleTreasure().isEmpty()
                        && m.getBc().getSpecificHiddenTreasure().isEmpty()
                )
                .collect(Collectors.toList());
    }
    
    public static List<Monster> monstruosConBuenRolloDeNivelUno() {
        return monstruos.stream()
                .filter(m -> m.getPrize().getLevel() > 1)
                .collect(Collectors.toList());
    }
    
    public static List<Monster> monstruosConsulta4(TreasureKind treasureKind) {
        return monstruos.stream()
                .filter(m ->
                        m.getBc().getSpecificVisibleTreasure().contains(treasureKind)
                        || m.getBc().getSpecificHiddenTreasure().contains(treasureKind)
                )
                .collect(Collectors.toList());
    }
}
