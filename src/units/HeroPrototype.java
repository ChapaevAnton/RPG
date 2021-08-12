package units;

public class HeroPrototype {
    //base stats
    public static final int BASE_POWER = 5;
    public static final int BASE_AGILITY = 5;
    public static final int BASE_LUCK = 5;

    public static final int DAMAGE = 5;
    public static final int DEFENCE = 5;

    public static final int BASE_LEVEL = 1;
    public static final int BASE_EXPERIENCE = 1;

    //current stats
    protected static int power;
    protected static int agility;
    protected static int luck;

    protected static int damage;
    protected static int defence;

    protected static int level;
    protected static int experience;

//
//    private void instantLevelUp(){
//        int lvlUpThreshold = 0;
//        lvlUpThreshold = (int)(lvlUpThreshold + 0.75 * lvlUpThreshold * HeroPrototype.level;
//        if(HeroPrototype.experience > lvlUpThreshold){
//            HeroPrototype.experience = HeroPrototype.experience - lvlUpThreshold;
//            HeroPrototype.level = HeroPrototype.level + 1;
//            System.out.println("Уровень повышен! Текущий уровень :" + HeroPrototype.level);
//            System.out.println(lvlUpThreshold);
//        }
//    }




}
