import java.awt.Color;
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

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	private JTable table;
	private static JLabel label;
	private static JLabel label_1;
	static ImageIcon logo = new ImageIcon("logo.png");
	
	public  void play() {
		SplashScreen frame = new SplashScreen();
		frame.setVisible(true);
		try {
			for(int x=0;x<102;x++) {
				SplashScreen.progressBar.setValue(x);
				Thread.sleep(180);
				SplashScreen.label_1.setText(Integer.toString(x)+" %");
				if (x==0) {
					SplashScreen.label.setText("Loading game...");
				} else if (x==13) {
					SplashScreen.label.setText("Gamieste...");
				}else if (x == 27) {
					SplashScreen.label.setText("Loading game...");
				}else if (x == 40) {
					SplashScreen.label.setText("Gamieste...");
				}else if (x == 50) {
					label_1.setForeground(Color.BLACK);
					SplashScreen.label.setText("Loading game...");
				}else if (x == 69) {
					SplashScreen.label.setText("Gamieste...");
				}else if (x == 86) {
					SplashScreen.label.setText("Loading game...");
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
	public SplashScreen() {
		setUndecorated(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 916, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setIconImage(logo.getImage());
		
		label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		label.setBounds(12, 570, 600, 37);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Calibri", Font.BOLD, 18));
		label_1.setBounds(447, 600, 83, 29);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(UIManager.getFont("Button.font"));
		lblNewLabel.setBackground(SystemColor.desktop);
		ImageIcon icon =new ImageIcon("SSimage.png");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 916, 600);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setForeground(Color.WHITE);
		progressBar.setBounds(0, 600, 916, 29);
		contentPane.add(progressBar);
		
		table = new JTable();
		table.setBounds(603, 719, 1, 1);
		contentPane.add(table);		
	}
	
}
