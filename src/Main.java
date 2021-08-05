import units.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Merchant merch = new Merchant("Bob", 150, 2500, 0);
        System.out.println(merch);
        Hero hero = new Hero("Дзюба", 1, 1, 50, 0, 0, 0, 0,
                0, 0, 0);
        hero.setLevel(7);
        GeneratorUnits generatorUnits = new GeneratorUnits(hero);
        List<Monster> listMonster = generatorUnits.generateMonsters();
        generatorUnits.generateHero();

        System.out.println(listMonster);
        System.out.println(listMonster.size());

        Combat combat = new Combat(hero,listMonster);
        combat.combat();
    }
}
