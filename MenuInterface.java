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
	
    private JFrame f;
	private JFrame newFrame;
    private JFrame startframe;
	private JFrame SecondFrame;
    private JFrame GodFrame; 
	
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
	
	private JTextField t1, t2, t4, t5, t6, t7;
	
	private JTable jt;
	
    static File click = new File("click.wav");
	
	static Player player1;
	static Player player2;
	
    
	
	public MenuInterface() {
    	gui();
    }
    
    public void gui() {
        f = new JFrame("Stracheship 1.0");
        
        JLabel background = new JLabel(new ImageIcon(
        		"stracheship.jpg"));
        add(background);
        
       
        f.setSize(1280, 733);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
    	
        b1 = new JButton("1. Έναρξη του Παιχνιδιού");
    	b1.setBounds(420, 270, 400, 80);
    	b1.addActionListener(this);
    	
        
    	b2 = new JButton("2. Παρουσίαση - Οδηγίες του Stracheship");
    	b2.setBounds(420, 410, 400, 80);
    	b2.addActionListener(this);
        
        b3 = new JButton("3. Τερματισμός");
        b3.setBounds(420, 550, 400, 80);
        b3.addActionListener(this);
    	
        
        background.setLayout(null);
        background.add(b1);
    	background.add(b2);
    	background.add(b3);
    	f.add(background);
    	f.setVisible(true);
    }
    
    public void Player() {
    	SecondFrame = new JFrame("Stracheship 1.0");
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
    	
    	String message = "";
    	
    	if (Player.playerNo == 0) {
    		
    		message = "Στοιχεία πρώτου παίκτη: ";
    	
    	} else if (Player.playerNo == 1) {
    		
    		message = "Στοιχεία δεύτερου παίκτη: ";
    	}
    	
    	JLabel title = new JLabel(message);
        title.setBounds(50, 50, 250, 30);
        title.setFont(new Font("SansSerif", Font.BOLD, 17));
    	
    	next = new JButton("Ετοίμασε τον στόλο σου");
    	next.addActionListener(this);
    	next.setBounds(50, 450, 200, 50);
    	
        JLabel name = new JLabel("Όνομα");
        name.setBounds(50, 100, 100, 30);
        
        
        t5 = new JTextField();  
        t5.setBounds(50,140, 200,30);  
        t5.addActionListener(this);
        
        JLabel sex = new JLabel("Φύλο");
        sex.setBounds(50, 180, 100, 30);
        
        
        t6 = new JTextField();  
        t6.setBounds(50, 220, 200, 30);
        t6.addActionListener(this);
        
        JLabel age = new JLabel("Ηλικία");
        age.setBounds(50, 260, 120, 30);
        
        
        t7 = new JTextField();  
        t7.setBounds(50, 300, 200,30);  
        t7.addActionListener(this);
    	
    	background.add(title);
        background.add(next);
    	background.add(name);
    	background.add(t5);
    	background.add(sex);
    	background.add(t6);
    	background.add(age);
    	background.add(t7);
    }
    
    public void Gods() {
    	GodFrame = new JFrame("Stracheship 1.0");
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
    	
    	zeus = new JButton("ΔΙΑΣ");
    	zeus.setBounds(50, 600, 200, 40);
    	zeus.addActionListener(this);
    	
        poseidon = new JButton("ΠΟΣΕΙΔΩΝΑΣ");
    	poseidon.setBounds(1010, 600, 200, 40);
    	poseidon.addActionListener(this);
        
        ares = new JButton("ΑΡΗΣ");
        ares.setBounds(690, 600, 200, 40);
        ares.addActionListener(this);
         
        artemis = new JButton("ΑΡΤΕΜΙΣ");
        artemis.setBounds(365, 600, 200, 40);
        artemis.addActionListener(this);
        

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
        	
        	
    	    newFrame = new JFrame("Παρουσίαση - Οδηγίες του Stracheship");
    		
    	    JLabel newPane = new JLabel(new ImageIcon(
            		"seastorm2.jpg"));
    		newPane.setLayout(null);
    	    
    		back = new JButton("Αρχικό Μενού");
    	    back.addActionListener(this);
    	    back.setBounds(550, 1750, 150, 30);
    		
    		
    		newFrame.setSize(1300, 800);
        	newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	newFrame.setVisible(true);
    		f.setVisible(false);
    		
    		JScrollPane scrollBar=new JScrollPane(newPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    		
    		
    		
    		JTextArea textArea = new JTextArea(2, 20);
    		textArea.setForeground(Color.WHITE);
    		textArea.setText("Παιχνίδι ναυμαχία-Σκάκι \r\n" + 
    				"\r\n" + 
    				"Περίληψη\r\n" + 
    				"Στο παιχνίδι αυτό οι παίκτες ανταγωνίζονται μεταξύ τους στην θάλασσα για την αντιμετώπιση και καταστροφή των αντίπαλων στρατευμάτων για την νίκη της ναυμαχίας.\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"Παίκτες: Το παιχνίδι φιλοξενεί δύο παίκτες που συναγωνίζονται για την πρωτιά .\r\n" + 
    				"\r\n" + 
    				"Πιόνια: \r\n" + 
    				"Κάθε παίκτης κατέχει τα δικά του στρατεύματα. Κάθε στράτευμα αποτελείται από 5 πλοία.\r\n" + 
    				"Κάθε πλοίο διαφέρει. Έχουμε το α πλοίο το οποίο λαμβάνει 2 θέσεις στον χώρο που εδράζεται το παιχνίδι.\r\n" + 
    				"Έπειτα το β και γ τα οποία κατέχουν 3 θέσεις , το δ και το ε με τις περισσότερες θέσεις 4.\r\n" + 
    				"Η αντοχή κάθε πλοίου απέναντι στις επιθέσεις του αντιπάλου διαφέρει ανάλογα το μέγεθος του.\r\n" + 
    				"Συγκεκριμένα :\r\n" + 
    				"α=2 χτυπήματα\r\n" + 
    				"β-γ=3 χτυπήματα\r\n" + 
    				"δ-ε=4 χτυπήματα \r\n" + 
    				"Στην ουσία καθένα αντέχει ν(θεσεις)\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"Χώρος που εδράζεται: \r\n" + 
    				"Σε δύο πίνακες 10x10. Ο κάθε παίκτης διαθέτει τον δικό του πίνακα στον οποίο οργανώνει τα δικά του πιόνια. \r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"Κινήσεις:\r\n" + 
    				"Κάθε πλοίο τοποθετείται διαφορετικά στον πίνακα και κινείται με διαφορετικό τρόπο ανάλογα τον τύπο του.\r\n" + 
    				"Συγκεκριμένα :\r\n" + 
    				"Το πλοίο α κατέχει μια θέση και μπορεί να τοποθετηθεί οπουδήποτε εφόσον έχει απόσταση δύο θέσεις από γειτονικά πλοία.\r\n" + 
    				"Μπορεί να μετακινηθεί μια θέση πάνω,δεξιά,αριστερά ή κάτω.\r\n" + 
    				"\r\n" + 
    				"Το πλοίο β κατέχει δύο θέσεις γειτονικές και μπορεί να τοποθετηθεί οριζόντια κρατώντας απόσταση δύο θέσεις από γειτονικά πλοία.\r\n" + 
    				"Μπορεί να μετακινηθεί οπουδήποτε θέλει παραμένοντας ωστόσο στην ίδια γραμμή.\r\n" + 
    				" \r\n" + 
    				"Το πλοίο γ κατέχει τρεις θέσεις γειτονικές και μπορεί να τοποθετηθεί κάθετα με απόσταση δύο θέσεις από γειτονικά πλοία.\r\n" + 
    				"Μετακινείται μια θέση προς όλες τις κατευθύνσεις και διαγώνια με τα υπόλοιπα μέρη του πλοίου να ακολουθούν.\r\n" + 
    				"\r\n" + 
    				"Το πλοίο δ κατέχει τέσσερις θέσεις γειτονικές και μπορεί να τοποθετηθεί οριζόντια με απόσταση δύο θέσεις από γειτονικά πλοία.\r\n" + 
    				"Μετακινείται ομοίως με το γ αλλά έως δύο θέσεις.\r\n" + 
    				"\r\n" + 
    				"Πλοκή:\r\n" + 
    				"Στο παιχνίδι αυτό κάθε παίκτης διαλέγει έναν χαρακτήρα(avatar) από την ελληνική μυθολογία με τον οποίο θα αγωνίζεται.\r\n" + 
    				"Ο χαρακτήρας τον οποίο θα επιλέξει θα φέρει κάποιες ιδιότητες και δυνατότητες.Ο κάθε παίκτης δεν μπορεί να γνωρίζει ποιον χαρακτήρα \r\n" + 
    				"έχει επιλέξει ο αντίπαλος του.Κάθε χαρακτήρας κατέχει μια ιδιότητα άμυνας καθώς και επίθεσης. \r\n" + 
    				"Οι διαθέσιμοι χαρακτήρες είναι οι ακόλουθοι:\r\n" + 
    				"->Δίας\r\n" + 
    				"->Άρης\r\n" + 
    				"->Ποσειδώνας\r\n" + 
    				"->Άρτεμης\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"Δίας\r\n" + 
    				"-----\r\n" + 
    				"Ως πατέρας όλων σε ιδιότητα άμυνας μπορεί να αναστήσει ένα από τα χαμένα του πλοία.\r\n" + 
    				"Σε επίθεση μπορεί να ρίξει έναν κεραυνό ο οποίος καταστρέφει ολοκληρωτικά τα πλοία α,β αν τα πετύχει ενώ αφήνει με μια μόνο ζωή\r\n" + 
    				"τα πλοία γ,δ εφόσον τα πετύχει.\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"Άρτεμης\r\n" + 
    				"-------\r\n" + 
    				"Ως προστάτιδα των μικρών παιδιών και των ζώων η ιδιότητα άμυνάς της είναι η προστασία των πλοίων της για δύο κινήσεις του αντιπάλου.\r\n" + 
    				"Δηλαδή για δύο αντίπαλες επιθέσεις αν κάποια πετύχει κάποιο πλοίο της αυτό δεν τα αποδυναμώνει.\r\n" + 
    				"\r\n" + 
    				"Ως θεά του κυνηγιού ρίχνει σε οριζόντια κίνηση ένα βέλος το οποίο αν περάσει από κουτί στο οποίο υπάρχει μέρος πλοίου δείχνει όλες \r\n" + 
    				"τις θέσεις που το πλοίο αυτό λαμβάνει.\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"Άρης\r\n" + 
    				"-----\r\n" + 
    				"Ο Άρης ως θεός του πολέμου σε άμυνα μπορεί να εμψυχώσει τον στρατό του αυξάνοντας όλα τα πλοία του κατά μια ζωή(εκτός αν έχουν φτάσει το όριο μέγιστης ζωής).\r\n" + 
    				"\r\n" + 
    				"Σε επίθεση αφοπλίζει τα πλοία του αντιπάλου για 4 κινήσεις του αφήνοντας του μόνο την ελευθερία να τα μετακινεί.\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"Ποσειδώνας\r\n" + 
    				"----------\r\n" + 
    				"Ο συγκεκριμένος χαρακτήρας εφόσον δαμάζει τα κύματα σε άμυνα μπορεί να σηκώσει κύματα και να κρύψει όλα τα πλοία του πίσω από αυτα.Συγκεκριμένα\r\n" + 
    				"η Άρτεμις δεν μπορεί να τα εντοπίσει με το βέλος της , ο άρης δεν μπορεί να αφοπλίσει τα όπλα τους και ο κεραυνός του δία να τα χτυπήσει με κεραυνό.\r\n" + 
    				"Βέβαια είναι επιλογή του παίκτη αν θα θέλει να χρησιμοποιήσει την κάρτα του στις επιθέσεις αυτές των αντιπάλων.\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"Σε επίθεση στέλνει κύματα στον αντίπαλο και ο αντίπαλος χάνει δύο επόμενες κινήσεις του μέχρι τα πλοία του να οργανωθούν ξανά απο τις φουρτούνες.\r\n" + 
    				"\r\n" + 
    				"Κάθε ιδιότητα κάθε θεότητας θέλει χρόνο επαναφόρτισης , συγκεκριμένα κάθε 10 κινήσεις παιχνιδιού επαναφορτίζεται η κάθε ιδιότητα.\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				"\r\n" + 
    				""); 
    	    textArea.setWrapStyleWord(true);
    	    textArea.setLineWrap(false);
    	    textArea.setOpaque(false);
    	    textArea.setEditable(false);
    	    textArea.setFocusable(true);
    	    textArea.setBounds(0, 0, 2000, 1600);
    	    textArea.setFont(new Font("SansSerif", Font.BOLD, 15));
    	    
    	    
    	    newPane.add(textArea);
    	    newPane.add(back);
    	    newFrame.add(scrollBar);
    	    
    	   
    	    
    	 } else if (e.getSource() == b3) {
    		 Bsound.Sound(click);
    		 
    		 System.exit(0);
    	 
    	 } else if (e.getSource() == back) {
    		 Bsound.Sound(click);
    		 
    		 newFrame.setVisible(false);
    		 f.setVisible(true);
    	 
    	 
    	 } else if (e.getSource() == submit) {
    		     Bsound.Sound(click);
    		 
    		     String answer1 = t1.getText();
    	         String answer2 = t2.getText();
    	         
    	     
    	         int x = Integer.parseInt(answer1);
    	         int y = Integer.parseInt(answer2);
    	         
    	         
    	         if (Player.playerNo == 1) {
    	        	  
    	        	 PlayerPlacesShip(Deck1, x, y, direction);
    	         
    	         } else {
    	        	 
    	        	 PlayerPlacesShip(Deck2, x, y, direction);
    	         }
    	         
    	         startframe.setVisible(false);
    	         startGame();
    	        
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
	         int age = Integer.parseInt(answer7);
	         
	         if (Player.playerNo == 0) {
	        	 
	        	 player1 = new Player(name, sex, age);
	         
	         } else {
	        	 
	        	 player2 = new Player(name, sex, age);
	         }
	         
    		 SecondFrame.setVisible(false);
	         
    		 startGame();
        
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
    		}
    		 
    		 
    		 if (Player.playerNo == 1) {
    			 
    			 GodFrame.setVisible(false);
        		 Player();
        	
        	 } else {
        		 Game runGame = new Game();
        		 
        		 GodFrame.setVisible(false);
        		 runGame.StracheshipBoard();
        	 }
        	
        }
   }
		
	
   
    public void startGame() {
        startframe = new JFrame("Stracheship 1.0");
       
        JLabel pn = new JLabel(new ImageIcon(
        		"storm5.jpg"));
        
        pn.setLayout(null);
        
        JLabel lb = new JLabel("Δώστε x, y, μέγεθος, και κατεύθυνση για το πλοίο");
        lb.setBounds(50, 50, 280, 30);
        lb.setOpaque(true);
        lb.setBackground(Color.GRAY);
        lb.setForeground(Color.BLACK);
        
        if (Player.playerNo == 2 && ShipPlacementCounter == 5) {
 		   counter = 1;
 		   size_counter = 2;
 	   }
 	   
        String message;
        message = String.format("Τοποθετήστε πλοίο %d θέσεων", 
            		size_counter);
        
        JLabel ShipCount = new JLabel(message); 
        ShipCount.setBounds(300, 600, 170, 30);
        ShipCount.setOpaque(true);
        ShipCount.setBackground(Color.GRAY);
        ShipCount.setForeground(Color.BLACK);
        
        submit = new JButton("Καταχώρηση");
        submit.addActionListener(this);  
        submit.setBounds(80, 400, 130, 30);
        
        JLabel lbt1 = new JLabel("Συντεταγμένη Χ");
        lbt1.setBounds(50, 100, 100, 30);
        lbt1.setOpaque(true);
        lbt1.setBackground(Color.GRAY);
        lbt1.setForeground(Color.BLACK);
        
        t1 = new JTextField();  
        t1.setBounds(50,140, 200,30);  
        t1.addActionListener(this);
        
        JLabel lbt2 = new JLabel("Συντεταγμένη Υ");
        lbt2.setBounds(50, 180, 100, 30);
        lbt2.setOpaque(true);
        lbt2.setBackground(Color.GRAY);
        lbt2.setForeground(Color.BLACK);
        
        t2 = new JTextField();  
        t2.setBounds(50, 220, 200, 30);
        t2.addActionListener(this);
        
        JLabel lbt4 = new JLabel("Κατεύθυνση Πλοίου");
        lbt4.setBounds(50, 260, 120, 30);
        lbt4.setOpaque(true);
        lbt4.setBackground(Color.GRAY);
        lbt4.setForeground(Color.BLACK);
        
        dirDown = new JButton("ΚΑΘΕΤΑ");
        dirRight = new JButton("ΟΡΙΖΟΝΤΙΑ");
        
        dirDown.setBounds(50, 325, 100, 30);
        dirRight.setBounds(155, 325, 100, 30);
        
        dirDown.addActionListener(this);
        dirRight.addActionListener(this);
        
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
        jt = new JTable(deck_array, column);
        jt.setCellSelectionEnabled(false);  
        jt.setBounds(785, 460, 400, 300);
        jt.setRowHeight(30);
        jt.setBackground(Color.LIGHT_GRAY);
        jt.setForeground(Color.BLACK);
        jt.setGridColor(Color.WHITE);
        
        pn.add(ShipCount);
        pn.add(lb);
        pn.add(lbt1);
        pn.add(t1);
        pn.add(lbt2);
        pn.add(t2);
        pn.add(lbt4);
        pn.add(dirRight);
        pn.add(dirDown);
        pn.add(jt); 
        pn.add(submit);
        
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
   
 
}
