import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Winner implements ActionListener {
    private int playerNo;
    private JFrame winnerframe;
    private JPanel winnerpanel;
    private JButton winnerbutton;
    private JLabel winnerlabel, winnerlabel2;

    Winner(int playerNo) {
        this.playerNo = playerNo;
        winnerframe = new JFrame("Results");
        winnerpanel = new JPanel();
        winnerbutton = new JButton("Ok");
        winnerbutton.addActionListener(this);


        winnerlabel = new JLabel("The winner is player :  " );
        winnerlabel.setFont(new Font("Serif", Font.PLAIN, 30));
        winnerlabel2 = new JLabel();
        winnerlabel2.setText(String.valueOf(playerNo));
        winnerlabel2.setFont(new Font("Serif", Font.PLAIN, 30));

        winnerframe.setSize(500,500 );
        winnerframe.setLayout(null);
        winnerframe.setContentPane(new JLabel(new ImageIcon("C:\\Users\\dimit\\Desktop\\orange.jpg")));

        winnerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winnerframe.setTitle("Results");
        winnerframe.setVisible(true);

        winnerframe.add(winnerbutton);
        winnerframe.add(winnerlabel);
        winnerframe.add(winnerlabel2);
        winnerbutton.setBounds(125, 300, 200, 50);
        winnerlabel.setBounds(125,200,200,50);
        winnerlabel2.setBounds(125,200,200,50);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);

    }

    public int getWinner(int PlayerNo) {
            return PlayerNo;
    }
}
