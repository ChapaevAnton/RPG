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

        List<Monster> poll = new ArrayList();

        for (int i = 0; i < hero.level; i++) {

            Skeleton skeleton = new Skeleton("Скелет", 100, 50, 5, 5, 5, 5, 10, 10);
            Zombie zombie = new Zombie("Зомби", 100, 50, 5, 5, 5, 5, 10, 10);
            Ogre ogre = new Ogre("Огр", 100, 50, 5, 5, 5, 5, 10, 10);

            int count = random.nextInt(3);
            switch (count) {
                case 0 -> {
                    poll.add(skeleton);
                }
                case 1 -> {
                    poll.add(zombie);
                }
                case 2 -> {
                    poll.add(ogre);
                }
            }
        }
        return poll;
    }

    private int getStat() {
        int sumStats = (hero.agility + hero.luck + hero.power) / 3;
        int stat = random.nextInt(sumStats);
        if (stat == 0)
            stat = 1;
        return stat;
    }

}