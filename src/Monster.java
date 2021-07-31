abstract public class Monster extends Unit  implements Fighting{

    public Monster(String name, int level, int experience, int gold) {
        super(name, LEVEL_BASE, EXPERIENCE_BASE, 5, 5, 5, DAMAGE_BASE, DEFENCE_BASE, 100, GOLD_BASE);
    }
}
