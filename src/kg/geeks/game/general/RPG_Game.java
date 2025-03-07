package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Aleksey", 1600, 70);

        Warrior warrior1 = new Warrior("Beka", 280, 10);
        Warrior warrior2 = new Warrior("Aman", 290, 15);
        Magic magic = new Magic("Ayana", 270, 10);
        Berserk berserk = new Berserk("Nurbolot", 260, 10);
        Medic assistant = new Medic("Azat", 300, 5, 5);
        Medic doc = new Medic("Cholponai", 250, 5, 15);
        TrickyBastard trickyBastard = new TrickyBastard("Saule", 260, 7);
        Hacker hacker = new Hacker("Dolot", 267, 3);
        King king = new King("Mirhat", 250, 0);
        // Да нет вот вроде есть

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, trickyBastard, hacker, king};


        printStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -------------- ");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0 &&
                    hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }
}
