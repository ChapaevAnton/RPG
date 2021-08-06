package units;

import java.util.Random;

public class Hero extends CombatUnit {

    public static final int LEVEL = 1;
    protected int kill;//количество убитых
    //спосбоность
    //снарежение

    public Hero(String name, int level, int health, int gold, int kill, int experience,
                int power, int agility, int luck, int damage, int defence) {
        super(name, health, gold, experience, power, agility, luck, damage, defence, level);
        this.kill = kill;
    }


    @Override
    public int attack() {
        int chance = new Random().nextInt(10) + 1;
        if (chance + luck / 5 > 7) {
            return (int)(getTotalDamage() * 1.5);
        } else {
            return getTotalDamage();
        }
    }

    @Override
    public int defence() {
        return getTotalDefence();
    }
}
