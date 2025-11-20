package Projekat4;
public class CircleCollider implements Collidable {
    private int x;
    private int y;
    private int radius;

    public CircleCollider(int x, int y, int radius) {
        if (radius <= 0) throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return radius; }

    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            int dx = x - c.x;
            int dy = y - c.y;
            int r = radius + c.radius;
            return dx*dx + dy*dy <= r*r;
        }
        if (other instanceof RectangleCollider) {
            return other.intersects(this);
        }
        return false;
    }
}
