import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Aris extends JFrame implements ActionListener {
     
	 public static int[] RIVAL_MOVES = {2,2}; 
	
	 static int x;
	
	 JButton buttonA;
     JButton buttonD;
     JTextField textField;
     JFrame frame;
     
     public void insertDataA() {
     	frame = new JFrame("ΔΙΑΛΕΞΕ ...");
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
     
     public void useDefence(Ship2 obj, Deck deck) {
    	  
    	 for (int i = 0; i < obj.getSize(); i++) {
 			
 			if (deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]].equals("S") ) {
 				
 				deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] = "A";
 			
 			}
	       
	     }
     }
     
     @Override
     public void actionPerformed(ActionEvent e) {
         if(e.getSource() == buttonA) {
            
          } else if (e.getSource() == buttonD) {
       
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
