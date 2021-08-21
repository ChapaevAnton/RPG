import units.CombatUnit;
import units.Hero;
import units.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Battle {

    private final Hero hero;
    private final List<CombatUnit> monsters;
    private final List<CombatUnit> deathToll;
    private final Random random = new Random(47);

    private int counter = 0;
    Scanner input = new Scanner(System.in);

    public Battle(Hero hero, List<CombatUnit> monsters) {
        this.hero = hero;
        this.monsters = monsters;
        this.deathToll = new ArrayList<>();
    }

    public List<CombatUnit> getDeathToll() {
        return deathToll;
    }

    public boolean action() {
        do {
            if (counter % 2 == 0) { //TODO make "turn()" method for unloading action()
                System.out.println("Которого монстра атаковать?");
                for(int i = 0; i < monsters.size(); i++){
                    System.out.println((i + 1) + " " + monsters.get(i).getName());
                }
                System.out.println((monsters.size() + 1) + " " + "Сплэш-атака!");
                int choice = input.nextInt();
                if(choice > monsters.size() + 1 || choice < 1){
                    System.out.println("Неверный выбор.");
                    continue;
                }
                if(choice == monsters.size() + 1){
                    System.out.println(hero.getName() + " наносит массивынй удар!");
                    splash(hero, monsters);
                } else {
                    strike(hero, monsters.get(choice - 1));
                }

            } else {
                strike(monsters, hero);
            }
//            turn(choice);
            counter++;
            kills();
            if(hero.currentLevelUp()){
                System.out.println("Уровень героя " + hero.getName() + " повышен!");
            }
        } while (isAliveMonsters() && hero.isAlive());
        return hero.isAlive();
    }


    private void kills(){
        for(int i = 0; i < monsters.size(); i++){
            if(monsters.get(i).getHealth() <= 0){
                hero.setExperience(hero.getExperience() + monsters.get(i).getExperience());
                hero.setGold(hero.getGold() + monsters.get(i).getGold());
                monsters.remove(i);
                hero.setKill(hero.getKill() + 1);
            }
        }
    }

    private boolean isAliveMonsters() {
        return monsters.stream().anyMatch(CombatUnit::isAlive);
    }

    private void strike(List<CombatUnit> attackers, CombatUnit defender) {
        //если attacker жив он атакует defender
        attackers.stream().filter(CombatUnit::isAlive).forEach(attacker -> strike(attacker, defender));
    }

    private void strike(CombatUnit attacker, CombatUnit defender) {
        int damage = (attacker.attack() - defender.defence());
        if(damage <= 0){
            damage = 0;
            System.out.println("Не пробил");
        } else if (damage <= defender.getHealth()) { //changed if to else if
            defender.setHealth(defender.getHealth() - damage);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender);
        } else {
            defender.setHealth(0);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender + ". " + defender + " погибает.");
        }
    }

    public void splash(Hero hero, List<CombatUnit> combatUnits) {
        for(int i = 0; i < combatUnits.size(); i++){
            strike(hero, combatUnits.get(i));
        }
    }
}