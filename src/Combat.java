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

    public void combat() {
        int counter = 0;
        do {
            if(monsters.size() == 0){
                System.out.println("Победа! " + hero.getName() + " победил!");
                break;
            }
            int randomMonster = random.nextInt(monsters.size());
                if (counter % 2 == 0) {
                    isFight = fight(hero, monsters.get(randomMonster));
                } else {
                    for (Monster monster : monsters) {
                        if (hero.getHealth() <= 0) {
                            System.out.println("конец боя...");
                            break;
                        }
                        isFight = fight(monster, hero);
                    }
            }
            counter++;

        } while (isFight);
    }

    private boolean fight(CombatUnit attacker, CombatUnit defender) {
        int damage = (attacker.attack() - defender.defence());
        if(damage < 0){
            damage = 0;
        }
        if (damage <= defender.getHealth()) {
            defender.setHealth(defender.getHealth() - damage);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender);
            return true;
        } else {
            defender.setHealth(0);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender + ". " + defender + " погибает.");
            if(defender == hero){
                System.out.println("конец боя...");
                return false;
            } else {
                monsters.remove(defender);
                return true;
            }

        }

    }
}