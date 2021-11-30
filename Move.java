import java.util.ArrayList;
import java.util.List;

public class Move {
	
	Deck boat = new Deck();
	//
	int i;
	int x;
	int y;
	int size;
	String direction;
	
	public void moveRight(int x, int y, int size, String direction) {
		//x = boat.ploia.get(i).getX();
		//y = boat.ploia.get(i).getSize();
		//size = boat.ploia.get(i).getSize();
		//direction = boat.ploia.get(i).getDirection();
		
		if (direction.equals("RIGHT") ) {
			if (y + size - 1 <= 9) {
				MenuInterface.Deck1.deck_arr[x][y] = "O";
				MenuInterface.Deck1.deck_arr[x][y+size] = "S";
				//boat.ploia.get(i).setY(y+1);
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveLeft(int i) {
		i = i-1;
		x = boat.ploia.get(i).getX();
		y = boat.ploia.get(i).getY();
		size = boat.ploia.get(i).getSize();
		direction = boat.ploia.get(i).getDirection();
		
		if (direction.equals("RIGHT") ) {
			if (y > 1) {
				MenuInterface.Deck1.deck_arr[x][y+size-1] = "O";
				MenuInterface.Deck1.deck_arr[x][y-1] = "S";
				boat.ploia.get(i).setY(y-1);
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveUp(int i) {
		i = i-1;
		x = boat.ploia.get(i).getX();
		y = boat.ploia.get(i).getY();
		size = boat.ploia.get(i).getSize();
		direction = boat.ploia.get(i).getDirection();
		
		if (direction.equals("DOWN") ) {
			if (x > 1) {
				MenuInterface.Deck1.deck_arr[x+size-1][y] = "O";
				MenuInterface.Deck1.deck_arr[x-1][y] = "S";
				boat.ploia.get(i).setX(x-1);
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
	
	public void moveDown(int i) {
		i = i-1;
		x = boat.ploia.get(i).getX();
		y = boat.ploia.get(i).getY();
		size = boat.ploia.get(i).getSize();
		direction = boat.ploia.get(i).getDirection();
		
		if (direction.equals("DOWN") ) {
			if (x + size - 1 <= 9) {
				MenuInterface.Deck1.deck_arr[x][y] = "O";
				MenuInterface.Deck1.deck_arr[x+size][y] = "S";
				boat.ploia.get(i).setX(x+1);
			} else {
				System.out.println("Δεν επιτρέπεται!");
			}
			
		}
	}
}
