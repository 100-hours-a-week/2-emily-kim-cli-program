import member.Login;
import member.Member;

import java.util.Scanner;

public class WelcomeView {
    Scanner sc=new Scanner(System.in);
    Login login;

    public WelcomeView(){
        login = new Login();
    }
    public void PrintWelcome(){
        System.out.println("---------------------------------------");
        System.out.println("      *.! Welcome to Taroro ..*!       ");
        System.out.println("        * ~.\"  *'~  *.'  -.*          ");
        System.out.println();
        System.out.println("---------------------------------------");
    }

    public Boolean AskMemberInfo() {
        return login.AskMemberInfo();
    }
    public Member Login(){
        login.AskPersonalInfo();
        return login.getCustomer();
    }



}
