package equipments;

import units.Merchant;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    protected static List<Merchant.Items> backpack = new ArrayList<>();

    public static void putInBackPack(Merchant.Items item){
        backpack.add(item);
    }

    public static void setBackpack(List<Merchant.Items> backpack) {
        Backpack.backpack = backpack;
    }
}
