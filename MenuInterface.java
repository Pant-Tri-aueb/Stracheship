import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// INCLUDES code from Stracheship_Game.java

public class MenuInterface extends JFrame implements java.awt.event.ActionListener {
   
	private JFrame f;
	private JFrame newFrame;
   
	private JButton b1;
    private JButton b2;
    private JButton b3;
	private JButton back;
    
	public MenuInterface() {
    	gui();
    }
    
    public void gui() {
        f = new JFrame("Stracheship 1.0");
    	
    	f.setSize(1200, 800);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    	JPanel p = new JPanel();
    	p.setBackground(Color.BLUE);
    	p.setBorder(BorderFactory.createEmptyBorder(150, 400, 150, 400));
    	p.setLayout(new GridLayout(4, 1, 0, 70));
    	
    	b1 = new JButton("1. Έναρξη του παιχνιδιού");
    	b1.addActionListener(this);
        
    	b2 = new JButton("2. Παρουσίαση - Οδηγίες του Stracheship");
        b2.addActionListener(this);
        
        b3 = new JButton("3. Τερματισμός");
    	b3.addActionListener(this);
    	
    	JLabel title = new JLabel("STRACHESHIP");
    	title.setFont(new Font("Anton", Font.BOLD, 52));
    	title.setForeground(Color.BLACK);
    	
    	p.add(title);
    	p.add(b1);
    	p.add(b2);
    	p.add(b3);
	    
    	f.add(p,BorderLayout.CENTER);
    	f.setVisible(true);
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1 ) {
        	
        	f.setVisible(false);
        	run();
        
        } else if (e.getSource() == b2) {
    		
    	    newFrame = new JFrame("Παρουσίαση - Οδηγίες του Stracheship");
    		JPanel newPane = new JPanel();
    		
    	    back = new JButton("Αρχικό Μενού");
    	    back.addActionListener(this);
    	   
    		newPane.setBackground(Color.CYAN);
    		
    		newFrame.setSize(1200, 1200);
        	newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	newFrame.getContentPane().setBackground(Color.CYAN);
        	newFrame.setVisible(true);
    		f.setVisible(false);
    		
    		JScrollPane scrollBar=new JScrollPane(newPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    		
    		
    		JTextArea textArea = new JTextArea(2, 20);
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
    				"->Αθηνά\r\n" + 
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
    	    textArea.setBackground(Color.BLUE);
    	    
    	    newPane.add(textArea);
    	    newPane.add(back);
    	    newFrame.add(scrollBar);
    	    
    	   
    	    
    	 } else if (e.getSource() == b3) {
    		
    		 System.exit(0);
    	 
    	 } else if (e.getSource() == back) {
    		 
    		 newFrame.setVisible(false);
    		 f.setVisible(true);
    	 }
		
	}
    public static void run() {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 729, 729);
        frame.setUndecorated(true);
        JPanel pn = new JPanel(){
            @Override
            public void paint(Graphics g) {
                for(int y = 0 ; y < 9;y++ ){
                    for(int x = 0 ; x < 9;x++){
                        g.setColor(Color.BLACK);
                        g.fillRect(x*81, y*81, 81, 81);
                        g.setColor(Color.BLUE);
                        g.fillRect(x*81+1, y*81+1, 81+1, 81+1);
                    }
                }
                
            }
        };
        frame.add(pn);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
    	new MenuInterface();
    }
}
