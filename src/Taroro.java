import Menu.Menu;
import member.Member;

import java.io.FileNotFoundException;

public class Taroro {
    static WelcomeView welcomeView;
    static Menu menu;
    static Member customer;
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
//        welcomeView = new WelcomeView();
//
//        welcomeView.PrintWelcome();
//        welcomeView.LoginStart();

        menu = new Menu();
        while(menu.PrintMenu()!=4){
            menu.GoTo();
        }
    }
}