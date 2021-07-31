package units;

public class Ogre extends Monster{
    public Ogre(String name, int level, int experience, int gold) {
        super(name, level, experience, gold);
    }

    public Ogre(String name, int level, int experience, int power, int agility, int luck, int damage, int defence, int health, int gold) {
        super(name, level, experience, power, agility, luck, damage, defence, health, gold);
    }
}
