import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Stracheship_Game{
    public static void main(String[] args) {
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
}