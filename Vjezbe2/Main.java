package vjezbe88;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Restoran r = new Restoran("Moj Restoran", "ulica bb", "123456789");

        Konobar k1 = new Konobar(1, "Omer", "Grahic", 8.5, 40, 5);
        Kuvar k2 = new Kuvar(2, "Mihailo ", "Vulovic", 10.0, 42);
        Menadzer m1 = new Menadzer(3, "Daniel", "Culafic", 15.0, 38, 250);
        Konobar k3 = new Konobar(4, "Ivan", "Ratkovic", 9.0, 37, 3);
        Kuvar k4 = new Kuvar(5, "Petar", "Korac", 12.0, 40);

        r.dodajZaposlenog(k1);
        r.dodajZaposlenog(k2);
        r.dodajZaposlenog(m1);
        r.dodajZaposlenog(k3);
        r.dodajZaposlenog(k4);

        System.out.print("Unesite mjesec obracuna: ");
        int mjesec = sc.nextInt();
        System.out.print("Unesite godinu: ");
        int godina = sc.nextInt();

        System.out.println("\nMjesečni obračun plata za " + mjesec + "/" + godina + ":");
        r.generisiObracun(mjesec, godina);

       
    }
}
