package stracheship.src.main.java.gr.aueb.dmst.simplesoftware;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Backgroundmusic  {
	  
	 public boolean play = true;
	 public Clip c;
	 	 
	 public void sound(File music) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		   AudioInputStream inputStream = AudioSystem.getAudioInputStream(music);
		   c = AudioSystem.getClip();
		   c.open(inputStream);
		   c.start();
	       c.loop(c.LOOP_CONTINUOUSLY);
		
	   }
	 
		 
}


