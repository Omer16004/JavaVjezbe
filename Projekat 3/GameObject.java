public class GameObject {

    private int x;
    private int y;
    private int sirina;
    private int visina;

    public GameObject(int x, int y, int sirina, int visina) {
        if (sirina <= 0) sirina = 1;
        if (visina <= 0) visina = 1;
        this.x = x;
        this.y = y;
        this.sirina = sirina;
        this.visina = visina;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getSirina() { return sirina; }
    public void setSirina(int sirina) {
        if (sirina > 0) this.sirina = sirina;
    }

    public int getVisina() { return visina; }
    public void setVisina(int visina) {
        if (visina > 0) this.visina = visina;
    }

    public boolean intersects(GameObject o) {
        return x < o.x + o.sirina &&
               x + sirina > o.x &&
               y < o.y + o.visina &&
               y + visina > o.y;
    }

    public String toString() {
        return "GameObject @ (" + x + "," + y + ") " + sirina + "x" + visina;
    }
}
