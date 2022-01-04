import java.util.ArrayList;
import java.util.List;

// Class thats implements ship movement
public class Move {
	
	// Useful vars
	int i;
	int x;
	int y;
	int size;
	String direction; 
	
	// Move ship i from Deck deck one block to the right
	public void moveRight(int i, Deck deck) throws ArrayIndexOutOfBoundsException, Exception {
		
		// Find ship and init its coordinates on deck
		i = i-1;
		Ship2 ship = Ship2.shipsList.get(i) ;
		x = ship.xy[0][0];
		y = ship.xy[0][1];
		size = ship.getSize();
		direction = ship.getDirection();
		
		if (direction.equals("RIGHT") ) {
			if (y + size - 1 <= 9) {
				//cheks if the ship drop on other ship in case of moving.
				if(deck.checkSpecificBox(x, y + size)){
					throw new Exception();
				}
				   // init temp array from temp Deck
				   int[][] array = new int[4][2];
				   Deck mydeck = new Deck();
				   
				   // Copy ship.xy to temp array
				   for (int j = 0; j < size; j++) {	
					    array[j][0] = ship.xy[j][0];
					    array[j][1] = ship.xy[j][1];
						
				   }
				   
				   // Copy array from Deck to the temp Deck
				   for (int j = 0; j < size; j++) {
					   mydeck.deck_arr[array[j][0]][array[j][1]] = deck.deck_arr[array[j][0]][array[j][1]]; 
				   }
					
				   // Return ship to the original array but one block to the right
				   for (int j = 0; j < size; j++) {
						deck.deck_arr[ship.xy[j][0]][ship.xy[j][1] + 1] = 
								mydeck.deck_arr[array[j][0]][array[j][1]];
					
					}
				   
				   // Leave blue (sea) behind the ship 
				   deck.deck_arr[ship.xy[0][0]][ship.xy[0][1]] = "O";
					
				    // Update ship coordinates
					for (int j = 0; j < size; j++) {
						ship.xy[j][1] += 1;
					}
			} else {
				// Not allowed!
				throw new ArrayIndexOutOfBoundsException();
			}
			
		}
	}
	
	// Move ship i from Deck deck one block to the left
	public void moveLeft(int i, Deck deck) throws ArrayIndexOutOfBoundsException,Exception{
		
		// Find ship and init its coordinates on deck
		i = i-1;
		Ship2 ship = Ship2.shipsList.get(i) ;
		x = ship.xy[0][0];
		y = ship.xy[0][1];
		size = ship.getSize();
		direction = ship.getDirection();
		
		
		if (direction.equals("RIGHT") ) {
			if (y > 0) {
				//cheks if the ship drop on other ship in case of moving.
				if(deck.checkSpecificBox(x, y-1)){
					throw new Exception();
				}
				// init temp array from temp Deck
				int[][] array = new int[4][2];
				Deck mydeck = new Deck();
				   
				 // Copy ship.xy to temp array
				 for (int j = 0; j < size; j++) {	
					    array[j][0] = ship.xy[j][0];
					    array[j][1] = ship.xy[j][1];
						
				 }
				   // Copy array from Deck to the temp Deck
				   for (int j = 0; j < size; j++) {
					   mydeck.deck_arr[array[j][0]][array[j][1]] = deck.deck_arr[array[j][0]][array[j][1]]; 
				   }
					
				   // Return ship to the original array but one block to the right
				   for (int j = 0; j < size; j++) {
						deck.deck_arr[ship.xy[j][0]][ship.xy[j][1] - 1] = 
								mydeck.deck_arr[array[j][0]][array[j][1]];
					
					}
				    // Leave blue (sea) behind the ship 
					deck.deck_arr[ship.xy[0][0]][ship.xy[size - 1][1]] = "O";
					
					// Update ship coordinates
					for (int j = 0; j < size; j++) {
						ship.xy[j][1] -= 1;
					}
			} else {
				// Not allowed!
				throw new ArrayIndexOutOfBoundsException();
			}
			
		}
	}
	
	// Move ship i from Deck deck one block Up
	public void moveUp(int i, Deck deck) throws ArrayIndexOutOfBoundsException,Exception{
		
		// Find ship and init its coordinates on deck
		i = i-1;
		Ship2 ship = Ship2.shipsList.get(i) ;
		x = ship.xy[0][0];
		y = ship.xy[0][1];
		size = ship.getSize();
		direction = ship.getDirection();
		
		if (direction.equals("DOWN") ) {
			if (x > 0) {
				//cheks if the ship drop on other ship in case of moving.
				if(deck.checkSpecificBox(x-1, y)){
					throw new Exception();
				}
				// init temp array from temp Deck
				int[][] array = new int[4][2];
				   Deck mydeck = new Deck();
				   
				   // Copy ship.xy to temp array
				   for (int j = 0; j < size; j++) {	
					    array[j][0] = ship.xy[j][0];
					    array[j][1] = ship.xy[j][1];
						
				   }
				   // Copy array from Deck to the temp Deck
				   for (int j = 0; j < size; j++) {
					   mydeck.deck_arr[array[j][0]][array[j][1]] = deck.deck_arr[array[j][0]][array[j][1]]; 
				   }
					
				   // Return ship to the original array but one block to the right
				   for (int j = 0; j < size; j++) {
						deck.deck_arr[ship.xy[j][0] - 1][ship.xy[j][1]] = 
								mydeck.deck_arr[array[j][0]][array[j][1]];
					
					}
				    // Leave blue (sea) behind the ship 
					deck.deck_arr[ship.xy[size - 1][0]][ship.xy[0][1]] = "O";
					
					// Update ship coordinates
					for (int j = 0; j < size; j++) {
						ship.xy[j][0] -= 1;
					}
			} else {
				// Not allowed!
				throw new ArrayIndexOutOfBoundsException();
			}
			
		}
	}
	
	// Move ship i from Deck deck one block Down
	public void moveDown(int i, Deck deck) throws ArrayIndexOutOfBoundsException,Exception{
		
		// Find ship and init its coordinates on deck
		i = i-1;
		Ship2 ship = Ship2.shipsList.get(i) ;
		x = ship.xy[0][0];
		y = ship.xy[0][1];
		size = ship.getSize();
		direction = ship.getDirection();
		
		if (direction.equals("DOWN") ) {
			if (x + size - 1 <= 9) {
				//cheks if the ship drop on other ship in case of moving.
				if(deck.checkSpecificBox(x + size, y)){
					throw new Exception();
				}
			   // init temp array from temp Deck	
			   int[][] array = new int[4][2];
			   Deck mydeck = new Deck();
			   
			  // Copy ship.xy to temp array
			   for (int j = 0; j < size; j++) {	
				    array[j][0] = ship.xy[j][0];
				    array[j][1] = ship.xy[j][1];
					
			   }
			   // Copy array from Deck to the temp Deck
			   for (int j = 0; j < size; j++) {
				   mydeck.deck_arr[array[j][0]][array[j][1]] = deck.deck_arr[array[j][0]][array[j][1]]; 
			   }
				
			   // Return ship to the original array but one block to the right
			   for (int j = 0; j < size; j++) {
					deck.deck_arr[ship.xy[j][0] + 1][ship.xy[j][1]] = 
							mydeck.deck_arr[array[j][0]][array[j][1]];
				
				}
			    // Leave blue (sea) behind the ship 
				deck.deck_arr[ship.xy[0][0]][ship.xy[0][1]] = "O";
				
				// Update ship coordinates
				for (int j = 0; j < size; j++) {
					ship.xy[j][0] += 1;
				}
				
			} else {
				// Not allowed!
				throw new ArrayIndexOutOfBoundsException();
			}
			
		}
	}
}
