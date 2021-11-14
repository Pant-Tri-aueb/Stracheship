import java.util.Scanner;

public class Game{
    public void printInstructions() {
    	System.out.println("Εδώ αναλυτικά θα γραφτούν οι οδηγίες του παιχνιδιού");
    }
    
    public void startGame() {
    	Deck start = new Deck();
    	start.PrintArray();
    	
    	int x,y,size;
    	
    	for (int i = 1; i <= 4; i++) {
    		System.out.print("Δώστε x,y,size,κατεύθυνση:");
    		Scanner sc= new Scanner(System.in);
    		Scanner scs= new Scanner(System.in);
    		x = sc.nextInt();
    		y = sc.nextInt();
    		size = sc.nextInt();
    		String direction = scs.nextLine();
		
    		start.shipPlacement(x, y, size, direction);

    		start.PrintArray();
    	
    	}
    }
}
