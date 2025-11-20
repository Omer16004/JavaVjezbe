package Projekat4;
public class BossEnemy extends Enemy {
    public BossEnemy(String type, int x, int y, Collidable c, int damage, int health) {
        super(type, x, y, c, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        int d = damage * 2;
        if (d > 100) d = 100;
        return d;
    }

    @Override
    public String toString() {
        return "Boss" + super.toString();
    }
}
