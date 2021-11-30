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
		   Clip c = AudioSystem.getClip();
		   c.open(inputStream);
		   while(true){
			   c.start();
			   c.loop(c.LOOP_CONTINUOUSLY);
		   }
	   }
}


