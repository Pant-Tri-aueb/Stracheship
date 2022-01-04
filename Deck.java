import java.util.ArrayList;
import java.util.List;

// Class to create and edit 10x10 arrays 
public class Deck {

	// String 10x10 array
    public String[][] deck_arr = new String[10][10];
    String player_name;

    // Constructor
    public Deck() {  
        DeckInitialization();
    }
       
    // Place ship (with check)
    public void shipPlacement(int x,int y,int size,String direction) {
        // X, Y coordinates from 1-10
        // ship size and direction either horizontal or vertical
        boolean check = ShipCheckOveral(x, y, size, direction);
        int i;
        int counter = 1;
        if (check == true) {
        	switch (counter) {
        	  case 1:
        		  Ship2 pl11 = new Ship2(x,y,size,direction);
        	    break;
        	  case 2:
        		  Ship2 pl12 = new Ship2(x,y,size,direction);
        	  case 3:
        		  Ship2 pl13 = new Ship2(x,y,size,direction);
        	    break;
        	  case 4:
        		  Ship2 pl14 = new Ship2(x,y,size,direction);
        	    break;
        	  case 5:
        		  Ship2 pl15 = new Ship2(x,y,size,direction);
        	    break;
        	}
        	counter++;
            
        	// Placement 
        	if(direction.equals("DOWN")) {
                for (i = x ; i < size + x ; i++){
                    this.deck_arr[i-1][y-1] = "S";
                }
            } else if (direction.equals("RIGHT")) {
                for (i = y ; i < size + y ; i++){
                    this.deck_arr[x-1][i-1] = "S";
                }  
            }
        }
    }

    // 10x10 array init
    public void DeckInitialization() { 

        for(int i=0 ; i<10 ; i++) {
            for(int j=0 ; j<10 ; j++) {
                this.deck_arr[i][j] = "O";
            }
        }
    }

    // Check out of bounds ship placement
    public boolean ShipOutOfDeckCheck(int x, int y, int size, String direction) {
        boolean checkship = true;
        if ((x > 10) || (y > 10)) {
            
        	checkship = false;
        } else if (((direction.equals("RIGHT")) && (y + size - 1 > 10)) || ((direction.equals("DOWN")) && (x + size - 1 > 10))) {
         
            checkship = false;
        }
        return checkship;
    }
    
    // Check ship placement on another ship
    public boolean ShipOnShipCheck(int x, int y, int size, String direction) {
        int i;
        boolean checkship = true;
        try {
            if (direction.equals("RIGHT")) {
                for (i = y ; i < size + y ; i++){
                    if (this.deck_arr[x-1][i-1] == "S") {
                	     checkship = false;
                	     
                    }
                }
             } else if (direction.equals("DOWN")) {
                 for (i = x ; i < size + x ; i++){
                     if (this.deck_arr[i-1][y-1] == "S") {
                         checkship = false;
                        
                     }
                 }
             } 
         return checkship;
        } catch (Exception e) {
        	checkship = false;
        	return checkship;
        }
    
    }
    
    // Combine ShipOutOfDeck and ShipOnShip check 
    public boolean ShipCheckOveral(int x, int y, int size, String direction) {
        boolean finalcheck = false;
        boolean flag1;
        boolean flag2;
        final String RIGHT = "RIGHT";
        final String DOWN = "DOWN";
        if (direction.equals(RIGHT)) {
            flag1 = ShipOutOfDeckCheck(x, y, size, RIGHT);
            flag2 = ShipOnShipCheck(x, y, size, RIGHT);
            if ((flag1 == true) && (flag2 == true)) {
            	finalcheck = true;
            }
        } else if (direction.equals(DOWN)) {
            flag1 = ShipOutOfDeckCheck(x, y, size, DOWN);
            flag2 = ShipOnShipCheck(x, y, size, DOWN);
            if ((flag1 == true) && (flag2 == true)) {
            	finalcheck = true;
            }
        }
        return finalcheck;
    }

    // Helpful method for GUIWINNER
    public void setPlayerName(String player_name) {
        this.player_name = player_name;
    }

    //Checks if the box is empty or not, return true if there is a ship.
    public boolean checkSpecificBox(int x,int y){
        if(deck_arr[x][y]=="S"){
            return true;
        }
        return false;
    }

    // Check for the winner
    public boolean checkWinner() {
        boolean result = true;
    	
    	for (int i = 0; i < 10; i++) {
	    	   for (int j = 0; j < 10; j++) {
	    	       
	    		   if ((deck_arr[i][j].equals("S")) || (deck_arr[i][j].equals("X")) ||
                         (deck_arr[i][j].equals("U")) || (deck_arr[i][j].equals("A"))) {
	    			   
	    			    result = false;
	    		   }
	    	   }
	      }
        
        return result; 
    }

    // Get winner name
    public static String getWinnerName() {
           
    	if (MenuInterface.Deck1.checkWinner() == true) {
    	     
    		return MenuInterface.player2.getName();
       
        } else {
        	
        	return MenuInterface.player1.getName();
        }
        
    }
}
   
