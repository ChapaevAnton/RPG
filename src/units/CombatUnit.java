package units;

abstract public class CombatUnit extends Unit {

    public static final int POWER = 5;
    public static final int AGILITY = 5;
    public static final int LUCK = 5;
    public static final int DAMAGE = 5;
    public static final int DEFENCE = 5;
    public static final int LEVEL = 1;

    protected int power;
    protected int agility;
    protected int luck;
    protected int damage;
    protected int defence;
    protected int level;

    protected CombatUnit(String name, int health, int gold, int experience, int power, int agility, int luck,
                         int damage, int defence, int level) {
        super(name, health, gold, experience);
        this.power = power;
        this.agility = agility;
        this.luck = luck;
        this.damage = damage;
        this.defence = defence;
        this.level = level;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return  name +
                ", lvl=" + level +
                ", HP=" + health;
    }

    public abstract int attack();

    public abstract int defence();

}
