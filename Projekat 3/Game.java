import java.util.ArrayList;

public class Game {

    private Player igrac;
    private ArrayList<Enemy> neprijatelji;
    private ArrayList<String> dogadjaji;

    public Game(Player igrac) {
        this.igrac = igrac;
        neprijatelji = new ArrayList<>();
        dogadjaji = new ArrayList<>();
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int stara = p.getZdravlje();
        int dmg = e instanceof BossEnemy ? e.getSteta() * 2 : e.getSteta();
        int nova = stara - dmg;
        if (nova < 0) nova = 0;
        p.setZdravlje(nova);

        String poruka = "Sudar ostvarn: Player by " + e.getTip() + " for " + dmg + " -> HP " + stara + " -> " + nova;
        dogadjaji.add(poruka);
    }

    public void addEnemy(Enemy e) {
        neprijatelji.add(e);
        String poruka = "Dodat neprijatelj " + e.getTip() + " na (" + e.getX() + "," + e.getY() + ")";
        dogadjaji.add(poruka);
    }

    public ArrayList<Enemy> findByType(String tekst) {
        ArrayList<Enemy> lista = new ArrayList<>();
        String q = tekst.toLowerCase().trim();

        for (Enemy e : neprijatelji) {
            if (e.getTip().toLowerCase().contains(q)) lista.add(e);
        }
        return lista;
    }

    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> lista = new ArrayList<>();
        for (Enemy e : neprijatelji) {
            if (checkCollision(igrac, e)) lista.add(e);
        }
        return lista;
    }

    public void resolveCollisions() {
        ArrayList<Enemy> lista = collidingWithPlayer();
        for (Enemy e : lista) {
            decreaseHealth(igrac, e);
        }
    }

    public void prikaziDogadjaje() {
        System.out.println("igra startovala");
        for (String s : dogadjaji) System.out.println(s);
    }

    public static void main(String[] args) {
       
    	 Player igrac = new Player("peTar petrović", 10, 5, 32, 32, 85);
        
    	 Game igra = new Game(igrac);

        MeleeEnemy n1 = new MeleeEnemy("orc", 12, 5, 16, 16, 20, 60);
         
        igra.addEnemy(n1);

    
        String data = "Goblin;12,5;16x16;20;boss";
        String[] dijelovi = data.split(";");
        String tip = dijelovi[0];
        String[] koord = dijelovi[1].split(",");
        String[] dim = dijelovi[2].split("x");
        int x = Integer.parseInt(koord[0]);
        int y = Integer.parseInt(koord[1]);
        int w = Integer.parseInt(dim[0]);
        int h = Integer.parseInt(dim[1]);
        int dmg = Integer.parseInt(dijelovi[3]);
        String vrsta = dijelovi[4];

        Enemy n2;
        if (vrsta.equalsIgnoreCase("boss")) {
            n2 = new BossEnemy(tip, x, y, w, h, dmg, 120);
        } else {
            n2 = new MeleeEnemy(tip, x, y, w, h, dmg, 60);
        }
        igra.addEnemy(n2);

        System.out.println("svi neprijatelji");
        for (Enemy e : igra.neprijatelji) System.out.println(e);
        System.out.println();

        System.out.println("pretraga 'gob'");
        for (Enemy e : igra.findByType("gob")) System.out.println(e);
        System.out.println();

        System.out.println("prije sudara");
        System.out.println(igrac);
        System.out.println();

        igra.resolveCollisions();

        System.out.println("posle sudara");
        System.out.println(igrac);
        System.out.println();

        igra.prikaziDogadjaje();
    }
}
