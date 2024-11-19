import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Importa_Audio extends File 
{
	private String s;
	private Clip audio_clip;
	
	Importa_Audio(String s)
	{
		super(s);
		
		try
		{
			 audio_clip = AudioSystem.getClip();
			audio_clip.open(AudioSystem.getAudioInputStream(this));
		}
		catch (Exception e) {}
		
		
		
	}
	
	 void PlaySound()
	{
		
			
			audio_clip.start();
		
			
			
			
		
	}
	
	 void StopSound()
	{
		
			audio_clip.close();
			audio_clip.stop();
		
	}
	 
	void RepeatInALoopSound()
	{
		audio_clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
