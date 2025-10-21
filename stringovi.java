package a;

import java.util.Scanner;

public class stringovi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite neki string: ");
		String unos = sc.nextLine();
		unos = unos.trim();
		String okrenutTekst = new StringBuilder(unos).reverse().toString();
		
		System.out.println(unos.equalsIgnoreCase(okrenutTekst) ? "Uneseni string je palindrom." : "Uneseni string nije palindrom." );
		
		
	
		
		}
	

			}
		
		
		
		

	


