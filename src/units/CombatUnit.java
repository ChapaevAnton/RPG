package units;

abstract public class CombatUnit extends Unit {

    public static final int POWER = 5;
    public static final int AGILITY = 5;
    public static final int LUCK = 5;
    public static final int DAMAGE = 5;
    public static final int DEFENCE = 5;

    protected int power;
    protected int agility;
    protected int luck;
    protected int damage;
    protected int defence;

    protected CombatUnit(String name, int health, int gold, int experience, int power, int agility, int luck, int damage, int defence) {
        super(name, health, gold, experience);
        this.power = power;
        this.agility = agility;
        this.luck = luck;
        this.damage = damage;
        this.defence = defence;
    }

    public abstract int attack();

    public abstract int defence();

}
