import java.util.Scanner;

public class Game {
    public void printInstructions() {
    	System.out.println("Εδώ αναλυτικά θα γραφτούν οι οδηγίες του παιχνιδιού");
    }
    
	public void startGame() {
    	Deck first_deck = new Deck();
    	first_deck.PrintArray();
    	PlayerPlacesShip(first_deck);	
    }

	//Η μεθοδο αυτη προσομοιωνει την τοποθετηση ενος διπλου, δυο τριπλων και 2 τετραπλων πλοιων. Η μεθοδο αυτη τελειωνει μολις τοποθετηθουν και τα 5 πλοια.
	public void PlayerPlacesShip (Deck deck) {
		int x,y,size;
		int counter = 1;
		int size_counter = 2;
		do { 
				System.out.print("Δώστε x,y,κατεύθυνση για το πλοίο " + size_counter +" θέσεων:");
				size = size_counter;
				Scanner sc= new Scanner(System.in);
    			Scanner scs= new Scanner(System.in);
    			x = sc.nextInt();
    			y = sc.nextInt();
				String direction = scs.nextLine();
				if (deck.ShipCheckOveral(x, y, size, direction) == true) {
					deck.shipPlacement(x, y, size, direction);
					deck.PrintArray();
					if (counter == 1) {
						size_counter = 3;
					} else if (counter == 3) {
						size_counter = 4;
					}
					counter ++; 
				}
		} while (counter < 6);
	}
}
