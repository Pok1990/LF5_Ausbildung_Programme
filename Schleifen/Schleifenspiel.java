import java.util.Scanner;
public class Schleifenspiel{
	public static void main(String[] args) {
		//Deklarationen
		//
		// eine While schleife welche 10² - 20² ausgibt
		int i = 10;
		while(i <= 20) {
		     System.out.printf("%d \n", i*i);
		     i = i+1;
		}

	      	System.out.println("Das war mit einer Whileschleife, nun mit einer Forschleife\n");
		//Die folgende for-Schleife gibt die ersten zehn Quadratzahlen aus:
		for(int s=10; s <=20; s = s+1) {
	      	System.out.printf("%d \n", s*s);
		}

	}

}

