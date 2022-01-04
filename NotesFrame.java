import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotesFrame extends javax.swing.JFrame implements ActionListener{

    JButton[][]butArray= new JButton[10][10];
    int size = 10;
    int firstrow, firstcol, secondrow;
    boolean firstClick = true;

    JPanel gamePAN = new JPanel();

    public NotesFrame(){
        initComponents();
        initialize();
        this.setSize(516, 539);
        this.add(gamePAN);
    }

    private void initialize(){
        JPanel gamePAN = new JPanel();
        gamePAN.setBounds(0,0,500,500);
        getContentPane().add(gamePAN);
        gamePAN.setLayout(new GridLayout(size,size));
        for(int r=0;r<size;r++){
            for(int c=0;c<size;c++){
                //Create a new JButton
                butArray[r][c] = new JButton();
                butArray[r][c].setBackground(Color.BLUE);
                butArray[r][c].addActionListener(this);
                butArray[r][c].setSize(50,50);
                gamePAN.add(butArray[r][c]);
            }
            validate();
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        for(int r = 0; r < size; r++){
            for (int i = 0; i < size; i++) {
                if(ae.getSource() == butArray[r][i]){
                    if (butArray[r][i].getBackground() == Color.BLUE) {
                        butArray[r][i].setBackground(Color.RED);
                    } else if (butArray[r][i].getBackground() == Color.RED) {
                        butArray[r][i].setBackground(Color.WHITE); 
                    } else if (butArray[r][i].getBackground() == Color.WHITE) {
                        butArray[r][i].setBackground(Color.BLUE); 
                    }
                }
            }
        }
        
    }

    private void initComponents() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        GroupLayout gamePANLayout = new GroupLayout(gamePAN);
        gamePAN.setLayout(gamePANLayout);
        gamePANLayout.setHorizontalGroup(gamePANLayout.createParallelGroup(Alignment.LEADING).addGap(0, 670, Short.MAX_VALUE));
        gamePANLayout.setVerticalGroup(gamePANLayout.createParallelGroup(Alignment.LEADING).addGap(0, 530, Short.MAX_VALUE));

        getContentPane().add(gamePAN);
        gamePAN.setBounds(50, 70 ,670, 530);

        pack();
    }





    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotesFrame().setVisible(true);
            }
        });
    }

    
}
