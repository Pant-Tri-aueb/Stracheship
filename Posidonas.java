import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Graphics;

public class Posidonas extends JFrame implements ActionListener{

	public static int[] RIVAL_MOVES = {1,1};

	static File reveal = new File("Reveal.wav");
	static File wave = new File("Wave.wav");
	
	JButton errorA;
	JButton errorD;
	JButton buttonA;
    JButton buttonD;
    JButton back;

	static int xChoice;
	static int yChoice;
	int round;
    
	Deck deck3 = new Deck();
	Deck deck4 = new Deck();

	JTextField textField;
	JTextField textFieldx;
	JTextField textFieldy;
    
    JFrame frame;
	JFrame errorFrame;
	JFrame visionFrame;

	private static int roundNo;

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
         buttonA = new JButton("ΑΠΟΚΑΛΥΨΗ");
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
     	 frame = new JFrame("ΔΩΣΕ ΣΥΝΤΕΤΑΓΗΜΕΝΕΣ");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new FlowLayout());
         buttonD = new JButton("ΥΨΩΣΗ ΚΥΜΑΤΟΣ");
         buttonD.addActionListener((ActionListener) this);
         textFieldx = new JTextField();
         textFieldx.setPreferredSize(new Dimension(250,40));
         textFieldx.setFont(new Font("Consolas",Font.BOLD, 25));
		 textFieldy = new JTextField();
         textFieldy.setPreferredSize(new Dimension(250,40));
         textFieldy.setFont(new Font("Consolas",Font.BOLD, 25));


         frame.add(buttonD);
         frame.add(textFieldx);
		 frame.add(textFieldy);
         frame.setVisible(true);
         frame.pack();

     }

	public void useVision(int shipNo) {
		Ship2 ship = Ship2.shipsList.get(shipNo - 1);

		if (Game.gameState == 1) {
			
		    for (int i = 0; i < ship.getSize(); i++){
	            deck3.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
	        }
	           
	        sea();
		} else {
			
            for (int i = 0 ; i < ship.getSize(); i++){
                deck4.deck_arr[ship.xy[i][0]][ship.xy[i][1]] = "S";
            }  
			
			sea();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonA) {
			Bsound.Sound(reveal);
			
			String answer = textField.getText();
			int x = Integer.parseInt(answer);
			frame.setVisible(false);

			if(Game.gameState == 1) {
				
				useVision(x + 5);
			
			} else {
				
				useVision(x);
			}
		
		} else if (e.getSource() == buttonD) {
          
			Bsound.Sound(wave);
			String answer1 = textFieldx.getText();
			String answer2 = textFieldy.getText();

			xChoice = Integer.parseInt(answer1);
			yChoice = Integer.parseInt(answer2);
			frame.setVisible(false);
			if (Game.gameState == 1) {
				
				useDefence(MenuInterface.Deck1, xChoice, yChoice);
				
			} else if (Game.gameState == 2) {
				
			   useDefence(MenuInterface.Deck2, xChoice, yChoice);
			}
			
		} else if (e.getSource() == back) {
			
			visionFrame.setVisible(false);
		}
		
		
		
	}

	public void sea() {
		
		visionFrame = new JFrame();
		visionFrame.setVisible(true);
		visionFrame.setBounds(0, 0, 729, 800);
		
		back = new JButton("BACK");
		back.setBounds(568, 15, 80, 25);
		back.addActionListener(this);
		back.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
		
		JLabel wood = new JLabel(new ImageIcon("wood.jpg"));
		wood.setBounds(0, 700, 729, 71);
		
		JLabel text = new JLabel("Vision does not reveal how much tolerance the ship is left with!");
		text.setBounds(80, 15, 485, 30);
		text.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 11));
		text.setForeground(Color.BLACK);
		
		JPanel pn = new JPanel(){
				
			   public void paint(Graphics g) {
				   for(int y = 0; y < 10; y++ ){
					   for(int x = 0; x < 10; x++){
						   g.setColor(Color.BLACK);
						   g.fillRect(x*70, y*70, 80, 70);
						   if (deck3.deck_arr[y][x] == "S" && Game.gameState == 1) {
							  
							   g.setColor(Color.GREEN);
						   
						   } else if (deck4.deck_arr[y][x] == "S" && Game.gameState == 2){
						   
							   g.setColor(Color.GREEN);
						   
						   } else { 
							  
							   g.setColor(new Color(65,105,225));
						   }
						  
						   g.fillRect(x*70+1, y*70+1, 80+1, 70+1);
					   }
				   }
				   
			   }
		   };
		   pn.setBounds(0, 0, 729, 729);
		   
		   pn.setLayout(null);
		   
		   wood.add(text);
		   wood.add(back);
		   visionFrame.add(wood);
		   		   
		   visionFrame.setLayout(null);
		   visionFrame.add(pn);
	}

	public void useDefence(Deck deck, int xChoice, int yChoice) {
		this.roundNo = Game.getRoundsNo();
		
		for (int i = xChoice; i < xChoice + 4; i++) {
			for (int j = yChoice; j < yChoice + 4; j++) {
				if (deck.deck_arr[i - 1][j - 1] == "S") {
					
					deck.deck_arr[i - 1][j - 1] = "U";
					
				} else if (deck.deck_arr[i - 1][j - 1] == "X") {
					
					deck.deck_arr[i - 1][j - 1] = "B"; 
				
				}
				
			}
		}

		MenuInterface.runGame.sea();
	}
	


	public static int getRoundNo() {
		return roundNo;
	}


	
	public static void endDefense(Deck deck) {
		
		for (int i = xChoice; i < xChoice + 4; i++) {
			for (int j = yChoice; j < yChoice + 4; j++) {
				if (deck.deck_arr[i - 1][j - 1] == "U") {
					
					deck.deck_arr[i - 1][j - 1] = "S";
					
				} else if (deck.deck_arr[i - 1][j - 1] == "B") {
					
					deck.deck_arr[i - 1][j - 1] = "X"; 
				
				}
				
			}
		}
	}
		
}
	
