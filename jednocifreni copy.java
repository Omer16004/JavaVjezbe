package a;

import java.util.Scanner;

public class jednocifreni {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite neki broj: ");
		
		String Broj = sc.nextLine();
		
		
		int suma = 0;
		for (int i = 0; i < Broj.length(); i++) {
			char cifra = Broj.charAt(i);
			suma += Character.getNumericValue(cifra);
			
		}
		if (suma % 2 == 0) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
		
		
		
		
		
		
	}

}
