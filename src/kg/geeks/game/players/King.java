package kg.geeks.game.players;

import java.util.Random;

public class King extends Hero {
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int n = random.nextInt(10);
        if (n == 0){
            boss.setHealth(0);
            System.out.println("Saitama killed boss!");
        }

    }

    public King(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SAITAMA);

    }
}
