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
        
        // Hier das Programm weiterschreiben
    }
}
