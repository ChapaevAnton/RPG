package equipments;

import units.Merchant;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    protected static List<Merchant.Items> backpack = new ArrayList<>();

    public static void putInBackPack(Merchant.Items item){
        backpack.add(item);
    }

    public void backpackContent(){
        for (Merchant.Items item : backpack) {
            System.out.println(item);
        }
    }

    public void deleteFromBackpack(){
        for(int i = 0; i < backpack.size(); i++){
            if(backpack.get(i).getQuantity() == 0){
                backpack.remove(i);
            }
        }
    }

    public Equipment kostyl(Merchant.Items item){
        return switch (item) {
            case SWORD -> new Equipment(Merchant.Items.SWORD.name, Merchant.Items.SWORD.getPoint(),
                    Merchant.Items.SWORD.getPrice(), Merchant.Items.SWORD.getQuantity());
            case SHIELD -> new Equipment(Merchant.Items.SHIELD.name, Merchant.Items.SHIELD.getPoint(),
                    Merchant.Items.SHIELD.getPrice(), Merchant.Items.SHIELD.getQuantity());
            case AXE -> new Equipment(Merchant.Items.AXE.name, Merchant.Items.AXE.getPoint(),
                    Merchant.Items.AXE.getPrice(), Merchant.Items.AXE.getQuantity());
            case PLATE -> new Equipment(Merchant.Items.PLATE.name, Merchant.Items.PLATE.getPoint(),
                    Merchant.Items.PLATE.getPrice(), Merchant.Items.PLATE.getQuantity());
            case HELM -> new Equipment(Merchant.Items.HELM.name, Merchant.Items.HELM.getPoint(),
                    Merchant.Items.HELM.getPrice(), Merchant.Items.HELM.getQuantity());
            default -> null;
        };
    }
}
