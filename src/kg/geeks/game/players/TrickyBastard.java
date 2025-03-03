package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

import java.util.Random;

public class TrickyBastard extends Hero {
    public TrickyBastard(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.Play_Dead);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        boolean abillity = random.nextBoolean();
        if (abillity){
            setHealth(getHealth() + boss.getDamage());
            boss.setHealth(boss.getHealth() + getDamage());
            System.out.println("Saule play dead");
        }
    }


}
