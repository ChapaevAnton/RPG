package equipments;

public class Weapon extends Equipment {

    private final static int DEFAULT_DAMAGE = 1;

    private int damage = DEFAULT_DAMAGE;

    public Weapon(String name) {
        super(name);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' + "; " +
                "damage='" + damage + '\'' +
                '}';
    }
}
