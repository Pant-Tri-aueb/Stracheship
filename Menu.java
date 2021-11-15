import java.util.*;
public class Menu { //h klash gia to menou
	
	public void startMenu() {
		System.out.println("Καλώς ήρθατε στο Stracheship!!!");
		System.out.println("Παρακαλούμε επιλέξτε μία από τις διαθέσιμες επιλογές:");
		System.out.println("1. Παρουσίαση - Οδηγίες του Stracheship");
		System.out.println("2. Έναρξη του παιχνιδιού");
		System.out.println("3. Τερματισμός");
		
		int choice;
		Scanner sc= new Scanner(System.in);
		
		do {
		choice = sc.nextInt();
		if (choice==1) {
			//odhgies
			Game c = new Game();
			c.printInstructions();
		} else if (choice==2) {
			Game a = new Game();
	    	a.startGame();			
		} else if (choice==3) {
			System.out.println("Exit....");
			System.exit(0);
		} else {
			System.out.println("Παρακαλώ εισάγετε μια έγκυρη επιλογή");
		}
		
		} while (choice<1 || choice>3);
	
	}
}
