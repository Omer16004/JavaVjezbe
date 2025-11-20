package Projekat4;
public class RectangleCollider implements Collidable {
    private int x;
    private int y;
    private int width;
    private int height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int left() { return x - width/2; }
    public int right() { return x + width/2; }
    public int top() { return y - height/2; }
    public int bottom() { return y + height/2; }

    private int clamp(int v, int min, int max) {
        if (v < min) return min;
        if (v > max) return max;
        return v;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            return !(right() < r.left() || left() > r.right() || bottom() < r.top() || top() > r.bottom());
        }
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            int cx = clamp(c.getX(), left(), right());
            int cy = clamp(c.getY(), top(), bottom());
            int dx = cx - c.getX();
            int dy = cy - c.getY();
            return dx*dx + dy*dy <= c.getRadius()*c.getRadius();
        }
        return false;
    }
}
