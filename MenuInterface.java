import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MenuInterface extends JFrame implements java.awt.event.ActionListener {
   
	private int ShipPlacementCounter = 0;
	private int counter = 1;
	private int size_counter = 2;
	
	private String direction;
	private String[][] deck_table = new String[10][10];
	
	static Deck Deck1 = new Deck();
	static Deck Deck2 = new Deck();
	
	static Backgroundmusic bmusic2 = new Backgroundmusic(); 
	 
	public static JFrame f;
	private JFrame newFrame;
    private JFrame startframe;
	private JFrame SecondFrame;
    private JFrame GodFrame; 
	private JFrame erFrame;
	
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
	private JButton back;
	private JButton submit;
	private JButton next;
	private JButton zeus;
	private JButton poseidon;
	private JButton ares;
	private JButton artemis;
	private JButton dirDown;
	private JButton dirRight;
	private JButton erButton1;
	private JButton erButton2;
	
	private JTextField t1, t2, t5, t6, t7;
	
	private JTable jt;
	
	static ImageIcon logo = new ImageIcon("logo.png");
    static File click = new File("click.wav");
    static File music = new File("Game.wav");
	
	static Player player1;
	static Player player2;
	
	
	public MenuInterface() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	gui();
    	SplashScreen.bmusic.play = true;
        
    }
    
    public void gui() {
    	
    	
        f = new JFrame("Stracheship 1.0");
        f.setIconImage(logo.getImage());
        
        JLabel background = new JLabel(new ImageIcon(
        		"stracheship.jpg"));
        add(background);
        
       
        f.setSize(1280, 733);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
    	
        Border roundedBorder = new LineBorder(new Color(64, 64, 64), 8, true);
       
        b1 = new JButton("START GAME");
    	b1.setBounds(420, 260, 400, 80);
    	b1.addActionListener(this);
    	b1.setFont(new Font("Wide Latin", Font.ITALIC, 25));
    	b1.setBackground(new Color(102, 51, 0));
    	b1.setForeground(Color.WHITE);
    	b1.setBorder(roundedBorder);
    	
        b2 = new JButton("HELP");
    	b2.setBounds(420, 400, 400, 80);
    	b2.addActionListener(this);
    	b2.setFont(new Font("Wide Latin", Font.ITALIC, 25));
    	b2.setBackground(new Color(102, 51, 0));
    	b2.setForeground(Color.WHITE);
    	b2.setBorder(roundedBorder);
    	
        b3 = new JButton("EXIT");
        b3.setBounds(420, 540, 400, 80);
        b3.addActionListener(this);
        b3.setFont(new Font("Wide Latin", Font.ITALIC, 25));
    	b3.setBackground(new Color(102, 51, 0));
    	b3.setForeground(Color.WHITE);
    	b3.setBorder(roundedBorder);
    	
        background.setLayout(null);
        background.add(b1);
    	background.add(b2);
    	background.add(b3);
    	f.add(background);
    	f.setVisible(true);
    }
    
    public void Player() {
    	SecondFrame = new JFrame("Stracheship 1.0");
    	SecondFrame.setIconImage(logo.getImage());
    	SecondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	SecondFrame.setSize(1280, 720);
    	
    	f.setVisible(false);
    	if (Player.playerNo == 1) {
    	
    		GodFrame.setVisible(false);
    	}
    	SecondFrame.setVisible(true);
    	
    	JLabel background = new JLabel(new ImageIcon(
         		"assasinscreedodyssey.jpg"));
    	
    	background.setLayout(null);
    	SecondFrame.add(background);
    	
    	JLabel scroll = new JLabel();
    	scroll.setBounds(30, 30, 400, 600);
    	scroll.setIcon(new ImageIcon("scroll.jpg"));
    	
    	
    	String message = "";
    	
    	if (Player.playerNo == 0) {
    		
    		message = "First Player Data: ";
    	
    	} else if (Player.playerNo == 1) {
    		
    		message = "Second Player Data: ";
    	}
    	
    	JLabel title = new JLabel(message);
        title.setBounds(50, 50, 300, 50);
        title.setFont(new Font("Vladimir Script", Font.BOLD, 35));
    	
    	next = new JButton("Prepare Your Fleet");
    	next.addActionListener(this);
    	next.setBackground(new Color(189,183,107));
    	next.setBounds(40, 450, 320, 50);
    	next.setFont(new Font("Vladimir Script", Font.BOLD, 30));
    	
        JLabel name = new JLabel("Name");
        name.setBounds(50, 110, 100, 35);
        name.setFont(new Font("Vladimir Script", Font.BOLD, 35));
        
        t5 = new JTextField();  
        t5.setBounds(50,150, 200,30);  
        t5.setFont(new Font("Vladimir Script", Font.PLAIN, 30));
        t5.addActionListener(this);
        t5.setBackground(new Color(240,230,140));
        
        JLabel sex = new JLabel("Sex");
        sex.setBounds(50, 190, 100, 35);
        sex.setFont(new Font("Vladimir Script", Font.BOLD, 35));
        
        t6 = new JTextField();  
        t6.setBounds(50, 230, 200, 30);
        t6.setFont(new Font("Vladimir Script", Font.PLAIN, 30));
        t6.addActionListener(this);
        t6.setBackground(new Color(240,230,140));
        
        JLabel age = new JLabel("Age");
        age.setBounds(50, 270, 120, 35);
        age.setFont(new Font("Vladimir Script", Font.BOLD, 35));
        
        t7 = new JTextField();  
        t7.setBounds(50, 310, 200,30);  
        t7.setFont(new Font("Vladimir Script", Font.PLAIN, 30));
        t7.addActionListener(this);
    	t7.setBackground(new Color(240,230,140));
    	
        scroll.add(title);
        scroll.add(next);
        scroll.add(name);
        scroll.add(t5);
        scroll.add(sex);
        scroll.add(t6);
        scroll.add(age);
        scroll.add(t7);
        
        background.add(scroll);
    }
    
    public void Gods() {
    	GodFrame = new JFrame("Stracheship 1.0");
    	GodFrame.setIconImage(logo.getImage());
    	GodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	GodFrame.setSize(1280, 725);
    	
    	startframe.setVisible(false);
    	GodFrame.setVisible(true);
    	
    	JLabel background;
    	
    	if (player1.getGod().equals("ΔΙΑΣ")) {
    		
    		 background = new JLabel(new ImageIcon(
             		"Διαφάνεια3.jpg"));
    		
    	} else if (player1.getGod().equals("ΑΡΤΕΜΙΣ")) {
        		
        	 background = new JLabel(new ImageIcon(
                 		"Διαφάνεια4.jpg"));
        		
        } else if (player1.getGod().equals("ΑΡΗΣ")) {
    		
    		 background = new JLabel(new ImageIcon(
             		"Διαφάνεια5.jpg"));
    		
    	} else if (player1.getGod().equals("ΠΟΣΕΙΔΩΝΑΣ")) {
    		
    		 background = new JLabel(new ImageIcon(
             		"Διαφάνεια6.jpg"));
    		
    	} else {
    		
    		 background = new JLabel(new ImageIcon(
             		"gods2.jpg"));
    	}
    	
    	
    	background.setLayout(null);
    	GodFrame.add(background);
    	
    	
    	zeus = new JButton("ZEUS");
    	zeus.setBounds(50, 600, 200, 40);
    	zeus.addActionListener(this);
    	zeus.setFont(new Font("Algerian", Font.PLAIN, 24));
    	zeus.setBackground(new Color(238,232,170));
    	
        poseidon = new JButton("POSEIDON");
    	poseidon.setBounds(1010, 600, 200, 40);
    	poseidon.addActionListener(this);
    	poseidon.setFont(new Font("Algerian", Font.PLAIN, 24));
        poseidon.setBackground(new Color(238,232,170));
    	
        ares = new JButton("ARES");
        ares.setBounds(690, 600, 200, 40);
        ares.addActionListener(this);
        ares.setFont(new Font("Algerian", Font.PLAIN, 24));
        ares.setBackground(new Color(238,232,170)); 
        
        artemis = new JButton("ARTEMIS");
        artemis.setBounds(365, 600, 200, 40);
        artemis.addActionListener(this);
        artemis.setFont(new Font("Algerian", Font.PLAIN, 24));
        artemis.setBackground(new Color(238,232,170));

    	if (player1.getGod().equals("ΔΙΑΣ")) {
    		
    		zeus.setVisible(false);
    		
    	} else if (player1.getGod().equals("ΑΡΤΕΜΙΣ")) {
        		
        	 artemis.setVisible(false);
        
    	} else if (player1.getGod().equals("ΑΡΗΣ")) {
    		
    		ares.setVisible(false);
    		
    	} else if (player1.getGod().equals("ΠΟΣΕΙΔΩΝΑΣ")) {
    		
    		poseidon.setVisible(false);
    		 
    	} else {
    		
    		 zeus.setVisible(true);
    		 artemis.setVisible(true);
    		 ares.setVisible(true);
    		 poseidon.setVisible(true);
    	}
        
        
        background.add(zeus);
        background.add(poseidon);
        background.add(ares);
        background.add(artemis);
    }
    
    
    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1 ) {
        	Bsound.Sound(click);
        	
        	Player();
        	
        } else if (e.getSource() == b2) {
        	Bsound.Sound(click);
        	
        	f.setVisible(false);
        	Help.instructions();
    	    
    	 } else if (e.getSource() == b3) {
    		 Bsound.Sound(click);
    		 
    		 System.exit(0);
    	 
    	 } else if (e.getSource() == back) {
    		 Bsound.Sound(click);
    		 
    		 newFrame.setVisible(false);
    		 f.setVisible(true);
    	 
    	 
    	 } else if (e.getSource() == submit) {
    		    Bsound.Sound(click);
    		 
    		    boolean checkException = false;
    		     
    		    int x = 0;
				int y = 0;
				try {	 
				    String answer1 = t1.getText();
					x = Integer.parseInt(answer1);
					if(x <=0 || x >= 11 ){
						throw new Exception();
					}
	
					String answer2 = t2.getText(); 
					y = Integer.parseInt(answer2);
					if(y <=0 || y >= 11 ){
						throw new Exception();
					}
				} catch (NumberFormatException ex) {
					checkException = true;
					 
					SecondFrame.setVisible(false);
					errorBox("Please enter a number at cordinates.",1);

				}catch(Exception ex){
					checkException = true;
					 
					SecondFrame.setVisible(false);
					errorBox("Enter a number from 1 to 10.",1);
				}
				
				if (Player.playerNo == 1){
					if(! Deck1.ShipOutOfDeckCheck(x, y, size_counter, direction) && !checkException ){
						checkException = true;
						SecondFrame.setVisible(false);
						errorBox("Ship is out of sea! Please, try again.",1);
						
					}else if(! Deck1.ShipOnShipCheck(x, y, size_counter, direction) && !checkException ){
						checkException = true;
						SecondFrame.setVisible(false);
						errorBox("Do not put the ship above others! Please, try again.",1);
					}
					PlayerPlacesShip(Deck1, x, y, direction);

				}else{
					if(! Deck2.ShipOutOfDeckCheck(x, y, size_counter, direction) && !checkException){
						checkException = true;
						SecondFrame.setVisible(false);
						errorBox("Ship is out of sea! Please, try again.",1);
						
					}else if( ! Deck2.ShipOnShipCheck(x, y, size_counter, direction) && !checkException){
						checkException = true;
						SecondFrame.setVisible(false);
						errorBox("Do not put the ship above others! Please, try again.",1);
					}
					PlayerPlacesShip(Deck2, x, y, direction);
				}

    	         startframe.setVisible(false);
    	         
    	         if (checkException == false) {
    	        	startGame();
    	         }
    	         
    	        
    	         if (ShipPlacementCounter == 10 && Player.playerNo == 2) {
         	         Gods();
    	         }
        
    	 } else if (e.getSource() == dirDown) {
    		 
    		 direction = "DOWN";
      
    	 } else if (e.getSource() == dirRight) {
    		 
    		 direction = "RIGHT";
    		 
    		 
    	 } else if (e.getSource() == next) {
    		Bsound.Sound(click);
    		 
    		String answer5 = t5.getText();
	        String answer6 = t6.getText();
	        String answer7 = t7.getText();
	         
	        String name = answer5;
			String sex = answer6;
			int age=0;

			boolean checkException = false;
			try {
				age = Integer.parseInt(answer7);
				if(age <= 0){
					throw new Exception();
				}	
			} catch (NumberFormatException ex) {
				checkException = true;	 
				SecondFrame.setVisible(false);
				errorBox("Please enter a number.",2);

			} catch(Exception ex){
				checkException = true;
				SecondFrame.setVisible(false);
				errorBox("Please enter a number over 0.",2);
			}
	         
	        if(!checkException){
				if (Player.playerNo == 0) {	
					player1 = new Player(name, sex, age);
				} else {
					player2 = new Player(name, sex, age);
				}
				
				SecondFrame.setVisible(false);
				startGame();
			}
	         
				
				
        
    	} else if (e.getSource() == zeus || e.getSource() == poseidon ||
        		e.getSource() == ares || e.getSource() == artemis) {
        	
    		 Bsound.Sound(click);
    		 
    		 if (Player.playerNo == 1) {
    			if (e.getSource() == zeus) {
    				
    				player1.setGod("ΔΙΑΣ"); 
    			
    			} else if (e.getSource() == poseidon) {
    				
    				player1.setGod("ΠΟΣΕΙΔΩΝΑΣ");
    			
    			} else if (e.getSource() == ares) {
    				
    				player1.setGod("ΑΡΗΣ");
    			
    			} else if (e.getSource() == artemis) {
    				
    				player1.setGod("ΑΡΤΕΜΙΣ");
    			}
    			 
    			
    		} else {
    			
                if (e.getSource() == zeus) {
    				
    				player2.setGod("ΔΙΑΣ"); 
    			
    			} else if (e.getSource() == poseidon) {
    				
    				player2.setGod("ΠΟΣΕΙΔΩΝΑΣ");
    			
    			} else if (e.getSource() == ares) {
    				
    				player2.setGod("ΑΡΗΣ");
    			
    			} else if (e.getSource() == artemis) {
    				
    				player2.setGod("ΑΡΤΕΜΙΣ");
    			}
                
                SplashScreen.bmusic.c.stop();
    		}
    		 
    		 
    		 if (Player.playerNo == 1) {
    			 
    			 GodFrame.setVisible(false);
        		 Player();
        	
        	 } else {
        		  
        		 GodFrame.setVisible(false);
        		
        		 try {
        			    Game runGame = new Game();
        			    
        	 			bmusic2.sound(music);
        	 			
        				} catch (UnsupportedAudioFileException e1) {
        					
        					e1.printStackTrace();
        				} catch (IOException e1) {
        					
        					e1.printStackTrace();
        				} catch (LineUnavailableException e1) {
        					
        					e1.printStackTrace();
        				}
        	 }
        	
        
    	} else if(e.getSource()==  erButton1){
    		Bsound.Sound(click);
    		
    		erFrame.setVisible(false);
    		startGame();
		
    	} else if(e.getSource()==  erButton2){
    		Bsound.Sound(click);
    		
    		erFrame.setVisible(false);
    		Player();
		
    	}
		
   }
		
	
   
    public void startGame() {
        startframe = new JFrame("Stracheship 1.0");
        startframe.setIconImage(logo.getImage());
        
        JLabel pn = new JLabel(new ImageIcon(
        		"storm5.jpg"));
        
        pn.setLayout(null);
        
        JLabel wood = new JLabel();
        wood.setBounds(30, 30, 400, 600);
        wood.setIcon(new ImageIcon("frame2.jpg"));
        
        JLabel lb = new JLabel("Insert X, Y and Direction");
        		             
        lb.setBounds(50, 50, 320, 30);
        lb.setOpaque(false);
        lb.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 19));
        lb.setForeground(Color.WHITE);
        
        if (Player.playerNo == 2 && ShipPlacementCounter == 5) {
 		   counter = 1;
 		   size_counter = 2;
 	   }
 	   
        String message;
        
        if (size_counter == 2) {
        	
        	message = "Place a small ship "
        			+ "(size = 2)";
        
        } else if (size_counter == 3) {
        	
        	message = "Place a normal ship "
        			+ "(size = 3)";
        
        } else {
        	 
        	message = "Place a large ship "
        			+ "(size = 4)";
        }
       
        JLabel ShipCount = new JLabel(message); 
        ShipCount.setBounds(70, 520, 310, 30);
        ShipCount.setOpaque(false);
        ShipCount.setFont(new Font("Copperplate Gothic Bold", Font.ITALIC, 17));
        ShipCount.setForeground(Color.WHITE);
        
        submit = new JButton("SUBMIT");
        submit.addActionListener(this);  
        submit.setBounds(130, 450, 130, 30);
        submit.setBackground(new Color(153, 76, 0));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 13));
        
        JLabel lbt1 = new JLabel("                      Coordinate X");
        lbt1.setBounds(45, 120, 280, 30);
        lbt1.setOpaque(false);
        lbt1.setFont(new Font("Copperplate Gothic Bold", Font.ITALIC, 17));
        lbt1.setForeground(Color.WHITE);
        
        t1 = new JTextField();  
        t1.setBounds(50, 160, 280,40);  
        t1.addActionListener(this);
        
        JLabel lbt2 = new JLabel("                      Coordinate Y");
        lbt2.setBounds(45, 240, 280, 30);
        lbt2.setOpaque(false);
        lbt2.setFont(new Font("Copperplate Gothic Bold", Font.ITALIC, 17));
        lbt2.setForeground(Color.WHITE);
        
        t2 = new JTextField();  
        t2.setBounds(50, 280, 280, 40);
        t2.addActionListener(this);
        
        JLabel lbt4 = new JLabel("                    Ship Direction");
        lbt4.setBounds(50, 350, 280, 30);
        lbt4.setOpaque(false);
        lbt4.setFont(new Font("Copperplate Gothic Bold", Font.ITALIC, 17));
        lbt4.setForeground(Color.WHITE);
        
        dirDown = new JButton("VERTICAL");
        dirRight = new JButton("HORIZONTAL");
        
        dirDown.setBounds(50, 385, 135, 30);
        dirRight.setBounds(195, 385, 135, 30);
        
        dirDown.addActionListener(this);
        dirRight.addActionListener(this);
        
        dirDown.setBackground(new Color(153, 76, 0));
        dirRight.setBackground(new Color(153, 76, 0));
	     
        dirDown.setForeground(Color.WHITE);
        dirRight.setForeground(Color.WHITE);
	       
	    dirDown.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
	    dirRight.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
	       
        String[][] deck_array = new String[10][10];
        String[] column = new String[10];
        
        for (int i = 0; i < 10; i++) {
        	 column[i] = "";
        }
        if (ShipPlacementCounter == 0 && Player.playerNo == 1) { 
            
        	deck_table = Deck1.deck_arr;
            deck_array = deck_table;
        
        } else if (ShipPlacementCounter == 5 && Player.playerNo == 2) {
        	
        	deck_table = Deck2.deck_arr;
            deck_array = deck_table;
        
        } else if (ShipPlacementCounter == 5 && Player.playerNo == 1) {
        	
        	Gods();
        	
        } else {
        	
        	deck_array = deck_table;
        }
        
        JLabel iron1 = new JLabel();
        iron1.setBounds(847, 430, 30, 350);
        iron1.setIcon(new ImageIcon("ironframe1.jpg"));
        
        JLabel iron2 = new JLabel();
        iron2.setBounds(845, 430, 340, 30);
        iron2.setIcon(new ImageIcon("ironframe2.jpg"));
        
        jt = new JTable(deck_array, column);
        jt.setCellSelectionEnabled(false);  
        jt.setBounds(785, 460, 400, 300);
        jt.setRowHeight(30);
        jt.setBackground(Color.LIGHT_GRAY);
        jt.setForeground(Color.BLACK);
        jt.setGridColor(Color.WHITE);
        jt.setVisible(false);
        
        JPanel pn2 = new JPanel(){
    		public void paint(Graphics g) {
    	         for(int y = 0; y < 10; y++ ){
    	              for(int x = 0; x < 10; x++){
    	                  g.setColor(Color.BLACK);
    	                  g.fillRect(x*30, y*30, 34, 30);
    	                       	
    	                      if (MenuInterface.Deck1.deck_arr[y][x] == "S" && Player.playerNo == 1) {
    	                    	  
    	                    	  g.setColor(new Color(139,69,19));
    	                       
    	                      } else if (MenuInterface.Deck2.deck_arr[y][x] == "S" && Player.playerNo == 2){
    	                       
    	                    	  g.setColor(new Color(139,69,19));
    	                       
    	                      } else { 
    	                    	  
    	                    	  g.setColor(new Color(65,105,225));
    	                      }
    	                      
    	                      g.fillRect(x*30+1, y*30+1, 34+1, 30+1);
    	                 }
    	          }
    	    }
    	};
    	pn2.setBounds(877, 460, 400, 300);
    	pn2.setLayout(null);
    	pn.add(pn2);
    	       
    	       	
        wood.add(lb);
        wood.add(lbt1);
        wood.add(t1);
        wood.add(lbt2);
        wood.add(t2);
        wood.add(lbt4);
        wood.add(dirRight);
        wood.add(dirDown);
        wood.add(ShipCount);
        wood.add(submit);
        
         
        pn.add(iron1);
        pn.add(iron2);
        pn.add(jt);
        pn.add(wood);
       
        
        
        startframe.add(pn);
        startframe.setSize(1200, 800);
        startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if (ShipPlacementCounter == 5 && Player.playerNo == 1) {
           
        	startframe.setVisible(false);
        
        } else if (ShipPlacementCounter == 5 && Player.playerNo == 2) {
        	
        	startframe.setVisible(true);
        	
        } else {
        	
        	startframe.setVisible(true);
        }
        
        startframe.setLayout(null);
        
          
   }
   
  public void PlayerPlacesShip (Deck deck, int x, int y, String direction) {
		
	   int size = size_counter;
	   
	   if (deck.ShipCheckOveral(x, y, size, direction) == true) {
			deck.shipPlacement(x, y, size, direction);
			if (counter == 1) {
				size_counter = 3;
			} else if (counter == 3) {
				size_counter = 4;
			}
			
			Ship2 ship = new Ship2(x, y, size, direction);
			Ship2.shipsList.add(ship);
			
			counter++;
			ShipPlacementCounter ++; 
		}
			
	
	}

	public void errorBox(String mess , int buttonNumber ){
		erFrame = new JFrame("Error!!!");
		erFrame.setIconImage(logo.getImage());
		erFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		erFrame.setLayout(new FlowLayout());
		JPanel pn = new JPanel();

		JLabel message = new JLabel(mess);

		if (buttonNumber == 1){
			erButton1 = new JButton("OK");
			erButton1.addActionListener(this);
			pn.add(erButton1);
		}else{
			erButton2 = new JButton("OK");
			erButton2.addActionListener(this);
			pn.add(erButton2);
		}
		pn.add(message);
		erFrame.add(pn);
		erFrame.setVisible(true);
		erFrame.pack();		
	}
   
   
 
}
