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
         static File click = new File("click.wav");

         //Logo Symbol.
	     static ImageIcon logo = new ImageIcon("logo.png");
    	 
    	 // Helpful var for attack
    	 static int x;
    	
    	// Some components    
        JButton buttonA;
        JButton buttonD;
        JButton errorA;
	    JButton errorD;
        JTextField textField;
       
        JFrame frame;
        JFrame erFrame;
        
        // Frame for the attack
        // Choose a row to inflict damage
        public void insertDataA() {
        	frame = new JFrame("CHOOSE A ROW");
            frame.setIconImage(logo.getImage());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.setLocation(300, 150);
            frame.setResizable(false);
            
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
            frame.setLocation(300, 150);
            frame.setResizable(false);
            
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
              
               

               try {
                    // Get the choice and turn it to int
                    String answer = textField.getText();
                    x = Integer.parseInt(answer);
                    if( (x > 10) || (x < 1)){
                        throw new Exception();
                    }
                    
                    // Find which player is currently playing and launch the attack
                    if (Game.gameState == 1) {
                        
                        throwArrow(MenuInterface.Deck2);
                        
                    } else {
                        
                        throwArrow(MenuInterface.Deck1);
                    }
                    frame.setVisible(false);
                }catch (NumberFormatException ex) {
                    frame.setVisible(false);
                    errorBox("Please enter a number.", 1);
                }catch(Exception ex){
                    frame.setVisible(false);
                    errorBox("Please enter a line (number) from 1 to 10.", 1);
                }
               
               
               
             } else if (e.getSource() == buttonD) {
                
                
                try {
                    String answer = textField.getText();
                
                    // Get the choice and turn it to int
                    x = Integer.parseInt(answer);
                    frame.setVisible(false);
                    if( (x > 5) || (x < 1)){
                        throw new IndexOutOfBoundsException();
                    }
                    
                    // Find which player is currently playing and use defense
                    if (Game.gameState == 1) {
                        
                        useDefence(Ship2.shipsList.get(x - 1) , MenuInterface.Deck1);
                        
                    } else if (Game.gameState == 2) {
                        
                       useDefence(Ship2.shipsList.get(x + 4) , MenuInterface.Deck2);
                    }
                }catch (NumberFormatException ex) {
                    frame.setVisible(false);
                    errorBox("Please enter a number.", 2);
                }catch(IndexOutOfBoundsException ex){
                    frame.setVisible(false);
                    errorBox("Please choose a ship from 1 to 5.", 2);
                }catch(ArithmeticException ex){
                    frame.setVisible(false);
                    errorBox("This ship has sunk.", 2);
                }catch(Exception ex){
                    frame.setVisible(false);
                    errorBox("This ship's tolerance is full, please try a diferent ship.", 2);
                }
                
                
                
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
	    public void useDefence(Ship2 obj,Deck deck) throws Exception, ArithmeticException { 
            //Check if ship has full life.
            if (obj.getSize()==obj.getTolerance()){
                throw new Exception();
            }
            if (obj.getTolerance() == 0){
                throw new ArithmeticException();
            }
	       
	    	  for (int i = 0; i < obj.getSize(); i++) {
    			
    			if (deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] == "X" ) {
    				
    				deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] = "S";
    			}
	       
	    	   
	       
              }
	    	  
	    	  
	    }

	    // Use the attack at Deck deck
	    public void throwArrow(Deck deck) {
            Bsound.Sound(arrows);
	       for (int y = 0; y < 10; y ++) {
	        	if (deck.deck_arr[x - 1][y] == "S") {
	    	            
	        		deck.deck_arr[x - 1][y] = "X";
	    	        	
	        	} else if (deck.deck_arr[x - 1][y] == "A") {
	    	            
	        		deck.deck_arr[x - 1][y] = "S";
	    	        	
	        	}
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

        //Checks all alive ships of one player, if any of them doesn't have full tolerance then RETURN true
        //(Defence can be uesed).
        // pla = player. 
        public static boolean checkShipsTolerance(int pla){
            if (pla == 1){
                for(int i=0 ; i <= 4; i++){
                   if( (Ship2.shipsList.get(i).getTolerance() != Ship2.shipsList.get(i).getSize() )
                    && (Ship2.shipsList.get(i).getTolerance() != 0)){
                        return true;
                   } 
                }
            }else{
                for(int i=5 ; i <= 9; i++){
                    if( (Ship2.shipsList.get(i).getTolerance() != Ship2.shipsList.get(i).getSize() )
                     && (Ship2.shipsList.get(i).getTolerance() != 0)){
                        return true;
                    } 
                }
            }
            return false;
        }

    }
