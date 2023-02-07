import java.util.Scanner;
import java.text.*;

// 2.6 Kommentare einfügen
// 3.3 Ausgabe verändert. 
// 3.4 Anzahl der Tickets hinzufügen
// 3.5 Zusatz - Fehlerbeseitigung
// 4.4 Ticketgrenzen im Fahrkartenautomaten
// 4.6 Geldeingabe Überprüfen
class Fahrkartenautomat {

	public static void begruessung(){
		System.out.println("Herzlich Willkommen!\n");
	}

	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag){
		double eingezahlterGesamtbetrag = 0.0;
		int gueltigesgeld = 0;
		double eingeworfeneMuenze = 0.0;
		double nochZuZahlen = 0;
		DecimalFormat format = new DecimalFormat("#0.00");
	
		eingezahlterGesamtbetrag = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			gueltigesgeld = 0;
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.println("Noch zu zahlen: " + format.format(nochZuZahlen));
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			gueltigesgeld =  (int)(eingeworfeneMuenze * 100);
			switch (gueltigesgeld){
				case 5:
				case 10:
				case 20:
				case 50:
				case 100:
				case 200:
				case 500:
				case 1000:
				case 2000:
					break;
				default:
					System.out.println(">> kein Gültiges Zahlungsmittel");
					continue;
			}
			
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag;
	}

	public static double fahrkartenbestellungErfassen(Scanner tastatur){
		
		double ticketPreis = 0;
		int anzahlkurzab = 0;
		int anzahleinzelab = 0;
		int anzahltagesab = 0;
		int anzahlvierfahrtenab = 0;
		int ticketwahl = 0;

		do{
			if (ticketwahl == 0){
				System.out.println("Wählen die Ihre Wunschfahrkarte für Berlin AB aus:");
				System.out.println("  Kurzstrecke AB [2,00 EUR] (1)");
				System.out.println("  Einzelfahrschein AB [3,00 EUR] (2)");
				System.out.println("  Tageskarte AB [8,00 EUR] (3)");
				System.out.println("  4-Fahrten-Karte AB [9,40 EUR] (4)\n");
				System.out.println("  Übersicht über Fahrkarten (0)\n");
				System.out.println("  Bezahlen(9)\n");
			}
			if (ticketwahl != 0 && (ticketwahl < 0 || ticketwahl > 4)){
				System.out.println(" >> Falsche Eingabe <<");
			}else{
			}	
			System.out.print("Ihre Wahl: ");
			ticketwahl = tastatur.nextInt();

			switch (ticketwahl){
				case 1:
					ticketPreis += 2.00;
					anzahlkurzab++;
					System.out.printf("Anzahl der Tickets %d von Kurzstrecke AB\n\n", anzahlkurzab);
					System.out.printf("Zwischensumme: %.2f €\n", ticketPreis);
					break;
				case 2:
					ticketPreis += 3.00; 
					anzahleinzelab++;
					System.out.printf("Anzahl der Tickets %d von Einzelfahrschein AB\n\n",anzahleinzelab );
					System.out.printf("Zwischensumme: %.2f €\n", ticketPreis);
					break;
				case 3:
					ticketPreis += 8.00; 
					anzahltagesab++;
					System.out.printf("Anzahl der Tickets %d von Tageskarte AB\n\n",anzahltagesab );
					System.out.printf("Zwischensumme: %.2f €\n", ticketPreis);
				       	break;
				case 4:
					ticketPreis += 9.40; 
					anzahlvierfahrtenab++;
					System.out.printf("Anzahl der Tickets %d von 4-Fahrten-Karte AB\n\n",anzahlvierfahrtenab );
					System.out.printf("Zwischensumme: %.2f €\n", ticketPreis);
					break;
				default:
					if (ticketwahl != 9){
						// mögliche Falsche Bedienung
						System.out.println("Diese Option steht ihnen nicht zur verfügung! bitte versuchen sie er erneut");
					} 
					break;	
			}
		}while(ticketwahl != 9 );

		return ticketPreis;
	}

	public static void main(String[] args) {
		
		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		double rueckgabebetrag;
		DecimalFormat format = new DecimalFormat("#0.00");
		
		begruessung();
		
		zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur,zuZahlenderBetrag);
		
		// Fahrscheinausgabe
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
		
		// Rückgeldberechnung uns -ausgabe
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + format.format(rueckgabebetrag) + " Euro");
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.49999) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.19999) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.09999) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.04999) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}
