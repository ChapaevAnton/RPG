package units;

import java.util.Random;

public class Hero extends Unit implements Fighting {

    //количество убитых
    //спосбоность
    //снарежение

    public Hero(String name) {
        super(name, LEVEL_BASE, EXPERIENCE_BASE, 5, 5, 5, DAMAGE_BASE, DEFENCE_BASE, 100, GOLD_BASE);
    }

    // TODO: 31.07.2021 add sword attack
    @Override
    public int attack() {
        int chance = new Random().nextInt(9);
    if(chance + (int) luck/5 > 6){
            return (DAMAGE_BASE + (damage * power/3))*2;
        } else {
            return DAMAGE_BASE + (damage * power/3);
        }

    }

    // TODO: 31.07.2021 add shield defense
    @Override
    public int defence() {
        return DEFENCE_BASE + (defence * agility/5);
    }
}
