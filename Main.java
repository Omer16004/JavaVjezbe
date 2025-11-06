package vjezbe_8;

import java.util.ArrayList;
import java.util.Scanner;

class EProizvod {
    protected String opis;
    protected String sifra;
    protected double uvoznaCijena;

    public EProizvod(String opis, String sifra, double uvoznaCijena) {
        this.opis = opis;
        this.sifra = sifra;
        this.uvoznaCijena = uvoznaCijena;
    }

    public String getKategorija() {
        String prefiks = sifra.substring(0, 2).toUpperCase();
        if (prefiks.equals("RA")) return "Racunari";
        else if (prefiks.equals("TE")) return "Telefoni";
        else if (prefiks.equals("TV")) return "TV";
        else return "Nepoznata kategorija";
    }

    public double izracunajMaloprodajnuCijenu() {
        return uvoznaCijena * 1.05;
    }

    public void prikaziPodatke() {
        System.out.println("Opis: " + opis);
        System.out.println("Šifra: " + sifra);
        System.out.println("Uvozna cijena: " + uvoznaCijena);
        System.out.println("Kategorija: " + getKategorija());
        System.out.println("Maloprodajna cijena: " + izracunajMaloprodajnuCijenu());
        System.out.println("-----------------------------------");
    }
}

class Racunar extends EProizvod {
    private String procesor;
    private int memorija;

    public Racunar(String opis, String sifra, double uvoznaCijena, String procesor, int memorija) {
        super(opis, sifra, uvoznaCijena);
        this.procesor = procesor;
        this.memorija = memorija;
    }

    @Override
    public double izracunajMaloprodajnuCijenu() {
        double cijena = super.izracunajMaloprodajnuCijenu();
        cijena = cijena * 1.05;
        return cijena;
    }

    @Override
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Procesor: " + procesor);
        System.out.println("Memorija: " + memorija + " GB");
        System.out.println("-----------------------------------");
    }
}

class Telefon extends EProizvod {
    private String operativniSistem;
    private double velicinaEkrana;

    public Telefon(String opis, String sifra, double uvoznaCijena, String operativniSistem, double velicinaEkrana) {
        super(opis, sifra, uvoznaCijena);
        this.operativniSistem = operativniSistem;
        this.velicinaEkrana = velicinaEkrana;
    }

    @Override
    public double izracunajMaloprodajnuCijenu() {
        double cijena = super.izracunajMaloprodajnuCijenu();
        if (velicinaEkrana > 6) {
            cijena = cijena * 1.03;
        }
        return cijena;
    }

    @Override
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Operativni sistem: " + operativniSistem);
        System.out.println("Veličina ekrana: " + velicinaEkrana + " inča");
        System.out.println("-----------------------------------");
    }
}

class TV extends EProizvod {
    private double velicinaEkrana;

    public TV(String opis, String sifra, double uvoznaCijena, double velicinaEkrana) {
        super(opis, sifra, uvoznaCijena);
        this.velicinaEkrana = velicinaEkrana;
    }

    @Override
    public double izracunajMaloprodajnuCijenu() {
        double cijena = super.izracunajMaloprodajnuCijenu();
        if (velicinaEkrana > 65) {
            cijena = cijena * 1.10;
        }
        return cijena;
    }

    @Override
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Veličina ekrana: " + velicinaEkrana + " inča");
        System.out.println("-----------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        ArrayList<EProizvod> proizvodi = new ArrayList<>();

        int izbor;

        do {
            System.out.println("==== MENI ====");
            System.out.println("1. Unos uređaja");
            System.out.println("2. Pregled svih uređaja");
            System.out.println("3. Pregled uređaja po tipu");
            System.out.println("0. Izlaz");
            System.out.print("Izbor: ");
            izbor = ulaz.nextInt();
            ulaz.nextLine();

            if (izbor == 1) {
                System.out.print("Unesite šifru proizvoda (RA/TE/TV...): ");
                String sifra = ulaz.nextLine();
                System.out.print("Unesite opis: ");
                String opis = ulaz.nextLine();
                System.out.print("Unesite uvoznu cijenu: ");
                double cijena = ulaz.nextDouble();
                ulaz.nextLine();

                String prefiks = sifra.substring(0, 2).toUpperCase();

                if (prefiks.equals("RA")) {
                    System.out.print("Unesite procesor: ");
                    String procesor = ulaz.nextLine();
                    System.out.print("Unesite memoriju (GB): ");
                    int memorija = ulaz.nextInt();
                    ulaz.nextLine();
                    proizvodi.add(new Racunar(opis, sifra, cijena, procesor, memorija));

                } else if (prefiks.equals("TE")) {
                    System.out.print("Unesite operativni sistem: ");
                    String os = ulaz.nextLine();
                    System.out.print("Unesite veličinu ekrana (inči): ");
                    double ekran = ulaz.nextDouble();
                    ulaz.nextLine();
                    proizvodi.add(new Telefon(opis, sifra, cijena, os, ekran));

                } else if (prefiks.equals("TV")) {
                    System.out.print("Unesite veličinu ekrana (inči): ");
                    double ekran = ulaz.nextDouble();
                    ulaz.nextLine();
                    proizvodi.add(new TV(opis, sifra, cijena, ekran));

                } else {
                    System.out.println("Nepoznata šifra, uređaj nije dodat!");
                }

            } else if (izbor == 2) {
                System.out.println("==== SVI UREĐAJI ====");
                for (EProizvod p : proizvodi) {
                    p.prikaziPodatke();
                }

            } else if (izbor == 3) {
                System.out.print("Unesite tip uređaja (Racunari/Telefoni/TV): ");
                String tip = ulaz.nextLine();
                System.out.println("==== Uređaji tipa: " + tip + " ====");
                for (EProizvod p : proizvodi) {
                    if (p.getKategorija().equalsIgnoreCase(tip)) {
                        p.prikaziPodatke();
                    }
                }
            }

        } while (izbor != 0);

        System.out.println("Kraj programa.");
    }
}
