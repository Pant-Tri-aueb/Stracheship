import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// Main class. This is where the game runs
public class Game extends JFrame implements java.awt.event.ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	// Player turn(1 or 2)
	public static int gameState = 1;
	
	private static int roundsNo = 1;
	private int shipNo = 1;
	
	// Helpful variables for Posidonas class
	private int pGameState;
	private int pRoundNo = 0;
	
	// All buttons
	private JButton attack;
	private JButton move;
	private JButton Up;
	private JButton Down;
	private JButton Left;
	private JButton Right;
	private JButton god;
	public  JButton changeTurn;
	private JButton next;
	private JButton sinkedNext;
	private JButton godAttack;
	private JButton godDefense;
	private JButton errorA;
	private JButton errorD;
	private JButton backMove;
	private JButton backAttack;
	private JButton showBoard;
	private JButton hideBoard;
	private JButton erButton1;
	private JButton erButton2;
	
	private JLabel playerinfo;
	private JLabel attackMessage;
	private JLabel shipCount1;
	private JLabel shipCount2;
	private JLabel tolerance1;
	private JLabel tolerance2;
	
	// Other components
	private JTextField Xattack, Yattack;
	
	public static JPanel pn;
	
	private JFrame frame; 
	private JFrame Aframe; 
	private JFrame Dframe;
	private JFrame hit;
	private JFrame erFrame;
	
	// Arrays to indicate WHERE each player has already attacked
	Deck hit1 = new Deck();
	Deck hit2 = new Deck();
	
	// Move class object
	Move m = new Move();
	
	// Sound files 
	static File click = new File("click.wav");
	static File cannon = new File("Bb.wav");
	static File spear = new File("Spear.wav");
	
	// Main logo
	static ImageIcon logo = new ImageIcon("logo.png");
	
	
	// Operating frame
	public void StracheshipBoard() {
	
	       frame = new JFrame();
	       frame.setIconImage(logo.getImage());
	       frame.setBounds(10, 10, 860, 860);
	       frame.setUndecorated(false);
	       frame.setLayout(null);
	      
	       // Wooden Background
	       playerinfo = new JLabel(new ImageIcon(
	         		"wood3.jpg"));
	       playerinfo.setBounds(0, 0, 860, 860);
	       playerinfo.setLayout(null);
	       
	       
	       // Check for Posidonas defense ending
	       if (roundsNo == pRoundNo + 5) {
				if (pGameState == 1) {
					
	                Posidonas.endDefense(MenuInterface.Deck1);
					
					
				} else if (pGameState == 2) {
					
					Posidonas.endDefense(MenuInterface.Deck2);

				} 
		   } 
	       
	       // Each player name
	       JLabel name1 = new JLabel(MenuInterface.player1.getName());
	       JLabel name2 = new JLabel(MenuInterface.player2.getName());
	      
	       name1.setBounds(20, 778, 170, 20);
	       name2.setBounds(20, 778, 170, 20);
	       
	       name1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 23));
	       name2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 23));
	       
	       name1.setForeground(Color.WHITE);
	       name2.setForeground(Color.WHITE);
	       
	       // Each player god 
	       JLabel god1 = new JLabel("GOD: " + MenuInterface.player1.getGod());
	       JLabel god2 = new JLabel("GOD: " + MenuInterface.player2.getGod());
	       
	       god1.setBounds(220, 780, 250, 20);
	       god2.setBounds(220, 780, 250, 20);
	       
	       god1.setFont(new Font("SansSerif", Font.BOLD, 23));
	       god2.setFont(new Font("SansSerif", Font.BOLD, 23));
	       
	       god1.setForeground(Color.WHITE);
	       god2.setForeground(Color.WHITE);
	      
	       // Update tolerance for all 5 ships and for every deck
           for (int i = 0; i < 5; i++) {
	    	   
	    	   Ship2.shipsList.get(i).updateTolerance(MenuInterface.Deck1);
	       
	       }
           for (int i = 5; i < 10; i++) {
	    	   
	    	   Ship2.shipsList.get(i).updateTolerance(MenuInterface.Deck2);
	       
	       }
	       
           // Tolerance String
	       String life = "";
	     
	       
	       if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 ) {
	    	  
	    	   life = String.format("%d", Ship2.shipsList.get(shipNo - 1).getTolerance());
	    	   
	    	   if (Integer.parseInt(life) > 1000) {
	   		   	
	    		   life = Character.toString('\u221E');
	   		   
	    	   }
	    	   
	       } else if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() == 0) {
	    			   
	    	   life = "SINKED";	
	    	   
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() != 0) {
	    	   
	    	   life = String.format("%d", Ship2.shipsList.get(shipNo + 4).getTolerance());
	    	   
	    	   if (Integer.parseInt(life) > 1000) {
		   		   	
	    		   life = Character.toString('\u221E');
	   		   
	    	   }
	    	   
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() == 0 ){
	    	    
	    	   life = "SINKED";
	    	   
	       }
	       
	       tolerance1 = new JLabel("TOLERANCE");
	       tolerance2 = new JLabel(life);
	       
	       tolerance1.setBounds(758, 200, 100, 30);
	       
	       if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 ) {

	    	   tolerance2.setBounds(790, 240, 75, 30);
	       
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() != 0) {
	    	   
	    	   tolerance2.setBounds(790, 240, 75, 30);
	       
	       } else if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() == 0 ) {
	    	   
	    	   tolerance2.setBounds(756, 240, 100, 30);
	       
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() == 0 ) {
	    	   
	    	   tolerance2.setBounds(768, 240, 100, 30);
	       }

	       
	       tolerance1.setForeground(Color.WHITE);
	       tolerance2.setForeground(Color.WHITE);
	       
	       tolerance1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 11));
	       tolerance2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
	       
	       if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() > 500 ) {
	    	   
	    	   tolerance2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
	       
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() > 500 ) {
	    	   
	    	   tolerance2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
	    	   
	       }
	       // Ship counter
	       shipCount1 = new JLabel("SHIP");
	       shipCount2 = new JLabel(String.format("%d", shipNo));	       
	       
	       shipCount1.setBounds(768, 90, 75, 30);
	       shipCount2.setBounds(788, 125, 75, 30);
	       
	       shipCount1.setForeground(Color.WHITE);
	       shipCount2.setForeground(Color.WHITE);
	       
	       shipCount1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 19));
	       shipCount2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 21));
	       
	       // Some useful BACK buttons
	       backMove = new JButton("BACK");
	       backAttack = new JButton("BACK");
	       
	       backMove.setBounds(755, 650, 90, 35);
	       backAttack.setBounds(755, 650, 90, 35);
	       
	       backMove.addActionListener(this);
	       backAttack.addActionListener(this);
	       
	       backMove.setBackground(Color.GRAY);
	       backAttack.setBackground(Color.GRAY);
	       
	       backMove.setForeground(Color.WHITE);
	       backAttack.setForeground(Color.WHITE);
	       
	       backMove.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
	       backAttack.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
	       
	       // Hit board
	       showBoard = new JButton("HIT");
	       hideBoard = new JButton("HIDE");
	       
	       showBoard.setBounds(755, 550, 90, 35);
	       hideBoard.setBounds(755, 550, 90, 35);
	       
	       showBoard.addActionListener(this);
	       hideBoard.addActionListener(this);
	       
	       showBoard.setBackground(Color.GRAY);
	       hideBoard.setBackground(Color.GRAY);
	       
	       showBoard.setForeground(Color.WHITE);
	       hideBoard.setForeground(Color.WHITE);
	       
	       showBoard.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
	       hideBoard.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
	       
	       // Attack button
	       next = new JButton("FIRE!");
	       next.setBounds(740, 775, 100, 30);
	       next.addActionListener(this);
	       next.setBackground(Color.red);
	       next.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
	       
	       // Next turn
	       changeTurn = new JButton("NEXT");	       
	       changeTurn.setBounds(765, 90, 75, 300);
	       changeTurn.setFont(new Font("Castellar", Font.BOLD, 11));
	       changeTurn.setForeground(new Color(255,215,0));
	       changeTurn.setBackground(Color.BLACK);
	       
	       // Use god 
	       god = new JButton("GOD");
	       god.setBounds(765, 400, 75, 300);
	       god.setFont(new Font("Castellar", Font.BOLD, 14));
	       god.setForeground(new Color(255,215,0));
	       god.setBackground(Color.BLACK);
	       
	       god.addActionListener(this);
	       changeTurn.addActionListener(this);
	       
	       godAttack = new JButton(new ImageIcon("swords.jpg"));
	       godDefense = new JButton(new ImageIcon("shield.jpg"));
	       
	       godAttack.setBounds(767, 125, 72, 250);
	       godDefense.setBounds(767, 385, 72, 250);
	       
	       godAttack.addActionListener(this);
	       godDefense.addActionListener(this);
	       
	       godAttack.setBackground(new Color(153, 0, 0));
	       godDefense.setBackground(new Color(0, 102, 0));
	       
	       // Coordinates for attack
	       attackMessage = new JLabel("SHOOT AT");
	       Xattack = new JTextField();
	       Yattack = new JTextField();
	       
	       Xattack.setBounds(600, 775, 50, 30);
	       Yattack.setBounds(670, 775, 50, 30);
	       attackMessage.setBounds(480, 775, 140, 30);
	       
	       attackMessage.setFont(new Font("SansSerif", Font.BOLD, 18));
	       attackMessage.setForeground(Color.WHITE);
	       
	       // Ship's choice whether to attack or move 
	       attack = new JButton("ATTACK");
	       move = new JButton("MOVE");
	       
	       attack.setBounds(480, 775, 130, 25);
	       move.setBounds(660, 775, 130, 25);
	       
	       attack.addActionListener(this);
	       move.addActionListener(this);
	       
	       attack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	       move.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	       
	       attack.setBackground(Color.GRAY);
	       move.setBackground(Color.GRAY);
	       
	       attack.setForeground(Color.WHITE);
	       move.setForeground(Color.WHITE);
	       
	       // In case this ship is sinked (0 tolerance)
	       sinkedNext = new JButton("NEXT SHIP");
	       sinkedNext.setBounds(580, 775, 130, 25);
	       sinkedNext.addActionListener(this);
	       sinkedNext.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
	       sinkedNext.setBackground(Color.GRAY);
	       sinkedNext.setForeground(Color.WHITE);
	       
	       // Show the correct labels each turn
	       if (gameState == 1) {
	    	   frame.add(name1);
	    	   frame.add(god1);
	    	  
	       } else { 
	    	   frame.add(name2);
	    	   frame.add(god2);
	       }
	       
	        // Move buttons for every direction
	        Up = new JButton("UP");
			Down = new JButton("DOWN");
			Left = new JButton("LEFT");
			Right = new JButton("RIGHT");
			
			Left.setBounds(475, 775, 100, 25);
		    Right.setBounds(635, 775, 100, 25);
		    Up.setBounds(475, 775, 100, 25);
		    Down.setBounds(635, 775, 100, 25);
		      
		    Left.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		    Right.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		    Up.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		    Down.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		    
		    Left.setBackground(Color.GRAY);
		    Right.setBackground(Color.GRAY);
		    Up.setBackground(Color.GRAY);
		    Down.setBackground(Color.GRAY);
		    
		    Left.setForeground(Color.WHITE);
		    Right.setForeground(Color.WHITE);
		    Up.setForeground(Color.WHITE);
		    Down.setForeground(Color.WHITE);
		    
			Left.addActionListener(this);
			Up.addActionListener(this);
			Down.addActionListener(this);
			Right.addActionListener(this);
			
			Left.setVisible(false);
			Down.setVisible(false);
			Up.setVisible(false);
			Right.setVisible(false);
			Xattack.setVisible(false);
			Yattack.setVisible(false);
			attackMessage.setVisible(false);
	        next.setVisible(false);
	        godAttack.setVisible(false);
	        godDefense.setVisible(false);
	        backAttack.setVisible(false);
	        backMove.setVisible(false);
			
	       // Fill the main frame with components 
           playerinfo.add(Left);
		   playerinfo.add(Up);
		   playerinfo.add(Down);
		   playerinfo.add(Right);
		   playerinfo.add(attack);
	       playerinfo.add(move);
	       playerinfo.add(god);
	       playerinfo.add(changeTurn);
	       playerinfo.add(shipCount1);
	       playerinfo.add(shipCount2);
	       playerinfo.add(Xattack);
	       playerinfo.add(Yattack);
	       playerinfo.add(attackMessage);
	       playerinfo.add(next);
	       playerinfo.add(tolerance1);
	       playerinfo.add(tolerance2);
	       playerinfo.add(sinkedNext);
	       playerinfo.add(godAttack);
	       playerinfo.add(godDefense);
	       playerinfo.add(backMove);
	       playerinfo.add(backAttack);
	       playerinfo.add(showBoard);
	       playerinfo.add(hideBoard);
	       
	       // Show or Hide several buttons, with conditions
	       
	       // Ship 1-5, not sinked, first player, normal tolerance
	       if (shipNo <= 5 && (Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 &&
	    		   Ship2.shipsList.get(shipNo - 1).getTolerance() < 500) && gameState == 1) {
	         
	    	   god.setVisible(false);
	           changeTurn.setVisible(false);
	           attack.setVisible(true);
	           move.setVisible(true);
	           sinkedNext.setVisible(false);
	           showBoard.setVisible(true);
	           hideBoard.setVisible(false);
	       
	       // Ship 1-5, not sinked, first player, infinite tolerance    
	       } else if (shipNo <= 5 && (Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 &&
		    		   Ship2.shipsList.get(shipNo - 1).getTolerance() > 500) && gameState == 1) {
		         
	    	   god.setVisible(false);
		       changeTurn.setVisible(false);
		       attack.setVisible(true);
		       move.setVisible(false);
		       sinkedNext.setVisible(false);
		       showBoard.setVisible(true);
	           hideBoard.setVisible(false);
	       
	       // Ship 1-5, not sinked, second player, normal tolerance 
	       } else if (shipNo <= 5 && (Ship2.shipsList.get(shipNo + 4).getTolerance() != 0 &&
	    		   Ship2.shipsList.get(shipNo + 4).getTolerance() < 500) && gameState == 2) {
	         
    	      god.setVisible(false);
	          changeTurn.setVisible(false);
	          attack.setVisible(true);
	          move.setVisible(true);
	          sinkedNext.setVisible(false);
	          showBoard.setVisible(true);
	          hideBoard.setVisible(false);
	       
	       // Ship 1-5, not sinked, second player, infinite tolerance 
	       } else if (shipNo <= 5 && (Ship2.shipsList.get(shipNo + 4).getTolerance() != 0 &&
	    		   Ship2.shipsList.get(shipNo + 4).getTolerance() > 500) && gameState == 2) {
	         
    	      god.setVisible(false);
	          changeTurn.setVisible(false);
	          attack.setVisible(true);
	          move.setVisible(false);
	          sinkedNext.setVisible(false);
	          showBoard.setVisible(true);
	          hideBoard.setVisible(false);
        
           // End of turn, GOD or NEXT
           } else if (shipNo > 5) {
	    	   
	    	   god.setVisible(true);
	    	   changeTurn.setVisible(true);
	    		
	    	   
	    	   attack.setVisible(false);
	    	   move.setVisible(false);
	    	   shipCount1.setVisible(false);
	    	   shipCount2.setVisible(false);
	    	   tolerance1.setVisible(false);
	    	   tolerance2.setVisible(false);
	    	   sinkedNext.setVisible(false);
	    	   showBoard.setVisible(false);
	           hideBoard.setVisible(false);
           
	       // Sinked ship 1-5, first player    
	       } else if (shipNo <= 5 && Ship2.shipsList.get(shipNo - 1).getTolerance() == 0 
	    		   && gameState == 1) {
	    	   
	    	   god.setVisible(false);
		       changeTurn.setVisible(false);
	    	   attack.setVisible(false);
	    	   move.setVisible(false);
	    	   sinkedNext.setVisible(true);
	    	   tolerance1.setVisible(true);
	    	   tolerance2.setVisible(true);
	    	   showBoard.setVisible(true);
		       hideBoard.setVisible(false);
	        
	       // Sinked ship 1-5, second player	   
	       } else if (shipNo <= 5 && Ship2.shipsList.get(shipNo + 4).getTolerance() == 0 
	    		   && gameState == 2) {
	    	   
	    	   god.setVisible(false);
		       changeTurn.setVisible(false);
	    	   attack.setVisible(false);
	    	   move.setVisible(false);
	    	   sinkedNext.setVisible(true);
	    	   tolerance1.setVisible(true);
	    	   tolerance2.setVisible(true);
	    	   showBoard.setVisible(true);
		       hideBoard.setVisible(false);
	        
	       }
	       
	       
	       frame.add(playerinfo);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setVisible(true);

	       // Find out whether a ship is sinked (check all 10 ships)
	       for (int i = 0; i < 10; i++) {
	    	   
	    	   Ship2 ship = Ship2.shipsList.get(i);
	    	      
	    	   // First player
	    	   if (i < 5) {
	    		   if (ship.isDestroyed1() == true) {
	    			  
	    			   for (int j = 0; j < ship.getSize(); j++) {
	    				   
	    				   MenuInterface.Deck1.deck_arr[ship.xy[j][0]][ship.xy[j][1]] = "O";
	    			   
	    			   }
	    			  
	    			  
	    		   }
	    	   
	    	   // Second player	   
	    	   } else {
	    		   
	    		   if (ship.isDestroyed2() == true) {
		    			  
	    			   for (int j = 0; j < ship.getSize(); j++) {
	    				   
	    				   MenuInterface.Deck2.deck_arr[ship.xy[j][0]][ship.xy[j][1]] = "O";
	    			   
	    			   }
	    			  
	    			  
	    		   }
	    	   }
	       } 
	       
	       // Add 10x10 table with colors (sea)
	       sea();
	       
	       // Check if any player has won
	       if (MenuInterface.Deck1.checkWinner() == true || MenuInterface.Deck2.checkWinner() == true) {
	    	   
	    	   GUIWINNER.winner();
	       }
	      
	    	   
	       
	   }
     
	 // Create 10x10 table filled with colors (ships)
	 public void sea() {
	    
		Ship2 ship;
		
		// Get the right ship
		if (gameState == 1 && shipNo < 6) {
			
			 ship = Ship2.shipsList.get(shipNo - 1);
			
		} else if (gameState == 2 && shipNo < 6){
			
			 ship = Ship2.shipsList.get(shipNo + 4);
		
		} else { // This is never used
			
			ship = Ship2.shipsList.get(shipNo - 1);
		}
		
		
       	
		 pn = new JPanel(){
		        
			private static final long serialVersionUID = 1L;
                
			    // Paint method
				public void paint(Graphics g) {
	               	for(int y = 0; y < 10; y++ ){
	                   	for(int x = 0; x < 10; x++){
	                       	g.setColor(Color.BLACK);
	                       	g.fillRect(x*70, y*70, 80, 70);
	                       	
	                       	if (MenuInterface.Deck1.deck_arr[y][x] == "S" && gameState == 1) {
	                            
	                       		// Check for every ship's turn and change its color to darker brown
	                       		// so it can be recognised
	                       		boolean belongs = false;  
	                       		
	                       		for (int i = 0; i < ship.getSize(); i++) {
	                       			
	                       			if (ship.xy[i][0] == y && ship.xy[i][1] == x && shipNo < 6) {
	                       				
	                       				belongs = true;
	                       			}
	                       			
	                       		}
	                       		
	                       		if (belongs == true) {
	                       			
	                       			// Dark brown
	                       			g.setColor(new Color(51, 25, 0));
	                       		
	                       		} else {
	                       			
	                       			// Normal brown
	                       			g.setColor(new Color(139, 69, 19));
	                       		}
	                       		
	                       
	                        } else if (MenuInterface.Deck2.deck_arr[y][x] == "S" && gameState == 2){
	                            
	                        	 
	                       		// Check for every ship's turn and change its color to darker brown
	                       		// so it can be recognised
	                       	    boolean belongs = false;  
	                       		
	                       		for (int i = 0; i < ship.getSize(); i++) {
	                       			
	                       			if (ship.xy[i][0] == y && ship.xy[i][1] == x && shipNo < 6) {
	                       				
	                       				belongs = true;
	                       			}
	                       			
	                       		}
	                       		
	                       		if (belongs == true) {
	                       			
	                       			// Dark Brown
	                       			g.setColor(new Color(51, 25, 0));
	                       		
	                       		} else {
	                       			
	                       			// Normal Brown
	                       			g.setColor(new Color(139, 69, 19));
	                       		}
	                       
	                       	// Block hit, player 1	
	                       	} else if (MenuInterface.Deck1.deck_arr[y][x] == "X" && gameState == 1) {
	                    	   
	                    	   	g.setColor(Color.RED);
	                       
	                    	// Block hit, player 2   	
                           	} else if (MenuInterface.Deck2.deck_arr[y][x] == "X" && gameState == 2) {
	                    	   
	                    	   	g.setColor(Color.RED);	                    	   
	                       
	                    	// Block armored, player 1   	
                           	} else if (MenuInterface.Deck1.deck_arr[y][x] == "A" && gameState == 1) {
                        	    
                        	   	g.setColor(Color.GRAY);
                           
                        	// Block armored, player 2   	
                           	} else if (MenuInterface.Deck2.deck_arr[y][x] == "A" && gameState == 2) {
	                    	   
	                    	   	g.setColor(Color.GRAY);	       
                           
	                    	// Posidonas Defense, player 1   	
                           	}else if (MenuInterface.Deck1.deck_arr[y][x] == "U" && gameState == 1) {
                        	    
								g.setColor(new Color(0, 0, 128));
						
							// Posidonas Defense, player 2	
							} else if (MenuInterface.Deck2.deck_arr[y][x] == "U" && gameState == 2) {
	                    	   
								g.setColor(new Color(0, 0, 128));      
						
							// Posidonas Defense but block hit, player 1	
                            }else if (MenuInterface.Deck1.deck_arr[y][x] == "B" && gameState == 1) {
                        	    
								g.setColor(new Color(102, 0, 51));
						
						    // Posidonas Defense but block hit, player 2		
							} else if (MenuInterface.Deck2.deck_arr[y][x] == "B" && gameState == 2) {
	                    	   
								g.setColor(new Color(102, 0, 51));      
						
							} else { 
	                    	  
								// BLUE
	                    	   	g.setColor(new Color(65,105,225));
	                       	}
	                        
	                       	
	                       	
	                       	g.fillRect(x*70+1, y*70+1, 80+1, 70+1);
	                   	}
	              	}
	            
	               
			   }
				
	       	};
	       	
	       	// Set sea bounds
	       	pn.setBounds(41, 41, 729, 729);
	       	pn.setLayout(null);
	       	pn.setVisible(true);
	       
	       	frame.setLayout(null);
	       	playerinfo.add(pn);
	}
	
	// In case player god's attacks are over 
	public void errorMessageA() {
		
		Aframe = new JFrame("Error");
        Aframe.setIconImage(logo.getImage());
		Aframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Aframe.setLayout(new FlowLayout());
        JPanel pn = new JPanel();
        
        JLabel message = new JLabel("Τελείωσαν οι διαθέσιμες επιθέσεις");
        
        errorA = new JButton("OK");
        errorA.addActionListener(this);
       
        pn.add(errorA);
        pn.add(message);
        
        Aframe.add(pn);
        Aframe.setVisible(true);
        Aframe.pack();
	}
	
	// In case player god's defenses are over 
    public void errorMessageD() {
		
		Dframe = new JFrame("Error");
        Dframe.setIconImage(logo.getImage());
		Dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dframe.setLayout(new FlowLayout());
        JPanel pn = new JPanel();
        
        JLabel message = new JLabel("Τελείωσαν οι διαθέσιμες άμυνες");
        
        errorD = new JButton("OK");
        errorD.addActionListener(this);
       
        pn.add(errorD);
        pn.add(message);
        
        Dframe.add(pn);
        Dframe.setVisible(true);
        Dframe.pack();
	}
	
    // Every button's function
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == move) {
			Bsound.Sound(click);
			
			backMove.setVisible(true);
			attack.setVisible(false);
			move.setVisible(false);
		    
			// Show the right buttons by checking ship direction (for each player)
			// Vertical = Up and Down
			// Horizontal = Left and Right
			
            if (gameState == 1 && Ship2.shipsList.get(shipNo - 1).getDirection().equals("DOWN")) {
				
				Up.setVisible(true);
				Down.setVisible(true);
			
			} else if (gameState == 1 && Ship2.shipsList.get(shipNo - 1).getDirection().equals("RIGHT")) {
				
				Left.setVisible(true);
				Right.setVisible(true);
			
			} else if (gameState == 2 && Ship2.shipsList.get(shipNo + 4).getDirection().equals("DOWN")) {
				
				Up.setVisible(true);
				Down.setVisible(true);
				
			} else if (gameState == 2 && Ship2.shipsList.get(shipNo + 4).getDirection().equals("RIGHT")) {
				
				Left.setVisible(true);
				Right.setVisible(true);
			}
            
		// Prepare ship's attack
		} else if (e.getSource() == attack) {
			Bsound.Sound(click);
			
			backAttack.setVisible(true);
			attack.setVisible(false);
			move.setVisible(false);
			
			Xattack.setVisible(true);
			Yattack.setVisible(true);
			attackMessage.setVisible(true);
			next.setVisible(true);
			
		// Move to the right
		} else if (e.getSource() == Right) {
			Bsound.Sound(click);
			
			backMove.setVisible(false);
	        
			boolean chekError= false;
			try {
				if (gameState == 1) {
	        	   
					m.moveRight(shipNo, MenuInterface.Deck1);
				   
				} else if (gameState == 2) {
					   
					m.moveRight(shipNo + 5, MenuInterface.Deck2);
				}
				shipNo++;
				
			} catch (ArrayIndexOutOfBoundsException ex) {
				frame.setVisible(false);
				chekError=!chekError;
				errorBox("Ship out of sea!!! Please, try something else.", 1);
			}catch(Exception ex){
				frame.setVisible(false);
				chekError=!chekError;
				errorBox("Ship fell on other ship!!! Be careful, please try something else.", 1);
			}
			
	        frame.setVisible(false);
			if(!chekError){
				StracheshipBoard();
				sea();
			}
			
	   
	    // Move Up	
		} else if (e.getSource() == Up) {
				Bsound.Sound(click);
				
				backMove.setVisible(false);

				boolean chekError= false;
				try {
					if (gameState == 1) {
		        	   
						m.moveUp(shipNo, MenuInterface.Deck1);
					  
				   } else if (gameState == 2) {
						  
					   m.moveUp(shipNo + 5, MenuInterface.Deck2);
				   }
				   shipNo++;
				} catch(ArrayIndexOutOfBoundsException ex) {
					frame.setVisible(false);
					chekError=!chekError;
					errorBox("Ship out of sea!!! Please, try something else.", 1);
				} catch(Exception ex){
					frame.setVisible(false);
					chekError=!chekError;
					errorBox("Ship fell on other ship!!! Be careful, please try something else.", 1);
				}
		        
	            frame.setVisible(false);
				
				if(!chekError){
					StracheshipBoard();
					sea();
				}	
				
		// Move to the Left
		} else if (e.getSource() == Left) {
					Bsound.Sound(click);
					
					backMove.setVisible(false);

					boolean chekError= false;
					try {
						if (gameState == 1) {
			        	   
							m.moveLeft(shipNo, MenuInterface.Deck1);
						   
						} else if (gameState == 2) {
							   
							m.moveLeft(shipNo + 5, MenuInterface.Deck2);
						
						}
						shipNo++;
					} catch (ArrayIndexOutOfBoundsException ex) {
						frame.setVisible(false);
						chekError=!chekError;
						errorBox("Ship out of sea!!! Please, try something else.", 1);
					}catch(Exception ex){
						frame.setVisible(false);
						chekError=!chekError;
						errorBox("Ship fell on other ship!!! Be careful, please try something else.", 1);
					}
			        
					frame.setVisible(false);
					
					if(!chekError){
						StracheshipBoard();
						sea();
					}	
		
		// Move Down
		} else if (e.getSource() == Down) {
			Bsound.Sound(click);
			
			backMove.setVisible(false);

			boolean chekError= false;
			try {
				if (gameState == 1) {
        	   
					m.moveDown(shipNo, MenuInterface.Deck1);
				
				} else if (gameState == 2) {
					
				   m.moveDown(shipNo + 5, MenuInterface.Deck2);
				}
				shipNo++; 
			} catch (ArrayIndexOutOfBoundsException ex) {
				frame.setVisible(false);
				chekError=!chekError;
				errorBox("Ship out of sea!!! Please, try something else.", 1);
			} catch(Exception ex){
				frame.setVisible(false);
				chekError=!chekError;
				errorBox("Ship fell on other ship!!! Be careful, please try something else.", 1);
			}

            frame.setVisible(false);
			
			if(!chekError){
				StracheshipBoard();
				sea();
			}	
			
		// End your turn
	    } else if (e.getSource() == changeTurn) {
	    	Bsound.Sound(click);
	    	
	    	frame.setVisible(false);
	    	if (gameState == 1) {
	    		
	    		gameState = 2;
	    	
	    	} else {
	    		
	    		gameState = 1;
	    	}
	    	roundsNo += 1;
	    	shipNo = 1;
	    	StracheshipBoard();
	    	sea();
	    
	    // Show hit board	
	    } else if (e.getSource() == showBoard) {
	        
	    	hit = new JFrame("POINTS HIT");
	    	hit.setIconImage(logo.getImage());
	    	
	    	JPanel pn = new JPanel(){
				
				private static final long serialVersionUID = 1L;

				// Sea Paint Method
				public void paint(Graphics g) {
					   for(int y = 0; y < 10; y++ ){
						   for(int x = 0; x < 10; x++){
							   g.setColor(Color.BLACK);
							   g.fillRect(x*40, y*40, 44, 40);
							   if (hit1.deck_arr[y][x] == "H" && Game.gameState == 1) {
								  
								   g.setColor(new Color(32 ,32 ,32));
							   
							   } else if (hit2.deck_arr[y][x] == "H" && Game.gameState == 2){
							   
								   g.setColor(new Color(32 ,32 ,32));
							   
							   } else { 
								  
								   g.setColor(new Color(65,105,225));
							   }
							  
							   g.fillRect(x*40+1, y*40+1, 44+1, 40+1);
						   }
					   }
					   
				   }
			 };
	    	pn.setLayout(null);
			pn.setVisible(true);
			pn.setBounds(0, 0, 420, 440);
	    	
	    	hit.add(pn); 
			hit.setLayout(null); 
	        hit.setSize(420, 440);
	        hit.setVisible(true);
	        hit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        showBoard.setVisible(false);
	        hideBoard.setVisible(true);
	    
	    // Hide hit board
	    } else if (e.getSource() == hideBoard) {
	    	
	    	hit.setVisible(false);
	    	showBoard.setVisible(true);
	        hideBoard.setVisible(false);
	    	
	    // Shoot 	
	    } else if (e.getSource() == next) {
	    	
	    	Bsound.Sound(click);
	    	
	    	backAttack.setVisible(false);
	    	boolean chekError= false;
			try {
					int x = Integer.parseInt(Xattack.getText());
					int y = Integer.parseInt(Yattack.getText());
					
					if (gameState == 1) {
						
						hit1.deck_arr[x - 1][y - 1] = "H"; // Update hit board
						
						if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("S")) { // normal block hit
							
							Bsound.Sound(cannon);
							MenuInterface.Deck2.deck_arr[x-1][y-1] = "X";
						
						} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("A")) { // armored block hit
							
							Bsound.Sound(cannon);
							MenuInterface.Deck2.deck_arr[x-1][y-1] = "S";

						} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("U")) { // Posidonas block hit

							MenuInterface.Deck2.deck_arr[x-1][y-1] = "U";	

						} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("X")) { // damaged block hit
							
							MenuInterface.Deck2.deck_arr[x-1][y-1] = "X";
						}
					
					} else {
						
						hit2.deck_arr[x - 1][y - 1] = "H";  // Update hit board
						
						if (MenuInterface.Deck1.deck_arr[x-1][y-1].equals("S")) { // normal block hit
							
							Bsound.Sound(cannon);
							MenuInterface.Deck1.deck_arr[x-1][y-1] = "X";
						
						} else if (MenuInterface.Deck1.deck_arr[x-1][y-1].equals("A")) { // armored block hit
							
							Bsound.Sound(cannon);
							MenuInterface.Deck1.deck_arr[x-1][y-1] = "S";

						} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("U")) { // Posidonas block hit

							MenuInterface.Deck1.deck_arr[x-1][y-1] = "U";	

						} else if (MenuInterface.Deck1.deck_arr[x-1][y-1].equals("X")) { // damaged block hit
							
							MenuInterface.Deck1.deck_arr[x-1][y-1] = "X";

						}
					}
					
					shipNo++;

			} catch (NumberFormatException ex) {
				chekError=!chekError;
				frame.setVisible(false);
				errorBox("Please enter a number.", 1);
			} catch (ArrayIndexOutOfBoundsException ex){
				chekError=!chekError;
				frame.setVisible(false);
				errorBox("Please enter a number from 1 to 10.", 1);
			}

					
	        frame.setVisible(false);
			if(!chekError){
				StracheshipBoard();
				sea();
			}
	        
	    
	    // Back button
	    } else if (e.getSource() == backAttack) {
	    	
	    	backAttack.setVisible(false);
	    	next.setVisible(false);
	    	Xattack.setVisible(false);
	    	Yattack.setVisible(false);
	    	move.setVisible(true);
	    	attack.setVisible(true);
	    
	    // Another back button	
	    } else if (e.getSource() == backMove) {	
	    	
	    	backMove.setVisible(false);
	    	Up.setVisible(false);
	    	Down.setVisible(false);
	    	Right.setVisible(false);
	    	Left.setVisible(false);
	    	move.setVisible(true);
	    	attack.setVisible(true);
	    
	    // Sinked ship, go to the next one	
	    } else if (e.getSource() == sinkedNext) {
	    	
	    	Bsound.Sound(click);
	    	
	    	shipNo++;
	        frame.setVisible(false);
	        StracheshipBoard();
	    	sea();
	    	
	    // Use your god
	    } else if (e.getSource() == god) {
	    	Bsound.Sound(click);
	    	
	    	changeTurn.setVisible(false);
	    	god.setVisible(false);
	    	godAttack.setVisible(true);
	    	godDefense.setVisible(true);
	    	
	    // Choose god attack
	    } else if (e.getSource() == godAttack) {
	    	Bsound.Sound(click);
	    	
	    	godAttack.setVisible(false);
	    	godDefense.setVisible(false);
	    	
	    	// Several conditions to choose the right god and check whether an attack can be used or not
	    	
	    	if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΤΕΜΙΣ" 
	    			&& Artemis.capacity(0) == true) {
	    	
	                
	                 Artemis A = new Artemis();
	                 A.insertDataA(); 
	                 Artemis.RIVAL_MOVES[0]--;
	                 
	                 changeTurn.setVisible(true);
	                 
	                 
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΤΕΜΙΣ" 
	    			&& Artemis.capacity(0) == true) {
	        	
	        	     Artemis A = new Artemis();
	        	     A.insertDataA();
	        		 Artemis.RIVAL_MOVES[0]--;
	        		 
	        		 changeTurn.setVisible(true);
	        	
	        
	        } else if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΤΕΜΙΣ" 
	        		&& Artemis.capacity(0) == false) {
	    	    
	        	// No more attacks left
	    	    errorMessageA();
	    	    changeTurn.setVisible(true);
	    	    
	        
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΤΕΜΙΣ" 
	        		&& Artemis.capacity(0) == false) {
	        	
	        	// No more attacks left
	        	errorMessageA();
	        	changeTurn.setVisible(true);
	        
	        } else if(gameState == 1 && MenuInterface.player1.getGod() == "ΔΙΑΣ" 
	    			&& Dias.capacity(0) == true) {
	        	
	        	 Dias D = new Dias();
                 D.insertDataA(); 
                 Dias.RIVAL_MOVES[0]--;
                 
                 changeTurn.setVisible(true);
                 
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	    			&& Dias.capacity(0) == true) {
	        	
	        	Dias D = new Dias();
                D.insertDataA(); 
                Dias.RIVAL_MOVES[0]--;
                
                changeTurn.setVisible(true);
                
	         } else if (gameState == 1 && MenuInterface.player1.getGod() == "ΔΙΑΣ" 
	        		&& Artemis.capacity(0) == false) {
	    	     
	        	// No more attacks left 
	    	    errorMessageA();
	    	    changeTurn.setVisible(true);
	    	    
	        
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	        		&& Artemis.capacity(0) == false) {
	        	
	        	// No more attacks left
	        	errorMessageA();
	        	changeTurn.setVisible(true);
	        
	        
	        } else if(gameState == 1 && MenuInterface.player1.getGod() == "ΠΟΣΕΙΔΩΝΑΣ" 
	    			&& Posidonas.capacity(0) == true) {
	        	
	        	Posidonas Pa = new Posidonas();
                Pa.insertDataA(); 
                Posidonas.RIVAL_MOVES[0]--;
                
                changeTurn.setVisible(true);
	        
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΠΟΣΕΙΔΩΝΑΣ"
	    			&& Posidonas.capacity(0) == true) {
	        	
	        	Posidonas Pa = new Posidonas();
                Pa.insertDataA(); 
                Posidonas.RIVAL_MOVES[0]--;
                
                changeTurn.setVisible(true);
	        
	        
	        }  else if (gameState == 1 && MenuInterface.player1.getGod() == "ΠΟΣΕΙΔΩΝΑΣ"
	        		&& Posidonas.capacity(0) == false) {
	    	     
	        	// No more attacks left
	    	    errorMessageA();
	    	    changeTurn.setVisible(true);
	    	    
	        
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΠΟΣΕΙΔΩΝΑΣ"
	        		&& Posidonas.capacity(0) == false) {
	        	
	        	// No more attacks left
	        	errorMessageA();
	        	changeTurn.setVisible(true);
	        
	        
	        } else if(gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΗΣ" 
	    			&& Aris.capacity(0) == true) {
	        	
	        	Aris Ar = new Aris();
                Bsound.Sound(spear);
	        	Ar.useAttack(MenuInterface.Deck2); 
                Aris.RIVAL_MOVES[0]--;
                
                changeTurn.setVisible(true);
	        
	        } else if(gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΗΣ" 
	    			&& Aris.capacity(0) == true) {
	        	
	        	Aris Ar = new Aris();
	        	 Ar.useAttack(MenuInterface.Deck1);
                Aris.RIVAL_MOVES[0]--;
                
                changeTurn.setVisible(true);
	        
	        } else if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΗΣ"
	        		&& Aris.capacity(0) == false) {
	    	    
	        	// No more attacks left
	    	    errorMessageA();
	    	    changeTurn.setVisible(true);
	        
	        }  else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΗΣ"
	        		&& Aris.capacity(0) == false) {
	    	    
	        	// No more attacks left
	    	    errorMessageA();
	    	    changeTurn.setVisible(true);
	        
	        }
	    	
	    	
	   } else if (e.getSource() == godDefense) {
		   Bsound.Sound(click);
		   
		   godAttack.setVisible(false);
	       godDefense.setVisible(false);
		   
	       
	   	   // Several conditions to choose the right god and check whether a defense can be used or not
	       
	       if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΤΕΜΙΣ" 
	    			&& Artemis.capacity(1) == true) {
	    	   
	    	   	Artemis A = new Artemis();
               	A.insertDataD(); 
               	Artemis.RIVAL_MOVES[1]--;
                
               	changeTurn.setVisible(true);
	    	   
	       	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΤΕΜΙΣ" 
	    			&& Artemis.capacity(1) == true) {
	        	
      	     	Artemis A = new Artemis();
      	     	A.insertDataD();
      		 	Artemis.RIVAL_MOVES[1]--;
      		    
      		 	changeTurn.setVisible(true);
      	
	       	} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΔΙΑΣ" 
	    			&& Dias.capacity(1) == true) {
	        	
	    	   	Dias D = new Dias();
               	D.insertDataD(); 
               	Dias.RIVAL_MOVES[1]--;
                
               	changeTurn.setVisible(true);
               
	       	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	    			&& Dias.capacity(1) == true) {
	        	
	    	   	Dias D = new Dias();
              	D.insertDataD(); 
              	Dias.RIVAL_MOVES[1]--;
                
              	changeTurn.setVisible(true);    
	        	
	       	} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΔΙΑΣ" 
	         		&& Dias.capacity(1) == false) {
	     	     
	       		// No more defenses left
	     	    errorMessageD();
	     	    changeTurn.setVisible(true);
	     	    
	       	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	           		&& Dias.capacity(1) == false) {
	      	    
	       	    // No more defenses left
	       	    errorMessageD();
	       	    changeTurn.setVisible(true);  
	        
        	} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΤΕΜΙΣ" 
      			&& Artemis.capacity(1) == false) {
        		
        		// No more defenses left
  	        	errorMessageD();
  	        	changeTurn.setVisible(true);
  	    
         	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΤΕΜΙΣ" 
        		&& Artemis.capacity(1) == false) {
   	     
         	    // No more defenses left
    	    	errorMessageD();
    	    	changeTurn.setVisible(true);
    	    
        	} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΗΣ" 
    			&& Aris.capacity(1) == true) {
        	
	    		Aris A = new Aris();
            	A.insertDataD(); 
            	Aris.RIVAL_MOVES[1]--;
               changeTurn.setVisible(true);
               
            
	    	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΗΣ" 
	    			&& Aris.capacity(1) == true) {
	        	

		   		Aris A = new Aris();
	       		A.insertDataD(); 
	       		Aris.RIVAL_MOVES[1]--;
	            changeTurn.setVisible(true);
	           

	    	} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΗΣ" 
      				&& Artemis.capacity(1) == false) {
	    		
	    		// No more defenses left
  	        	errorMessageD();
  	        	changeTurn.setVisible(true);
  	    
         	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΗΣ" 
        			&& Artemis.capacity(1) == false) {
   	     
         	    // No more defenses left
    	    	errorMessageD();
    	    	changeTurn.setVisible(true);
         
			} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΠΟΣΕΙΔΩΝΑΣ" 
					&& Posidonas.capacity(1) == true) {
	
   				Posidonas Pd = new Posidonas();
   				Pd.insertDataD();
				pGameState = gameState;
   				pRoundNo = Posidonas.getRoundNo();
   				Posidonas.RIVAL_MOVES[1]--;
   				changeTurn.setVisible(true);
   				
   				
			} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΠΟΣΕΙΔΩΝΑΣ" 
					&& 	Posidonas.capacity(1) == true) {
			
				Posidonas Pd = new Posidonas();
				Pd.insertDataD();
   				pGameState = gameState;
   				pRoundNo = Posidonas.getRoundNo();
   				Posidonas.RIVAL_MOVES[1]--;
   				changeTurn.setVisible(true);
   				

			} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΠΟΣΕΙΔΩΝΑΣ" 
				&& Posidonas.capacity(1) == false) {
	 
				// No more defenses left
				errorMessageD();
				changeTurn.setVisible(true);
	
   			} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΠΟΣΕΙΔΩΝΑΣ" 
		  		&& Posidonas.capacity(1) == false) {
	   
   			    // No more defenses left
	  			errorMessageD();
	  			changeTurn.setVisible(true);
   			}
	   
	   // Close Error Frame (attack) 	   
	   } else if (e.getSource() == errorA) {
		   Bsound.Sound(click);
		   
	    	Aframe.setVisible(false);
	    	god.setVisible(true);
	        changeTurn.setVisible(true);
	    
	   // Close Error Frame (attack)     
	   }  else if (e.getSource() == errorD) {
	    	Bsound.Sound(click);
	    	
	    	Dframe.setVisible(false);
	    	god.setVisible(true);
	    	changeTurn.setVisible(true);

	    } else if(e.getSource()==  erButton1){
			
    		erFrame.setVisible(false);
			StracheshipBoard();
	    	sea();	
		
    	} else if(e.getSource()==  erButton2){
    		erFrame.setVisible(false);
    	}
    }
	
	// Get the number or rounds played yet
	public static int getRoundsNo() {
		return roundsNo;
	}

	public void errorBox(String mess , int buttonNumber ){
		erFrame = new JFrame("Error!!!");
		erFrame.setIconImage(logo.getImage());
		erFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		erFrame.setLayout(new FlowLayout());
		JPanel pn = new JPanel();

		JLabel message = new JLabel(mess);

		if (buttonNumber == 1){
			erButton1 = new JButton("OK");
			erButton1.addActionListener(this);
			pn.add(erButton1);
		}else{
			erButton2 = new JButton("OK");
			erButton2.addActionListener(this);
			pn.add(erButton2);
		}
		pn.add(message);
		erFrame.add(pn);
		erFrame.setVisible(true);
		erFrame.pack();		
	}
}
