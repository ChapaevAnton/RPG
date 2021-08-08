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
            int randomMonster = random.nextInt(monsters.size());
                if (counter % 2 == 0) {
                    isFight = strike(hero, monsters.get(randomMonster));
                } else {
                    for (Monster monster : monsters) {
                        if(!monsters.get(randomMonster).isAlive()) continue;
                        isFight = strike(monster, hero);
                    }
            }
            counter++;
        } while (isFight);
    }

    public boolean victory(){
        int count = 0;
        if (!hero.isAlive()) {
            System.out.println("конец боя...");
            return false;
        }
        for(int i = 0; i < monsters.size(); i++){
            if(!monsters.get(i).isAlive()){
                count++;
            }
        }
        if(count != monsters.size()) return true;
    }

    private boolean strike(CombatUnit attacker, CombatUnit defender) {
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
            return false;
        }

    }
}