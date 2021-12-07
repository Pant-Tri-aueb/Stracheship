import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Bsound {
	static void Sound(File sound ) {
		try {
			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(sound));
			c.start();
			Thread.sleep(c.getMicrosecondLength()/1000);
			
		} catch(Exception e)
		{
	}
  }
}
	
