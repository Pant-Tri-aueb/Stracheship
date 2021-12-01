import java.util.Scanner;

public class Posidonas {

	private int poseidonDefenceTries = 5;

	public boolean doDefence(){
		Scanner defencequestionScanner = new Scanner(System.in);
		System.out.println("Έχεις " + poseidonDefenceTries + " διαθέσιμες άμυνες του Ποσειδώνα, θέλεις να τις χρησιμοποιήσεις;\nY/N?");
		String  answer = defencequestionScanner.nextLine();
		boolean defence;
		if (answer == "Y") {
			defence = true;
		} else {
			defence = false;
		}
		return defence;
	}

	public void poseidonDefence() {
		
		if (doDefence() == true) {
			
			poseidonDefenceTries-- ;
		}

	}
}
