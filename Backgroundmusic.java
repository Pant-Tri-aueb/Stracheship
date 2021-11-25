import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Backgroundmusic  {
	   public void sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		   AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("tar.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(inputStream);
	        while(true){
	            clip.start();
	            clip.loop(clip.LOOP_CONTINUOUSLY);
	            }
	        }
}


