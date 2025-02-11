package Menu.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music extends Thread{
    File music;
    AudioInputStream musicStream;
    Clip musicClip;

    public Music(String musicTitle) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String title="src/Menu/Music/"+musicTitle+".wav";

        music = new File(title);
        musicStream = AudioSystem.getAudioInputStream(music);
        musicClip = AudioSystem.getClip();
    }

    public void run(){
        try {
            musicClip.open(musicStream);
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();
            while(true){
                //System.out.println("Menu.Music.Menu.Music playing.");
                Thread.sleep(1);
            }

        } catch (LineUnavailableException | IOException | InterruptedException e) {
            musicClip.stop();
            musicClip.close();
           // System.out.println("Menu.Music.Menu.Music stopped.");

            //throw new RuntimeException(e);
        }
       // System.out.println("Menu.Music.Menu.Music thread end.");
    }
}
