import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class ArtemisArrow extends JFrame implements ActionListener {

    JButton button;
    JTextField textField;
    ArtemisArrow(){
        JFrame frame = new JFrame("Enter coordinates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        button = new JButton("Submit");
        button.addActionListener(this);
        textField = new JTextField("enter x");
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas",Font.BOLD, 25));


        frame.add(button);
        frame.add(textField);
        frame.setVisible(true);
        frame.pack();


    }

    public static void main(String[] args){
        new ArtemisArrow();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            textField.getText();
            System.exit(0);

        }
    }


}
