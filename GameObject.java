package Projekat4;
public abstract class GameObject {
    protected int x;
    protected int y;
    protected Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null) throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.collider = collider;
    }

    public boolean intersects(GameObject other) {
        return collider.intersects(other.collider);
    }

    public abstract String getDisplayName();
}
