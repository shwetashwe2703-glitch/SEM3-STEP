public class Character {

    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health -= amount;

            if (health < 0) {
                health = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health += amount;

            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public int getHealth() {
        return health;
    }
}