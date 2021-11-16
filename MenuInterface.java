import javax.swing.*;
import java.awt.*;

public class MenuInterface {
   
    public MenuInterface() {
    	gui();
    }
    
    public void gui() {
    	JFrame f = new JFrame("Stracheship 1.0");
    	
    	f.setSize(900, 900);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    	JPanel p = new JPanel();
    	p.setBackground(Color.BLUE);
    	p.setBorder(BorderFactory.createEmptyBorder(150, 200, 150, 200));
    	p.setLayout(new GridLayout(4, 1, 0, 70));
    	
    	JButton b1 = new JButton("1. Έναρξη του παιχνιδιού");
    	JButton b2 = new JButton("2. Παρουσίαση - Οδηγίες του Stracheship");
    	JButton b3 = new JButton("3. Τερματισμός");
    	
      JLabel title = new JLabel("STRACHESHIP");
    	title.setFont(new Font("Anton", Font.BOLD, 65));
    	title.setForeground(Color.BLACK);
    	
      p.add(title);
    	p.add(b1);
    	p.add(b2);
    	p.add(b3);
	    
    	f.add(p,BorderLayout.CENTER);
    	f.setVisible(true);
    }
    
    public static void main(String[] args) {
    	new MenuInterface();
    }
}
