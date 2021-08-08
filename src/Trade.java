import units.Hero;
import units.Merchant;

public class Trade {
    private Hero hero;
    private Merchant merch;

    public Trade(Hero hero, Merchant merch) {
        this.hero = hero;
        this.merch = merch;
    }

    public void getGoodType(int choice){
        switch(choice) {
            case 1:
                buyGood(Merchant.Goods.POTION25);
                break;
            case 2:
                buyGood(Merchant.Goods.POTION50);
                break;
            case 3:
                buyGood(Merchant.Goods.POTION100);
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
            return false;
        }
    }

    private void putInBackpack(Merchant.Goods good){
        //TODO make a backpack
        hero.setHealth(hero.getHealth() + good.getPoint());
    }
}
