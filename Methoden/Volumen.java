import java.util.Scanner;
public class Volumen{
	public static double volum(double Seitenlänge){
		double volumen = Seitenlänge * Seitenlänge * Seitenlänge;
		return volumen;
	}
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		System.out.println("git die Seitenlänge des würfels ein");	
		double laenge = tastatur.nextDouble();
		double volummen= 0.0;
		volummen = volum(laenge);
		System.out.println(volummen);

		System.out.println("nun machen wir das mit der doppelten länge!");	
		laenge *= 2;
		volummen = volum(laenge);
		System.out.println(volummen);
	}
}
