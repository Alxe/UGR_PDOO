package napakalaki;

/**
 *
 * @author alexnp
 */
public class Treasure {
    private String name;
    
    private int bonus;
    
    private TreasureKind type;
    
    public Treasure(String name, int bonus, TreasureKind type) {
        this.name = name;
        this.bonus = bonus;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBonus() {
        return bonus;
    }
    
    public TreasureKind getType() {
        return type;
    }
}
