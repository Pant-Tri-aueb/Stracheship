import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Aris extends JFrame implements ActionListener {
     
	 public static int[] RIVAL_MOVES = {1,2}; 
	
	 static int x;
	
	 JButton buttonA;
     JButton buttonD;
     JTextField textField;
     JFrame frame;
     
  
     public void insertDataD() {
     	frame = new JFrame("ΔΙΑΛΕΞΕ ΠΛΟΙΟ");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         buttonD = new JButton("ΘΩΡΑΚΙΣΗ");
         buttonD.addActionListener(this);
         textField = new JTextField();
         textField.setPreferredSize(new Dimension(250,40));
         textField.setFont(new Font("Consolas",Font.BOLD, 25));


         frame.add(buttonD);
         frame.add(textField);
         frame.setVisible(true);
         frame.pack();

     }
     
     public static boolean capacity(int index) {
         boolean available = true;
     	
         if (RIVAL_MOVES[index] > 0) {
         	available = true;
         	
         } else {
         	
         	available = false;
         }
         
         return available;        
             
        
      }
     public void useAttack(Deck deck) {
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
     
     public void useDefence(Ship2 obj, Deck deck) {
    	  
    	 for (int i = 0; i < obj.getSize(); i++) {
 			
 			if (deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]].equals("S") ) {
 				
 				deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] = "A";
 			
 			}
	       
	     }
     }
     
     @Override
     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == buttonD) {
       
             String answer = textField.getText();
             x = Integer.parseInt(answer);
             frame.setVisible(false);
             if (Game.gameState == 1) {
          	   
          	   useDefence(Ship2.shipsList.get(x - 1) , MenuInterface.Deck1);
          	   
             } else if (Game.gameState == 2) {
          	   
                useDefence(Ship2.shipsList.get(x + 4) , MenuInterface.Deck2);
             }
             
           }
     }
	
}

