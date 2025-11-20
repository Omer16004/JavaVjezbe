package Projekat4;
import java.util.*;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> log = new ArrayList<>();

    public Game(Player player) {
        if (player == null) throw new IllegalArgumentException();
        this.player = player;
    }

    public void addEnemy(Enemy e) {
        if (e == null) throw new IllegalArgumentException();
        enemies.add(e);
        log.add("Added " + e.getDisplayName());
    }

    public ArrayList<Enemy> search(String text) {
        ArrayList<Enemy> r = new ArrayList<>();
        String t = text.toLowerCase();
        for (Enemy e : enemies) {
            if (e.getDisplayName().toLowerCase().contains(t)) r.add(e);
        }
        return r;
    }

    public void decreaseHealth(Player p, Enemy e) {
        int nh = p.getHealth() - e.getEffectiveDamage();
        if (nh < 0) nh = 0;
        log.add("Hit " + p.getDisplayName() + " by " + e.getDisplayName());
        p.setHealth(nh);
    }

    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (player.intersects(e)) decreaseHealth(player, e);
        }
    }

    public static Enemy parseEnemy(String line) {
        String[] parts = line.split(";");
        if (parts.length != 5) throw new IllegalArgumentException();
        String name = parts[0];
        String[] pos = parts[1].split(",");
        int x = Integer.parseInt(pos[0]);
        int y = Integer.parseInt(pos[1]);
        String[] size = parts[2].split("x");
        int w = Integer.parseInt(size[0]);
        int h = Integer.parseInt(size[1]);
        int dmg = Integer.parseInt(parts[3]);
        String type = parts[4].toLowerCase();

        Collidable c = new RectangleCollider(x, y, w, h);

        if (type.contains("boss")) {
            return new BossEnemy(name, x, y, c, dmg, 100);
        }
        return new MeleeEnemy(name, x, y, c, dmg, 100);
    }

    public ArrayList<String> getLog() {
        return log;
    }
}
