import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


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
	private JButton erButton1;
	private JButton erButton2;
	private JButton chturn2;
	
	private JLabel playerinfo;
	private JLabel attackMessage;
	private JLabel shipCount1;
	private JLabel shipCount2;
	private JLabel tolerance1;
	private JLabel tolerance2;
	private JLabel notes;
	private JLabel remainingAttacks1;
	private JLabel remainingAttacks2;
	private JLabel remainingDefenses1;
	private JLabel remainingDefenses2;
	
	// Other components
	private JTextField Xattack, Yattack;
	
	public static JPanel pn;
	
	private JFrame frame; 
	private JFrame Aframe; 
	private JFrame Dframe;
	private JFrame erFrame;
	private JFrame changeFrame;
	
	// Arrays to indicate WHERE each player has already attacked
	NotesFrame hit1;
	/**
	 * 
	 */
	NotesFrame hit2;
	
	// Move class object
	Move m = new Move();
	
	// Sound files 
	static File click = new File("click.wav");
	static File cannon = new File("Bb.wav");
	static File spear = new File("Spear.wav");
	static File bloom = new File("Splash.wav");
	
	// Main logo
	static ImageIcon logo = new ImageIcon("logo.png");
	
	public Game() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		StracheshipBoard();
		
	}
	
	// Operating frame
	public void StracheshipBoard() {
	
	       frame = new JFrame();
	       frame.setIconImage(logo.getImage());
	       frame.setBounds(10, 10, 1720, 860);
	       frame.setUndecorated(false);
	       frame.setLayout(null);
	       frame.setResizable(false);
	      
	       // Wooden Background
	       playerinfo = new JLabel(new ImageIcon(
	         		"wood3.jpg"));
	       playerinfo.setBounds(0, 0, 1720, 860);
	       playerinfo.setLayout(null);
	       
	       
		   if (roundsNo == 1 && shipNo == 1) {
			    
			
			   hit1 = new NotesFrame();
			   hit1.gamePAN.setBounds(1050, 100, 500, 500);
			   hit1.gamePAN.setVisible(true);
			   
			   hit2 = new NotesFrame();
			   hit2.gamePAN.setBounds(1050, 100, 500, 500);
			   hit2.gamePAN.setVisible(false);
		   
		   } else if (roundsNo == 2 && shipNo == 1) {
			   hit1.gamePAN.setVisible(false);	
			   hit2.gamePAN.setVisible(true);
		   }
	       
		   if (gameState == 1 && roundsNo > 1) {
			   hit2.gamePAN.setVisible(false);
			   hit1.gamePAN.setVisible(true);
			   
		   } else if (gameState == 2) {
			   hit1.gamePAN.setVisible(false);
			   hit2.gamePAN.setVisible(true);
		   }
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
	      
	       name1.setBounds(120, 778, 270, 20);
	       name2.setBounds(120, 778, 270, 20);
	       
	       name1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 23));
	       name2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 23));
	       
	       name1.setForeground(Color.WHITE);
	       name2.setForeground(Color.WHITE);
	       
	       // Each player god 
	       JLabel god1 = new JLabel("GOD: " + MenuInterface.player1.getGod());
	       JLabel god2 = new JLabel("GOD: " + MenuInterface.player2.getGod());
	       
	       god1.setBounds(450, 780, 250, 20);
	       god2.setBounds(450, 780, 250, 20);
	       
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
	    	   
	    	   if (Integer.parseInt(life) >= 1000) {
	   		   	
	    		   life = Character.toString('\u221E');
	   		   
	    	   }
	    	   
	       } else if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() == 0) {
	    			   
	    	   life = "SUNK";	
	    	   
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() != 0) {
	    	   
	    	   life = String.format("%d", Ship2.shipsList.get(shipNo + 4).getTolerance());
	    	   
	    	   if (Integer.parseInt(life) >= 1000) {
		   		   	
	    		   life = Character.toString('\u221E');
	   		   
	    	   }
	    	   
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() == 0 ){
	    	    
	    	   life = "SUNK";
	    	   
	       }
	       
	       tolerance1 = new JLabel("TOLERANCE");
	       tolerance2 = new JLabel(life);
	       
	       tolerance1.setBounds(823, 200, 160, 30);
	       
	       if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 ) {

	    	   tolerance2.setBounds(885, 240, 75, 30);
	       
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() != 0) {
	    	   
	    	   tolerance2.setBounds(885, 240, 75, 30);
	       
	       } else if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() == 0 ) {
	    	   
	    	   tolerance2.setBounds(858, 240, 140, 30);
	       
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() == 0 ) {
	    	   
	    	   tolerance2.setBounds(858, 240, 140, 30);
	       }

	       
	       tolerance1.setForeground(Color.WHITE);
	       tolerance2.setForeground(Color.WHITE);
	       
	       tolerance1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
	       tolerance2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 23));
	       
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
	       
	       shipCount1.setBounds(861, 90, 75, 30);
	       shipCount2.setBounds(881, 125, 75, 30);
	       
	       shipCount1.setForeground(Color.WHITE);
	       shipCount2.setForeground(Color.WHITE);
	       
	       shipCount1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 23));
	       shipCount2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
	       
	       // Some useful BACK buttons
	       backMove = new JButton("BACK");
	       backAttack = new JButton("BACK");
	       
	       backMove.setBounds(855, 670, 90, 35);
	       backAttack.setBounds(855, 670, 90, 35);
	       
	       backMove.addActionListener(this);
	       backAttack.addActionListener(this);
	       
	       backMove.setBackground(Color.GRAY);
	       backAttack.setBackground(Color.GRAY);
	       
	       backMove.setForeground(Color.WHITE);
	       backAttack.setForeground(Color.WHITE);
	       
	       backMove.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
	       backAttack.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
	       
	       notes = new JLabel("TAKE YOUR NOTES HERE");
	       notes.setBounds(1130, 630, 600, 100);
	       notes.setForeground(Color.WHITE);
	       notes.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
	       
	       // Attack button
	       next = new JButton("FIRE!");
	       next.setBounds(780, 500, 240, 45);
	       next.addActionListener(this);
	       next.setBackground(Color.red);
	       next.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 17));
	       
	       // Next turn
	       changeTurn = new JButton("NEXT");	       
	       changeTurn.setBounds(765, 90, 95, 300);
	       changeTurn.setFont(new Font("Castellar", Font.BOLD, 11));
	       changeTurn.setForeground(new Color(255,215,0));
	       changeTurn.setBackground(Color.BLACK);
	       
	       // Use god 
	       god = new JButton("GOD");
	       god.setBounds(765, 400, 95, 300);
	       god.setFont(new Font("Castellar", Font.BOLD, 14));
	       god.setForeground(new Color(255,215,0));
	       god.setBackground(Color.BLACK);
	       
	       god.addActionListener(this);
	       changeTurn.addActionListener(this);
	       
	       // For god Attacks and Defenses Labels
	       String Amessage1 = "";
	       String Amessage2 = "";
	       String Dmessage1 = "";
	       String Dmessage2 = "";
	       
	       if (gameState == 1 && MenuInterface.player1.getGod().equals("ΔΙΑΣ")) {
	    	   if (Dias.RIVAL_MOVES[0] == 1) {
	    		   Amessage1 = "YOU HAVE 1";
	    		   Amessage2 = "ATTACK LEFT";
	    	   
	    	   } else {
	    		   Amessage1 = "YOU HAVE NO";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   }
	       
	       } else if (gameState == 2 && MenuInterface.player2.getGod().equals("ΔΙΑΣ")) {
	    	   if (Dias.RIVAL_MOVES[0] == 1) {
                   Amessage1 = "YOU HAVE 1";
                   Amessage2 = "ATTACK LEFT";
	    		   
	    	   } else {
	    		   Amessage1 = "YOU HAVE NO";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   }
	       
	       } else if (gameState == 1 && MenuInterface.player1.getGod().equals("ΑΡΤΕΜΙΣ")) {
	    	   if(Artemis.RIVAL_MOVES[0] == 2) {
	    		   Amessage1 = "YOU HAVE 2";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   
	    	   } else if (Artemis.RIVAL_MOVES[0] == 1) {
	    		   Amessage1 = "YOU HAVE 1";
                   Amessage2 = "ATTACK LEFT";
	    	   
	    	   } else {
	    		   Amessage1 = "YOU HAVE NO";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   }
	    	   
	       } else if (gameState == 2 && MenuInterface.player2.getGod().equals("ΑΡΤΕΜΙΣ")) {
	    	   if(Artemis.RIVAL_MOVES[0] == 2) {
	    		   Amessage1 = "YOU HAVE 2";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   
	    	   } else if (Artemis.RIVAL_MOVES[0] == 1) {
	    		   Amessage1 = "YOU HAVE 1";
                   Amessage2 = "ATTACK LEFT";
	    	   
	    	   } else {
	    		   Amessage1 = "YOU HAVE NO";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   }
	    	   
	       } else if (gameState == 1 && MenuInterface.player1.getGod().equals("ΑΡΗΣ")) {
	    	   if (Aris.RIVAL_MOVES[0] == 1) {
	    		   Amessage1 = "YOU HAVE 1";
	    		   Amessage2 = "ATTACK LEFT";
	    	   
	    	   } else {
	    		   Amessage1 = "YOU HAVE NO";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   }
	       
	       } else if (gameState == 2 && MenuInterface.player2.getGod().equals("ΑΡΗΣ")) {
	    	   if (Aris.RIVAL_MOVES[0] == 1) {
                   Amessage1 = "YOU HAVE 1";
                   Amessage2 = "ATTACK LEFT";
	    		   
	    	   } else {
	    		   Amessage1 = "YOU HAVE NO";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   }
	       
	       } else if (gameState == 1 && MenuInterface.player1.getGod().equals("ΠΟΣΕΙΔΩΝΑΣ")) {
	    	   if (Posidonas.RIVAL_MOVES[0] == 1) {
	    		   Amessage1 = "YOU HAVE 1";
	    		   Amessage2 = "ATTACK LEFT";
	    	   
	    	   } else {
	    		   Amessage1 = "YOU HAVE NO";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   }
	       
	       } else if (gameState == 2 && MenuInterface.player2.getGod().equals("ΠΟΣΕΙΔΩΝΑΣ")) {
	    	   if (Posidonas.RIVAL_MOVES[0] == 1) {
                   Amessage1 = "YOU HAVE 1";
                   Amessage2 = "ATTACK LEFT";
	    		   
	    	   } else {
	    		   Amessage1 = "YOU HAVE NO";
	    		   Amessage2 = "ATTACKS LEFT";
	    	   }
	       
	       }
	       
	       remainingAttacks1 = new JLabel(Amessage1);
	       remainingAttacks1.setBounds(860, 200, 190, 40);
	       remainingAttacks1.setForeground(Color.WHITE);
	       remainingAttacks1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16)); 
	       remainingAttacks1.setVisible(false);
	       
	       remainingAttacks2 = new JLabel(Amessage2);
	       remainingAttacks2.setBounds(860, 245, 190, 40);
	       remainingAttacks2.setForeground(Color.WHITE);
	       remainingAttacks2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16)); 
	       remainingAttacks2.setVisible(false);
	       
	       if (gameState == 1 && MenuInterface.player1.getGod().equals("ΔΙΑΣ")) {
	    	   if (Dias.RIVAL_MOVES[1] == 2) {
	    		   Dmessage1 = "YOU HAVE 2";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   
	    	   } else if (Dias.RIVAL_MOVES[1] == 1) {
	    		   Dmessage1 = "YOU HAVE 1";
	    		   Dmessage2 = "DEFENSE LEFT";
	    	   
	    	   } else {
	    		   Dmessage1 = "YOU HAVE NO";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   }
	       
	       } else if (gameState == 2 && MenuInterface.player2.getGod().equals("ΔΙΑΣ")) {
	    	   if (Dias.RIVAL_MOVES[1] == 2) {
	    		   Dmessage1 = "YOU HAVE 2";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   
	    	   } else if (Dias.RIVAL_MOVES[1] == 1) {
	    		   Dmessage1 = "YOU HAVE 1";
	    		   Dmessage2 = "DEFENSE LEFT";
	    	   
	    	   } else {
	    		   Dmessage1 = "YOU HAVE NO";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   }
	       
	       } else if (gameState == 1 && MenuInterface.player1.getGod().equals("ΑΡΤΕΜΙΣ")) {
	    	   if(Artemis.RIVAL_MOVES[1] == 2) {
	    		   Dmessage1 = "YOU HAVE 2";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   
	    	   } else if (Artemis.RIVAL_MOVES[1] == 1) {
	    		   Dmessage1 = "YOU HAVE 1";
                   Dmessage2 = "DEFENSE LEFT";
	    	   
	    	   } else {
	    		   Dmessage1 = "YOU HAVE NO";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   }
	    	   
	       } else if (gameState == 2 && MenuInterface.player2.getGod().equals("ΑΡΤΕΜΙΣ")) {
	    	   if(Artemis.RIVAL_MOVES[1] == 2) {
	    		   Dmessage1 = "YOU HAVE 2";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   
	    	   } else if (Artemis.RIVAL_MOVES[1] == 1) {
	    		   Dmessage1 = "YOU HAVE 1";
                   Dmessage2 = "DEFENSE LEFT";
	    	   
	    	   } else {
	    		   Dmessage1 = "YOU HAVE NO";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   }
	    	   
	       } else if (gameState == 1 && MenuInterface.player1.getGod().equals("ΑΡΗΣ")) {
	    	   if(Aris.RIVAL_MOVES[1] == 2) {
	    		   Dmessage1 = "YOU HAVE 2";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   
	    	   } else if (Aris.RIVAL_MOVES[1] == 1) {
	    		   Dmessage1 = "YOU HAVE 1";
                   Dmessage2 = "DEFENSE LEFT";
	    	   
	    	   } else {
	    		   Dmessage1 = "YOU HAVE NO";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   }
	    	   
	       
	       } else if (gameState == 2 && MenuInterface.player2.getGod().equals("ΑΡΗΣ")) {
	    	   if(Aris.RIVAL_MOVES[1] == 2) {
	    		   Dmessage1 = "YOU HAVE 2";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   
	    	   } else if (Aris.RIVAL_MOVES[1] == 1) {
	    		   Dmessage1 = "YOU HAVE 1";
                   Dmessage2 = "DEFENSE LEFT";
	    	   
	    	   } else {
	    		   Dmessage1 = "YOU HAVE NO";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   }
	    	   
	       
	       } else if (gameState == 1 && MenuInterface.player1.getGod().equals("ΠΟΣΕΙΔΩΝΑΣ")) {
	    	   if (Posidonas.RIVAL_MOVES[1] == 1) {
	    		   Dmessage1 = "YOU HAVE 1";
	    		   Dmessage2 = "DEFENSE LEFT";
	    	   
	    	   } else {
	    		   Dmessage1 = "YOU HAVE NO";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   }
	       
	       } else if (gameState == 2 && MenuInterface.player2.getGod().equals("ΠΟΣΕΙΔΩΝΑΣ")) {
	    	   if (Posidonas.RIVAL_MOVES[1] == 1) {
	    		   Dmessage1 = "YOU HAVE 1";
	    		   Dmessage2 = "DEFENSE LEFT";
	    	   
	    	   } else {
	    		   Dmessage1 = "YOU HAVE NO";
	    		   Dmessage2 = "DEFENSES LEFT";
	    	   }
	       
	       }
	       
	       remainingDefenses1 = new JLabel(Dmessage1);
	       remainingDefenses1.setBounds(860, 460, 190, 40);
	       remainingDefenses1.setForeground(Color.WHITE);
	       remainingDefenses1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
	       remainingDefenses1.setVisible(false);
	       
	       remainingDefenses2 = new JLabel(Dmessage2);
	       remainingDefenses2.setBounds(860, 505, 190, 40);
	       remainingDefenses2.setForeground(Color.WHITE);
	       remainingDefenses2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16)); 
	       remainingDefenses2.setVisible(false);
	       
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
	       
	       Xattack.setBounds(900, 400, 50, 30);
	       Yattack.setBounds(970, 400, 50, 30);
	       attackMessage.setBounds(780, 400, 140, 30);
	       
	       attackMessage.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
	       attackMessage.setForeground(Color.WHITE);
	       
	       // Ship's choice whether to attack or move 
	       attack = new JButton("ATTACK");
	       move = new JButton("MOVE");
	       
	       attack.setBounds(808, 430, 180, 40);
	       move.setBounds(808, 570, 180, 40);
	       
	       attack.addActionListener(this);
	       move.addActionListener(this);
	       
	       attack.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
	       move.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
	       
	       attack.setBackground(Color.GRAY);
	       move.setBackground(Color.GRAY);
	       
	       attack.setForeground(Color.WHITE);
	       move.setForeground(Color.WHITE);
	       
	       // In case this ship is sinked (0 tolerance)
	       sinkedNext = new JButton("NEXT SHIP");
	       sinkedNext.setBounds(808, 430, 180, 40);
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
			
			Left.setBounds(808, 430, 180, 40);
		    Right.setBounds(808, 570, 180, 40);
		    Up.setBounds(808, 430, 180, 40);
		    Down.setBounds(808, 570, 180, 40);
		      
		    Left.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		    Right.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		    Up.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		    Down.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		    
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
	       playerinfo.add(notes);
	       playerinfo.add(hit1.gamePAN);
	       playerinfo.add(hit2.gamePAN);
	       playerinfo.add(remainingAttacks1);
	       playerinfo.add(remainingAttacks2);
	       playerinfo.add(remainingDefenses1);
	       playerinfo.add(remainingDefenses2);
	       
	       // Show or Hide several buttons, with conditions
	       
	       // Ship 1-5, not sinked, first player, normal tolerance
	       if (shipNo <= 5 && (Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 &&
	    		   Ship2.shipsList.get(shipNo - 1).getTolerance() < 500) && gameState == 1) {
	         
	    	   god.setVisible(false);
	           changeTurn.setVisible(false);
	           attack.setVisible(true);
	           move.setVisible(true);
	           sinkedNext.setVisible(false);
	   
	       // Ship 1-5, not sinked, first player, infinite tolerance    
	       } else if (shipNo <= 5 && (Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 &&
		    		   Ship2.shipsList.get(shipNo - 1).getTolerance() > 500) && gameState == 1) {
		         
	    	   god.setVisible(false);
		       changeTurn.setVisible(false);
		       attack.setVisible(true);
		       move.setVisible(false);
		       sinkedNext.setVisible(false);
		      
	       
	       // Ship 1-5, not sinked, second player, normal tolerance 
	       } else if (shipNo <= 5 && (Ship2.shipsList.get(shipNo + 4).getTolerance() != 0 &&
	    		   Ship2.shipsList.get(shipNo + 4).getTolerance() < 500) && gameState == 2) {
	         
    	      god.setVisible(false);
	          changeTurn.setVisible(false);
	          attack.setVisible(true);
	          move.setVisible(true);
	          sinkedNext.setVisible(false);
	          
	       // Ship 1-5, not sinked, second player, infinite tolerance 
	       } else if (shipNo <= 5 && (Ship2.shipsList.get(shipNo + 4).getTolerance() != 0 &&
	    		   Ship2.shipsList.get(shipNo + 4).getTolerance() > 500) && gameState == 2) {
	         
    	      god.setVisible(false);
	          changeTurn.setVisible(false);
	          attack.setVisible(true);
	          move.setVisible(false);
	          sinkedNext.setVisible(false);
	         
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
	    	   
	    	   frame.setVisible(false);
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
        Aframe.setResizable(false);
        JPanel pn = new JPanel();
        
        JLabel message = new JLabel("NO MORE ATTACKS AVAILABLE!");
        
        errorA = new JButton("OK");
        errorA.addActionListener(this);
       
        pn.add(errorA);
        pn.add(message);
        
        Aframe.add(pn);
        Aframe.setVisible(true);
        Aframe.pack();
	}
	
	// In case player god's defenses are over 
    public void errorMessageD(int x) {
		
		Dframe = new JFrame("Error");
        Dframe.setIconImage(logo.getImage());
		Dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dframe.setLayout(new FlowLayout());
        Dframe.setResizable(false);
        JPanel pn = new JPanel();
		JLabel message;
		if (x == 1){
			//For every god.
			message = new JLabel("NO MORE DEFENCES AVAILABLE!");
		}else if (x == 2){
			//For Artemis.
			message = new JLabel("ALL YOUR SHIPS HAVE FULL LIFE.");
		}else{
			//For Dias.
			message = new JLabel("THERE IS NO SUNKEN SHIP.");
		}
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
	    	changeFrame();
	    	
	    	if (gameState == 1) {
	    		
	    		gameState = 2;
	    	
	    	} else {
	    		
	    		gameState = 1;
	    	}
	    	roundsNo += 1;
	    	shipNo = 1;
	    	
	    
	    } else if (e.getSource() == chturn2) {
	    	
	    	changeFrame.setVisible(false);
	    	StracheshipBoard();
	    	sea();
	    	
	    	
	    // Shoot 	
	    } else if (e.getSource() == next) {
	    	
	    	Bsound.Sound(click);
	    	
	    	backAttack.setVisible(false);
	    	boolean chekError= false;
			try {
					int x = Integer.parseInt(Xattack.getText());
					int y = Integer.parseInt(Yattack.getText());
					
					if (gameState == 1) {
						
						if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("S")) { // normal block hit
							
							Bsound.Sound(cannon);
							MenuInterface.Deck2.deck_arr[x-1][y-1] = "X";
						
						} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("A")) { // armored block hit
							
							Bsound.Sound(cannon);
							MenuInterface.Deck2.deck_arr[x-1][y-1] = "S";

						} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("U")) { // Posidonas block hit
							Bsound.Sound(cannon);
							MenuInterface.Deck2.deck_arr[x-1][y-1] = "U";	

						} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("X")) { // damaged block hit
							Bsound.Sound(cannon);
							MenuInterface.Deck2.deck_arr[x-1][y-1] = "X";
						
						} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("O")) {
							
							Bsound.Sound(bloom);
						}
					
					} else {
						
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

						} else if (MenuInterface.Deck1.deck_arr[x-1][y-1].equals("O")) {
							
							Bsound.Sound(bloom);
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
	    	Bsound.Sound(click);
	    	
	    	backAttack.setVisible(false);
	    	next.setVisible(false);
	    	Xattack.setVisible(false);
	    	Yattack.setVisible(false);
	    	attackMessage.setVisible(false);
	    	move.setVisible(true);
	    	attack.setVisible(true);
	    
	    // Another back button	
	    } else if (e.getSource() == backMove) {	
	    	Bsound.Sound(click);
	    	
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
	    	remainingAttacks1.setVisible(true);
	    	remainingAttacks2.setVisible(true);
	    	remainingDefenses1.setVisible(true);
	    	remainingDefenses2.setVisible(true);
	    	
	    // Choose god attack
	    } else if (e.getSource() == godAttack) {
	    	Bsound.Sound(click);
	    	
	    	remainingAttacks1.setVisible(false);
	    	remainingAttacks2.setVisible(false);
	    	remainingDefenses1.setVisible(false);
	    	remainingDefenses2.setVisible(false);
	    	
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
	        		&& Dias.capacity(0) == false) {
	    	     
	        	// No more attacks left 
	    	    errorMessageA();
	    	    changeTurn.setVisible(true);
	    	    
	        
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	        		&& Dias.capacity(0) == false) {
	        	
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
	        	Bsound.Sound(spear); 
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
		   
		   remainingAttacks1.setVisible(false);
	       remainingAttacks2.setVisible(false);
	       remainingDefenses1.setVisible(false);
	       remainingDefenses2.setVisible(false);
		   
		   godAttack.setVisible(false);
	       godDefense.setVisible(false);
		   
	       
	   	   // Several conditions to choose the right god and check whether a defense can be used or not
	       
	       if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΤΕΜΙΣ" 
	    			&& Artemis.capacity(1) == true) {

					if (Artemis.checkShipsTolerance(gameState)){
						Artemis A = new Artemis();
						A.insertDataD(); 
						Artemis.RIVAL_MOVES[1]--;
					 
						changeTurn.setVisible(true);
					}else{
						errorMessageD(2);
					}  
	       	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΤΕΜΙΣ" 
	    			&& Artemis.capacity(1) == true) {
	        	
						if (Artemis.checkShipsTolerance(gameState)){
							Artemis A = new Artemis();
							A.insertDataD(); 
							Artemis.RIVAL_MOVES[1]--;
						 
							changeTurn.setVisible(true);
						}else{
							errorMessageD(2);
						}
      	
	       	} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΔΙΑΣ" 
	    			&& Dias.capacity(1) == true) {
	        	
					if(Dias.checkShipsTolerance(gameState)){
						Dias D = new Dias();
						D.insertDataD(); 
						Dias.RIVAL_MOVES[1]--;
					 
						changeTurn.setVisible(true);
					}else{
						errorMessageD(3);
					}
	    	   
               
	       	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	    			&& Dias.capacity(1) == true) {
						
						if(Dias.checkShipsTolerance(gameState)){
							Dias D = new Dias();
							D.insertDataD(); 
							Dias.RIVAL_MOVES[1]--;
						 
							changeTurn.setVisible(true);
						}else{
							errorMessageD(3);
						}    
	        	
	       	} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΔΙΑΣ" 
	         		&& Dias.capacity(1) == false) {
	     	     
	       		// No more defenses left
	     	    errorMessageD(1);
	     	    changeTurn.setVisible(true);
	     	    
	       	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	           		&& Dias.capacity(1) == false) {
	      	    
	       	    // No more defenses left
	       	    errorMessageD(1);
	       	    changeTurn.setVisible(true);  
	        
        	} else if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΤΕΜΙΣ" 
      			&& Artemis.capacity(1) == false) {
        		
        		// No more defenses left
  	        	errorMessageD(1);
  	        	changeTurn.setVisible(true);
  	    
         	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΤΕΜΙΣ" 
        		&& Artemis.capacity(1) == false) {
   	     
         	    // No more defenses left
    	    	errorMessageD(1);
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
  	        	errorMessageD(1);
  	        	changeTurn.setVisible(true);
  	    
         	} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΗΣ" 
        			&& Artemis.capacity(1) == false) {
   	     
         	    // No more defenses left
    	    	errorMessageD(1);
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
				errorMessageD(1);
				changeTurn.setVisible(true);
	
   			} else if (gameState == 2 && MenuInterface.player2.getGod() == "ΠΟΣΕΙΔΩΝΑΣ" 
		  		&& Posidonas.capacity(1) == false) {
	   
   			    // No more defenses left
	  			errorMessageD(1);
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
	    	Bsound.Sound(click);
	    	
    		erFrame.setVisible(false);
			StracheshipBoard();
	    	sea();	
		
    	} else if(e.getSource()==  erButton2){
    		Bsound.Sound(click);
    		
    		erFrame.setVisible(false);
    	}
    }
	
	// Get the number or rounds played yet
	public static int getRoundsNo() {
		return roundsNo;
	}

	public void changeFrame() {
		changeFrame = new JFrame();
		changeFrame.setIconImage(logo.getImage());
		changeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changeFrame.setLayout(null);
		changeFrame.setBounds(600, 200, 400, 400);
		changeFrame.setVisible(true);
		changeFrame.setResizable(false);
		
		JLabel pn = new JLabel((new ImageIcon("wood3.jpg")));
		pn.setBounds(0, 0, 400, 400);
		
		JLabel message = new JLabel("TURN AROUND!");
		message.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
		message.setBounds(85, 50, 250, 70);
		message.setForeground(Color.WHITE);
		
		chturn2 = new JButton("NEXT");
		chturn2.addActionListener(this);
		chturn2.setBounds(120, 225, 140, 50);
		chturn2.setBackground(Color.GRAY);
		chturn2.setForeground(Color.WHITE);
		chturn2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 17));
		
		pn.add(chturn2);
		pn.add(message);
		changeFrame.add(pn);
	}
	
	public void errorBox(String mess , int buttonNumber ){
		erFrame = new JFrame("Error!!!");
		erFrame.setIconImage(logo.getImage());
		erFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		erFrame.setLayout(new FlowLayout());
		erFrame.setResizable(false);
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
