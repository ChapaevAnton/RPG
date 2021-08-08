import units.CombatUnit;
import units.Hero;
import units.Monster;

import java.util.List;
import java.util.Random;

public class Combat {

    private final Hero hero;
    private final List<Monster> monsters;
    private boolean isFight = false;

    public Combat(Hero hero, List<Monster> monsters) {
        this.hero = hero;
        this.monsters = monsters;
    }

    Random random = new Random();

    public void turn() {
        int counter = 0;
        do {
            int randomMonster = random.nextInt(monsters.size());
            if (counter % 2 == 0) {
                isFight = strike(hero, monsters.get(randomMonster));
            } else {
                isFight = strike(hero, monsters);
            }
            counter++;
        } while (isFight);
    }


    private boolean isAliveMonsters() {
        return monsters.stream().anyMatch(CombatUnit::isAlive);
    }


    public boolean strike(CombatUnit defender, List<Monster> attacker) {

        boolean isCombat = false;
        do {

            for (CombatUnit monster : monsters) {
                if (monster.isAlive()) isCombat = strike(monster, hero) && isAliveMonsters();
            }

        } while (isCombat);

        return isCombat;
    }

    private boolean strike(CombatUnit attacker, CombatUnit defender) {
        int damage = (attacker.attack() - defender.defence());
        if (damage < 0) {
            damage = 0;
        }
        if (damage <= defender.getHealth()) {
            defender.setHealth(defender.getHealth() - damage);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender);
            return true;
        } else {
            defender.setHealth(0);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender + ". " + defender + " погибает.");
            return false;
        }

    }
}