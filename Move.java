import java.util.ArrayList;
import java.util.List;

public class Move {
	
	int i;
	int x;
	int y;
	int size;
	String direction; 
	
	public void moveRight(int i, Deck deck) {
		i = i-1;
		Ship2 ship = Ship2.shipsList.get(i) ;
		x = ship.xy[0][0];
		y = ship.xy[0][1];
		size = ship.getSize();
		direction = ship.getDirection();
		
		if (direction.equals("RIGHT") ) {
			if (y + size - 1 <= 9) {
				int[][] array = new int[4][2];
				   Deck mydeck = new Deck();
				   
				   for (int j = 0; j < size; j++) {	
					    array[j][0] = ship.xy[j][0];
					    array[j][1] = ship.xy[j][1];
						
				   }
				   
				   for (int j = 0; j < size; j++) {
					   mydeck.deck_arr[array[j][0]][array[j][1]] = deck.deck_arr[array[j][0]][array[j][1]]; 
				   }
					
				   
				   for (int j = 0; j < size; j++) {
						deck.deck_arr[ship.xy[j][0]][ship.xy[j][1] + 1] = 
								mydeck.deck_arr[array[j][0]][array[j][1]];
					
					}
				   deck.deck_arr[ship.xy[0][0]][ship.xy[0][1]] = "O";
					
					for (int j = 0; j < size; j++) {
						ship.xy[j][1] += 1;
					}
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveLeft(int i, Deck deck) {
		i = i-1;
		Ship2 ship = Ship2.shipsList.get(i) ;
		x = ship.xy[0][0];
		y = ship.xy[0][1];
		size = ship.getSize();
		direction = ship.getDirection();
		
		
		if (direction.equals("RIGHT") ) {
			if (y > 0) {
				int[][] array = new int[4][2];
				   Deck mydeck = new Deck();
				   
				   for (int j = 0; j < size; j++) {	
					    array[j][0] = ship.xy[j][0];
					    array[j][1] = ship.xy[j][1];
						
				   }
				   
				   for (int j = 0; j < size; j++) {
					   mydeck.deck_arr[array[j][0]][array[j][1]] = deck.deck_arr[array[j][0]][array[j][1]]; 
				   }
					
				   
				   for (int j = 0; j < size; j++) {
						deck.deck_arr[ship.xy[j][0]][ship.xy[j][1] - 1] = 
								mydeck.deck_arr[array[j][0]][array[j][1]];
					
					}
					deck.deck_arr[ship.xy[0][0]][ship.xy[size - 1][1]] = "O";
					
					for (int j = 0; j < size; j++) {
						ship.xy[j][1] -= 1;
					}
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveUp(int i, Deck deck) {
		i = i-1;
		Ship2 ship = Ship2.shipsList.get(i) ;
		x = ship.xy[0][0];
		y = ship.xy[0][1];
		size = ship.getSize();
		direction = ship.getDirection();
		
		if (direction.equals("DOWN") ) {
			if (x > 0) {
				
				int[][] array = new int[4][2];
				   Deck mydeck = new Deck();
				   
				   for (int j = 0; j < size; j++) {	
					    array[j][0] = ship.xy[j][0];
					    array[j][1] = ship.xy[j][1];
						
				   }
				   
				   for (int j = 0; j < size; j++) {
					   mydeck.deck_arr[array[j][0]][array[j][1]] = deck.deck_arr[array[j][0]][array[j][1]]; 
				   }
					
				   
				   for (int j = 0; j < size; j++) {
						deck.deck_arr[ship.xy[j][0] - 1][ship.xy[j][1]] = 
								mydeck.deck_arr[array[j][0]][array[j][1]];
					
					}
					deck.deck_arr[ship.xy[size - 1][0]][ship.xy[0][1]] = "O";
					
					for (int j = 0; j < size; j++) {
						ship.xy[j][0] -= 1;
					}
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveDown(int i, Deck deck) {
		i = i-1;
		Ship2 ship = Ship2.shipsList.get(i) ;
		x = ship.xy[0][0];
		y = ship.xy[0][1];
		size = ship.getSize();
		direction = ship.getDirection();
		
		if (direction.equals("DOWN") ) {
			if (x + size - 1 <= 9) {
				
			   int[][] array = new int[4][2];
			   Deck mydeck = new Deck();
			   
			   for (int j = 0; j < size; j++) {	
				    array[j][0] = ship.xy[j][0];
				    array[j][1] = ship.xy[j][1];
					
			   }
			   
			   for (int j = 0; j < size; j++) {
				   mydeck.deck_arr[array[j][0]][array[j][1]] = deck.deck_arr[array[j][0]][array[j][1]]; 
			   }
				
			   
			   for (int j = 0; j < size; j++) {
					deck.deck_arr[ship.xy[j][0] + 1][ship.xy[j][1]] = 
							mydeck.deck_arr[array[j][0]][array[j][1]];
				
				}
				deck.deck_arr[ship.xy[0][0]][ship.xy[0][1]] = "O";
				
				for (int j = 0; j < size; j++) {
					ship.xy[j][0] += 1;
				}
				
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
}
