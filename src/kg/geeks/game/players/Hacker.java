package kg.geeks.game.players;

import java.util.Random;

public class Hacker extends Hero {
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int n = 50;
        boss.setHealth(boss.getHealth() - n);
        for (Hero hero: heroes){
            if (hero.getHealth() > 0){
                hero.setHealth(hero.getHealth() + n);
                System.out.println("Hacker rob hp from boss and give to " + hero.getName());
                break;
            }
        }
    }

    public Hacker(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HACKER);

    }
}
