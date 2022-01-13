import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Graphics;

// Class for Poseidon
public class Posidonas extends JFrame implements ActionListener{

	// Limit for attack and defense
	public static int[] RIVAL_MOVES = {1,1};

	// Sound files
	static File reveal = new File("Reveal.wav");
	static File wave = new File("Wave.wav");
	static File click = new File("click.wav");

	//Logo Symbol.
	static ImageIcon logo = new ImageIcon("logo.png");
	
	// All buttons 
	JButton errorA;
	JButton errorD;
	JButton buttonA;
    JButton buttonD;
    JButton back;

    // Useful vars for Posidonas methods
	static int xChoice;
	static int yChoice;
	int round;
    
	// Temp decks used for useVision method
	Deck deck3 = new Deck();
	Deck deck4 = new Deck();

	// Other components
	JTextField textField;
	JTextField textFieldx;
	JTextField textFieldy;
    
    JFrame frame;
	JFrame visionFrame;
	JFrame erFrame;

	// Useful var
	private static int roundNo;

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
     // Choose a ship to find its position
	 public void insertDataA() {
     	 frame = new JFrame("CHOOSE A SHIP");
		  frame.setIconImage(logo.getImage());
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         frame.setLocation(650, 455);
         
         // Exit and use attack method
         buttonA = new JButton("REVEAL");
         buttonA.addActionListener(this);
         buttonA.setBackground(Color.RED);
         buttonA.setForeground(Color.BLACK);
         buttonA.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
         
         // Choose a ship here
         textField = new JTextField();
         textField.setPreferredSize(new Dimension(250,40));
         textField.setFont(new Font("Consolas",Font.BOLD, 25));


         frame.add(buttonA);
         frame.add(textField);
         frame.setVisible(true);
         frame.pack();

     }
	 // Frame for defense
     // Choose the area the waves will cover
	 public void insertDataD() {
     	 frame = new JFrame("INSERT COORDINATES");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setIconImage(logo.getImage());
		 frame.setLayout(new FlowLayout());
         frame.setLocation(650, 455);
         
         // Exit and use defense
         buttonD = new JButton("RISE WAVES");
         buttonD.addActionListener((ActionListener) this);
         buttonD.setBackground(Color.GREEN);
         buttonD.setForeground(Color.BLACK);
         
         // Insert coordinates here
         textFieldx = new JTextField();
         textFieldx.setPreferredSize(new Dimension(250,40));
         textFieldx.setFont(new Font("Consolas",Font.BOLD, 25));
		 textFieldy = new JTextField();
         textFieldy.setPreferredSize(new Dimension(250,40));
         textFieldy.setFont(new Font("Consolas",Font.BOLD, 25));


         frame.add(buttonD);
         frame.add(textFieldx);
		 frame.add(textFieldy);
         frame.setVisible(true);
         frame.pack();

     }
	 
     // Attack method, reveals the posotion of ship number: shipNo
	 public void useVision(int shipNo) throws Exception{
		Ship2 ship = Ship2.shipsList.get(shipNo - 1);

		// Check if the ship has already sunk.
        if (ship.getTolerance()==0){
            throw new Exception();
        }

		// Find player 
		if (Game.gameState == 1) {
			
		    for (int i = 0; i < ship.getSize(); i++){
	            // Use the temp array to show the ship
		    	deck3.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
	        }
	           
	        sea(); // painting method
		} else {
			
            for (int i = 0 ; i < ship.getSize(); i++){
                // Use the temp array to show the ship
            	deck4.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
            }  
			
			sea(); // painting method
		}
	}
    // All buttons function
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonA) {
			

			try {
				// Get the choice and turn it to int
				String answer = textField.getText();
				int x = Integer.parseInt(answer);
				if( (x > 5) || (x < 1)){
					throw new IndexOutOfBoundsException();
				}
				
				// Find player
				if(Game.gameState == 1) {
					
					useVision(x + 5);
				
				} else {
					
					useVision(x);
				}
				frame.setVisible(false);
				Bsound.Sound(reveal);
			}catch (NullPointerException ex) {
				frame.setVisible(false);
				errorBox("Please enter a number.", 1);
			} catch (IndexOutOfBoundsException ex) {
                frame.setVisible(false);
				errorBox("Please enter a number from 1 to 5.",1);
			}catch (Exception ex) {
				frame.setVisible(false);
				errorBox("This ship has already sunk.",1);
			}
			
		
		} else if (e.getSource() == buttonD) {
          
			
			
			try {
				// Get the choices and turn both to int
				String answer1 = textFieldx.getText();
				String answer2 = textFieldy.getText();

				xChoice = Integer.parseInt(answer1);
				yChoice = Integer.parseInt(answer2);
				
				if( (xChoice > 10) || (xChoice < 1) || (yChoice > 10) || (yChoice < 1)){
					throw new Exception();
				}
				frame.setVisible(false);
				// Find player
				if (Game.gameState == 1) {
					
					useDefence(MenuInterface.Deck1, xChoice, yChoice);
					
				} else if (Game.gameState == 2) {
					
				useDefence(MenuInterface.Deck2, xChoice, yChoice);
				}
				Bsound.Sound(wave);
			} catch (NumberFormatException ex) {
                frame.setVisible(false);
				errorBox("Please enter a number.",2);
            } catch (Exception ex) {
                frame.setVisible(false);
				errorBox("Please enter a number from 1 to 10.",2);
			}
			
			
			
		} else if (e.getSource() == back) {
			// Exit frame, continue
			visionFrame.setVisible(false);
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

	// Painting method for the temporary deck used for useVision method
	public void sea() {
		
		visionFrame = new JFrame();
		visionFrame.setVisible(true);
		visionFrame.setBounds(0, 0, 729, 800);
		
		back = new JButton("BACK");
		back.setBounds(568, 15, 80, 25);
		back.addActionListener(this);
		back.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.GRAY);
		
		JLabel wood = new JLabel(new ImageIcon("wood.jpg"));
		wood.setBounds(0, 700, 729, 71);
		
		JLabel text = new JLabel("Vision does not reveal how much tolerance the ship is left with!");
		text.setBounds(80, 15, 485, 30);
		text.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 11));
		text.setForeground(Color.WHITE);
		
		JPanel pn = new JPanel(){
				
			   public void paint(Graphics g) {
				   for(int y = 0; y < 10; y++ ){
					   for(int x = 0; x < 10; x++){
						   g.setColor(Color.BLACK);
						   g.fillRect(x*70, y*70, 80, 70);
						   if (deck3.deck_arr[y][x] == "S" && Game.gameState == 1) {
							  
							   g.setColor(Color.GREEN);
						   
						   } else if (deck4.deck_arr[y][x] == "S" && Game.gameState == 2){
						   
							   g.setColor(Color.GREEN);
						   
						   } else { 
							   // BLUE
							   g.setColor(new Color(65,105,225));
						   }
						  
						   g.fillRect(x*70+1, y*70+1, 80+1, 70+1);
					   }
				   }
				   
			   }
		   };
		   pn.setBounds(0, 0, 729, 729);
		   
		   pn.setLayout(null);
		   
		   wood.add(text);
		   wood.add(back);
		   visionFrame.add(wood);
		   		   
		   visionFrame.setLayout(null);
		   visionFrame.add(pn);
	}

	// Defense method, rises protective waves at a 4x4 area
	// with (xChoice, yChoice) top left corner
	
	// Ships cannot move when ther is at least one block inside the
	// wave area
	public void useDefence(Deck deck, int xChoice, int yChoice) {
		// Hold the round number, use it to end the defense
		// 4 rounds after activating
		this.roundNo = Game.getRoundsNo();
		
		for (int i = xChoice; i < xChoice + 4; i++) {

			if (i <= 10){
				for (int j = yChoice; j < yChoice + 4; j++) {
					
					if (j <= 10){
						// Transform both normal and damaged blocks
						if (deck.deck_arr[i - 1][j - 1].equals("S")) {
							
							deck.deck_arr[i - 1][j - 1] = "U";
							
						} else if (deck.deck_arr[i - 1][j - 1].equals("X")) {
							
							deck.deck_arr[i - 1][j - 1] = "B"; 
						
						}
					}
					
					
				}
			}
			
		}

		
	}
	

    // Useful Getter
	public static int getRoundNo() {
		return roundNo;
	}


	// Necessary method to end the defense
	public static void endDefense(Deck deck) {
		
		// Restore both normal and damaged blocks
		for (int i = xChoice; i < xChoice + 4; i++) {
			if(i <= 10){
				for (int j = yChoice; j < yChoice + 4; j++) {
					if(j <= 10){
						if (deck.deck_arr[i - 1][j - 1] == "U") {
						
							deck.deck_arr[i - 1][j - 1] = "S";
							
						} else if (deck.deck_arr[i - 1][j - 1] == "B") {
							
							deck.deck_arr[i - 1][j - 1] = "X"; 
						
						}
					}
					
					
				}
			}
			
		}
	}
	
	public void errorBox(String mess , int buttonNumber){
		erFrame = new JFrame("Error!!!");
		erFrame.setIconImage(logo.getImage());
		erFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		erFrame.setLayout(new FlowLayout());
		erFrame.setLocation(650, 455);
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
}
	
