import Menu.Login;
import Member.Member;
import Menu.Music.MusicPlay;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class WelcomeView {
    Login login;
    MusicPlay musicPlay;

    public WelcomeView() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        login = new Login();
        musicPlay = new MusicPlay();
    }

    public void PrintWelcome(){
        System.out.println("-------------------------------------------");
        System.out.println("* ~.\"  *'~  *.'  -.* * ~.\"  *'~  *.'_ -.*");
        System.out.println(
                " _____                                  \n" +
                "|_   _|  __ _  _ __   ___   _ __   ___  \n" +
                "  | |   / _` || '__| / _ \\ | '__| / _ \\ \n" +
                "  | |  | (_| || |   | (_) || |   | (_) |\n" +
                "  \\_/   \\__,_||_|    \\___/ |_|    \\___/ \n");
        System.out.println("* ~.\"  *'~  *.'  -.* * ~.\"  *'~  *.'_ -.*");
        System.out.println("        *.! Welcome to Taroro ..*!         ");
        System.out.println("          * ~.\"  *'~  *.'  -.*            ");
        System.out.println("-------------------------------------------");
    }

    public MusicPlay getMusicPlay() {
        return musicPlay;
    }

    public boolean isAskMemberInfo() {
        return login.isAskMemberInfo();
    }
    public Member Login(){
        login.AskPersonalInfo();
        return login.getCustomer();
    }
    public Member NonLogin(){
        return login.getCustomer();
    }
    public void Logout(){
        login.Logout();
        musicPlay.MusicStop();
    }

}
