import java.util.Scanner;

public class WelcomeView {
    Scanner sc=new Scanner(System.in);
    Login login;

    public WelcomeView(){}
    public void PrintWelcome(){
        System.out.println("---------------------------------------");
        System.out.println("      *.! Welcome to Taroro ..*!       ");
        System.out.println("        * ~.\"  *'~  *.'  -.*          ");
        System.out.println();
        System.out.println("---------------------------------------");
    }

    public void LoginStart(){
        login = new Login();
        login.AskPersonalInfo();
        login.AskMemberInfo();

    }



}
