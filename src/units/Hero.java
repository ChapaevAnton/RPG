package units;

import java.util.Random;

public class Hero extends CombatUnit {

    public static final int LEVEL = 1;
    protected int kill;//количество убитых
    public static final int BASE_EXPERIENCE = 100;
    protected int maxHP = health;
    //спосбоность

    public Hero(String name, int power){
        super(name, HEALTH, GOLD, EXPERIENCE, power, AGILITY, LUCK, DAMAGE, DEFENCE, LEVEL);
        this.kill = 0;
    }

    public Hero(String name, int health, int gold, int experience, int kill, int strength, int agility, int luck,
                int damage, int defence, int level) {
        super(name, health, gold, experience, strength, agility, luck, damage, defence, level);
        this.kill = kill;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public boolean currentLevelUp(){
        int lvlUpThreshold = 0;
        for(int i = 0; i < level; i++){
            lvlUpThreshold = (int)(BASE_EXPERIENCE + 0.75 * BASE_EXPERIENCE * level);
            if(experience < lvlUpThreshold){
                return false;
            }
            experience = experience - lvlUpThreshold;
            level = level + 1;
            setStats(level); //power, agi, luck
        } return true;
    }

    private void setStats(int level){
        agility = (int)(agility + AGILITY * 0.2 * level);
        strength = (int)(strength + STRENGTH * 0.2 * level);
        luck = (int)(luck + LUCK * 0.2 * level);
        health = (health + 5 * level * strength);
        maxHP = (maxHP + 5 * level * strength);
    }

    @Override
    public int attack() {
        int chance = new Random().nextInt(10) + 1;
        damage = DAMAGE + level + 5 + strength;
        if (chance + luck / 5 > 7) {
            return (int) (getTotalDamage() * 1.5);
        } else {
            return getTotalDamage();
        }
    }

    @Override
    public int defence() {
        defence = DEFENCE + level + agility / 5;
        return getTotalDefence();
    }


    public String getInfoFull() {
        return "Hero -> \n" +
                "  name='" + name +
                ", level=" + level +
                ", health=" + health +
                ", kill=" + kill +
                ", experience=" + experience +
                ", gold=" + gold + "\n" +
                "  power=" + strength +
                ", agility=" + agility +
                ", luck=" + luck + "\n" +
                "  damage=" + damage +
                ", defence=" + defence +
                ", weapon=" + weapon +
                ", armour=" + armour;


    }
}
