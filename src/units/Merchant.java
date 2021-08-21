package units;

import java.util.List;

public class Merchant extends Unit {
    public Merchant(String name, int health, int gold, int experience) {
        super(name, health, gold, experience);
    }

    private final List<Goods> listOfGood = List.of(Goods.POTION25, Goods.POTION50, Goods.POTION100);

    public List<Goods> getListOfGood() {
        return listOfGood;
    }

    public enum Goods { //TODO make quantity for the goods
        POTION25("Малое зелье исцеления", 25, 25),
        POTION50("Среднее зелье исцеления", 50, 50),
        POTION100("Большое зелье исцеления", 100, 100);
        public final String name;
        private final int point;
        private final int price;

        Goods(String name, int point, int price) {
            this.name = name;
            this.point = point;
            this.price = price;
        }
        public int getPoint() {
            return point;
        }
        public int getPrice() {
            return price;
        }
    }

    @Override
    public String toString() {
        return name + ", HP = " + health + ", gold = " + gold;
    }
}
