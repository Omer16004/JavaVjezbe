package a;

import java.util.Scanner;

public class opetglupadistanca{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.println("Unesi centar kruga (cx, cy): ");
        double cx = sc.nextDouble();
        double cy = sc.nextDouble();


        System.out.println("Unesite poluprečnike r1 i r2 (r1 < r2): ");
        double r1 = sc.nextDouble();
        double r2 = sc.nextDouble();

     
        System.out.println("Unesite broj tacaka n: ");
        int n = sc.nextInt();

      
        int count = 0;
        double maxDist = 0;
        double maxDistX = 0, maxDistY = 0;

   
        for (int i = 0; i < n; i++) {
            System.out.println("Unesi tacku " + (i + 1) + " (xi, yi): ");
            double xi = sc.nextDouble();
            double yi = sc.nextDouble();

         
            if (yi > cy) {
                
                double distanca = Math.sqrt(Math.pow(xi - cx, 2) + Math.pow(yi - cy, 2));

          
                if (distanca >= r1 && distanca <= r2) {
                    count++;

              
                    if (distanca > maxDist) {
                        maxDist = distanca;
                        maxDistX = xi;
                        maxDistY = yi;
                    }
                }
            }
        }

        System.out.println("Broj tacaka u prstenu: " + count);
        if (count > 0) {
            System.out.println("Najudaljenija tacka: (" + maxDistX + ", " + maxDistY + ") sa udaljenostom: " + maxDist);
        } else {
            System.out.println("Nema tacaka u prstenu.");
        }
    }
}

	        	 
	         
	         
	         
	        	 
	 
	        
		
	     
	
	


