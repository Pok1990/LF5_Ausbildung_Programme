import java.util.Scanner;
public class Summe{
	public static void main(String[] args) {
		//Deklarationen
		//
		// eine While schleife welche 10² - 20² ausgibt
		Scanner tastatur = new Scanner(System.in);
		System.out.print("Bitte geben sie eine Zahl ein: ");	
		int bla = tastatur.nextInt();
		int keks = 0;
		System.out.print("Folgende Zahlen werden Addiert\n");	
		for (int i = 1; i <= bla; i++){
			System.out.print(i + " ");
			keks += i; 
		}
		System.out.println();	
		System.out.printf("Die Summe der zahlen ist: %d\n", keks);	

	}

}

