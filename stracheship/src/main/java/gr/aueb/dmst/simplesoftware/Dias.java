package stracheship.src.main.java.gr.aueb.dmst.simplesoftware;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;

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
	
	//Logo Symbol.
	static ImageIcon logo = new ImageIcon("logo.png");

	// Some components
	JButton errorA;
	JButton errorD;
	JButton buttonA;
    JButton buttonD;
    
    JTextField textField;
    
    JFrame frame;
	JFrame erFrame;
	
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
		 frame.setIconImage(logo.getImage());
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         frame.setLocation(300, 150);
         frame.setResizable(false);
         
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
         frame.setLocation(300, 150);
         frame.setResizable(false);
         
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
			//Use audio effect.
			Bsound.Sound(thunder);
			
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
			//Use audio effect.
			Bsound.Sound(thunder);
			
		// Chech if the ship is already sinked
	    // and drop error message
		} else if (ship.getTolerance() == 0) {
			
			errorBox("Ship has already sunk!", 1);
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
			Bsound.Sound(resurrect);
					
		
	    // The ship is not sinked yet
	    // Drop error message
		} else {
			
		    errorBox("Ship is not sunken yet!", 2);
		}
	}

	// All buttons function
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonA) {
            
			try {
				// Get choice and turn it to int
				String answer = textField.getText();
				int x = Integer.parseInt(answer);
				if( (x > 5) || (x < 1)){
					throw new Exception();
				}
				// Find player and strike
				if (Game.gameState == 1) {
				
				strike(x + 5);
				
				} else {
				
				strike(x);
				
            	}
				frame.setVisible(false);
				
			} catch (NullPointerException ex) {
				frame.setVisible(false);
				errorBox("Please enter a number.", 1);
			}catch(Exception ex){
				frame.setVisible(false);
				errorBox("Please enter a number from 1 to 5.", 1);
			}
			
            
		} else if (e.getSource() == buttonD) {
			
			try {
				// Get choice and turn it to int
				String answer = textField.getText();
				int x = Integer.parseInt(answer);
				if( (x > 5) || (x < 1)){
					throw new Exception();
				}
				
				// Find player and use defense
				if (Game.gameState == 1) {
					
					resurrection(x);
					
				} else {
					
					resurrection(x + 5);
					
				}
				frame.setVisible(false);
			}catch (NullPointerException ex) {
				frame.setVisible(false);
				errorBox("Please enter a number.", 2);
			}catch(Exception ex){
				frame.setVisible(false);
				errorBox("Please enter a number from 1 to 5.", 2);
			}
			
			
	            
		// Exit error frames	
		} else if (e.getSource() == errorA) {
			Bsound.Sound(click);
			
	    	erFrame.setVisible(false);
	    	insertDataA();
	    
	    
		} else if (e.getSource() == errorD) {
			Bsound.Sound(click);
			
			erFrame.setVisible(false);
			insertDataD();
	    	
		}
   }

	 public void errorBox(String mess , int buttonNumber){
			erFrame = new JFrame("Error!!!");
			erFrame.setIconImage(logo.getImage());
			erFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			erFrame.setLayout(new FlowLayout());
			erFrame.setLocation(650, 455);
			erFrame.setResizable(false);
			JPanel pn = new JPanel();

			JLabel message = new JLabel(mess);
			message.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));

			if (buttonNumber == 1){
				errorA = new JButton("OK");
				errorA.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
				errorA.addActionListener(this);
				pn.add(errorA);
			}else{
				errorD = new JButton("OK");
				errorD.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
				errorD.addActionListener(this);
				pn.add(errorD);
			}
			pn.add(message);
			erFrame.add(pn);
			erFrame.setVisible(true);
			erFrame.pack();		
		}
	    //Returns true if there is at least one shunken ship.
        // pla = player. 
        public static boolean checkShipsTolerance(int pla){
            if (pla == 1){
                for(int i=0 ; i <= 4; i++){
                   if( (Ship2.shipsList.get(i).getTolerance() == 0) ){
                        return true;
                   } 
                }
            }else{
                for(int i=5 ; i <= 9; i++){
                    if( (Ship2.shipsList.get(i).getTolerance() == 0)){
                        return true;
                    } 
                }
            }
            return false;
        }
}
