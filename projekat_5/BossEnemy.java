package game;
public class BossEnemy extends Enemy{
    public BossEnemy(String t,int x,int y,Collidable c,int d,int h){
        super(t,x,y,c,d,h);
    }
    public int getEffectiveDamage(){return damage*2;}
    public String toString(){return "[BOSS] "+type+" DMG="+getEffectiveDamage()+" HP="+health;}
}
