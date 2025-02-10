import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music extends Thread{
    File music;
    AudioInputStream musicStream;
    Clip musicClip;
    public Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        music = new File("src/Quiet Nights - Nate Blaze.wav");
        musicStream = AudioSystem.getAudioInputStream(music);
        musicClip = AudioSystem.getClip();
    }

    //지금은 프로그램 종료시 음악 종료 됨
    public void run(){
        try {
            musicClip.open(musicStream);
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();
            while(!musicClip.isActive()){
                System.out.println("\n🎵   🎵");
                //Thread.sleep(1000000);
                //Thread.join();
            }

        } catch (LineUnavailableException | IOException e) {
            musicClip.stop();
            musicClip.close();
            System.out.println("Music stopped.");

//            throw new RuntimeException(e);
        }

//        System.out.println("Music stopped.");
    }
}
