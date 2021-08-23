package units;

import java.util.List;

public class Merchant extends Unit {
    public Merchant(String name, int health, int gold) {
        super(name, health, gold);
    }

    private final List<Items> listOfItems = List.of(Items.POTION25, Items.POTION50, Items.POTION100);

    public enum Items { //TODO make quantity for the goods
        POTION25("Малое зелье исцеления", 25, 25, 1),
        POTION50("Среднее зелье исцеления", 50, 50, 1),
        POTION100("Большое зелье исцеления", 100, 100,1 ),
        SWORD("Рыцарский меч", 12, 150, 1),
        AXE("Варварский топор", 15, 200, 1),
        SHIELD("Прочный щит", 15, 300, 1),
        HELM("Лёгкий шлем", 5, 80, 1),
        PLATE("Крепкий доспех", 20, 650, 1);
        public final String name;
        private final int point;
        private final int price;
        private int quantity;


        Items(String name, int point, int price, int quantity) {
            this.name = name;
            this.point = point;
            this.price = price;
            this.quantity = quantity;
        }
        public int getPoint() {
            return point;
        }
        public int getPrice() {
            return price;
        }
        public  int getQuantity(){
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    @Override
    public String toString() {
        return name + ", HP = " + health + ", gold = " + gold;
    }
}
