package vjezbex;

interface Ekonomican {
    double potrosnjaPoKm();
}

abstract class Vozilo {
    protected int id;
    protected double maxBrzina;

    public Vozilo(int id, double maxBrzina) {
        this.id = id;
        this.maxBrzina = maxBrzina;
    }

    public void info() {
        System.out.println("ID: " + id + ", Max brzina: " + maxBrzina);
    }

    public abstract double izracunajVrijemeDostave(double udaljenostKm);
}

class Bicikl extends Vozilo implements Ekonomican {
    public Bicikl(int id, double maxBrzina) {
        super(id, maxBrzina);
    }

    @Override
    public double izracunajVrijemeDostave(double udaljenostKm) {
        return udaljenostKm / maxBrzina;
    }

    @Override
    public double potrosnjaPoKm() {
        return 0;
    }
}

class Motor extends Vozilo {
    public Motor(int id, double maxBrzina) {
        super(id, maxBrzina);
    }

    @Override
    public double izracunajVrijemeDostave(double udaljenostKm) {
        return udaljenostKm / maxBrzina;
    }
}

class Auto extends Vozilo {
    public Auto(int id, double maxBrzina) {
        super(id, maxBrzina);
    }

    @Override
    public double izracunajVrijemeDostave(double udaljenostKm) {
        return udaljenostKm / maxBrzina;
    }
}

public class Main {
    public static void main(String[] args) {

        Vozilo[] vozila = {
                new Bicikl(1, 20),
                new Motor(2, 60),
                new Auto(3, 90)
        };

        double udaljenost = 10;

        for (Vozilo v : vozila) {
            v.info();
            double vrijeme = v.izracunajVrijemeDostave(udaljenost);
            System.out.println("Vrijeme dostave: " + vrijeme + " h");

            if (v instanceof Ekonomican) {
                double p = ((Ekonomican) v).potrosnjaPoKm();
                System.out.println("Potrosnja po km: " + p);
            } else {
                System.out.println("Potrosnja po km: nema (nije ekonomican)");
            }

            System.out.println();
        }
    }
}


