package units;

public class Merchant extends Unit{
    public Merchant(String name, int health, int gold, int experience) {
        super(name, health, gold, experience);
    }


    @Override
    public String toString(){
        return name + ", HP = " + health + ", gold = " + gold;
    }
}
