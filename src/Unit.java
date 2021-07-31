public abstract class Unit {


    public static final int DAMAGE_BASE = 10;
    public static final int DEFENCE_BASE = 10;
    public static final int LEVEL_BASE = 1;
    public static final int EXPERIENCE_BASE = 0;
    public static final int GOLD_BASE = 50;


    public Unit(String name, int level, int experience, int power, int agility, int luck, int damage, int defence, int health, int gold) {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.power = power;
        this.agility = agility;
        this.luck = luck;
        this.damage = damage;
        this.defence = defence;
        this.health = health;
        this.gold = gold;
    }

    private String name;

    private int level;
    private int experience;

    private int power;
    private int agility;
    private int luck;

    private int damage;
    private int defence;
    private int health;

    private int gold;

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", health=" + health +
                '}';
    }
}
