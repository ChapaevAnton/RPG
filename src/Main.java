import units.Hero;
import units.Skeleton;

public class Main {

    public static void main(String[] args) {

        Hero hero = new Hero("Дзюба");
        Skeleton skeleton = new Skeleton("Скелет", 1, 50, 20);
        Combat combat = new Combat(hero,skeleton);
        combat.combat();

    }
}
