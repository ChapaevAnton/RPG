package units;

import java.util.Random;

public class Hero extends CombatUnit {

    public static final int LEVEL = 1;
    protected int kill;//количество убитых

    public Hero(String name, int health, int gold, int experience, int kill, int power, int agility, int luck,
                int damage, int defence, int level) {
        super(name, health, gold, experience, power, agility, luck, damage, defence, level);
        this.kill = kill;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }
    //спосбоность



    @Override
    public int attack() {
        int chance = new Random().nextInt(10) + 1;
        damage = DAMAGE + level + 5 + power;
        if (chance + luck / 5 > 7) {
            return (int)(getTotalDamage() * 1.5);
        } else {
            return getTotalDamage();
        }
    }

    @Override
    public int defence() {
        defence = DEFENCE + level + agility / 5;
        return getTotalDefence();
    }
}
