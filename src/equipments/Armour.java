package equipments;

public class Armour extends Equipment{

    private final static int DEFAULT_DEFENCE = 1;

    private int defence = DEFAULT_DEFENCE;

    public Armour(String name) {
        super(name);
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    @Override
    public String toString() {
        return "Armour{" +
                "defence=" + defence +
                ", name='" + name + '\'' +
                '}';
    }
}
