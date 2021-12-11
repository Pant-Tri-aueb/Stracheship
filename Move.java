import java.util.ArrayList;
import java.util.List;

public class Move {
	
	int i;
	int x;
	int y;
	int size;
	String direction; 
	
	public void moveRight(int i, Deck deck) {
		i = i - 1;
		x = Ship2.shipsList.get(i).getX();
		y = Ship2.shipsList.get(i).getY();
		size = Ship2.shipsList.get(i).getSize();
		direction = Ship2.shipsList.get(i).getDirection();
		
		if (direction.equals("RIGHT") ) {
			if (y + size - 1 <= 9) {
				deck.deck_arr[x-1][y-1] = "O";
				deck.deck_arr[x-1][y+size-1] = "S";
				Ship2.shipsList.get(i).setY(y+1);
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveLeft(int i, Deck deck) {
		i = i - 1;
		x = Ship2.shipsList.get(i).getX();
		y = Ship2.shipsList.get(i).getY();
		size = Ship2.shipsList.get(i).getSize();
		direction = Ship2.shipsList.get(i).getDirection();
		
		if (direction.equals("RIGHT") ) {
			if (y > 1) {
				deck.deck_arr[x-1][y+size-1-1] = "O";
				deck.deck_arr[x-1][y-1-1] = "S";
				Ship2.shipsList.get(i).setY(y-1);
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveUp(int i, Deck deck) {
		i = i-1;
		x = Ship2.shipsList.get(i).getX();
		y = Ship2.shipsList.get(i).getY();
		size = Ship2.shipsList.get(i).getSize();
		direction = Ship2.shipsList.get(i).getDirection();
		
		if (direction.equals("DOWN") ) {
			if (x > 1) {
				deck.deck_arr[x+size-1-1][y-1] = "O";
				deck.deck_arr[x-1-1][y-1] = "S";
				Ship2.shipsList.get(i).setX(x-1);
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveDown(int i, Deck deck) {
		i = i-1;
		x = Ship2.shipsList.get(i).getX();
		y = Ship2.shipsList.get(i).getY();
		size = Ship2.shipsList.get(i).getSize();
		direction = Ship2.shipsList.get(i).getDirection();
		
		if (direction.equals("DOWN") ) {
			if (x + size - 1 <= 9) {
				deck.deck_arr[x-1][y-1] = "O";
				deck.deck_arr[x+size-1][y-1] = "S";
				Ship2.shipsList.get(i).setX(x+1);
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
}
