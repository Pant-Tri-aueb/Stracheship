import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game implements java.awt.event.ActionListener{
	
	private int gameState = 1;
	
	private JButton attack;
	private JButton move;
	
	private JFrame frame; 
	
	public void StracheshipBoard() {
		   frame = new JFrame();
	       frame.setBounds(10, 10, 729, 820);
	       frame.setUndecorated(false);
	       frame.setLayout(null);
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
	       pn.setBounds(0, 0, 729, 729);
	       
	       JLabel playerinfo = new JLabel(new ImageIcon(
	         		"wood.jpg"));
	       playerinfo.setBounds(0, 700, 729, 91);
	       
	       JLabel name1 = new JLabel(MenuInterface.player1.getName());
	       JLabel name2 = new JLabel(MenuInterface.player2.getName());
	      
	       name1.setBounds(20, 730, 150, 20);
	       name2.setBounds(20, 730, 150, 20);
	       
	       name1.setFont(new Font("SansSerif", Font.BOLD, 23));
	       name2.setFont(new Font("SansSerif", Font.BOLD, 23));
	       
	       name1.setForeground(Color.BLACK);
	       name2.setForeground(Color.BLACK);
	       
	       JLabel god1 = new JLabel("GOD: " + MenuInterface.player1.getGod());
	       JLabel god2 = new JLabel("GOD: " + MenuInterface.player2.getGod());
	       
	       god1.setBounds(140, 730, 250, 20);
	       god2.setBounds(140, 730, 250, 20);
	       
	       god1.setFont(new Font("SansSerif", Font.BOLD, 23));
	       god2.setFont(new Font("SansSerif", Font.BOLD, 23));
	       
	       god1.setForeground(Color.BLACK);
	       god2.setForeground(Color.BLACK);
	      
	       attack = new JButton("ΕΠΙΘΕΣΗ");
	       move = new JButton("ΜΕΤΑΚΙΝΗΣΗ");
	       
	       attack.setBounds(390, 730, 140, 30);
	       move.setBounds(550, 730, 140, 30);
	       
	       attack.addActionListener(this);
	       move.addActionListener(this);
	       
	       if (gameState == 1) {
	    	   frame.add(name1);
	    	   frame.add(god1);
	    	  
	       } else { 
	    	   frame.add(name2);
	    	   frame.add(god2);
	       }
	       
	       frame.add(attack);
	       frame.add(move);
	       frame.add(playerinfo);
	       frame.add(pn);
	       frame.setDefaultCloseOperation(3);
	       frame.setVisible(true);
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == attack) {
			gameState = 2;
			frame.setVisible(false);
			StracheshipBoard();
		
		} else if (e.getSource() == move) {
			Move metakinhsh = new Move();
			metakinhsh.moveRight(1);
			gameState = 1;
			frame.setVisible(false);
			StracheshipBoard();
		}
		
	}
}
