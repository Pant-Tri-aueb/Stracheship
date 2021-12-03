import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game implements java.awt.event.ActionListener{
	
	private int gameState = 1;
	private int shipNo;
	
	private JButton attack;
	private JButton move;
	private JButton Up;
	private JButton Down;
	private JButton Left;
	private JButton Right;
	private JButton next;
	private JButton god;
	private JButton changeTurn;
	
	private JLabel ship;
	private JLabel playerinfo;
	
	private JTextField selectShip;
	
	private JFrame frame; 
	
	public void StracheshipBoard() {
		   frame = new JFrame();
	       frame.setBounds(10, 10, 860, 860);
	       frame.setUndecorated(false);
	       frame.setLayout(null);
	      
	       playerinfo = new JLabel(new ImageIcon(
	         		"wood2.jpg"));
	       playerinfo.setBounds(0, 0, 860, 860);
	       playerinfo.setLayout(null);
	       
	       JLabel name1 = new JLabel(MenuInterface.player1.getName());
	       JLabel name2 = new JLabel(MenuInterface.player2.getName());
	      
	       name1.setBounds(20, 780, 150, 20);
	       name2.setBounds(20, 780, 150, 20);
	       
	       name1.setFont(new Font("SansSerif", Font.BOLD, 23));
	       name2.setFont(new Font("SansSerif", Font.BOLD, 23));
	       
	       name1.setForeground(Color.BLACK);
	       name2.setForeground(Color.BLACK);
	       
	       JLabel god1 = new JLabel("GOD: " + MenuInterface.player1.getGod());
	       JLabel god2 = new JLabel("GOD: " + MenuInterface.player2.getGod());
	       
	       god1.setBounds(140, 780, 250, 20);
	       god2.setBounds(140, 780, 250, 20);
	       
	       god1.setFont(new Font("SansSerif", Font.BOLD, 23));
	       god2.setFont(new Font("SansSerif", Font.BOLD, 23));
	       
	       god1.setForeground(Color.BLACK);
	       god2.setForeground(Color.BLACK);
	      
	       changeTurn = new JButton("ΤΕΛΟΣ");	       
	       changeTurn.setBounds(765, 90, 75, 300);
	       
	       god = new JButton("ΘΕΟΣ");
	       god.setBounds(765, 400, 75, 300);
	       
	       god.addActionListener(this);
	       changeTurn.addActionListener(this);
	       
	       
	       attack = new JButton("ΕΠΙΘΕΣΗ");
	       move = new JButton("ΜΕΤΑΚΙΝΗΣΗ");
	       
	       attack.setBounds(410, 775, 130, 25);
	       move.setBounds(590, 775, 130, 25);
	       
	       attack.addActionListener(this);
	       move.addActionListener(this);
	       
	       
	       
	       if (gameState == 1) {
	    	   frame.add(name1);
	    	   frame.add(god1);
	    	  
	       } else { 
	    	   frame.add(name2);
	    	   frame.add(god2);
	       }
	       
	       ship = new JLabel("Διάλεξε πλοίο");
		   ship.setBounds(420, 775, 120, 30);
		   ship.setFont(new Font("SansSerif", Font.BOLD, 14));
		   ship.setForeground(Color.BLACK);
		    
		    selectShip = new JTextField();
			selectShip.setBounds(550, 775, 70, 30);    
			selectShip.addActionListener(this);
			
			
		    next = new JButton("Συνέχεια");
			next.setBounds(640, 775, 100, 30);
			next.addActionListener(this);
			
			
			Up = new JButton("UP");
			Down = new JButton("DOWN");
			Left = new JButton("LEFT");
			Right = new JButton("RIGHT");
			
			Left.setBounds(440, 775, 100, 25);
		    Right.setBounds(600, 775, 100, 25);
		    Up.setBounds(440, 775, 100, 25);
		    Down.setBounds(600, 775, 100, 25);
		       
			Left.addActionListener(this);
			Up.addActionListener(this);
			Down.addActionListener(this);
			Right.addActionListener(this);
			
			Left.setVisible(false);
			Down.setVisible(false);
			Up.setVisible(false);
			Right.setVisible(false);
			selectShip.setVisible(false);
			ship.setVisible(false);
	        next.setVisible(false);
			
	       playerinfo.add(next);
		   playerinfo.add(ship);
		   playerinfo.add(selectShip);
           playerinfo.add(Left);
		   playerinfo.add(Up);
		   playerinfo.add(Down);
		   playerinfo.add(Right);
		   playerinfo.add(attack);
	       playerinfo.add(move);
	       playerinfo.add(god);
	       playerinfo.add(changeTurn);
	       
	       frame.add(playerinfo);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setVisible(true);
	       
	       sea();
	   }

	public void sea() {
	
		JPanel pn = new JPanel(){
		        
	           public void paint(Graphics g) {
	               for(int y = 0; y < 10; y++ ){
	                   for(int x = 0; x < 10; x++){
	                       g.setColor(Color.BLACK);
	                       g.fillRect(x*70, y*70, 80, 70);
	                       if (MenuInterface.Deck1.deck_arr[y][x] == "S" && gameState == 1) {
	                    	  
	                    	   g.setColor(Color.GRAY);
	                       
	                       } else if (MenuInterface.Deck2.deck_arr[y][x] == "S" && gameState == 2){
	                       
	                    	   g.setColor(Color.GRAY);
	                       
	                       } else { 
	                    	  
	                    	   g.setColor(Color.BLUE);
	                       }
	                      
	                       g.fillRect(x*70+1, y*70+1, 80+1, 70+1);
	                   }
	               }
	               
	           }
	       };
	       pn.setBounds(41, 41, 729, 729);
	       pn.setLayout(null);
	       
	       frame.setLayout(null);
	       playerinfo.add(pn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == move) {
			
			attack.setVisible(false);
			move.setVisible(false);
			
			ship.setVisible(true);
			selectShip.setVisible(true);
			next.setVisible(true);
			
		
		} else if (e.getSource() == attack) {
			gameState = 1;
			frame.setVisible(false);
			StracheshipBoard();
		
		
		} else if (e.getSource() == next) {
			
			ship.setVisible(false);
			selectShip.setVisible(false);
			next.setVisible(false);
			
			shipNo = Integer.parseInt(selectShip.getText());
			
		    //  Class  ArrayList    object      getter
			if (Ship2.shipsList.get(shipNo - 1).getDirection().equals("DOWN")) {
				
				Up.setVisible(true);
				Down.setVisible(true);
			//                              shipNo -1 + 5 for player 2	
			} else if (Ship2.shipsList.get(shipNo - 1).getDirection().equals("RIGHT")) {
				
				Left.setVisible(true);
				Right.setVisible(true);
			}
		
		} else if (e.getSource() == Down) {
			Move m = new Move();
			shipNo = Integer.parseInt(selectShip.getText());
			m.moveDown(shipNo);
			
			StracheshipBoard();
			sea();
			
		
	    } else if (e.getSource() == changeTurn) {
	    	
	    	frame.setVisible(false);
	    	if (gameState == 1) {
	    		
	    		gameState = 2;
	    	} else {
	    		gameState = 1;
	    	}
	    	StracheshipBoard();
	    	sea();
	    }
		
	}
}
