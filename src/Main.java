import units.GeneratorUnits;
import units.Hero;
import units.Monster;
import units.Skeleton;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Hero hero = new Hero("Дзюба");
        hero.setLevel(5);

        GeneratorUnits generatorUnits = new GeneratorUnits(hero);

        List<Monster> listMonster = generatorUnits.generateMonsters();
        System.out.println(listMonster);

//        Combat combat = new Combat(hero,skeleton);
//        combat.combat();



    }
}
