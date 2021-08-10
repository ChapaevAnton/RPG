import units.CombatUnit;
import units.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Battle {

    private final Hero hero;
    private final List<CombatUnit> monsters;
    private final List<CombatUnit> deathToll;
    private final Random random = new Random(47);

    public Battle(Hero hero, List<CombatUnit> monsters) {
        this.hero = hero;
        this.monsters = monsters;
        this.deathToll = new ArrayList<>();
    }

    public List<CombatUnit> getDeathToll() {
        return deathToll;
    }

    public void fight() {

        if (turn()) {
            System.out.println("Герой победил");
            // TODO: 10.08.2021 начисляем эксприенс золото килы
            int totalGold = 0;
            int totalExp = 0;
            int totalKills = deathToll.size();
            for (CombatUnit monster : deathToll) {
                totalGold += monster.getGold();
                totalExp += monster.getExperience();
            }
            hero.setGold(hero.getGold() + totalGold);
            hero.setExperience(hero.getExperience() + totalExp);
            hero.setKill(hero.getKill() + totalKills);

        } else {
            System.out.println("Герой проиграл");
            // TODO: 10.08.2021 game over
        }

    }

    private boolean turn() {
        int counter = 0;

        do {

            int randomMonster = random.nextInt(monsters.size());

            if (counter % 2 == 0) {
                strike(hero, monsters.get(randomMonster));
            } else {
                strike(monsters, hero);
            }
            counter++;

            killCount();
        } while (isAliveMonsters() && hero.isAlive());

        return hero.isAlive();
    }

    private boolean isAliveMonsters() {
        return monsters.stream().anyMatch(CombatUnit::isAlive);
    }

    private void killCount() {
        //добавляем убитых attackers в список убитых
        deathToll.addAll(monsters.stream().filter(combatUnit -> !combatUnit.isAlive()).collect(Collectors.toList()));
        //убираем с поля боя убитых attackers
        monsters.removeIf(attacker -> !attacker.isAlive());
    }

    private void strike(List<CombatUnit> attackers, CombatUnit defender) {
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