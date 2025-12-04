package game;
public abstract class Enemy extends GameObject implements Attacker{
    protected String type; protected int damage; protected int health;
    public Enemy(String t,int x,int y,Collidable c,int dmg,int hp){
        super(x,y,c);
        type=t;
        if(dmg<0||dmg>100) throw new IllegalArgumentException();
        if(hp<0||hp>100) throw new IllegalArgumentException();
        damage=dmg; health=hp;
    }
    public int getEffectiveDamage(){return damage;}
    public String getDisplayName(){return type;}
    public String toString(){return type+" DMG="+damage+" HP="+health;}
}
