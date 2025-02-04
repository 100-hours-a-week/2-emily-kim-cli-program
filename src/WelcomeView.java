import member.Login;
import member.Member;


public class WelcomeView {
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
