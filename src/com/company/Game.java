package com.company;

public class Game {


    public static void startGame() {
        Boss boss = new Boss(3000,
                50, "Thanos");

        Warrior warrior = new Warrior(270,
                20, "Warrior",
                EnumSuperAbility.CRITICAL_DAMAGE);

        Berserk berserk = new Berserk(240,
                10, "Berserk",
                EnumSuperAbility.REVERT_DAMAGE);

        Magic magic = new Magic(250,
                25, "Magic",
                EnumSuperAbility.BOOST);

        Medic doc = new Medic(220,
                5, "Doc", 10,
                EnumSuperAbility.HEAL);

        Medic assistant = new Medic(260,
                10, "Assistant", 5,
                EnumSuperAbility.HEAL);

        Hero[] heroes = {warrior, berserk, magic, doc, assistant};

        System.out.println("____THE GAME____");
        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)){
            round(boss, heroes);
        }

    }

    private static void round(Boss boss, Hero[] heroes){
        bossHit(boss, heroes);
        heroesHit(boss, heroes);
        applySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes WON!!!");
            return true;
        }

        boolean allHeroesDead = true;

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.println("Boss WON!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println(boss.getName() + " health:" +
                boss.getHealth() + " damage: " +
                boss.getDamage());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() + " health:" +
                    heroes[i].getHealth() + " damage:" +
                    heroes[i].getDamage());
        }
        System.out.println("_____________");
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - hero.getDamage());
            }
        }
    }

    private static void applySuperAbilities(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                hero.applySuperAbility(boss, heroes);
            }
        }
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - boss.getDamage());
            }
        }
    }
}
