    package napakalaki;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author alexnp
 */
public class PruebaNapakalaki {

    static List<Monster> monstruos = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        monstruos.add(
                new Monster("3 Byakhees de bonanza", 8,
                        new Prize(2, 1),
                        new BadConsequence(
                                "Pierdes tu armadura visible y otra oculta", 0,
                                Arrays.asList(TreasureKind.ARMOR),
                                Arrays.asList(TreasureKind.ARMOR))));
        monstruos.add(
                new Monster("Tenochtitlan", 2,
                        new Prize(1, 1),
                        new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
                                Arrays.asList(TreasureKind.HELMET),
                                Collections.<TreasureKind>emptyList())));
        monstruos.add(
                new Monster("El sopor de Dunwich", 2,
                        new Prize(1, 1),
                        new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
                                Arrays.asList(TreasureKind.SHOES),
                                Collections.<TreasureKind>emptyList())));
        monstruos.add(
                new Monster("Demonios de Magaluf", 2,
                        new Prize(4, 1),
                        new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, 1, 1)));
        monstruos.add(
                new Monster("El gorrón en el umbral", 13,
                        new Prize(3, 1),
                        new BadConsequence("Pierdes todos tus tesoros visibles", 0, Integer.MAX_VALUE, 0)));
        monstruos.add(
                new Monster("H.P. Munchcraft", 6, 
                        new Prize(2, 1), 
                        new BadConsequence("Pierdes la armadura visible", 0,
                                Arrays.asList(TreasureKind.ARMOR), 
                                Collections.<TreasureKind>emptyList())));
        
        monstruos.add(
                new Monster("Necrófago", 13, 
                        new Prize(1, 1), 
                        new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, 
                                Arrays.asList(TreasureKind.ARMOR), Collections.<TreasureKind>emptyList())));
        
        monstruos.add(
                new Monster("El rey de rosado", 11, 
                        new Prize(3, 2), 
                        new BadConsequence("Pierdes 5 niveles de 3 tesoros visibles", 5, 3, 0)));
        
        monstruos.add(
                new Monster("Flecher", 2, 
                        new Prize(1, 1), 
                        new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)));
        
        monstruos.add(
                new Monster("Los hondos", 8, 
                        new Prize(2, 1), 
                        new BadConsequence("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estas muerto", true)));
        
        monstruos.add(
                new Monster("Semillas Cthulhu", 4, 
                        new Prize(2, 1), 
                        new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2)));
        
        monstruos.add(
                new Monster("Dameargo", 1, 
                        new Prize(2, 1), 
                        new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0,
                                Arrays.asList(TreasureKind.ONEHAND), 
                                Collections.<TreasureKind>emptyList())));
        monstruos.add(
                new Monster("Pollipólipo volante", 3, 
                        new Prize(2, 1), 
                        new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)));
        monstruos.add(
                new Monster("Yskhtihyssg-Goth", 14, 
                        new Prize(3, 1), 
                        new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true)));
        monstruos.add(
                new Monster("Familia feliz", 1, 
                        new Prize(3, 1), 
                        new BadConsequence("La familia te atrapa. Estás muerto.", true)));
        monstruos.add(
                new Monster("Roboggoth", 8, 
                        new Prize(2, 1), 
                        new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, Arrays.asList(TreasureKind.BOTHHANDS), Collections.<TreasureKind>emptyList())));
        monstruos.add(
                new Monster("El espía sordo", 5, 
                        new Prize(1, 1), 
                        new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,
                                Arrays.asList(TreasureKind.HELMET), Collections.<TreasureKind>emptyList())));
        monstruos.add(
                new Monster("Tongue", 19, 
                        new Prize(2, 1), 
                        new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)));
        monstruos.add(
                new Monster("Bicéfalo", 21, 
                        new Prize(2, 1), 
                        new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, Integer.MAX_VALUE, 0)));
    
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
