import units.*;
import equipments.Armour;
import equipments.Weapon;
import units.CombatUnit;
import units.GeneratorUnits;

import java.util.List;
import java.util.Scanner;

public class Example {
    private static boolean gameOn = true;
    private static boolean tradeOn = false;
    private static int menuLvl = 0;
    private static int tradeMenuLvl = 0;
    private static final Hero hero = new Hero();
    private static final Merchant merch = new Merchant("Боб", 50, 500, 0);

    public static void main(String[] args) {
        System.out.println("Привет-привет! Это пробный вариант текстовой RPG." +
                "Если всё же решишься поиграть - помотри что у нас та по пунктам меню.");
        while(gameOn){
            Scanner input = new Scanner(System.in);
            if(menuLvl == 0){
                System.out.println("Главно меню:");
                System.out.println("1. Создать героя \n2. Играть \n3. К торговцу \n4. Выход");
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        if(hero.getName() == null){
                            menuLvl = 1;
                        } else {
                            System.out.println("Герой уже в наличии, рекомендуем" +
                                    " его использовать по прямому назначению.");
                            continue;
                        }
                    case 2:
                        if(hero.getName() == null){
                            System.out.println("Сражаться-то пока некому. Может сначала создадим героя?");
                        } else {
                            battle();
                        }
                        continue;
                    case 3:
                        menuLvl = 2;
                        tradeOn = true;
                        continue;
                    case 4:
                        System.out.println("Удачи!");
                        gameOn = false;
                        break;
                    default:
                        System.out.println("Некорректный ввод.");
                }
            } else if(menuLvl == 1){
                System.out.println("Для начала можем выбрать ему имя.");
                String name = input.nextLine();
                hero.setName(name);
                System.out.println("Значит " + hero.getName() + "? Хорошо, а теперь подберём соответствующий тип");
                System.out.println("1. Проворный \n2. Мощный \n3. Везучий");
                int choice = input.nextInt();
                heroType(choice);
                hero.getInfoFull();
                System.out.println("Ну что ж, с гером определились, теперь к игре?");
                menuLvl = 0;
            } else if (menuLvl == 2){
                if(hero.getName() == null){
                    System.out.println("Героя бы для начала создать...");
                    menuLvl = 0;
                } else {
                    System.out.println("Торговец приветствует вас в своей лавке и предлагает на выбор несколько товаров");
                    Trade trade = new Trade(hero, merch);
                    while (tradeOn){
                        if(tradeMenuLvl == 0){
                            System.out.println("Выберите, что вас интересует: \n1. Зелья \n2. Экиперовка \n3. Покинуть торговца");
                            int tradeChoice = input.nextInt();
                            switch (tradeChoice) {
                                case 1 -> {
                                    tradeMenuLvl = 1;
                                }
                                case 2 -> {
                                    tradeMenuLvl = 2;
                                }
                                case 3 -> {
                                    menuLvl = 0;
                                    tradeOn = false;
                                }
                                default -> System.out.println("Некорректный ввод");
                            }
                        } else if (tradeMenuLvl == 1){
                            System.out.println("1. Малое зелье \n2. Среднее зелье \n3. Большое зелье \n4. Вернуться");
                            int choice = input.nextInt();
                            switch (choice) {
                                case 1 -> {
                                    trade.getPot(1);
                                }
                                case 2 -> {
                                    trade.getPot(2);
                                }
                                case 3 -> {
                                    trade.getPot(3);
                                }
                                case 4 -> {
                                    tradeMenuLvl = 0;
                                }
                                default -> System.out.println("Некорректный ввод");
                            }
                        } else if (tradeMenuLvl == 2){
                            System.out.println("1. Меч \n2. Щит \n3. Топор \n4. Шлем \n5. Доспехи \n6. Вернуться");
                            int choice = input.nextInt();
                            switch (choice) {
                                case 1 -> {
                                    trade.getEquip(1);
                                }
                                case 2 -> {
                                    trade.getEquip(2);
                                }
                                case 3 -> {
                                    trade.getEquip(3);
                                }
                                case 4 -> {
                                    trade.getEquip(4);
                                }
                                case 5 -> {
                                    trade.getEquip(6);
                                }
                                case 6 -> {
                                    tradeMenuLvl = 0;
                                }
                                default -> System.out.println("Некорректный ввод");
                            }
                        }
                    }
                }
            }
        }
    }

    private static void heroType(int choice){
        switch (choice){
            case 1:
                hero.setAgility(hero.getAgility() + 5);
            case 2:
                hero.setStrength(hero.getStrength() + 5);
            case 3:
                hero.setLuck(hero.getLevel() + 10);
        }
    }

    private static void battle(){
        GeneratorUnits generatorUnits = new GeneratorUnits(hero);
        List<CombatUnit> listMonster = generatorUnits.generateMonsters();

        listMonster.clear();
        listMonster.add(new Skeleton("Скелет1", 100, 50, 200,
                20, 0, 0, 0, 0, 1));
        listMonster.add(new Skeleton("Скелет2", 70, 50, 200,
                40, 0, 0, 0, 0, 1));
        listMonster.add(new Skeleton("Скелет3", 110, 50, 200,
                40, 0, 0, 0, 0, 1));

        Armour armour = new Armour("Панцирь бедной черепахи");
        armour.setDefence(25);
        Weapon weapon = new Weapon("Ржавый меч");                                  //test for weapon & armor
        weapon.setDamage(30);
        hero.setWeapon(weapon);
        System.out.println(armour);
        hero.setArmour(armour);

        Battle battle = new Battle(hero, listMonster);
        battle.action();
    }
}
