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
    public Hero generateHero(){
        setHeroStats(hero);
        return hero;
    }
    public List<Monster> generateMonsters() {

        List<Monster> poll = new ArrayList();
        List<Integer> levelsList = getMonsterLevel();
        for (int i = 0; i < levelsList.size(); i++) {
            int count = random.nextInt(3);
            switch (count) {
                case 0 -> {
                    Skeleton skeleton = new Skeleton("Скелет" + (i + 1), 0, 50, 50,
                            0, 0, 0, 0, 0, levelsList.get(i));
                    setMonsterStats(skeleton);
                    poll.add(skeleton);
                }
                case 1 -> {
                    Zombie zombie = new Zombie("Зомби" + (i + 1), 0, 50, 50,
                            0, 0, 0, 0, 0, levelsList.get(i));
                    setMonsterStats(zombie);
                    poll.add(zombie);
                }
                case 2 -> {
                    Ogre ogre = new Ogre("Огр" + (i + 1), 0, 50, 50,
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
        monster.health = CombatUnit.HEALTH + monster.level*25;
        monster.damage = CombatUnit.DAMAGE + monster.level + 5 + monster.power;
        monster.defence = CombatUnit.DEFENCE + monster.level + monster.agility/5;
    }

    private void setHeroStats(Hero hero) {
        hero.agility = CombatUnit.AGILITY + hero.level + 3;
        hero.power = CombatUnit.POWER + hero.level + 3;
        hero.luck = CombatUnit.LUCK + hero.level + 3;
        hero.health = CombatUnit.HEALTH + hero.level*50;
        hero.damage = CombatUnit.DAMAGE + hero.level + hero.power + 8;
        hero.defence = CombatUnit.DEFENCE + hero.level + hero.agility/5;
    }


}
