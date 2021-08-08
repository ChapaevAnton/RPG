import units.CombatUnit;
import units.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Combat {

    private final Hero hero;
    private final List<CombatUnit> monsters;
    private final List<CombatUnit> deathToll;
    private final Random random = new Random();

    public Combat(Hero hero, List<CombatUnit> monsters) {
        this.hero = hero;
        this.monsters = monsters;
        this.deathToll = new ArrayList<>();
    }

    public List<CombatUnit> getDeathToll() {
        return deathToll;
    }

    public void turn() {
        int counter = 0;

        do {
            int randomMonster = random.nextInt(monsters.size());
            if (counter % 2 == 0) {
                strike(hero, monsters.get(randomMonster));
            } else {
                strike(monsters, hero);
            }
            counter++;
        } while (isAliveMonsters() && hero.isAlive());
    }


    private boolean isAliveMonsters() {
        return monsters.stream().anyMatch(CombatUnit::isAlive);
    }

    private void strike(List<CombatUnit> attackers, CombatUnit defender) {
        //добавляем убитых attackers в список убитых
        deathToll.addAll(attackers.stream().filter(combatUnit -> !combatUnit.isAlive()).collect(Collectors.toList()));
        //убираем с поля боя убитых attackers
        attackers.removeIf(attacker -> !attacker.isAlive());
        //если attacker жив он атакует defender
        attackers.stream().filter(CombatUnit::isAlive).forEach(attacker -> strike(attacker, defender));

    }

    private void strike(CombatUnit attacker, CombatUnit defender) {
        int damage = (attacker.attack() - defender.defence());
        if (damage < 0) {
            damage = 0;
        }
        if (damage <= defender.getHealth()) {
            defender.setHealth(defender.getHealth() - damage);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender);
        } else {
            defender.setHealth(0);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender + ". " + defender + " погибает.");
        }
    }

}