package kg.geeks.game.players;

public abstract class GameEntity {
    private String name;
    private int health;
    private int damage;

    public GameEntity(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getName()
               + " health: " + this.getHealth() + " damage: " + this.getDamage();
    }
}
