import equipments.Armour;
import units.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Merchant merch = new Merchant("Bob", 150, 2500, 0);
//        System.out.println(merch);
//        System.out.println(merch.getListOfGood());

        Hero hero = new Hero("Дзюба", 1000, 500, 0, 0, 20, 20, 20,
                20, 10, 2);

        System.out.println(hero.getInfoFull());

        Armour armour = new Armour("Buckler");
        armour.setDefence(10);
//        Weapon weapon = new Weapon("Sword");
//        weapon.setDamage(5);
//        hero.setWeapon(weapon);
        System.out.println(armour);
        hero.setArmour(armour);
        System.out.println(hero.getArmour());
        System.out.println(hero.getDefence());
        System.out.println(hero.getTotalDefence());

//        Trade trade = new Trade(hero, merch);
//        trade.getGoodType(2);
//        System.out.println(merch); // check gold for merch and hero
//        System.out.println(hero.getGold());
//        System.out.println(hero);


        GeneratorUnits generatorUnits = new GeneratorUnits(hero);
        List<CombatUnit> listMonster = generatorUnits.generateMonsters();

        listMonster.clear();
        listMonster.add(new Skeleton("Скелет1", 100, 50, 200,
                20, 0, 0, 0, 0, 1));
        listMonster.add(new Skeleton("Скелет2", 70, 50, 200,
                40, 0, 0, 0, 0, 1));

//        System.out.println(listMonster.stream().anyMatch(CombatUnit::isAlive));

//        System.out.println(listMonster.size());
//
        Battle battle = new Battle(hero, listMonster);
        battle.fight();

        System.out.println(battle.getDeathToll());
        System.out.println(hero.getInfoFull());

    }
}
