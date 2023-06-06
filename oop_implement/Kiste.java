public class Kiste{
	public int hoehe;
	public int breite;
	public int tiefe;
	public String farbe;

	public Kiste(){
		this.hoehe = 1;
		this.breite = 1;
		this.tiefe = 1;
		this.farbe = "grau";
	}	

	public Kiste(int hoehe, int breite, int tiefe){
		this.hoehe = hoehe;
		this.breite = breite;
		this.tiefe = tiefe;
		this.farbe = "grau";
	}	

	public Kiste(int hoehe, int breite, int tiefe, String farbe){
		this.hoehe = hoehe;
		this.breite = breite;
		this.tiefe = tiefe;
		this.farbe = farbe;
	}	
	public int get_volume(){
		int volume = this.hoehe * this.breite * this.tiefe;
		System.out.println("mein Volumen ist: "+ volume);
		return volume;
	}

	public String get_farbe(){
		String farbe = this.farbe;
		System.out.println("meine Farbe ist : "+ farbe);
		return farbe;
	
	}

	public static void main(String[] args){
	System.out.println("Das Programm erstellt kisten!");	

	Kiste standard = new Kiste();
	standard.get_farbe();
	standard.get_volume();	
	
	Kiste großekiste = new Kiste(2,4,6);
	großekiste.get_farbe();
	großekiste.get_volume();	

	Kiste blauekiste = new Kiste(2,3,7,"blau");
	blauekiste.get_farbe();
	blauekiste.get_volume();	
	}
}

