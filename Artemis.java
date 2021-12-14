   import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.*;
    public class Artemis extends JFrame implements ActionListener {

    	 public static int[] RIVAL_MOVES = {2,2};
    	 
    	 static int x;
    	
    	    
        JButton buttonA;
        JButton buttonD;
        JTextField textField;
        JFrame frame;
        
        Artemis(){
        }

        public void insertDataA() {
        	frame = new JFrame("ΔΙΑΛΕΞΕ ΓΡΑΜΜΗ");
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
            buttonD = new JButton("ΠΡΟΣΤΑΣΙΑ");
            buttonD.addActionListener(this);
            textField = new JTextField();
            textField.setPreferredSize(new Dimension(250,40));
            textField.setFont(new Font("Consolas",Font.BOLD, 25));


            frame.add(buttonD);
            frame.add(textField);
            frame.setVisible(true);
            frame.pack();

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buttonA) {
               String answer = textField.getText();
               x = Integer.parseInt(answer);
               frame.setVisible(false);
               if (Game.gameState == 1) {
            	   
            	   throwArrow(MenuInterface.Deck2);
            	   
               } else {
            	   
            	   throwArrow(MenuInterface.Deck1);
               }
               
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
        
	    public static boolean capacity(int index) {
	        boolean available = true;
	    	
	        if (RIVAL_MOVES[index] > 0) {
	        	available = true;
	        	
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
	    	        	
	        	 } else if (deck.deck_arr[x - 1][y] == "A") {
	    	            
	        		  deck.deck_arr[x - 1][y] = "S";
	    	        	
	        	 }
	        }
	      
	    
	    }

    }

