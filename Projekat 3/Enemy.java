public class Enemy extends GameObject {

    private String tip;
    private int steta;
    private int zdravlje;

    public Enemy(String tip, int x, int y, int sirina, int visina, int steta, int zdravlje) {
        super(x, y, sirina, visina);
        setTip(tip);
        setSteta(steta);
        setZdravlje(zdravlje);
    }

    public String getTip() { return tip; }
    public void setTip(String tip) {
        if (tip == null || tip.trim().isEmpty()) this.tip = "nepoznat";
        else this.tip = tip.trim().toLowerCase();
    }

    public int getSteta() { return steta; }
    public void setSteta(int steta) {
        if (steta < 0) steta = 0;
        if (steta > 100) steta = 100;
        this.steta = steta;
    }

    public int getZdravlje() { return zdravlje; }
    public void setZdravlje(int zdravlje) {
        if (zdravlje < 0) zdravlje = 0;
        if (zdravlje > 100) zdravlje = 100;
        this.zdravlje = zdravlje;
    }

    public String toString() {
        return "Enemy[" + tip + "] @ (" + getX() + "," + getY() + ") " +
                getSirina() + "x" + getVisina() + " DMG=" + steta + " HP=" + zdravlje;
    }
}
