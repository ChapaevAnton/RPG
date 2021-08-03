import units.GeneratorUnits;
import units.Hero;
import units.Monster;
import units.Skeleton;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Hero hero = new Hero("Дзюба", 1, 100, 50, 0, 0, 5, 5, 5, 10, 10);
        hero.setLevel(5);

        GeneratorUnits generatorUnits = new GeneratorUnits(hero);
        List<Monster> listMonster = generatorUnits.generateMonsters();
        System.out.println(listMonster);
        System.out.println(listMonster.size());


//        Combat combat = new Combat(hero,skeleton);
//        combat.combat();



    }
}
