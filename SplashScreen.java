import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	public static Backgroundmusic bmusic = new Backgroundmusic();
	
	/**
	  * method :fills progressBar
	  * 	    sets label_1 as an indicator for progressBar progress
	  *         sets label different messages that will pop up in SplashScreen  
	  */
	
	public  void play() {
		SplashScreen frame = new SplashScreen();
		frame.setVisible(true);
		try {
			for(int x=0;x<102;x++) {
				progressBar.setValue(x);
				Thread.sleep(180);
				label_1.setText(String.valueOf(x)+" %");
				if (x==0) {
					SplashScreen.label.setText("Loading game...");
				} else if (x==13) {
					SplashScreen.label.setText("Please Wait...");
				}else if (x == 27) {
					SplashScreen.label.setText("Loading game...");
				}else if (x == 40) {
					SplashScreen.label.setText("Please Wait...");
				}else if (x == 50) {
					label_1.setForeground(Color.BLACK);
					SplashScreen.label.setText("Loading game...");
				}else if (x == 69) {
					SplashScreen.label.setText("Please Wait...");
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
		try {
			MenuInterface mn = new MenuInterface();
			
			File music = new File("Background.wav");
			bmusic.sound(music);
		
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	/**
	  * Create the frame.
	  */
	
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
		label.setFont(new Font("Forte", Font.PLAIN, 25));
		label.setBounds(12, 565, 600, 37);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Forte", Font.PLAIN, 21));
		label_1.setBounds(455, 0, 83, 29);
		
		
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
		progressBar.add(label_1);
		
		table = new JTable();
		table.setBounds(603, 719, 1, 1);
		contentPane.add(table);		
	}
	
}
