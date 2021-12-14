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

public class Game extends JFrame implements java.awt.event.ActionListener{
	
	public static int gameState = 1;
	private int shipNo = 1;
	
	private JButton attack;
	private JButton move;
	private JButton Up;
	private JButton Down;
	private JButton Left;
	private JButton Right;
	private JButton god;
	public JButton changeTurn;
	private JButton next;
	private JButton sinkedNext;
	private JButton godAttack;
	private JButton godDefense;
	private JButton errorA;
	private JButton errorD;
	
	private JLabel playerinfo;
	private JLabel attackMessage;
	private JLabel shipCount1;
	private JLabel shipCount2;
	private JLabel tolerance1;
	private JLabel tolerance2;
	
	private JTextField Xattack, Yattack;
	
	
	private JFrame frame; 
	private JFrame Aframe; 
	private JFrame Dframe; 
	
	
	Move m = new Move();
	
	static File click = new File("click.wav");
	static File cannon = new File("Boom.wav");
	
	public void StracheshipBoard() {
		   
		   frame = new JFrame();
	       frame.setBounds(10, 10, 860, 860);
	       frame.setUndecorated(false);
	       frame.setLayout(null);
	      
	       playerinfo = new JLabel(new ImageIcon(
	         		"wood3.jpg"));
	       playerinfo.setBounds(0, 0, 860, 860);
	       playerinfo.setLayout(null);
	       
	       
	       
	       JLabel name1 = new JLabel(MenuInterface.player1.getName());
	       JLabel name2 = new JLabel(MenuInterface.player2.getName());
	      
	       name1.setBounds(20, 780, 170, 20);
	       name2.setBounds(20, 780, 170, 20);
	       
	       name1.setFont(new Font("SansSerif", Font.BOLD, 23));
	       name2.setFont(new Font("SansSerif", Font.BOLD, 23));
	       
	       name1.setForeground(Color.WHITE);
	       name2.setForeground(Color.WHITE);
	       
	      
	      
	       JLabel god1 = new JLabel("ΘΕΟΣ: " + MenuInterface.player1.getGod());
	       JLabel god2 = new JLabel("ΘΕΟΣ: " + MenuInterface.player2.getGod());
	       
	       god1.setBounds(220, 780, 250, 20);
	       god2.setBounds(220, 780, 250, 20);
	       
	       god1.setFont(new Font("SansSerif", Font.BOLD, 23));
	       god2.setFont(new Font("SansSerif", Font.BOLD, 23));
	       
	       god1.setForeground(Color.WHITE);
	       god2.setForeground(Color.WHITE);
	      
           for (int i = 0; i < 5; i++) {
	    	   
	    	   Ship2.shipsList.get(i).updateTolerance(MenuInterface.Deck1);
	       
	       }
           for (int i = 5; i < 10; i++) {
	    	   
	    	   Ship2.shipsList.get(i).updateTolerance(MenuInterface.Deck2);
	       
	       }
	       
	       String life = "";
	     
	       
	       if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 ) {
	    	  
	    	   life = String.format("%d", Ship2.shipsList.get(shipNo - 1).getTolerance());
	    	  
	       } else if (gameState == 1 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo - 1).getTolerance() == 0) {
	    			   
	    	   life = "ΒΥΘΙΣΤΗΚΕ";	
	    	   
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() != 0) {
	    	   
	    	   life = String.format("%d", Ship2.shipsList.get(shipNo + 4).getTolerance());
	    	   
	    	   
	       } else if (gameState == 2 && shipNo <= 5 
	    		   && Ship2.shipsList.get(shipNo + 4).getTolerance() == 0 ){
	    	    
	    	   life = "ΒΥΘΙΣΤΗΚΕ";
	    	   
	       }
	       
	       tolerance1 = new JLabel("ANTOXH");
	       tolerance2 = new JLabel(life);
	       
	       tolerance1.setBounds(762, 200, 100, 30);
	       
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
	    	   
	    	   tolerance2.setBounds(756, 240, 100, 30);
	       }

	       
	       tolerance1.setForeground(Color.WHITE);
	       tolerance2.setForeground(Color.WHITE);
	       
	       tolerance1.setFont(new Font("SansSerif", Font.BOLD, 17));
	       tolerance2.setFont(new Font("SansSerif", Font.BOLD, 15));
	       
	       shipCount1 = new JLabel("ΠΛΟΙΟ");
	       shipCount2 = new JLabel(String.format("%do", shipNo));	       
	       
	       shipCount1.setBounds(765, 90, 75, 30);
	       shipCount2.setBounds(785, 125, 75, 30);
	       
	       shipCount1.setForeground(Color.WHITE);
	       shipCount2.setForeground(Color.WHITE);
	       
	       shipCount1.setFont(new Font("SansSerif", Font.BOLD, 19));
	       shipCount2.setFont(new Font("SansSerif", Font.BOLD, 19));
	       
	       next = new JButton("ΠΥΡ!");
	       next.setBounds(765, 600, 75, 30);
	       next.addActionListener(this);
	       
	       changeTurn = new JButton("ΤΕΛΟΣ");	       
	       changeTurn.setBounds(765, 90, 75, 300);
	       
	       god = new JButton("ΘΕΟΣ");
	       god.setBounds(765, 400, 75, 300);
	       
	       god.addActionListener(this);
	       changeTurn.addActionListener(this);
	       
	       godAttack = new JButton(new ImageIcon("swords.jpg"));
	       godDefense = new JButton(new ImageIcon("shield.jpg"));
	       
	       godAttack.setBounds(767, 90, 72, 250);
	       godDefense.setBounds(767, 350, 72, 250);
	       
	       godAttack.addActionListener(this);
	       godDefense.addActionListener(this);
	       
	       attackMessage = new JLabel("ΕΠΙΘΕΣΗ ΣΤΟ");
	       Xattack = new JTextField();
	       Yattack = new JTextField();
	       
	       
	       Xattack.setBounds(660, 775, 30, 30);
	       Yattack.setBounds(710, 775, 30, 30);
	       attackMessage.setBounds(480, 775, 140, 30);
	       
	       attackMessage.setFont(new Font("SansSerif", Font.BOLD, 18));
	       attackMessage.setForeground(Color.WHITE);
	       
	       attack = new JButton("ΕΠΙΘΕΣΗ");
	       move = new JButton("ΜΕΤΑΚΙΝΗΣΗ");
	       
	       attack.setBounds(480, 775, 130, 25);
	       move.setBounds(660, 775, 130, 25);
	       
	       attack.addActionListener(this);
	       move.addActionListener(this);
	       
	       sinkedNext = new JButton("ΣΥΝΕΧΕΙΑ");
	       sinkedNext.setBounds(580, 775, 130, 25);
	       sinkedNext.addActionListener(this);
	       
	       
	       if (gameState == 1) {
	    	   frame.add(name1);
	    	   frame.add(god1);
	    	  
	       } else { 
	    	   frame.add(name2);
	    	   frame.add(god2);
	       }
	       
	        
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
			Xattack.setVisible(false);
			Yattack.setVisible(false);
			attackMessage.setVisible(false);
	        next.setVisible(false);
	        godAttack.setVisible(false);
	        godDefense.setVisible(false);
			
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
	       
	       if (shipNo <= 5 && Ship2.shipsList.get(shipNo - 1).getTolerance() != 0 && gameState == 1) {
	         
	    	 god.setVisible(false);
	         changeTurn.setVisible(false);
	         attack.setVisible(true);
	         move.setVisible(true);
	         sinkedNext.setVisible(false);
	        
	       } else if (shipNo <= 5 && Ship2.shipsList.get(shipNo + 4).getTolerance() != 0 
	        		&& gameState == 2) {
		         
		    	 god.setVisible(false);
		         changeTurn.setVisible(false);
		         attack.setVisible(true);
		         move.setVisible(true);
		         sinkedNext.setVisible(false);
		         
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
           
	       } else if (shipNo <= 5 && Ship2.shipsList.get(shipNo - 1).getTolerance() == 0 
	    		   && gameState == 1) {
	    	   
	    	   god.setVisible(false);
		       changeTurn.setVisible(false);
	    	   attack.setVisible(false);
	    	   move.setVisible(false);
	    	   sinkedNext.setVisible(true);
	    	   tolerance1.setVisible(true);
	    	   tolerance2.setVisible(true);
	    	   
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
	       
	       for (int i = 0; i < 10; i++) {
	    	   
	    	   Ship2 ship = Ship2.shipsList.get(i);
	    	   
	    	   if (i < 5) {
	    		   if (ship.isDestroyed1() == true) {
	    			  
	    			   for (int j = 0; j < ship.getSize(); j++) {
	    				   
	    				   MenuInterface.Deck1.deck_arr[ship.xy[j][0]][ship.xy[j][1]] = "O";
	    			   
	    			   }
	    			  
	    			  
	    		   }
	    	   
	    		   
	    	   } else {
	    		   
	    		   if (ship.isDestroyed2() == true) {
		    			  
	    			   for (int j = 0; j < ship.getSize(); j++) {
	    				   
	    				   MenuInterface.Deck2.deck_arr[ship.xy[j][0]][ship.xy[j][1]] = "O";
	    			   
	    			   }
	    			  
	    			  
	    		   }
	    	   }
	       } 
	       
	      
	       sea();
	       
	    
	       if (MenuInterface.Deck1.checkWinner() == true || MenuInterface.Deck2.checkWinner() == true) {
	    	   
	    	   GUIWINNER.winner();
	       }
	      
	    	   
	       
	   }

	public void sea() {
	
		JPanel pn = new JPanel(){
		        
	           public void paint(Graphics g) {
	               for(int y = 0; y < 10; y++ ){
	                   for(int x = 0; x < 10; x++){
	                       g.setColor(Color.BLACK);
	                       g.fillRect(x*70, y*70, 80, 70);
	                       if (MenuInterface.Deck1.deck_arr[y][x] == "S" && gameState == 1) {
	                    	  
	                    	   g.setColor(Color.LIGHT_GRAY);
	                       
	                       } else if (MenuInterface.Deck2.deck_arr[y][x] == "S" && gameState == 2){
	                       
	                    	   g.setColor(Color.LIGHT_GRAY);
	                       
	                       } else if (MenuInterface.Deck1.deck_arr[y][x] == "X" && gameState == 1) {
	                    	   
	                    	   g.setColor(Color.RED);
	                       
                           } else if (MenuInterface.Deck2.deck_arr[y][x] == "X" && gameState == 2) {
	                    	   
	                    	   g.setColor(Color.RED);	                    	   
	                       
                           } else if (MenuInterface.Deck1.deck_arr[y][x] == "A" && gameState == 1) {
                        	    
                        	   g.setColor(Color.GRAY);
                           
                           } else if (MenuInterface.Deck2.deck_arr[y][x] == "A" && gameState == 2) {
	                    	   
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
	
	public void errorMessageA() {
		
		Aframe = new JFrame("Error");
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
	
    public void errorMessageD() {
		
		Dframe = new JFrame("Error");
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == move) {
			Bsound.Sound(click);
			
			attack.setVisible(false);
			move.setVisible(false);
		    
			//  Class  ArrayList    object      getter
            if (gameState == 1 && Ship2.shipsList.get(shipNo - 1).getDirection().equals("DOWN")) {
				
				Up.setVisible(true);
				Down.setVisible(true);
			//                              shipNo -1 + 5 for player 2	
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
            
		
		} else if (e.getSource() == attack) {
			Bsound.Sound(click);
			
			attack.setVisible(false);
			move.setVisible(false);
			
			Xattack.setVisible(true);
			Yattack.setVisible(true);
			attackMessage.setVisible(true);
			next.setVisible(true);
			
			
		} else if (e.getSource() == Right) {
			Bsound.Sound(click);
			

	        if (gameState == 1) {
	        	   
	        	m.moveRight(shipNo, MenuInterface.Deck1);
	           
	        } else if (gameState == 2) {
	        	   
	            m.moveRight(shipNo + 5, MenuInterface.Deck2);
	        }
			
	        frame.setVisible(false);
			shipNo++;
			StracheshipBoard();
			sea();
			
		} else if (e.getSource() == Up) {
				Bsound.Sound(click);
				

		        if (gameState == 1) {
		        	   
		        	 m.moveUp(shipNo, MenuInterface.Deck1);
		           
		        } else if (gameState == 2) {
		        	   
		        	m.moveUp(shipNo + 5, MenuInterface.Deck2);
		        }
	            frame.setVisible(false);
				shipNo++;
				StracheshipBoard();
				sea();	
		
		} else if (e.getSource() == Left) {
					Bsound.Sound(click);
					
					

			        if (gameState == 1) {
			        	   
			        	m.moveLeft(shipNo, MenuInterface.Deck1);
			           
			        } else if (gameState == 2) {
			        	   
			            m.moveLeft(shipNo + 5, MenuInterface.Deck2);
			        
			        }
			         
					frame.setVisible(false);
					shipNo++;
					StracheshipBoard();
					sea();
		
		
		} else if (e.getSource() == Down) {
			Bsound.Sound(click);
			
           if (gameState == 1) {
        	   
        	   m.moveDown(shipNo, MenuInterface.Deck1);
           
           } else if (gameState == 2) {
        	   
        	  m.moveDown(shipNo + 5, MenuInterface.Deck2);
           }
			
            
            frame.setVisible(false);
			shipNo++;
			StracheshipBoard();
			sea();
			
		
	    } else if (e.getSource() == changeTurn) {
	    	Bsound.Sound(click);
	    	
	    	frame.setVisible(false);
	    	if (gameState == 1) {
	    		
	    		gameState = 2;
	    	
	    	} else {
	    		
	    		gameState = 1;
	    	}
	    	
	    	shipNo = 1;
	    	StracheshipBoard();
	    	sea();
	    
	    
	    } else if (e.getSource() == next) {
	    	
	    	Bsound.Sound(click);
	    	Bsound.Sound(cannon);
	    	int x = Integer.parseInt(Xattack.getText());
	    	int y = Integer.parseInt(Yattack.getText());
	    	
	    	if (gameState == 1) {
	    		
	    		if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("S")) /* SHIP HIT */ {
	    			
	    			MenuInterface.Deck2.deck_arr[x-1][y-1] = "X";
	    		
	    		} else if (MenuInterface.Deck2.deck_arr[x-1][y-1].equals("A")) {
	    			
	    			MenuInterface.Deck2.deck_arr[x-1][y-1] = "S";
	    		}
	    	
	    	} else {
	    		
                if (MenuInterface.Deck1.deck_arr[x-1][y-1].equals("S")) /* SHIP HIT */ {
	    			
	    			MenuInterface.Deck1.deck_arr[x-1][y-1] = "X";
	    		
                } else if (MenuInterface.Deck1.deck_arr[x-1][y-1].equals("A")) /* SHIP HIT */ {
	    			
	    			MenuInterface.Deck1.deck_arr[x-1][y-1] = "S";
	    		}
	    	}
	    	
	    	
	    	shipNo++;
	        frame.setVisible(false);
	        StracheshipBoard();
	    	sea();
	    
	    } else if (e.getSource() == sinkedNext) {
	    	
	    	Bsound.Sound(click);
	    	
	    	shipNo++;
	        frame.setVisible(false);
	        StracheshipBoard();
	    	sea();
	    	
	    
	    } else if (e.getSource() == god) {
	    	Bsound.Sound(click);
	    	
	    	changeTurn.setVisible(false);
	    	god.setVisible(false);
	    	godAttack.setVisible(true);
	    	godDefense.setVisible(true);
	    	
	    
	    } else if (e.getSource() == godAttack) {
	    	Bsound.Sound(click);
	    	
	    	godAttack.setVisible(false);
	    	godDefense.setVisible(false);
	    	
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
	    	     
	    	    errorMessageA();
	    	    changeTurn.setVisible(true);
	    	    
	        
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΤΕΜΙΣ" 
	        		&& Artemis.capacity(0) == false) {
	        	
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
	    	     
	    	    errorMessageA();
	    	    changeTurn.setVisible(true);
	    	    
	        
	        } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	        		&& Artemis.capacity(0) == false) {
	        	
	        	errorMessageA();
	        	changeTurn.setVisible(true);
	        }	    		    	
	    	
	   } else if (e.getSource() == godDefense) {
		   Bsound.Sound(click);
		   
		   godAttack.setVisible(false);
	       godDefense.setVisible(false);
		   
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
      	
	       } else if(gameState == 1 && MenuInterface.player1.getGod() == "ΔΙΑΣ" 
	    			&& Dias.capacity(1) == true) {
	        	
	    	   Dias D = new Dias();
               D.insertDataD(); 
               Dias.RIVAL_MOVES[1]--;
               
               changeTurn.setVisible(true);
               
	       } else if(gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	    			&& Dias.capacity(1) == true) {
	        	
	    	   Dias D = new Dias();
              D.insertDataD(); 
              Dias.RIVAL_MOVES[1]--;
              
              changeTurn.setVisible(true);    
	        	
	       } else if (gameState == 1 && MenuInterface.player1.getGod() == "ΔΙΑΣ" 
	         		&& Artemis.capacity(1) == false) {
	     	     
	     	    errorMessageD();
	     	    
	       } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΔΙΑΣ" 
	           		&& Artemis.capacity(1) == false) {
	      	     
	       	    errorMessageD();
	       	      
	        
        } else if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΤΕΜΙΣ" 
      		&& Artemis.capacity(1) == false) {
  	     
  	        errorMessageD();
  	    
         } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΤΕΜΙΣ" 
        		&& Artemis.capacity(1) == false) {
   	     
    	    errorMessageD();
    	    
        } else if(gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΗΣ" 
    			&& Dias.capacity(1) == true) {
        	
	    	Aris A = new Aris();
            A.insertDataD(); 
            Aris.RIVAL_MOVES[1]--;
            
            changeTurn.setVisible(true);
            
	    } else if(gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΗΣ" 
	    			&& Dias.capacity(1) == true) {
	        	

		   Aris A = new Aris();
	       A.insertDataD(); 
	       Aris.RIVAL_MOVES[1]--;
	            
	        changeTurn.setVisible(true);
	    } else if (gameState == 1 && MenuInterface.player1.getGod() == "ΑΡΗΣ" 
      		&& Artemis.capacity(1) == false) {
  	     
  	        errorMessageD();
  	    
         } else if (gameState == 2 && MenuInterface.player2.getGod() == "ΑΡΗΣ" 
        		&& Artemis.capacity(1) == false) {
   	     
    	    errorMessageD();
         
         }
		   
	   } else if (e.getSource() == errorA) {
		   Bsound.Sound(click);
		   
	    	Aframe.setVisible(false);
	    	god.setVisible(true);
	        changeTurn.setVisible(true);
	    	
	    }  else if (e.getSource() == errorD) {
	    	Bsound.Sound(click);
	    	
	    	Dframe.setVisible(false);
	    	god.setVisible(true);
	    	changeTurn.setVisible(true);
	    }
    }
}
