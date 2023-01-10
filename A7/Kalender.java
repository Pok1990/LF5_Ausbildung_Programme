import java.util.Scanner;
public class Kalender {
	public static void main(String[] args) {
		int tage = 0;
		int monat;
		Scanner tastatur = new Scanner(System.in);

		System.out.print("Wie lautet der Monat (1-12): ");
		monat = tastatur.nextInt();

		switch (monat){
		case 2:
			tage= 28;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			tage = 31;
			break;
		default:
			tage = 30;
		} 

		System.out.printf("Der %d-te Monat im Jahr hat %d Tage.\n", monat, tage);
		tastatur.close();
	}
}
