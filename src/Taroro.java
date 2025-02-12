import Menu.Menu;
import Member.Member;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Taroro {
    static WelcomeView welcomeView;
    static Menu menu;
    static Member customer;
    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        welcomeView = new WelcomeView();
        welcomeView.PrintWelcome();
        if(welcomeView.isAskMemberInfo()){
            customer = welcomeView.Login();
        }
        else{
            customer=welcomeView.NonLogin();
        }
        menu = new Menu(customer, welcomeView.getMusicPlay());
        menu.GoTo();
        welcomeView.Logout();
    }
}