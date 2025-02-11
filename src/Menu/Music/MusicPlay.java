package Menu.Music;

import Menu.Menu;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MusicPlay extends Menu {

    Music music;
    public MusicPlay() {
        try {
            music = new Music("TaroroMainTheme");
            music.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int WelcomeMusicPlay(){
        System.out.println("-------------------------------------------");
        System.out.println(" *.!  운이 들어오는 배경 음악을 설정하세요  ..*! ");
        System.out.println("           * ~.\"  *'~  *.' -.*            ");
        System.out.println();
        System.out.println("*'~  1. 기본 배경 음악");
        System.out.println("*'~  2. 건강운이 들어오는 음악");
        System.out.println("*'~  3. 애정운이 들어오는 음악");
        System.out.println("*'~  4. 재물운이 들어오는 음악");
        System.out.println("*'~  5. 나가기");
        return this.PickNum(1,5);
    }

    public void GoTo() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        while(true){
            switch (this.WelcomeMusicPlay()){
                case 1:
                    System.out.println("-------------------------------------------");
                    System.out.println("   기본 배경 음악을 플레이합니다.               ");
                    ChangeMusic("TaroroMainTheme");
                    break;
                case 2:
                    System.out.println("-------------------------------------------");
                    System.out.println("   건강운이 들어오는 음악을 플레이합니다.         ");
                    ChangeMusic("TaroroHealth");
                    break;
                case 3:
                    System.out.println("-------------------------------------------");
                    System.out.println("   애정운이 들어오는 음악을 플레이합니다.         ");
                    ChangeMusic("TaroroLove");
                    break;
                case 4:
                    System.out.println("-------------------------------------------");
                    System.out.println("   재물운이 들어오는 음악을 플레이합니다.         ");
                    ChangeMusic("TaroroWealth");
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    public void ChangeMusic(String musicTitle) {
        music.interrupt();

        try {
            music = new Music(musicTitle);
            music.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void MusicStop(){
        music.interrupt();
    }
}
