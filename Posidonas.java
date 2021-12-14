import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Graphics;

public class Posidonas extends JFrame implements ActionListener{

	public static int[] RIVAL_MOVES = {1,2};

	JButton errorA;
	JButton errorD;
	JButton buttonA;
    JButton buttonD;
    JButton back;
    
	Deck deck3 = new Deck();
	Deck deck4 = new Deck();

    JTextField textField;
    
    JFrame frame;
	JFrame errorFrame;
	JFrame playerinfo;

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
         buttonA = new JButton("ΕΝΟΡΑΣΗ!");
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
         buttonD = new JButton("...");
         buttonD.addActionListener((ActionListener) this);
         textField = new JTextField();
         textField.setPreferredSize(new Dimension(250,40));
         textField.setFont(new Font("Consolas",Font.BOLD, 25));


         frame.add(buttonD);
         frame.add(textField);
         frame.setVisible(true);
         frame.pack();

     }

	public void useVision(int shipNo) {
		Ship2 ship;

		if (Game.gameState == 1) {
			 
	        ship = Ship2.shipsList.get(shipNo - 1);
		
		} else {
			
		    ship = Ship2.shipsList.get(shipNo - 1);
		}

		if (Game.gameState == 1) {
			
			//deck3.shipPlacement(ship.xy[0][0],ship.xy[0][1],ship.getSize(),ship.getDirection());
			 if(ship.getDirection().equals("DOWN")) {
	                for (int i = 0; i < ship.getSize(); i++){
	                    deck3.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
	                }
	            } else if (ship.getDirection().equals("RIGHT")) {
	                for (int i = 0 ; i < ship.getSize(); i++){
	                    deck4.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
	                }  
	            }
			sea();
		} else {
			
			//deck4.shipPlacement(ship.xy[0][0],ship.xy[0][1],ship.getSize(),ship.getDirection());
			if(ship.getDirection().equals("DOWN")) {
                for (int i = 0; i < ship.getSize(); i++){
                    deck3.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
                }
            } else if (ship.getDirection().equals("RIGHT")) {
                for (int i = 0 ; i < ship.getSize(); i++){
                    deck4.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
                }  
            }
			sea();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonA) {
			String answer = textField.getText();
			int x = Integer.parseInt(answer);
			frame.setVisible(false);

			if(Game.gameState == 1) {
				
				useVision(x + 5);
			
			} else {
				
				useVision(x);
			}
		
		} else if (e.getSource() == back) {
			
			playerinfo.setVisible(false);
		}
		
		
		
	}

	public void sea() {
		
		playerinfo = new JFrame();
		playerinfo.setVisible(true);
		playerinfo.setBounds(0, 0, 729, 800);
		
		back = new JButton("ΠΙΣΩ");
		back.setBounds(392, 732, 80, 25);
		back.addActionListener(this);
		
		JPanel pn = new JPanel(){
				
			   public void paint(Graphics g) {
				   for(int y = 0; y < 10; y++ ){
					   for(int x = 0; x < 10; x++){
						   g.setColor(Color.BLACK);
						   g.fillRect(x*70, y*70, 80, 70);
						   if (deck3.deck_arr[y][x] == "S" && Game.gameState == 1) {
							  
							   g.setColor(Color.LIGHT_GRAY);
						   
						   } else if (deck4.deck_arr[y][x] == "S" && Game.gameState == 2){
						   
							   g.setColor(Color.LIGHT_GRAY);
						   
						   } else if (deck3.deck_arr[y][x] == "X" && Game.gameState == 1) {
							   
							   g.setColor(Color.RED);
						   
						   } else if (deck4.deck_arr[y][x] == "X" && Game.gameState == 2) {
							   
							   g.setColor(Color.RED);	                    	   
						   
						   } else if (deck3.deck_arr[y][x] == "A" && Game.gameState == 1) {
								
							   g.setColor(Color.GRAY);
						   
						   } else if (deck4.deck_arr[y][x] == "A" && Game.gameState == 2) {
							   
							   g.setColor(Color.GRAY);	       
						   
						   } else { 
							  
							   g.setColor(Color.BLUE);
						   }
						  
						   g.fillRect(x*70+1, y*70+1, 80+1, 70+1);
					   }
				   }
				   
			   }
		   };
		   pn.setBounds(0, 0, 729, 729);
		   
		   pn.setLayout(null);
		   
		   playerinfo.setBackground(Color.GRAY);
		   playerinfo.add(back);		   
		   playerinfo.setLayout(null);
		   playerinfo.add(pn);
	}
}
