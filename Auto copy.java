package a;

import java.util.ArrayList;
import java.util.Scanner;

class Auto {

	Scanner scanner = new Scanner(System.in);

	private String markaAuta;
	private int godinaProizvodnje;
	private float jacinaMotora;
	private boolean prodat;
	private int kubikaza;
	private boolean registrovan;
	private static int brojProdatihAuta;
	
	public Auto (String markaAuta, int godinaProizvodnje, float jacinaMotora, boolean prodat, int kubikaza, boolean registrovan) {
		this.markaAuta = markaAuta;
		this.godinaProizvodnje = godinaProizvodnje;
		this.jacinaMotora = jacinaMotora;
		this.prodat = prodat;
		this.kubikaza = kubikaza;
		this.registrovan = registrovan;
		if (prodat) {
			brojProdatihAuta++;
		this.registrovan = godinaProizvodnje < 1985? false: registrovan;
		}
	}	



	public String getMarkaAuta() {
		return markaAuta;
	}

	public void setMarkaAuta(String markaAuta) {
		this.markaAuta = markaAuta;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		if (godinaProizvodnje >= 2025) {
			System.out.println("Uneli ste neispravnu godinu proizvodnje.");
		} else {
			this.godinaProizvodnje = godinaProizvodnje;
		}
		
	}

	public float getJacinaMotora() {
		return jacinaMotora;
	}

	public void setJacinaMotora(float jacinaMotora) {
		this.jacinaMotora = jacinaMotora;
	}

	public boolean isProdat() {
		return prodat;
	}

	public void setProdat(boolean prodat) {
		this.prodat = prodat;
	}

	public int getKubikaza() {
		return kubikaza;
	}

	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}

	public boolean isRegistrovan() {
		return registrovan;
	}

	public void setRegistrovan(boolean registrovan) {
		this.registrovan = registrovan;
	}
	
    public boolean mozeSeRegistrovati() {
    	if (godinaProizvodnje < 1985) {
			return false;
		} else {
			return true;
		}
    	
    }
    
    public static double koeficijentZaGodiste (int godinaProizvodnje) {
    	if (godinaProizvodnje < 1985) return 0;
    	if (godinaProizvodnje <= 2000) return 3.0;
    	if (godinaProizvodnje <= 2010) return 2.0;
    	return 1.0;

		
   
    	
    	
    }
    
    public float cijenaRegistracije() {
    	if (!mozeSeRegistrovati()) return 0;
    	return (float) (koeficijentZaGodiste(godinaProizvodnje) * (kubikaza * jacinaMotora));
    	
    	
		}
    	
   
    
    public String toString () {
    	return "Marka auta: " + markaAuta + ", Godina proizvodnje: " + godinaProizvodnje + ", Jacina motora: " + jacinaMotora + ", Prodat: " + prodat + ", Kubikaza: " + kubikaza + ", Registrovan: " + registrovan;
    	
    }
    public class Testauto{
    	public void main(String[] args) {
    		ArrayList<Auto> listaAuta = new ArrayList<>();
    		listaAuta.add (new Auto("Toyota", 2015, 2.0f, false, 2000, true));
    		listaAuta.add (new Auto("Ford", 1999, 1.6f, true, 1600, false));
    		
    		System.out.println(listaAuta.get(0).toString());
    		
    	
    				
    			
    	}
		    }
}
