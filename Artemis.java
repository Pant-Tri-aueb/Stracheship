 import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.*;
    public class Artemis extends JFrame implements ActionListener {

    	 public static int[] RIVAL_MOVES = {2,2};
    	 static int x;
    	
    	    
        JButton button;
        JTextField textField;
        JFrame frame;
        
        Artemis(){
        }

        public void insertData() {
        	frame = new JFrame("Συντεταγμένες");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            button = new JButton("ΕΠΙΘΕΣΗ!");
            button.addActionListener(this);
            textField = new JTextField();
            textField.setPreferredSize(new Dimension(250,40));
            textField.setFont(new Font("Consolas",Font.BOLD, 25));


            frame.add(button);
            frame.add(textField);
            frame.setVisible(true);
            frame.pack();

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button) {
               String answer = textField.getText();
               x = Integer.parseInt(answer);
               frame.setVisible(false);
               if (Game.gameState == 1) {
            	   
            	   throwArrow(MenuInterface.Deck2);
            	   
               } else {
            	   
            	   throwArrow(MenuInterface.Deck1);
               }
               
             }
        }
        
	    public static boolean capacity(int index) {
	        boolean available = true;
	    	
	        if (RIVAL_MOVES[index] > 0) {
	        	available = true;
	        	RIVAL_MOVES[index]--;
	        
	        } else {
	        	
	        	available = false;
	        }
	        
	        return available;        
	            
	       
	     }

	    public void useDefence(Ship2 obj,Deck deck) { // the ship that uses the power
	       
	    	  for (int i = 0; i < obj.getSize(); i++) {
    			
    			if (deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] == "X" ) {
    				
    				deck.deck_arr[obj.xy[i][0]][obj.xy[i][1]] = "S";
    			}
	       
	    	   
	       
        }
	        
	        
	    }

	    public void throwArrow(Deck deck) {
	       
	       for (int y = 0; y < 10; y ++) {
	        	 if (deck.deck_arr[x - 1][y] == "S") {
	    	            
	        		  deck.deck_arr[x - 1][y] = "X";
	    	        	
	        	 }
	        }
	      
	    
	    }

    }
