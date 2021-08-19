import units.CombatUnit;
import units.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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

//    public void fight() {
//
//        if (turn()) {
//            System.out.println(hero.getName() + " победил");
//
//            int totalGold = 0;
//            int totalExp = 0;
//            int totalKills = deathToll.size();
//            for (CombatUnit monster : deathToll) {
//                totalGold += monster.getGold();
//                totalExp += monster.getExperience();
//            }
//            hero.setGold(hero.getGold() + totalGold);
//            hero.setExperience(hero.getExperience() + totalExp);
//            hero.setKill(hero.getKill() + totalKills);
//
//        } else {
//            System.out.println(hero.getName() + " проиграл");
//            // TODO: 10.08.2021 game over
//        }
//
//    }

//    public boolean turn() { //TODO check if new turn method is ok, then delete this one
//        int counter = 0;
//        do {
//            int randomMonster = random.nextInt(monsters.size());
//            if (counter % 2 == 0) {
//                strike(hero, monsters.get(randomMonster));
//            } else {
//                strike(monsters, hero);
//            }
//            counter++;
//            kills();
//            if(hero.currentLevelUp()){
//                System.out.println("Уровень героя " + hero.getName() + " повышен!");
//            }
//        } while (isAliveMonsters() && hero.isAlive());
//        return hero.isAlive();
//    }

    public boolean action() {
        do {
            if (counter % 2 == 0) { //TODO make "turn()" method for unloading action()
                System.out.println("Которого монстра атаковать?");
                for(int i = 0; i < monsters.size(); i++){
                    System.out.println((i + 1) + monsters.get(i).getName());
                }
                int choice = input.nextInt() - 1;
                if(choice > monsters.size() || choice < 0){
                    System.out.println("Неверный выбор.");
                    continue;
                }
                strike(hero, monsters.get(choice));
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

//    private void turn(int chosenMonster){
//        if (counter % 2 == 0) {
//            strike(hero, monsters.get(chosenMonster));
//        } else {
//            strike(monsters, hero);
//        }
//    }

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

//    private void killCount() {
//        //добавляем убитых attackers в список убитых
//        deathToll.addAll(monsters.stream().filter(combatUnit -> !combatUnit.isAlive()).collect(Collectors.toList()));
//
//        //убираем с поля боя убитых attackers
//        monsters.removeIf(attacker -> !attacker.isAlive());
//    }

    private void strike(List<CombatUnit> attackers, CombatUnit defender) {
        //если attacker жив он атакует defender
        attackers.stream().filter(CombatUnit::isAlive).forEach(attacker -> strike(attacker, defender));
    }

    private void strike(CombatUnit attacker, CombatUnit defender) {
        int damage = (attacker.attack() - defender.defence());
        if (damage < -5) {
            System.out.println("Промах!");
        } else if(damage <= 0){
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


//    int attack = attackUnit.attack() + attackUnit.getSword();
//    int defence = defenceUnit.defence() + defenceUnit.getShield();
//    int damageHit = attack - defence;
//
//    if (damageHit < -10) {
//        attackUnit.setHealth(attackUnit.getHealth() + damageHit);
//        System.out.println("\u2694" + attackUnit + " нанеся слабый удар не пробил броню " + defenceUnit + ", при это раня себя на " + damageHit + " очков урона");
//    } else if (damageHit <= 0) {
//        defenceUnit.setHealth(defenceUnit.getHealth());
//        System.out.println("\u2699" + attackUnit + " нанося удар и промахнулся по " + defenceUnit);
//    } else {
//        defenceUnit.setHealth(defenceUnit.getHealth() - damageHit);
//        System.out.println("\u2694" + attackUnit + " нанес удар в " + damageHit + " очков урона, по " + defenceUnit);
//    }

//    private void instantGetExp(){
//        int lvlUpThreshold = 0;
//        lvlUpThreshold = (int)(lvlUpThreshold + 0.75 * lvlUpThreshold * hero.getLevel());
//        if(hero.getExperience() > lvlUpThreshold){
//            hero.setExperience(hero.getExperience() - lvlUpThreshold);
//            hero.setLevel(hero.getLevel() + 1);
//            System.out.println("Уровень повышен! Текущий уровень :" + hero.getLevel());
//            System.out.println(lvlUpThreshold);
//        }
//    }



    //Old method of leveling up hero
//    private void levelUp(){
//        int lvlUpThreshold = 0;
//            for(int i = 0; i < hero.getLevel(); i++){
//                lvlUpThreshold = (int)(Hero.BASE_EXPERIENCE + 0.75 * Hero.BASE_EXPERIENCE * hero.getLevel());
//                if(hero.getExperience() < lvlUpThreshold){                  //placed break condition here
//                    break;                                                  //cuz it prevents next action, but provides caculation of threshold
//                }
//                hero.setExperience(hero.getExperience() - lvlUpThreshold);
//                hero.setLevel(hero.getLevel() + 1);
//                setStats(hero.getLevel()); //power, agi, luck
//                System.out.println("Exp: " + hero.getExperience() + "/" + lvlUpThreshold);
//                System.out.println("Уровень повышен! Текущий уровень :" + hero.getLevel());
//            }
//    }
//
//    private void setStats(int level){
//        hero.setAgility((int)(hero.getAgility() + CombatUnit.AGILITY * 0.2 * level));
//        hero.setStrength((int)(hero.getStrength() + CombatUnit.STRENGTH * 0.2 * level));
//        hero.setLuck((int)(hero.getLuck() + CombatUnit.LUCK * 0.2 * level));
//        hero.setHealth((hero.getHealth() + 5 * level * hero.getStrength()));
//    }

//    while (attackUnit.getExperience() >= Hero.LEVEL_UP) {
//        attackUnit.setLevel(attackUnit.getLevel() + 1);
//
//        //рандомно увеличиваем характеристики
//        if (Math.random() > .5) attackUnit.setForce(attackUnit.getForce() + 1);
//        else attackUnit.setAgility(attackUnit.getAgility() + 1);
//
//        attackUnit.setExperience(attackUnit.getExperience() - Hero.LEVEL_UP);
//        System.out.println("\u23EB Ваш уровень повышен!");
//    }

}