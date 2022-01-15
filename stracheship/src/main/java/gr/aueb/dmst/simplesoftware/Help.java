package stracheship.src.main.java.gr.aueb.dmst.simplesoftware;


import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTextArea;

import javax.swing.Timer;

import javax.swing.JLabel;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Help extends JFrame implements ActionListener{

 static ImageIcon logo = new ImageIcon("logo.png");	
 static File click = new File("click.wav");
	
 private JButton back;
 private JButton back2;
 private JButton back3;
 private JButton b1;
 private JButton b2;
 private JButton b3;
 private JButton b4;
 private JButton b5;
 private JButton b6;
 private JButton god1;
 private JButton god2;
 private JButton god3;
 private JButton god4;
 

 private JLabel lb;
 private JLabel title;
 private JTextArea a1;
 private JTextArea a2;
 private JTextArea a3;
 private JTextArea a4;
 private JTextArea a5;
 private JTextArea a6;
 private JTextArea a7;
 private JTextArea a8;
 private JTextArea a9;
 private JTextArea a10;
 
 int Textlength = 0;
 Timer t;
 int i = 0;

 /**
  * Launch the application.
  */
 public static void instructions() {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Help frame = new Help();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the frame.
  */
 public Help() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(250, 100, 1300, 900);
  setResizable(false);
  lb = new JLabel(new ImageIcon("help.jpg"));
  lb.setLayout(null);
  lb.setBounds(0, 0, 1300, 900);
  
  title = new JLabel("                                                                Stracheship Presentation" );
  title.setBounds(0, 30, 1300, 20);
  title.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
  title.setForeground(Color.WHITE);
  
  a1 = new JTextArea("                                                                                                                        Main idea\r\n" + 
			"\r\n" + 
			"Stracheship is a competitive game, a variation of the known games of chess, ship naval battles. Basically is a combination of those two\r\n"+
			"\r\n"+
			"games as the name shall clarify.\r\n" + 
			"\r\n" + 
			"Stra from strategy that it should use\r\n" + 
			"\r\n" + 
			"Ches from chess\r\n" + 
			"\r\n" + 
			"And ship from naval battles.\r\n" + 
			"\r\n" + 
			"In this game two players compete for the domination of the sea. Main goal is to destroy all the ships of competitor.\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n");
  
  a1.setBounds(0, 0, 1300, 600);
  a1.setVisible(false);
  a1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
  a1.setForeground(Color.WHITE);
  a1.setWrapStyleWord(true);
  a1.setLineWrap(false);
  a1.setOpaque(false);
  a1.setEditable(false);
  a1.setFocusable(true);
  
  a2 = new JTextArea("                                                                                                                        Play area\r\n" + 
			"\r\n" + 
			"Stracheship is taking place in two 10x10 tables. Each player has his own table.\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n");

  a2.setBounds(0, 0, 1300, 600);
  a2.setVisible(false);
  a2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
  a2.setForeground(Color.WHITE);
  a2.setWrapStyleWord(true);
  a2.setLineWrap(false);
  a2.setOpaque(false);
  a2.setEditable(false);
  a2.setFocusable(true);
  
  a3 = new JTextArea("                                                                                                                          FLEET\r\n" + 
			"\r\n" + 
			"Each player is given a number of troops. Specifically each player has five ships each one of them with a different length and stamina.\r\n" + 
			"\r\n" + 
			"They have one small ship which withholds two places in the  table and can endures two attacks of enemy troops.\r\n" + 
			"\r\n" + 
			"Two normal ships with three places in the warzone and stamina of three lifes.\r\n" + 
			"\r\n" + 
			"Two large ships with four places and stamina of 4 enemy attacks.\r\n" + 
			"\r\n" + 
			"\r\n");

  a3.setBounds(0, 0, 1300, 600);
  a3.setVisible(false);
  a3.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
  a3.setForeground(Color.WHITE);
  a3.setWrapStyleWord(true);
  a3.setLineWrap(false);
  a3.setOpaque(false);
  a3.setEditable(false);
  a3.setFocusable(true);
  
  a4 = new JTextArea("                                                                                                                        Movement\r\n" + 
			"\r\n" + 
			"Ships can be places either horizontally either vertically. If a ship is horizontally placed\r\n" + 
			"\r\n" + 
			"It can only move right or left. In the opposite, if it is placed vertically it can only move up or down by size of the table.\r\n" + 
			"\r\n" + 
			"\r\n");

  a4.setBounds(0, 0, 1300, 600);
  a4.setVisible(false);
  a4.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
  a4.setForeground(Color.WHITE);
  a4.setWrapStyleWord(true);
  a4.setLineWrap(false);
  a4.setOpaque(false);
  a4.setEditable(false);
  a4.setFocusable(true);
  
  a5 = new JTextArea("                                                                                                                         Deities\r\n" + 
			"\r\n" + 
			"Players represent a god from Greek mythology. They choose the deity before the game starts. They cannot choose the same. Each one of \r\n "+ 
			"\r\n"+
			"them has different power of attack and defense accordingly his role in mythology. The deities they can choose is zeus , artemis ,\r\n "+
			"\r\n"+
			"ares and Poseidon. More specifically :\r\n" + 
			"\r\n");

  a5.setBounds(0, 0, 1300, 200);
  a5.setVisible(false);
  a5.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
  a5.setForeground(Color.WHITE);
  a5.setWrapStyleWord(true);
  a5.setLineWrap(false);
  a5.setOpaque(false);
  a5.setEditable(false);
  a5.setFocusable(true);
  
  a6 = new JTextArea("                                                                                                                  Game instructions\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"Each player has his own round. In this round the player has five available movements . He can choose in every move if he wants \r\n"+
			"\r\n"+
			"to move a ship of his or to hit in a block of the enemy table so as to hit enemy troops.\r\n"+
			"\r\n" + 
			"When those five movements end player gets to choose either to give turn in enemy or to use god power. \r\n"+
			"\r\n"+
			"If he chooses god then he picks attack or defense accordingly to his plans.\r\n"+ 
			"\r\n" + 
			"When god power ends he has to choose to give turn so he cannot see the table of his enemy. Also, player can win any time. \r\n"+
			"\r\n"+
			"Not all movements must be used. \r\n" +
			"\r\n" + 
			"In case in which he hits an enemy ship a sound will be made so the player knows he actually hit a block that contains part \r\n"+
			"\r\n"+
			"of the ship.\r\n" + 
			"\r\n" + 
			"Screen of the player contains his table(sea), ships. When he clicks in a ship it also shows its stamina and type of sea(small, \r\n"+
			"\r\n"+
			"normal, large).\r\n" + 
			"\r\n" + 
			"All ships have the same color. For reasons of convenience the ship you click gets more dark.\r\n" + 
			"\r\n" + 
			"Players also have a map of enemy table which shows the blocks he has hit with a black color.  So, every time he presses the \r\n"+
			"\r\n"+
			"button “hit” in his screen he knows his previous hits. This map can be updated only manually, something like a players notepad \r\n"+
			"\r\n"+
			"Color Blue means, block not hit at all, color Red means ship is hit in this block and color White means no ship at the block hit  \r\n"+
			"\r\n"+
			"Also ships can move so there is the option to clear a particular block by turing it back to Blue. Color can be changed simply \r\n "+
			"\r\n"+
			"by clicking at a certain block in this sequence : (BLUE) - RED - WHITE - BLUE...");

  a6.setBounds(0, 0, 1300, 600);
  a6.setVisible(false);
  a6.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
  a6.setForeground(Color.WHITE);
  a6.setWrapStyleWord(true);
  a6.setLineWrap(false);
  a6.setOpaque(false);
  a6.setEditable(false);
  a6.setFocusable(true);
  
  a7 = new JTextArea("                                                                                                                           Zeus\r\n" + 
			"\r\n" + 
			"Attack = As the god of thunders in his attacks he chooses a ship of the enemy troops and\r\n" + 
			"\r\n" + 
			"either he destroys it or only leaves it with one life. If the ship is small or normal it gets full destroyed, if it is large \r\n"+
			"\r\n"+
			"it is left with stamina of one hit.\r\n" + 
			"\r\n" + 
			"His attacks ,however, cannot pass the defense of Poseidon but can go through the defense of Aris.\r\n" + 
			"\r\n" + 
			"Defense = Being the father of all gods he can raise a ship that is destroyed back to life with full stamina.\r\n" + 
			"\r\n");

a7.setBounds(0, 0, 1300, 600);
a7.setVisible(false);
a7.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
a7.setForeground(Color.WHITE);
a7.setWrapStyleWord(true);
a7.setLineWrap(false);
a7.setOpaque(false);
a7.setEditable(false);
a7.setFocusable(true);

a8 = new JTextArea("                                                                                                                          Artemis\r\n" + 
		"\r\n" + 
		"Attack :\r\n" + 
		"\r\n" + 
		"As the goddess of hunt she picks a line out of ten and throws an arrow among that line. Everything in the way of the arrow gets hit.\r\n" + 
		"\r\n" + 
		"Defense:\r\n" + 
		"\r\n" + 
		"Goddess of care and protector of children, she can pick a ship of hers which is not destroyed and full its stamina.\r\n" + 
		"\r\n");

a8.setBounds(0, 0, 1300, 600);
a8.setVisible(false);
a8.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
a8.setForeground(Color.WHITE);
a8.setWrapStyleWord(true);
a8.setLineWrap(false);
a8.setOpaque(false);
a8.setEditable(false);
a8.setFocusable(true);

a9 = new JTextArea("                                                                                                                            Ares\r\n" + 
		"\r\n" + 
		"Attack:\r\n" + 
		"\r\n" + 
		"God of war. His attack matches his role in mythology, every ship of the enemy gets hit one time losing one point on its stamina.\r\n" + 
		"\r\n" + 
		"Defense:\r\n" + 
		"\r\n" + 
		"Being the god of war he protects his warriors. He chooses a ship of his own and shields it. The enemy has to hit each block \r\n"+
		"\r\n"+
		"of the shield ship two times to destroy it.\r\n" + 
		"\r\n");

a9.setBounds(0, 0, 1300, 600);
a9.setVisible(false);
a9.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
a9.setForeground(Color.WHITE);
a9.setWrapStyleWord(true);
a9.setLineWrap(false);
a9.setOpaque(false);
a9.setEditable(false);
a9.setFocusable(true);

a10 = new JTextArea("                                                                                                                         Poseidon\r\n" + 
		"\r\n" + 
		"Attack:\r\n" + 
		"\r\n" + 
		"God of sea. He chooses a ship of the enemy. That ship appears in a new different table(10x10)/sea. Now the player knows the \r\n"+
		"\r\n"+
		"specific place of that ship. However the player cannot know how much life/stamina that ship contains.\r\n" + 
		"\r\n" + 
		"Defense:\r\n" + 
		"\r\n" + 
		"Picks coordinates x,y in the table. Those coordinates form the top left corner of a new 4x4 table which is created. \r\n"+
		"\r\n"+
		"Every ship in this table is being protected by enemy attacks for four rounds.\r\n" + 
		"\r\n" + 
		"\r\n");

a10.setBounds(0, 0, 1300, 600);
a10.setVisible(false);
a10.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
a10.setForeground(Color.WHITE);
a10.setWrapStyleWord(true);
a10.setLineWrap(false);
a10.setOpaque(false);
a10.setEditable(false);
a10.setFocusable(true);
  
  
  
  b1 = new JButton("MAIN IDEA");
  b1.addActionListener(this);
  b1.setBounds(200, 180, 250, 40);
  b1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  b1.setBackground(Color.GRAY);
  b1.setForeground(Color.WHITE);
  
  b2 = new JButton("SEA");
  b2.addActionListener(this);
  b2.setBounds(530, 180, 250, 40);
  b2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  b2.setBackground(Color.GRAY);
  b2.setForeground(Color.WHITE);
   
  b3 = new JButton("FLEET");
  b3.addActionListener(this);
  b3.setBounds(860, 180, 250, 40);
  b3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  b3.setBackground(Color.GRAY);
  b3.setForeground(Color.WHITE);
  
  b4 = new JButton("MOVEMENT");
  b4.addActionListener(this);
  b4.setBounds(200, 400, 250, 40);
  b4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  b4.setBackground(Color.GRAY);
  b4.setForeground(Color.WHITE);
  
  b5 = new JButton("DEITIES");
  b5.addActionListener(this);
  b5.setBounds(530, 400, 250, 40);
  b5.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  b5.setBackground(Color.GRAY);
  b5.setForeground(Color.WHITE);
  
  b6 = new JButton("GAME INSTRUCTIONS");
  b6.addActionListener(this);
  b6.setBounds(860, 400, 250, 40);
  b6.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  b6.setBackground(Color.GRAY);
  b6.setForeground(Color.WHITE);
  
  god1 = new JButton("ZEUS");
  god1.addActionListener(this);
  god1.setBounds(350, 300, 250, 40);
  god1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  god1.setBackground(Color.GRAY);
  god1.setForeground(Color.WHITE);
  god1.setVisible(false);
  
  god2 = new JButton("ARTEMIS");
  god2.addActionListener(this);
  god2.setBounds(650, 300, 250, 40);
  god2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  god2.setBackground(Color.GRAY);
  god2.setForeground(Color.WHITE);
  god2.setVisible(false);
  
  god3 = new JButton("ARES");
  god3.addActionListener(this);
  god3.setBounds(350, 500, 250, 40);
  god3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  god3.setBackground(Color.GRAY);
  god3.setForeground(Color.WHITE);
  god3.setVisible(false); 
  
  god4 = new JButton("POSEIDON");
  god4.addActionListener(this);
  god4.setBounds(650, 500, 250, 40);
  god4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  god4.setBackground(Color.GRAY);
  god4.setForeground(Color.WHITE);
  god4.setVisible(false); 
  
  this.setIconImage(logo.getImage());
  
  
  
  back = new JButton("BACK");
  back.addActionListener(this);
  back.setBounds(530, 700, 250, 40);
  back.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  back.setBackground(Color.GRAY);
  back.setForeground(Color.WHITE);
  
  back2 = new JButton("BACK");
  back2.addActionListener(this);
  back2.setBounds(510, 700, 250, 40);
  back2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  back2.setBackground(Color.GRAY);
  back2.setForeground(Color.WHITE);
  back2.setVisible(false);
  
  back3 = new JButton("BACK");
  back3.addActionListener(this);
  back3.setBounds(510, 700, 250, 40);
  back3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
  back3.setBackground(Color.GRAY);
  back3.setForeground(Color.WHITE);
  back3.setVisible(false);
  
  
  lb.add(a1);
  lb.add(a2);
  lb.add(a3);
  lb.add(a4);
  lb.add(a5);
  lb.add(a6);
  lb.add(a7);
  lb.add(a8);
  lb.add(a9);
  lb.add(a10);
  lb.add(b1);
  lb.add(b2);
  lb.add(b3);
  lb.add(b4);
  lb.add(b5);
  lb.add(b6);
  lb.add(god1);
  lb.add(god2);
  lb.add(god3);
  lb.add(god4);
  lb.add(back);
  lb.add(back2);
  lb.add(back3);
  lb.add(title);
  this.add(lb);
  
	//String txt = textArea.getText();
	//Textlength = txt.length();
	
	
	t = new Timer(1, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			i++;
			if(i < Textlength + 1) {
				//textArea.setText(txt.substring(0,i));
				}
			}
		});
  t.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
	 if(e.getSource() == back) {
		 Bsound.Sound(click);
		 
		 this.setVisible(false);
		 MenuInterface.f.setVisible(true);
					
	 } else if (e.getSource() == b1) {
		 Bsound.Sound(click);
		 
		 b1.setVisible(false);
		 b2.setVisible(false);
		 b3.setVisible(false);
		 b4.setVisible(false);
		 b5.setVisible(false);
		 b6.setVisible(false);
		 a1.setVisible(true);
		 back.setVisible(false);
		 back2.setVisible(true);
		 title.setVisible(false);
     
	 } else if (e.getSource() == b2) {
		 Bsound.Sound(click);
		 b1.setVisible(false);
		 b2.setVisible(false);
		 b3.setVisible(false);
		 b4.setVisible(false);
		 b5.setVisible(false);
		 b6.setVisible(false);
		 a2.setVisible(true);
		 back.setVisible(false);
		 back2.setVisible(true);
		 title.setVisible(false);
 
	 } else if (e.getSource() == b3) {
		 Bsound.Sound(click);
		 b1.setVisible(false);
		 b2.setVisible(false);
		 b3.setVisible(false);
		 b4.setVisible(false);
		 b5.setVisible(false);
		 b6.setVisible(false);
		 a3.setVisible(true);
		 back.setVisible(false);
		 back2.setVisible(true);
		 title.setVisible(false);
 
	 } else if (e.getSource() == b4) {
		 Bsound.Sound(click);
	    b1.setVisible(false);
	    b2.setVisible(false);
	    b3.setVisible(false);
	    b4.setVisible(false);
	    b5.setVisible(false);
	    b6.setVisible(false);
	    a4.setVisible(true);
	    back.setVisible(false);
	    back2.setVisible(true);
	    title.setVisible(false);

	 } else if (e.getSource() == b5) {
		 Bsound.Sound(click);
	    b1.setVisible(false);
	    b2.setVisible(false);
	    b3.setVisible(false);
	    b4.setVisible(false);
	    b5.setVisible(false);
	    b6.setVisible(false);
	    a5.setVisible(true);
	    back.setVisible(false);
	    back2.setVisible(true);
     	title.setVisible(false);
     	god1.setVisible(true);
     	god2.setVisible(true);
     	god3.setVisible(true);
     	god4.setVisible(true);


	 }else if (e.getSource() == b6) {
		 Bsound.Sound(click);
		 b1.setVisible(false);
		 b2.setVisible(false);
		 b3.setVisible(false);
		 b4.setVisible(false);
		 b5.setVisible(false);
		 b6.setVisible(false);
		 a6.setVisible(true);
		 back.setVisible(false);
		 back2.setVisible(true);
		 title.setVisible(false);
	 
	 } else if (e.getSource() == god1) {
		 Bsound.Sound(click);
		 a5.setVisible(false);
		 a7.setVisible(true);
		 back3.setVisible(true);
		 god1.setVisible(false);
	     god2.setVisible(false);
	     god3.setVisible(false);
	     god4.setVisible(false);
	     back2.setVisible(false);
	     back3.setVisible(true);


	 } else if (e.getSource() == god2) {
		 Bsound.Sound(click);
		 a5.setVisible(false);
		 a8.setVisible(true);
		 back3.setVisible(true);
		 god1.setVisible(false);
	     god2.setVisible(false);
	     god3.setVisible(false);
	     god4.setVisible(false);
	     back2.setVisible(false);
	     back3.setVisible(true);


	 } else if (e.getSource() == god3) {
		 Bsound.Sound(click);
	     a5.setVisible(false);
	     a9.setVisible(true);
	     back3.setVisible(true);
	     god1.setVisible(false);
	     god2.setVisible(false);
	     god3.setVisible(false);
	     god4.setVisible(false);
	     back2.setVisible(false);
	     back3.setVisible(true);

	 } else if (e.getSource() == god4) {
		 Bsound.Sound(click);
		 a5.setVisible(false);
		 a10.setVisible(true);
		 back3.setVisible(true);
		 god1.setVisible(false);
	     god2.setVisible(false);
	     god3.setVisible(false);
	     god4.setVisible(false);
	     back2.setVisible(false);
	     back3.setVisible(true);

		 
	 } else if (e.getSource() == back2) {
		 Bsound.Sound(click);
		 b1.setVisible(true);
		 b2.setVisible(true);
		 b3.setVisible(true);
		 b4.setVisible(true);
		 b5.setVisible(true);
		 b6.setVisible(true);
		 a1.setVisible(false);
		 a2.setVisible(false);
		 a3.setVisible(false);
		 a4.setVisible(false);
		 a5.setVisible(false);
		 a6.setVisible(false);
		 god1.setVisible(false);
	     god2.setVisible(false);
	     god3.setVisible(false);
	     god4.setVisible(false);
		 back2.setVisible(false);
		 back.setVisible(true);
		 title.setVisible(true);
		 
	 } else if (e.getSource() == back3) {
		 Bsound.Sound(click);
		 back3.setVisible(false);
		 a5.setVisible(true);
		 a7.setVisible(false);
		 a8.setVisible(false);
		 a9.setVisible(false);
		 a10.setVisible(false);
		 god1.setVisible(true);
	     god2.setVisible(true);
	     god3.setVisible(true);
	     god4.setVisible(true);
	     back2.setVisible(true);
		 
	 }
	
  } 
}
