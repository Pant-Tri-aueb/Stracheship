import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

// Artemis Class
public class Artemis extends JFrame implements ActionListener {

	     // Limit for attack and defense
    	 public static int[] RIVAL_MOVES = {2,2};
    	 
    	 // Attack sound
    	 static File arrows = new File("Arrow.wav");
    	 static File heal = new File("Heal.wav");
    	 
    	 // Helpful var for attack
    	 static int x;
    	
    	// Some components    
        JButton buttonA;
        JButton buttonD;
        JTextField textField;
        JFrame frame;
        
        // Frame for the attack
        // Choose a row to inflict damage
        public void insertDataA() {
        	frame = new JFrame("CHOOSE A ROW");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            
            JPanel pn = new JPanel();
            
            // Button to close frame and attack
            buttonA = new JButton("LOOSE!");
            buttonA.addActionListener(this);
            buttonA.setBackground(Color.RED);
            buttonA.setForeground(Color.BLACK);
            buttonA.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
            
            // Choose row here
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
        // Choose a ship for healing
        public void insertDataD() {
        	frame = new JFrame("CHOOSE A SHIP");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            
            JPanel pn = new JPanel();
          
            // Exit frame and heal ship
            buttonD = new JButton("HEAL!");
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
       
        // All button's function 
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buttonA) {
              
               Bsound.Sound(arrows);
               
               // Get the choice and turn it to int
               String answer = textField.getText();
               x = Integer.parseInt(answer);
               
               frame.setVisible(false);
               
               // Find which player is currently playing and launch the attack
               if (Game.gameState == 1) {
            	   
            	   throwArrow(MenuInterface.Deck2);
            	   
               } else {
            	   
            	   throwArrow(MenuInterface.Deck1);
               }
               
             } else if (e.getSource() == buttonD) {
                Bsound.Sound(heal); 
                
                String answer = textField.getText();
                
                // Get the choice and turn it to int
                x = Integer.parseInt(answer);
                frame.setVisible(false);
                
                // Find which player is currently playing and use defense
                if (Game.gameState == 1) {
             	   
             	   useDefence(Ship2.shipsList.get(x - 1) , MenuInterface.Deck1);
             	   
                } else if (Game.gameState == 2) {
             	   
                   useDefence(Ship2.shipsList.get(x + 4) , MenuInterface.Deck2);
                }
                
            }
        }
        
        
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

	    // Use defense at ship obj from Deck deck
	    public void useDefence(Ship2 obj,Deck deck) { 
	       
	    	  for (int i = 0; i < obj.getSize(); i++) {
    			
    			if (deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] == "X" ) {
    				
    				deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] = "S";
    			}
	       
	    	   
	       
              }
	    	  
	    	  MenuInterface.runGame.sea();
	    }

	    // Use the attack at Deck deck
	    public void throwArrow(Deck deck) {
	       
	       for (int y = 0; y < 10; y ++) {
	        	if (deck.deck_arr[x - 1][y] == "S") {
	    	            
	        		deck.deck_arr[x - 1][y] = "X";
	    	        	
	        	} else if (deck.deck_arr[x - 1][y] == "A") {
	    	            
	        		deck.deck_arr[x - 1][y] = "S";
	    	        	
	        	}
	        }
	      
	    
	    }

    }
