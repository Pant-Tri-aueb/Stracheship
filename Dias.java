import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Class Dias
public class Dias extends JFrame implements ActionListener {

	// Limit for attack and defense
	public static int[] RIVAL_MOVES = {1,2};
	
	// Attack sound
	static File thunder = new File("L.wav");
	static File resurrect = new File("Resurrect.wav");
	static File click = new File("click.wav");
	
	// Some components
	JButton errorA;
	JButton errorD;
	JButton buttonA;
    JButton buttonD;
    
    JTextField textField;
    
    JFrame frame;
	JFrame errorFrame;
	
	// Check for attack (index = 0) or defense (index = 1) limit
	public static boolean capacity(int index) {
        boolean available = true;
    	
        if (RIVAL_MOVES[index] > 0) {
        	available = true;
        	
        } else {
        	
        	available = false;
        }
        
        return available;        
            
       
     }
	
	 // Frame for the attack
     // Choose a ship to inflict damage
	 public void insertDataA() {
     	 frame = new JFrame("CHOOSE A SHIP");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         
         JPanel pn = new JPanel();
         
         // Exit and attack
         buttonA = new JButton("LIGHTNING!");
         buttonA.addActionListener(this);
         buttonA.setBackground(Color.RED);
         buttonA.setForeground(Color.BLACK);
         buttonA.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
         
         // Choose ship here
         textField = new JTextField();
         textField.setPreferredSize(new Dimension(250,40));
         textField.setFont(new Font("Consolas",Font.BOLD, 25));
         
         pn.add(buttonA);
         pn.add(textField);
         frame.add(pn);
         frame.setVisible(true);
         frame.pack();

     }
	 
	 // Frame for defense
     // Choose a ship to resurrect
	 public void insertDataD() {
     	 frame = new JFrame("CHOOSE A SHIP");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         
         JPanel pn = new JPanel();
         
         // Exit and attack
         buttonD = new JButton("RESURRECT!");
         buttonD.addActionListener(this);
         buttonD.setBackground(Color.GREEN);
         buttonD.setForeground(Color.BLACK);
         buttonD.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
         
         // Choose ship here
         textField = new JTextField();
         textField.setPreferredSize(new Dimension(250,40));
         textField.setFont(new Font("Consolas",Font.BOLD, 25));


         pn.add(buttonD);
         pn.add(textField);
         frame.add(pn);
         frame.setVisible(true);
         frame.pack();

     }
	  
	 // In case a sinked ship has been chosen
	 public void errorA() {
	 		
			errorFrame = new JFrame("Error");
	        errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        errorFrame.setLayout(new FlowLayout());
	        JPanel pn = new JPanel();
	        
	        JLabel message = new JLabel("Ship is already sinked!");
	        message.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	        
	        errorA = new JButton("OK");
	        errorA.addActionListener(this);
	       
	        pn.add(errorA);
	        pn.add(message);
	        
	        errorFrame.add(pn);
	        errorFrame.setVisible(true);
	        errorFrame.pack();
	  }
	 
	  // In case a non-sinked ship has been chosen for resurrection
	  public void errorD() {
	 		
			errorFrame = new JFrame("Error");
	        errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        errorFrame.setLayout(new FlowLayout());
	        JPanel pn = new JPanel();
	        
	        JLabel message = new JLabel("Ship is not sinked yet!");
	        
	        errorD = new JButton("OK");
	        errorD.addActionListener(this);
	       
	        pn.add(errorD);
	        pn.add(message);
	        
	        errorFrame.add(pn);
	        errorFrame.setVisible(true);
	        errorFrame.pack();
		}
	
	 // Attack method at ship number: shipNo 
	 public void strike(int shipNo) {
		
		// Find the right ship 
		Ship2 ship;
		if (Game.gameState == 1) {
			 
	        ship = Ship2.shipsList.get(shipNo - 1);
		
		} else {
			
		    ship = Ship2.shipsList.get(shipNo - 1);
		}
		  
		
		// Check whether the ship is small or normal sized
		// If so, destroy it
		if (ship.getTolerance() > 0 && (ship.getSize() == 2 || ship.getSize() == 3)) {
			// Find player
			if (Game.gameState == 1) {
				for (int i = 0; i < ship.getSize(); i++) {
					if (MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] != "U" ) {

						MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "X";
					
					}
				}
			
			} else {
                for (int i = 0; i < ship.getSize(); i++) {
					
					if (MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] != "U" ) {

						MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "X";
					
					}
				}
			}
			
		// In case the ship is large sized, do not destroy it 
		// Inflict 3 blocks of damage 
		} else if (ship.getTolerance() > 0 && ship.getSize() == 4) {
			// Find player
			if (Game.gameState == 1) {
				for (int i = 0; i < ship.getSize() - 1; i++) {
					
					if (MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] != "U" ) {

						MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "X";
					
					}
				}
			
			} else {
                for (int i = 0; i < ship.getSize() - 1; i++) {
					
					if (MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] != "U" ) {

						MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "X";
					
					}
				}
			}
			
		// Chech if the ship is already sinked
	    // and drop error message
		} else if (ship.getTolerance() == 0) {
			
			errorA();
		}
        	
	}
   
	// Bring back ship number: shipNo
	public void resurrection(int shipNo) {
		
		Ship2 ship = Ship2.shipsList.get(shipNo - 1);
		
		// Ship is sinked
		if (ship.getTolerance() == 0) {
			
			ship.setTolerance(ship.getSize());
			
			// Get size and place the ship back to its last position correctly
			if (ship.getDirection().equals("DOWN")) {
				for (int i = 0; i < ship.getSize(); i++) {
					
					// Find player
					if (Game.gameState == 1) {
						
						MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
					
					} else if (Game.gameState == 2) {
						
						MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
						
					}
					
				}

			} else if (ship.getDirection().equals("RIGHT")) {
				for (int i = 0; i < ship.getSize(); i++) {
					
					// Find player
					if (Game.gameState == 1) {
						
						MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
					
					} else if (Game.gameState == 2) {
						
						MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
						
					}
					
				}
			}
			
			MenuInterface.runGame.sea();		
		
	    // The ship is not sinked yet
	    // Drop error message
		} else {
			
		    errorD();
		}
	}

	// All buttons function
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonA) {
            
			Bsound.Sound(thunder);
			
			// Get choice and turn it to int
			String answer = textField.getText();
            int x = Integer.parseInt(answer);
            
            frame.setVisible(false);
            // Find player and strike
            if (Game.gameState == 1) {
         	   
         	   strike(x + 5);
         	   
            } else {
         	   
         	   strike(x);
            
            }
            
		} else if (e.getSource() == buttonD) {
			Bsound.Sound(resurrect);
			
			// Get choice and turn it to int
			String answer = textField.getText();
			int x = Integer.parseInt(answer);
			
			frame.setVisible(false);
			// Find player and use defense
			if (Game.gameState == 1) {
	         	   
	         	   resurrection(x);
	         	   
	            } else {
	         	   
	         	   resurrection(x + 5);
	            
	            }
	            
		// Exit error frames	
		} else if (e.getSource() == errorA) {
			Bsound.Sound(click);
			
	    	errorFrame.setVisible(false);
	    	insertDataA();
	    
	    
		} else if (e.getSource() == errorD) {
			Bsound.Sound(click);
			
			errorFrame.setVisible(false);
			
	    	
		}
   }
}
