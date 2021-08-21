import units.Hero;
import units.Merchant;

public class Trade {
    private final Hero hero;
    private final Merchant merch;

    public Trade(Hero hero, Merchant merch) {
        this.hero = hero;
        this.merch = merch;
    }

    public void getGoodType(int choice){
        switch (choice) {
            case 1:
                buyGood(Merchant.Goods.POTION25);
                System.out.println(hero.getName() + " купил " + Merchant.Goods.POTION25.name());
                break;
            case 2:
                buyGood(Merchant.Goods.POTION50);
                System.out.println(hero.getName() + " купил " + Merchant.Goods.POTION50.name());
                break;
            case 3:
                buyGood(Merchant.Goods.POTION100);
                System.out.println(hero.getName() + " купил " + Merchant.Goods.POTION100.name());
                break;
        }
    }


    private boolean buyGood(Merchant.Goods good){
        if(hero.getGold() >= good.getPrice()){
            hero.setGold(hero.getGold() - good.getPrice());
            merch.setGold(merch.getGold() + good.getPrice());
            putInBackpack(good);
            return true;
        } else {
            System.out.println("Недостаточно золота.");
            return false;
        }
    }

    private void putInBackpack(Merchant.Goods good){
        //TODO make a backpack
        hero.setHealth(hero.getHealth() + good.getPoint());
    }
}
