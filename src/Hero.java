public class Hero extends Unit implements Fighting {

    //количество убитых
    //спосбоность
    //снарежение

    public Hero(String name) {
        super(name, LEVEL_BASE, EXPERIENCE_BASE, 5, 5, 5, DAMAGE_BASE, DEFENCE_BASE, 100, GOLD_BASE);
    }


    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defence() {
        return 0;
    }
}
