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
//        while(menu.PrintMenu()!=4){
//            menu.GoTo();
//        }
        welcomeView.Logout();
    }
}