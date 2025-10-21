package a;

import java.util.Scanner;

public class samoglasnici {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	System.out.println("Unesite neki string: ");

	String unos = sc.nextLine();
	unos = unos.toLowerCase();
	int brojsamoglasnika = 0;
	int brojslova = 0; 
	for (int i = 0; i < args.length; i++) {
		char znak = unos.charAt(unos.length()-1);
		if (znak == 'a' || znak == 'e' || znak == 'i' || znak == 'o' || znak == 'u') {
			brojsamoglasnika++;
		
			
			System.out.println("Broj samoglasnika u unesenom stringu je: " + brojsamoglasnika);
			
			
		}
		
	}
	}

}
