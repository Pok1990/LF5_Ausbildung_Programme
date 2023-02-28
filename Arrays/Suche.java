import java.util.Scanner;
public class Suche{
	public static void main(String[] args) {
		//Deklarationen
		
		int [] zahlenarray = {1,3,5,6,7,213,6,64,2,12,9876,335,8,96,42,34565,21,3567,87654,23,5,742,42,5,5,55,33,22,55,66,77,88,8482,99};
		String text = "nicht gefunden";
		int wert = 39;
	
		for (int i=0 ; i < zahlenarray.length;i++){
			if (wert == i){
				text = "gefunden";
				break;
			}	
		}
		System.out.println("die zahl " + wert + " wurde " + text);


	}


}
