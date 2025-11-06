package vjezbe88;

import java.util.ArrayList;
import java.util.Scanner;

class Zaposleni {
	int id;
	String ime;
	String prezime;
	double plataPoSatu;
	double ukupanBrojSati;

	public Zaposleni(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.plataPoSatu = plataPoSatu;
		this.ukupanBrojSati = ukupanBrojSati;
	}

	public double izracunajPlatu() {
		return 0;
	}

	public String getTip() {
		return "Zaposleni";
	}

	public String getDodatneInfo() {
		return "";
	}
}

class Konobar extends Zaposleni {
	double prekovremeniSati;

	public Konobar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati,
			double prekovremeniSati) {
		super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
		this.prekovremeniSati = prekovremeniSati;
	}

	@Override
	public double izracunajPlatu() {
		return 4 * (ukupanBrojSati * plataPoSatu + prekovremeniSati * plataPoSatu * 1.2);
	}

	@Override
	public String getTip() {
		return "Konobar";
	}

	@Override
	public String getDodatneInfo() {
		return "Prekovremeni sati: " + prekovremeniSati;
	}
}

class Kuvar extends Zaposleni {
	public Kuvar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
		super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
	}

	@Override
	public double izracunajPlatu() {
		return 1500 + 4 * ukupanBrojSati * plataPoSatu;
	}

	@Override
	public String getTip() {
		return "Kuvar";
	}

	@Override
	public String getDodatneInfo() {
		return "Fiksni dodatak: 1500";
	}
}

class Menadzer extends Zaposleni {
	double bonus;

	public Menadzer(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double bonus) {
		super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
		this.bonus = bonus;
	}

	@Override
	public double izracunajPlatu() {
		return 1300 + 4 * ukupanBrojSati * plataPoSatu + bonus;
	}

	@Override
	public String getTip() {
		return "Menadzer";
	}

	@Override
	public String getDodatneInfo() {
		return "Bonus: " + bonus;
	}
}

class Restoran {
	String naziv;
	String adresa;
	String pib;
	ArrayList<Zaposleni> zaposleni = new ArrayList<>();

	public Restoran(String naziv, String adresa, String pib) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.pib = pib;
	}

	public void dodajZaposlenog(Zaposleni z) {
		zaposleni.add(z);
	}

	public void ukloniZaposlenog(int id) {
		zaposleni.removeIf(z -> z.id == id);
	}

	public Zaposleni nadjiPoID(int id) {
		for (Zaposleni z : zaposleni) {
			if (z.id == id)
				return z;
		}
		return null;
	}

	public void generisiObracun(int mjesec, int godina) {
		double ukupno = 0;
		System.out.println("-----------------------------------------------------------");
		System.out.println("ID\tIme\tPrezime\tTip\tSati\tDodatak\t\tPlata (EUR)");
		System.out.println("-----------------------------------------------------------");

		for (Zaposleni z : zaposleni) {
			double plata = z.izracunajPlatu();
			ukupno += plata;
			System.out.printf("%d\t%s\t%s\t%s\t%.1f\t%s\t%.2f\n", z.id, z.ime, z.prezime, z.getTip(), z.ukupanBrojSati,
					z.getDodatneInfo(), plata);
		}

		System.out.println("-----------------------------------------------------------");
		System.out.println("Ukupan trosak plata: " + ukupno + " EUR");
		System.out.println("-----------------------------------------------------------");
	}
}
