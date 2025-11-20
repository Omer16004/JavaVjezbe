package Projekat4;
public class Player extends GameObject {
    private String name;
    private int health;

    public Player(String name, int x, int y, Collidable c, int health) {
        super(x, y, c);
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException();
        String[] parts = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            sb.append(Character.toUpperCase(p.charAt(0)))
              .append(p.substring(1).toLowerCase())
              .append(" ");
        }
        this.name = sb.toString().trim();
        if (health < 0 || health > 100) throw new IllegalArgumentException();
        this.health = health;
    }

    public int getHealth() { return health; }

    public void setHealth(int h) {
        if (h < 0) h = 0;
        if (h > 100) throw new IllegalArgumentException();
        this.health = h;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player[" + name + "] (" + x + "," + y + ") HP=" + health;
    }
}
