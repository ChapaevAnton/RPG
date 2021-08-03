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


    // TODO: 31.07.2021 add sword attack
    @Override
    public int attack() {
        int chance = new Random().nextInt(9);
        if (chance + luck / 5 > 6) {
            return (DAMAGE + (damage * power / 3)) * 2;
        } else {
            return DAMAGE + (damage * power / 3);
        }

    }

    // TODO: 31.07.2021 add shield defense
    @Override
    public int defence() {
        return DEFENCE + (defence * agility / 5);
    }
}
