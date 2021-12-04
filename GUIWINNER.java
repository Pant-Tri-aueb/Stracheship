import javax.swing.*;
import java.awt.*;

public class GUIWINNER {

    private static int playerNo;

    GUIWINNER(int playerNo) {
        this.playerNo = playerNo;
    }

    public static void main(String[] args) {


        
        ImageIcon img = new ImageIcon("war.png");
        ImageIcon img2 = new ImageIcon("logo.png");


        JLabel label = new JLabel(String.format("The winner is player %d%s", playerNo , "Name")); // create
        //label.setText("Winner is player: "); // set text for label
        label.setIcon(img);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text left , center of imageicon
        label.setVerticalTextPosition(JLabel.TOP); // SET TEXT TOP CENTER
        label.setForeground(Color.WHITE); // set font color of text
        label.setFont(new Font("MV Boli", Font.BOLD, 30)); // set font of text
        label.setIconTextGap(0); // set gap fo text to image
        label.setBackground(Color.BLACK);
        label.setOpaque(true);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(565,458);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        frame.add(label);
        frame.setIconImage(img2.getImage());
        
    }

}
