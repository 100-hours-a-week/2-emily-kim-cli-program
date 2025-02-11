import Menu.Menu;
import Member.Member;

import java.io.FileNotFoundException;

public class Taroro {
    static WelcomeView welcomeView;
    static Menu menu;
    static Member customer;
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        welcomeView = new WelcomeView();
        welcomeView.PrintWelcome();
        if(welcomeView.AskMemberInfo()){
            customer = welcomeView.Login();
            menu = new Menu(customer);
        }
        else{
            menu = new Menu();
        }
        menu.GoTo();
        welcomeView.Logout();
    }
}