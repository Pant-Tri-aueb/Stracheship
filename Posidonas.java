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
    
	Deck deck3;
	Deck deck4;

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
			deck3 = new Deck();
			deck3.shipPlacement(ship.xy[0][0],ship.xy[0][1],ship.getSize(),ship.getDirection());
		} else {
			deck4 = new Deck();
			deck4.shipPlacement(ship.xy[0][0],ship.xy[0][1],ship.getSize(),ship.getDirection());
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
		}
		
		
		
	}

	public void sea() {
		
		playerinfo = new JFrame();
		playerinfo.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		   pn.setBounds(41, 41, 729, 729);
		   pn.setLayout(null);
		   
		   playerinfo.setLayout(null);
		   playerinfo.add(pn);
	}
}

