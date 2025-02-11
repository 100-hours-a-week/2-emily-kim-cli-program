import Menu.Menu;
import Member.Member;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
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
            menu = new Menu(customer, welcomeView.getMusicPlay());
        }
        else{
            menu = new Menu(welcomeView.getMusicPlay());
        }
        menu.GoTo();
        welcomeView.Logout();
    }
}