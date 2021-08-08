import equipments.Armour;
import equipments.Equipment;
import equipments.Weapon;
import units.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Merchant merch = new Merchant("Bob", 150, 2500, 0);
//        System.out.println(merch);
//        System.out.println(merch.getListOfGood());

        Hero hero = new Hero("Дзюба", 1, 500, 500, 0, 0, 20, 20,
                20, 10, 10);

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

        hero.setLevel(7);
        GeneratorUnits generatorUnits = new GeneratorUnits(hero);
        List<Monster> listMonster = generatorUnits.generateMonsters();

        System.out.println(listMonster);
//        System.out.println(listMonster.size());
//
//        Combat combat = new Combat(hero, listMonster);
//        combat.combat();



    }
}
