package units;

import equipments.Armour;
import equipments.Weapon;

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


    protected Weapon weapon;
    protected Armour armour;

    public CombatUnit(String name, int health, int gold, int experience,
                      int power, int agility, int luck, int damage, int defence, int level) {
        super(name, health, gold, experience);
        this.power = power;
        this.agility = agility;
        this.luck = luck;
        this.damage = damage;
        this.defence = defence;
        this.level = level;
    }

    public boolean isAlive(){
        return getHealth() > 0;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public int getTotalDamage() {
        int totalDamage = getDamage();
        totalDamage += weapon == null ? 0 : weapon.getDamage();
        return totalDamage;
    }

    public int getTotalDefence() {
        int totalDefence = getDefence();
        totalDefence += armour == null ? 0 : armour.getDefence();
        return totalDefence;
    }

    @Override
    public String toString() {
        return name +
                ", lvl=" + level +
                ", HP=" + health;
    }

    public abstract int attack();

    public abstract int defence();

}
