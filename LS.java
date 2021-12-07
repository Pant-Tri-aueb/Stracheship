import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class LS extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	private JTable table;
	private static JLabel label;
	private static JLabel label_1;
	
	public  void play() {
		LS frame = new LS();
		frame.setVisible(true);
		try {
			for(int x=2;x<102;x++) {
				LS.progressBar.setValue(x);
				Thread.sleep(180);
				LS.label_1.setText(Integer.toString(x)+" %");
				if (x==0) {
					LS.label.setText("Loading game..");
				} else if (x==13) {
					LS.label.setText("Gamieste.....");
				}else if (x == 27) {
					LS.label.setText("Loading game...");
				}else if (x == 40) {
					LS.label.setText("Gamieste..");
				}else if (x == 54) {
					LS.label.setText("Loading game......");
				}else if (x == 69) {
					LS.label.setText("Gamieste...");
				}else if (x == 86) {
					LS.label.setText("Loading game..");
				}
				
				if(x==101) {
					frame.dispose();
				}
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		MenuInterface mn = new MenuInterface();
	}
	public LS() {
		setUndecorated(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Forte", Font.PLAIN, 27));
		label.setBounds(12, 683, 209, 37);
		contentPane.add(label);

		label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		label_1.setBounds(605, 720, 81, 27);
		contentPane.add(label_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(UIManager.getFont("Button.font"));
		lblNewLabel.setBackground(SystemColor.desktop);
		ImageIcon icon = new ImageIcon("ST.jpg");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 1200, 720);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setForeground(new Color(0, 255, 0));
		progressBar.setBounds(0, 720, 1200, 27);
		contentPane.add(progressBar);
		
		table = new JTable();
		table.setBounds(603, 719, 1, 1);
		contentPane.add(table);
		
	}
	
	public static void main(String args[]) {
		LS l = new LS();
		l.play();
  }

}
