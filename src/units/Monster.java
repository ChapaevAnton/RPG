package units;

import java.util.Random;

abstract public class Monster extends Unit  implements Fighting {

    public Monster(String name, int level, int experience, int gold) {
        super(name, LEVEL_BASE, EXPERIENCE_BASE, 5, 5, 5, DAMAGE_BASE, DEFENCE_BASE, 100, GOLD_BASE);
    }

    public Monster(String name, int level, int experience, int power, int agility, int luck, int damage, int defence, int health, int gold) {
        super(name, level, experience, power, agility, luck, damage, defence, health, gold);
    }

    @Override
    public int attack() {
        int chance = new Random().nextInt(9);
        if(chance + (int) luck/5 > 6){
            return (DAMAGE_BASE + (damage * power/3))*2;
        } else {
            return DAMAGE_BASE + (damage * power/3);
        }

    }

    @Override
    public int defence() {
        return DEFENCE_BASE + (defence * agility/5);
    }

}
