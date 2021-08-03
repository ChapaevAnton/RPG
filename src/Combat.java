import units.CombatUnit;

public class Combat {

    private final CombatUnit unitFirst;
    private final CombatUnit unitSecond;
    private boolean isFight = false;

    public Combat(CombatUnit unitFirst, CombatUnit unitSecond) {
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


    private boolean fight(CombatUnit attacker, CombatUnit defender) {

        if (defender.getHealth() < 0) return false;

        int damage = (attacker.attack() - defender.defence());

        if (damage <= defender.getHealth()) {
            defender.setHealth(defender.getHealth() - damage);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender);
            return true;
        } else {
            defender.setHealth(0);
            System.out.println(attacker + " ударил на " + damage + " урона " + defender + "и убил");
            System.out.println("конец боя...");
            return false;
        }

    }
}