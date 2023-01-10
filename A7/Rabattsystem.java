import java.util.Scanner;
public class Rabattsystem{
	public static void main(String[] args) {
		//Deklarationen
		Scanner tastatur = new Scanner(System.in);
		double bestellwert = 0;
		double rabatt = 0;
		double endergebnis = 0;
		String Alter = "Bitte geben sie ihren Bestellwert ein: ";
		System.out.print(Alter);
		bestellwert = tastatur.nextDouble();
		if (bestellwert >= 0 && bestellwert <= 100){
			rabatt = 0.1;
		}		
		else if (bestellwert <= 500){
			rabatt = 0.15;
		} else{
			rabatt = 0.2;
		}		
		

		int i = 0;
		i++;

		System.out.println(i);

		endergebnis = bestellwert * (1- rabatt);	
		System.out.println("Der Bestellwert abzüglich Rabatte beträgt : "+ endergebnis + " Euro");
	}

}

