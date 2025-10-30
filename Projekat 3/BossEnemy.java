public class BossEnemy extends Enemy {

    public BossEnemy(String tip, int x, int y, int sirina, int visina, int steta, int zdravlje) {
        super(tip, x, y, sirina, visina, steta, zdravlje);
    }

    public int getUkupnaSteta() {
        return getSteta() * 2;
    }

    public String toString() {
        return "BossEnemy[" + getTip() + "] @ (" + getX() + "," + getY() + ") " +
                getSirina() + "x" + getVisina() + " DMG=" + getSteta() + "x2 HP=" + getZdravlje();
    }
}
