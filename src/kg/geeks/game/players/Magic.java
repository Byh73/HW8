package kg.geeks.game.players;

public class Magic extends Hero {
public Magic(String name, int health, int damage){
        super(name, health, damage,SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int increaseDamage = 5; // Использую только в этом методе, не вижу смысла делать глобальным
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && hero.getDamage() != 0) {
                int newDamage = hero.getDamage() + increaseDamage;
                hero.setDamage(newDamage);
            }
        }
        System.out.println("Magic " + this.getName() + " increased the damage of each heroes, to " + increaseDamage);
    }


}
