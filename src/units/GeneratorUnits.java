package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorUnits {
    private Hero hero;

    public GeneratorUnits(Hero hero) {
        this.hero = hero;
    }
    private Random random = new Random();
    public List<Monster> generateMonsters() {





        Skeleton skeleton = new Skeleton("скелет",1,50,getStat(),getStat(),getStat(),5,5,100,50);
        Zombie zombie = new Zombie("Зомби", 1,50,getStat(),getStat(),getStat(),5,5,100,50);
        Ogre ogre = new Ogre("Огр", 1,50,getStat(),getStat(),getStat(),5,5,100,50);
        List<Monster> poll = new ArrayList();
        for (int i = 0; i < hero.level; i++) {
            int count = random.nextInt(2);
            switch (count) {
                case 0 -> {
                    poll.add(skeleton);
                }
                case 1 -> {
                    poll.add(ogre);
                }
                case 2 -> {
                    poll.add(zombie);
                }
            }
        }
        return poll;
    }
    private int getStat(){
        int sumStats = (hero.agility + hero.luck + hero.power) / 3;
        int stat = random.nextInt(sumStats);
        if(stat == 0)
            stat = 1;
        return stat;
    }






}
