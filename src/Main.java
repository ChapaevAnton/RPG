import units.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Merchant merch = new Merchant("Bob", 150, 2500, 0);
        System.out.println(merch);
        Hero hero = new Hero("Дзюба", 1, 500, 50, 0, 0, 20, 20,
                20, 10, 10);
        hero.setLevel(7);
        GeneratorUnits generatorUnits = new GeneratorUnits(hero);
        List<Monster> listMonster = generatorUnits.generateMonsters();

        System.out.println(listMonster);
        System.out.println(listMonster.size());

        Combat combat = new Combat(hero,listMonster);
        combat.combat();
    }
}
