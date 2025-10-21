package a;

import java.util.Scanner;

public class unazad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		
		int [] niz = new int[10];
		int MaxPosjeta = 0;
		
		for (int i = 0; i < niz.length; i++) {
			System.out.println("Unesite " + (i+1) + ". broj posjetioca: ");
			
niz[i] = sc.nextInt();

for (int j = 0; j < niz.length; j++) {
	if (niz[j] > MaxPosjeta) {
		MaxPosjeta = niz[j];
		
	}
	
}
System.out.println("Najveci broj posjetioca je: " + MaxPosjeta);

		}
		

		
		}
		
	
		
		
		
	
		
		

		

	}


