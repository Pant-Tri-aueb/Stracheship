import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Class for every ship
public class Ship2 {

	// Useful ArrayList that holds all 10 ships in the game as Ship2 objects
	// First 5 (0-4) belong to the first player
	// The rest 5 (5-9) belong to the second
    static ArrayList<Ship2> shipsList = new ArrayList<Ship2>(10);
	
    // Useful counter
	public static int Shipcounter = 0;
	
	// Ship data 
	private int ShipNumber;
    private int tolerance;
    private int x;
    private int y;
    private int size;
    // Useful 2-dim array that holds each ship coordinates
    // (X,Y for every block) 
    // 4 rows for the maximun size of a ship which is 4
    // 2 columns, one for the x coordinate and one for the y
    // Know where a particular ship is, anytime 
    public int[][] xy = new int[4][2]; 
    private String direction;

    // Constructor
    public Ship2(int x, int y, int size, String direction) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.direction = direction;
        this.tolerance = size;
        this.ShipNumber = Shipcounter + 1;
        
        // Init xy array for ship coordinates
        this.xy[0][0] = x - 1;
        this.xy[0][1] = y - 1;
        
        // Different way for each direction
        if (this.direction.equals("DOWN")) {    
        
        	for(int i = 1; i < this.size; i++) {
        	    
        		this.xy[i][0] = (x - 1) + i;
        	    this.xy[i][1] = y - 1; 
        	}
        
        } else if (this.direction.equals("RIGHT")) {
            
        	for(int i = 1; i < this.size; i++) {
        	    
        		this.xy[i][0] = x - 1;
        	    this.xy[i][1] = (y - 1) + i;
        	}
        }
    }
    
    // Another constructor
    public Ship2() {
    	
    }

    // Update a specific ship's tolerance by searching 
    // 10x10 array from Deck deck
    public void updateTolerance(Deck deck) {
    	this.tolerance = 0;
    	
    	for (int i = 0; i < this.size; i++) {
    			
    			if (deck.deck_arr[this.xy[i][0]][this.xy[i][1]] == "S" ) {
    				tolerance++;
    				
    			} else if (deck.deck_arr[this.xy[i][0]][this.xy[i][1]] == "A") {
    				
    				tolerance += 2;
                
    			} else if (deck.deck_arr[this.xy[i][0]][this.xy[i][1]] == "U") {

                    tolerance += 1000;
                }
    		
        }
    }
    
    // Method to check whether a specific ship is sinked or not 
    // for the first player
    public boolean isDestroyed1() {
    	boolean result = true;
    	
    	for (int i = 0; i < this.size; i++) {
    		
    		if (MenuInterface.Deck1.deck_arr[xy[i][0]][xy[i][1]].equals("S") || 
    				MenuInterface.Deck1.deck_arr[xy[i][0]][xy[i][1]].equals("A") || 
    				MenuInterface.Deck1.deck_arr[xy[i][0]][xy[i][1]].equals("U")) {
    			
    			result = false;
    		}
    		
    	}
    	
    	return result;
    }
    // Method to check whether a specific ship is sinked or not 
    // for the second player
    public boolean isDestroyed2() {
	    boolean result = true;
        
	    for (int i = 0; i < this.size; i++) {
	       
	    	if (MenuInterface.Deck2.deck_arr[xy[i][0]][xy[i][1]].equals("S") || 
	    			MenuInterface.Deck2.deck_arr[xy[i][0]][xy[i][1]].equals("A") || 
    				MenuInterface.Deck2.deck_arr[xy[i][0]][xy[i][1]].equals("U")) {
              
	        	result = false;
            }
        }
        
	    return result;
    }
    
    // Getters and Setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getSize() {
        return size;
    }
    
    public String getDirection() {
        return direction;
    }
    
    public int getTolerance() {
        return tolerance;
    }

    public void setTolerance(int tolerance) {
        this.tolerance = tolerance;
    }

	public int getShipNumber() {
		return ShipNumber;
	}

	public void setShipNumber(int shipNumber) {
		ShipNumber = shipNumber;
	}

    
}
