import java.util.Scanner;
import java.text.*;

// 2.6 Kommentare einfügen
// 3.3 Ausgabe verändert. 
// 3.4 Anzahl der Tickets hinzufügen
// 3.5 Zusatz - Fehlerbeseitigung
// 4.4 Ticketgrenzen im Fahrkartenautomaten
class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen = 0;
		double ticketPreis = 2.50;
		DecimalFormat format = new DecimalFormat("#0.00");
		int ticketAnzahl = 1;	
		
		// Eingabe von Ticketpreis und Ticketanzahl - mit zusätzlicher Eingabekontrolle (zwischen 1 und 10)
		System.out.print("Ticketpreis (Euro): ");
		ticketPreis = tastatur.nextDouble();
		if (ticketPreis < 1 || ticketPreis > 10 ){
			ticketPreis = 1;	
			System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt");
		}
		System.out.print("Anzahl der Tickets: ");
		ticketAnzahl = tastatur.nextInt();
		if (ticketAnzahl < 1 || ticketAnzahl > 10 ){
			ticketAnzahl = 1;	
			System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt");
		}
		// -----------------------------------------------------------------------------------
		zuZahlenderBetrag = ticketPreis * ticketAnzahl;
		
		// Geldeinwurf
		eingezahlterGesamtbetrag = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.println("Noch zu zahlen: " + format.format(nochZuZahlen));
			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		
		// Fahrscheinausgabe
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
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
