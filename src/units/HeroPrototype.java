package units;

import java.util.Random;

public class HeroPrototype extends CombatUnit{
    //base stats
    public static final int BASE_STRENGTH = 5;
    public static final int BASE_AGILITY = 5;
    public static final int BASE_LUCK = 5;

    public static final int BASE_DAMAGE = 5;
    public static final int BASE_DEFENCE = 5;
    public static final int HP = 200;

    public static final int BASE_LEVEL = 1;
    public static final int BASE_EXPERIENCE = 0;

    //current stats
    protected static int strength;
    protected static int agility;
    protected static int luck;

    protected static int damage;
    protected static int defence;
    protected static int hp;
    protected static int maxHP = hp;

    protected static int level;
    protected static int experience;

    public HeroPrototype(String name) {
        super(name, HP, GOLD, EXPERIENCE, BASE_STRENGTH, BASE_AGILITY, BASE_LUCK, BASE_DAMAGE, BASE_DEFENCE, BASE_LEVEL);
    }

    public void levelUp(){
        int lvlUpThreshold = 0;
            lvlUpThreshold = (int)(BASE_EXPERIENCE + 0.75 * BASE_EXPERIENCE * level);
            if(experience > lvlUpThreshold){
                experience = experience - lvlUpThreshold;
                level = level + 1;
                setStats(level); //power, agi, luck
                System.out.println("Уровень повышен! Текущий уровень :" + level);
        }
    }

    private void setStats(int level){
        agility = (int)(agility + BASE_AGILITY * 0.2 * level);
        strength = (int)(strength + BASE_STRENGTH * 0.2 * level);
        luck = (int)(luck + BASE_LUCK * 0.2 * level);
        hp = (hp + 5 * level * strength);
        maxHP = (maxHP + 5 * level * strength);
    }

    @Override
    public int attack() {
        int chance = new Random().nextInt(10) + 1;
        damage = BASE_DAMAGE + level + 5 + strength;
        if (chance + luck / 5 > 7) {
            return (int) (getTotalDamage() * 1.5);
        } else {
            return getTotalDamage();
        }
    }

    @Override
    public int defence() {
        defence = BASE_DEFENCE + level + agility / 5;
        return getTotalDefence();
    }

    @Override
    public String toString() {
        return name + "lvl: " + level + '\'' + ", hp: " + hp + "/" + maxHP + " exp: " + experience;
    }

}
