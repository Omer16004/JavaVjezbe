//almedin mekic
//omer lejs grahic
public class Player extends GameObject {

    private String ime;
    private int zdravlje;

    public Player(String ime, int x, int y, int sirina, int visina, int zdravlje) {
        super(x, y, sirina, visina);
        setIme(ime);
        setZdravlje(zdravlje);
    }

    public String getIme() { return ime; }

    public void setIme(String ime) {
        if (ime == null || ime.trim().isEmpty()) {
            this.ime = "Nepoznat";
            return;
        }
        String[] rijeci = ime.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rijeci.length; i++) {
            String r = rijeci[i];
            sb.append(Character.toUpperCase(r.charAt(0)));
            if (r.length() > 1) sb.append(r.substring(1).toLowerCase());
            if (i < rijeci.length - 1) sb.append(" ");
        }
        this.ime = sb.toString();
    }

    public int getZdravlje() { return zdravlje; }

    public void setZdravlje(int zdravlje) {
        if (zdravlje < 0) zdravlje = 0;
        if (zdravlje > 100) zdravlje = 100;
        this.zdravlje = zdravlje;
    }

    public String toString() {
        return "Player[" + ime + "] @ (" + getX() + "," + getY() + ") "
                + getSirina() + "x" + getVisina() + " HP=" + zdravlje;
    }
}
