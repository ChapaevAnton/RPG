package units;

import java.util.Random;

abstract public class Monster extends CombatUnit {

    public Monster(String name, int health, int gold, int experience, int power, int agility, int luck,
                   int damage, int defence, int level) {
        super(name, health, gold, experience, power, agility, luck, damage, defence, level);
    }

    @Override
    public int attack() {
        int chance = new Random().nextInt(9);
        if (chance + luck / 5 > 6) {
            return (DAMAGE + (damage * power / 3)) * 2;
        } else {
            return DAMAGE + (damage * power / 3);
        }

    }

    @Override
    public int defence() {
        return DEFENCE + (defence * agility / 5);
    }

}
