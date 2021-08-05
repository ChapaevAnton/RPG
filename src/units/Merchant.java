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

    public enum Goods {

        POTION25(25, 25),
        POTION50(50, 50),
        POTION100(100, 100);
        private final int point;
        private final int price;

        Goods(int point, int price) {
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
