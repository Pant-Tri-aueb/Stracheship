import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dias extends JFrame implements ActionListener {

	public static int[] RIVAL_MOVES = {1,2};
	
	
	JButton errorA;
	JButton errorD;
	JButton buttonA;
    JButton buttonD;
    
    JTextField textField;
    
    JFrame frame;
	JFrame errorFrame;
	
	public static boolean capacity(int index) {
        boolean available = true;
    	
        if (RIVAL_MOVES[index] > 0) {
        	available = true;
        	
        } else {
        	
        	available = false;
        }
        
        return available;        
            
       
     }
	
	 public void insertDataA() {
     	 frame = new JFrame("ΔΙΑΛΕΞΕ ΠΛΟΙΟ");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         buttonA = new JButton("ΕΠΙΘΕΣΗ!");
         buttonA.addActionListener(this);
         textField = new JTextField();
         textField.setPreferredSize(new Dimension(250,40));
         textField.setFont(new Font("Consolas",Font.BOLD, 25));


         frame.add(buttonA);
         frame.add(textField);
         frame.setVisible(true);
         frame.pack();

     }
	 
	 public void insertDataD() {
     	 frame = new JFrame("ΔΙΑΛΕΞΕ ΠΛΟΙΟ");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         buttonD = new JButton("ΕΠΑΝΑΦΟΡΑ");
         buttonD.addActionListener(this);
         textField = new JTextField();
         textField.setPreferredSize(new Dimension(250,40));
         textField.setFont(new Font("Consolas",Font.BOLD, 25));


         frame.add(buttonD);
         frame.add(textField);
         frame.setVisible(true);
         frame.pack();

     }
	  public void errorA() {
	 		
			errorFrame = new JFrame("Error");
	        errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        errorFrame.setLayout(new FlowLayout());
	        JPanel pn = new JPanel();
	        
	        JLabel message = new JLabel("Τo πλοίο έχει καταστραφεί!");
	        
	        errorA = new JButton("OK");
	        errorA.addActionListener(this);
	       
	        pn.add(errorA);
	        pn.add(message);
	        
	        errorFrame.add(pn);
	        errorFrame.setVisible(true);
	        errorFrame.pack();
		}
	  public void errorD() {
	 		
			errorFrame = new JFrame("Error");
	        errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        errorFrame.setLayout(new FlowLayout());
	        JPanel pn = new JPanel();
	        
	        JLabel message = new JLabel("Το πλοίο δεν έχει καταστραφεί");
	        
	        errorD = new JButton("OK");
	        errorD.addActionListener(this);
	       
	        pn.add(errorD);
	        pn.add(message);
	        
	        errorFrame.add(pn);
	        errorFrame.setVisible(true);
	        errorFrame.pack();
		}
		
	public void strike(int shipNo) {
		Ship2 ship;
		if (Game.gameState == 1) {
			 
	        ship = Ship2.shipsList.get(shipNo + 4);
		
		} else {
			
		    ship = Ship2.shipsList.get(shipNo - 1);
		}
		  
		
		if (ship.getTolerance() > 0 && (ship.getSize() == 2 || ship.getSize() == 3)) {
			if (Game.gameState == 1) {
				for (int i = 0; i < ship.getSize(); i++) {
					
					MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "X";
				}
			
			} else {
                for (int i = 0; i < ship.getSize(); i++) {
					
					MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "X";
				}
			}
			
		
		} else if (ship.getTolerance() > 0 && ship.getSize() == 4) {
			
			if (Game.gameState == 1) {
				for (int i = 0; i < ship.getSize() - 1; i++) {
					
					MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "X";
				}
			
			} else {
                for (int i = 0; i < ship.getSize() - 1; i++) {
					
					MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "X";
				}
			}
			
		
		} else if (ship.getTolerance() == 0) {
			
			errorA();
		}
        	
	}

	public void resurrection(int shipNo) {
		Ship2 ship = Ship2.shipsList.get(shipNo - 1);
		
		if (ship.getTolerance() == 0) {
			
			ship.setTolerance(ship.getSize());
			
			if (ship.getDirection().equals("DOWN")) {
				for (int i = 0; i < ship.getSize(); i++) {
					
					if (Game.gameState == 1) {
						
						MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
					
					} else if (Game.gameState == 2) {
						
						MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
						
					}
					
				}

			} else if (ship.getDirection().equals("RIGHT")) {
				for (int i = 0; i < ship.getSize(); i++) {
					
					if (Game.gameState == 1) {
						
						MenuInterface.Deck1.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
					
					} else if (Game.gameState == 2) {
						
						MenuInterface.Deck2.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
						
					}
					
				}
			}
					
		} else {
			
		    errorD();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonA) {
            
			String answer = textField.getText();
            int x = Integer.parseInt(answer);
            frame.setVisible(false);
            if (Game.gameState == 1) {
         	   
         	   strike(x + 5);
         	   
            } else {
         	   
         	   strike(x);
            
            }
            
		} else if (e.getSource() == buttonD) {
			
			String answer = textField.getText();
			int x = Integer.parseInt(answer);
			frame.setVisible(false);
			if (Game.gameState == 1) {
	         	   
	         	   resurrection(x);
	         	   
	            } else {
	         	   
	         	   resurrection(x + 5);
	            
	            }
	            
			
		} else if (e.getSource() == errorA) {
	    	
	    	errorFrame.setVisible(false);
	    	insertDataA();
	    
	    
		} else if (e.getSource() == errorD) {
			
			errorFrame.setVisible(false);
			
	    	
		}
   }
}
