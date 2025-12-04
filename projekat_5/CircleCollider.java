package game;
public class CircleCollider implements Collidable {
    public int cx,cy,r;
    public CircleCollider(int cx,int cy,int r){
        if(r<=0) throw new IllegalArgumentException();
        this.cx=cx;this.cy=cy;this.r=r;
    }
    private int clamp(int v,int min,int max){ return Math.max(min,Math.min(v,max)); }
    public boolean intersects(Collidable other){
        if(other instanceof CircleCollider){
            CircleCollider o=(CircleCollider)other;
            int dx=cx-o.cx, dy=cy-o.cy;
            int dist=dx*dx+dy*dy, rad=r+o.r;
            return dist<=rad*rad;
        }
        if(other instanceof RectangleCollider){
            RectangleCollider rc=(RectangleCollider)other;
            int closestX=clamp(cx,rc.x,rc.x+rc.width);
            int closestY=clamp(cy,rc.y,rc.y+rc.height);
            int dx=cx-closestX, dy=cy-closestY;
            return dx*dx+dy*dy<=r*r;
        }
        return false;
    }
}
