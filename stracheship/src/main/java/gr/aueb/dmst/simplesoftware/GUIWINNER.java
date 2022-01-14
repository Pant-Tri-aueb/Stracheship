package stracheship.src.main.java.gr.aueb.dmst.simplesoftware;


import javax.swing.*;
import java.awt.*;
import java.io.File;

// Class for winner announcment
public class GUIWINNER {

    private static int playerNo;
    
   
    // Constructor
    GUIWINNER(int playerNo) {
        this.playerNo = playerNo;
    }

    // Run to show the winner
    public static void winner() {
        
    	
    	MenuInterface.bmusic2.c.stop();
    	
        ImageIcon img = new ImageIcon("navmaxia.jpg"); 
        ImageIcon img2 = new ImageIcon("logo.png");
        
        // Winner frame text
        JLabel label = new JLabel(String.format("The winner is %s!", 
        		(MenuInterface.Deck1.checkWinner() == true) || (MenuInterface.Deck2.checkWinner() == true)  ?  
        				Deck.getWinnerName() : "There is no winner yet :(" )); 
        
        
        
        label.setIcon(img);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text left , center of imageicon
        label.setVerticalTextPosition(JLabel.TOP); // SET TEXT TOP CENTER
        label.setForeground(Color.WHITE); // set font color of text
        label.setFont(new Font("MV Boli", Font.BOLD, 30)); // set font of text
        label.setIconTextGap(0); // set gap fo text to image
        label.setBackground(Color.BLACK);
        label.setOpaque(true);

        // Main winner frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(565,458);
        frame.setLocation(350, 100);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(label);
        frame.setIconImage(img2.getImage());
        frame.pack();
        
       
        
    }

}
