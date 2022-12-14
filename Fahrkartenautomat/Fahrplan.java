public class Fahrplan {
    public static void main(String[] args) {
        // Weichenstellungen
        int fahrzeit = 0;
        boolean haltInSpandau = false;
        boolean richtungHamburg = false;
        boolean haltInStendal = true;
        char endetIn = 'h'; //h=Hannover, b=Braunschweig, w=Wolfsburg

        fahrzeit = fahrzeit + 8; // Fahrzeit Hbf -> Spandau

        if (haltInSpandau == true) {
            	fahrzeit = fahrzeit + 2; // Halt in Spandau
        }
       	if (richtungHamburg){
		fahrzeit += 96;
	}
		
	if (haltInStendal){
		fahrzeit += 16;  
	}else{
		fahrzeit += 6;  // wird umfahren Umfahren 
	}

	switch (endetIn){
		case 'h':
			fahrzeit += 62;  
			System.out.println(String.format("Fahrziel Hannover beträgt %d Minuten",fahrzeit));
			break;
		case 'b':
			fahrzeit += 50;  
			System.out.println(String.format("Fahrziel Braunschweig beträgt %d Minuten",fahrzeit));
			break;
		case 'w': 
			fahrzeit += 29;  
			System.out.println(String.format("Fahrziel Wolfsburg beträgt %d Minuten",fahrzeit));
			break;
		default: 
			System.out.println("Fehler im Zielcomputer - wir fahren ins Nichts!!!");	
	}
    }
}
