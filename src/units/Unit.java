package units;

public abstract class Unit implements Fighting {


    public static final int DAMAGE_BASE = 10;
    public static final int DEFENCE_BASE = 10;
    public static final int LEVEL_BASE = 1;
    public static final int EXPERIENCE_BASE = 0;
    public static final int GOLD_BASE = 50;


    public Unit(String name, int level, int experience, int power, int agility, int luck, int damage, int defence,
                int health, int gold) {
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

    protected String name;

    protected int level;
    protected int experience;

    protected int power;
    protected int agility;
    protected int luck;

    protected int damage;
    protected int defence;
    protected int health;

    protected int gold;

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", health=" + health;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int attack() {

    /*
    Random chance = new Random();
    int critProc = chance.nextInt(9);
    if(critProc + (int) luck/5 > 5){
        hp = hp - (DAMAGE_BASE + (damage * (int) power/3))*2;
    } else {
        hp = hp - DAMAGE_BASE + (damage * (int) power/3);
    }
     */
        return 0;
    }

    @Override
    public int defence() {
        return 0;
    }
}
