package main;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[10]; //change size as more sound files are used

    public Sound(){
        soundURL[0] = getClass().getResource("../../res/sounds/temp_song.wav");
        soundURL[1] = getClass().getResource("../../res/sounds/temp_effect.wav");
    }

    public void setSound(int i){
        try {
            AudioInputStream AIS = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(AIS);
        } catch (Exception e) {
        }
    }

    public void playSound(){
        clip.start();
    }

    public void loopSound(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopSound(){
        clip.stop();
    }
    
}
