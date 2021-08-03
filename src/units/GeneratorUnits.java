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
        List<Integer> levelsList = getMonsterLevel();
        for (int i = 0; i < levelsList.size(); i++) {
            int count = random.nextInt(3);
            switch (count) {
                case 0 -> {
                    Skeleton skeleton = new Skeleton("Скелет", 0, 50, 50,
                            0, 0, 0, 0, 0, levelsList.get(i));
                    setMonsterStats(skeleton);
                    poll.add(skeleton);
                }
                case 1 -> {
                    Zombie zombie = new Zombie("Зомби", 0, 50, 50,
                            0, 0, 0, 0, 0, levelsList.get(i));
                    setMonsterStats(zombie);
                    poll.add(zombie);
                }
                case 2 -> {
                    Ogre ogre = new Ogre("Огр", 0, 50, 50,
                            0, 0, 0, 0, 0, levelsList.get(i));
                    setMonsterStats(ogre);
                    poll.add(ogre);
                }
            }
        }
        return poll;
    }

    public List<Integer> getMonsterLevel(){
        int enemyNum = hero.level;
        List<Integer> enemiesLvl = new ArrayList<>();
        while(enemyNum != 0){
            int enemyLvl = random.nextInt(enemyNum) + 1;
            enemyNum -= enemyLvl;
            enemiesLvl.add(enemyLvl);
        } return enemiesLvl;
    }

    private void setMonsterStats(Monster monster) {
        if(monster instanceof Skeleton){
            monster.agility = CombatUnit.AGILITY + monster.level + 2;
            monster.power = CombatUnit.POWER + monster.level;
        } else {
            monster.agility = CombatUnit.AGILITY + monster.level;
            monster.power = CombatUnit.POWER + monster.level + 2;
        }
        monster.luck = CombatUnit.LUCK + monster.level;
        monster.health = CombatUnit.HEALTH + monster.level*10;
        monster.damage = CombatUnit.DAMAGE + monster.level;
        monster.defence = CombatUnit.DEFENCE + monster.level;
    }


}
