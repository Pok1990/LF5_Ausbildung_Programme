import java.util.Scanner;
import java.text.*;

// 2.6 Kommentare einfügen
// 3.3 Ausgabe verändert. 
// 3.4 Anzahl der Tickets hinzufügen
// 3.5 Zusatz - Fehlerbeseitigung
// 4.4 Ticketgrenzen im Fahrkartenautomaten
// 4.6 Geldeingabe Überprüfen
class Fahrkartenautomat {

	public static double muenzRueckgabe(double rueckgabe, double value, String stringvalue){
		while (rueckgabe >= value) {
			System.out.println(stringvalue);
			rueckgabe -= value;
		}
		return rueckgabe;
	}

	public static void begruessung(){
		System.out.println("Herzlich Willkommen!\n");
	}

	public static void rueckgeldAusgeben(double zuZahlenderBetrag, double eingezahlterGesamtbetrag){

		DecimalFormat format = new DecimalFormat("#0.00");
		double rueckgabebetrag;
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + format.format(rueckgabebetrag) + " Euro");
			System.out.println("wird in folgenden Münzen ausgezahlt:");
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 2.0, "2 Euro");
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 1.0, "1 Euro");
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 0.49999, "50 Cent");
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 0.19999, "20 Cent");
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 0.09999, "10 Cent");
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 0.04999, " 5 Cent");
		}
		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
	}
	
	public static void fahrkartenAusgeben(){
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
		int ticketanzahl = 0;
		int ticketwahl = 0;
		
		double[] ticketpreise = new double[14];
		String[] Fahrkartennamen= new String[14];

		ticketpreise[1] = 3.00;
		Fahrkartennamen[1] = "Einzelfahrschein AB";
		ticketpreise[2] = 3.50;
		Fahrkartennamen[2] = "Einzelfahrschein BC";
		ticketpreise[3] = 3.80;
		Fahrkartennamen[3] = "Einzelfahrschein ABC";
		ticketpreise[4] = 2.00;
		Fahrkartennamen[4] = "Kurzstrecke AB";
		ticketpreise[5] = 8.600;
		Fahrkartennamen[5] = "Tageskarte AB";
		ticketpreise[6] = 9.20;
		Fahrkartennamen[6] = "Tageskarte BC";
		ticketpreise[7] = 10.00;
		Fahrkartennamen[7] = "Tageskarte ABC";
		ticketpreise[8] = 9.40;
		Fahrkartennamen[8] = "4-Fahrten-Karte AB";
		ticketpreise[9] = 12.60;
		Fahrkartennamen[9] = "4-Fahrten-Karte BC";
		ticketpreise[10] = 13.80;
		Fahrkartennamen[10] = "4-Fahrten-Karte ABC";
		ticketpreise[11] = 25.50;
		Fahrkartennamen[11] = "Kleingruppen-Tageskarte AB";
		ticketpreise[12] = 26.00;
		Fahrkartennamen[12] = "Kleingruppen-Tageskarte BC";
		ticketpreise[13] = 26.50;
		Fahrkartennamen[13] = "Kleingruppen-Tageskarte ABC";

		do{
			System.out.println("Wählen die Ihre Wunschfahrkarte für Berlin aus:");
			for (int i= 0;i < ticketpreise.length ; i++){
				if (i == 0) continue;
				System.out.printf(" [%d]\t %s mit [ %.2f EUR ] \n",i,Fahrkartennamen[i],ticketpreise[i]);
			}
			System.out.println(" [0]\t Bezahlen\n");

			System.out.print("Ihre Auswahl: ");
			ticketwahl = tastatur.nextInt();
			
			if ( ticketwahl > 0 && ticketwahl <= ticketpreise.length-1 ){
				ticketPreis += ticketpreise[ticketwahl];	
				ticketanzahl++;
				System.out.printf("Anzahl der Tickets: %d \n",ticketanzahl);
				System.out.printf("Noch zu Zahlen: %.2f \n",ticketPreis);
			}else{
				if (ticketwahl == 0){ break; }
				System.out.println("Ungültige Auswahl --> Try Again\n");		
			}

		}while(ticketwahl != 0 );
		return ticketPreis;
	}

	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		
		begruessung();
		zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur,zuZahlenderBetrag);
		fahrkartenAusgeben();
		rueckgeldAusgeben(zuZahlenderBetrag,eingezahlterGesamtbetrag);

		tastatur.close();
	}
}
