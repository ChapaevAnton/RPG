import units.Unit;

public class Combat {

    private Unit unitFirst;
    private Unit unitSecond;
    private boolean isFight = false;

    public Combat(Unit unitFirst, Unit unitSecond) {
        this.unitFirst = unitFirst;
        this.unitSecond = unitSecond;
    }


    public void combat() {
        int counter = 0;

        do {

            if (counter % 2 == 0) {
                isFight = fight(unitFirst, unitSecond);
            } else {
                isFight = fight(unitSecond, unitFirst);
            }
            counter++;

        } while (isFight);
    }


    private boolean fight(Unit attacker, Unit defender) {

        if (defender.getHealth() > 0) {
            int damage = (attacker.attack() - defender.defence());

            if (damage <= defender.getHealth()) {
                defender.setHealth(defender.getHealth() - damage);
                System.out.println(attacker + " ударил на " + damage + " урона " + defender);
                return true;
            } else {
                defender.setHealth(0);
                System.out.println(attacker + " ударил на " + damage + " урона " + defender);
                System.out.println("конец боя...");
                return false;
            }
        }
        return true;
    }
}