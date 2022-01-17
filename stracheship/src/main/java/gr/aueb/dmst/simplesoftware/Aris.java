package stracheship.src.main.java.gr.aueb.dmst.simplesoftware;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Class Aris
public class Aris extends JFrame implements ActionListener {
     
	 // Limit for attack and defense
	 public static int[] RIVAL_MOVES = {1,2}; 
	
	 // Defense Sound
	 static File metal = new File("stracheship/src/main/java/gr/aueb/dmst/simplesoftware/Metal.wav");

     // Click Sound.
     static File click = new File("stracheship/src/main/java/gr/aueb/dmst/simplesoftware/click.wav");

     //Logo Symbol.
	static ImageIcon logo = new ImageIcon("stracheship/src/main/java/gr/aueb/dmst/simplesoftware/logo.png");

	 
	 // Helpful var for defense 
	 static int x;
	
	 // Some components
	 JButton buttonA;
     JButton buttonD;
     JButton errorD;
     JTextField textField;
     JFrame frame;
     JFrame erFrame;
     
     // Frame for defense
     // Choose a ship to armor
     public void insertDataD() {
     	 frame = new JFrame("CHOOSE A SHIP");
         frame.setIconImage(logo.getImage());
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         frame.setLocation(650, 455);
         frame.setResizable(false);
         
         JPanel pn = new JPanel();
         
         // Exit frame and armor the ship
         buttonD = new JButton("ARMOR!");
         buttonD.addActionListener(this);
         buttonD.setBackground(Color.GREEN);
         buttonD.setForeground(Color.BLACK);
         buttonD.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
         
         // Choose the ship here 
         textField = new JTextField();
         textField.setPreferredSize(new Dimension(250,40));
         textField.setFont(new Font("Consolas",Font.BOLD, 25));

         pn.add(buttonD);
         pn.add(textField);
         frame.add(pn);
         frame.setVisible(true);
         frame.pack();

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
     
     // Use the attack on Deck deck (no choice required)
     public void useAttack(Deck deck) {
    	 // Find the player and damage the opponent 
    	 if (Game.gameState == 1) {
    		 
    		 for (int i = 5; i < 10; i++) {
    			 
    			Ship2 ship = Ship2.shipsList.get(i);
    			
    			for (int j = 0; j < ship.getSize(); j++) {
    				
    				if (deck.deck_arr[ship.xy[j][0]][ship.xy[j][1]] == "S") {
    					
    					deck.deck_arr[ship.xy[j][0]][ship.xy[j][1]] = "X";
    				    break;
    				
    				} else if (deck.deck_arr[ship.xy[j][0]][ship.xy[j][1]] == "A") {
    					
    					deck.deck_arr[ship.xy[j][0]][ship.xy[j][1]] = "S";
    				    break;
    				}
    			}
    		 }
    	 
    	 } else if (Game.gameState == 2) {
    		 for (int i = 0; i < 5; i++) {
    			 
     			Ship2 ship = Ship2.shipsList.get(i);
     			
     			for (int j = 0; j < ship.getSize(); j++) {
     				
     				if (deck.deck_arr[ship.xy[j][0]][ship.xy[j][1]] == "S") {
     					
     					deck.deck_arr[ship.xy[j][0]][ship.xy[j][1]] = "X";
     				    break;
     				
     				} else if (deck.deck_arr[ship.xy[j][0]][ship.xy[j][1]] == "A") {
     					
     					deck.deck_arr[ship.xy[j][0]][ship.xy[j][1]] = "S";
     				    break;
     				}
     			}
     		 }
    		 
    	 }
     }
     
     // Use defense (armor) at ship obj from Deck deck
     public void useDefence(Ship2 obj, Deck deck) throws Exception{
        // Check if the ship has already sunk.
        if (obj.getTolerance()==0){
            throw new Exception();
        }
        Bsound.Sound(metal);
    	 for (int i = 0; i < obj.getSize(); i++) {
 			
 			if (deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]].equals("S") ) {
 				
 				deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] = "A";
 			
 			}
	       
	     }
    	 
    	 
     }
     
     // All buttons function
     @Override
     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == buttonD) {
            
        	 
            try {
                 // Get the choice and turn it to int
                String answer = textField.getText();
                x = Integer.parseInt(answer);
                
                frame.setVisible(false);
                
                if( (x > 5) || (x < 1)){
					throw new IndexOutOfBoundsException();
				}
                // Find the right player
                if (Game.gameState == 1) {
                
                    useDefence(Ship2.shipsList.get(x - 1) , MenuInterface.Deck1);
                
                } else if (Game.gameState == 2) {
                
                    useDefence(Ship2.shipsList.get(x + 4) , MenuInterface.Deck2);
                }    
            } catch (NumberFormatException ex) {
                frame.setVisible(false);
				errorBox("Please enter a number.");
            } catch (IndexOutOfBoundsException ex) {
                frame.setVisible(false);
				errorBox("Please enter a number from 1 to 5.");
            }catch (Exception ex) {
                frame.setVisible(false);
				errorBox("This ship has already sunk.");
            }
             
        }else if (e.getSource() == errorD) {
			Bsound.Sound(click);
			
			erFrame.setVisible(false);
			insertDataD();
	    	
		}

     }
	
     public void errorBox(String mess ){
        erFrame = new JFrame("Error!!!");
        erFrame.setIconImage(logo.getImage());
        erFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        erFrame.setLayout(new FlowLayout());
        erFrame.setLocation(650, 455);
        erFrame.setResizable(false);
        JPanel pn = new JPanel();

        JLabel message = new JLabel(mess);
        message.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));

        errorD = new JButton("OK");
        errorD.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        errorD.addActionListener(this);
        pn.add(errorD);

        pn.add(message);
        erFrame.add(pn);
        erFrame.setVisible(true);
        erFrame.pack();		
    }
}
