import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ship2 {

    static ArrayList<Ship2> shipsList = new ArrayList<Ship2>(10);
	
    
	public static int Shipcounter = 0;
	
	
	private int ShipNumber;
    private int capacity;
    private int tolerance;
    private int x;
    private int y;
    private int size;
    public int[][] xy = new int[4][2]; 
    private String direction;

   
    public Ship2(int x, int y, int size, String direction) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.direction = direction;
        this.ShipNumber = Shipcounter + 1;
        
        this.xy[0][0] = x - 1;
        this.xy[0][1] = y - 1;
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
    
    public Ship2() {
    	
    }

    public boolean isDestroyed1() {
    	boolean result = true;
    	
    	for (int i = 0; i < this.size; i++) {
    		
    		if (MenuInterface.Deck1.deck_arr[xy[i][0]][xy[i][1]] == "S") {
    			
    			result = false;
    		}
    		
    	}
    	
    	return result;
    }

    public boolean isDestroyed2() {
	    boolean result = true;
        
	    for (int i = 0; i < this.size; i++) {
	       
	    	if (MenuInterface.Deck2.deck_arr[xy[i][0]][xy[i][1]] == "S") {
              
	        	result = false;
            }
        }
        
	    return result;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
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
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
