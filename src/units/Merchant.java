package units;

import java.util.List;

public class Merchant extends Unit {
    public Merchant(String name, int health, int gold, int experience) {
        super(name, health, gold, experience);
    }

    private final List<Items> listOfItems = List.of(Items.POTION25, Items.POTION50, Items.POTION100, Items.AXE,
            Items.PLATE, Items.HELM, Items.SHIELD, Items.SWORD);

    public List<Items> getListOfItems() {
        return listOfItems;
    }

    public enum Items { //TODO make quantity for the goods
        POTION25("Малое зелье исцеления", 25, 25),
        POTION50("Среднее зелье исцеления", 50, 50),
        POTION100("Большое зелье исцеления", 100, 100),
        SWORD("Рыцарский меч", 12, 150),
        AXE("Варварский топор", 15, 200),
        SHIELD("Прочный щит", 15, 300),
        HELM("Лёгкий шлем", 5, 80),
        PLATE("Крепкий доспех", 20, 650);
        public final String name;
        private final int point;
        private final int price;

        Items(String name, int point, int price) {
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
