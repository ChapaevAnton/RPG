package units;

public abstract class Unit {


    public static final int HEALTH = 200;
    public static final int EXPERIENCE = 0;
    public static final int GOLD = 50;

    protected String name;
    protected int health;
    protected int gold;
    protected int experience;

    protected Unit(String name, int health, int gold, int experience) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

}
