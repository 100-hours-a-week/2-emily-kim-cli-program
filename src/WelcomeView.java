import Member.Login;
import Member.Member;


public class WelcomeView {
    Login login;
    Music music;

    public WelcomeView(){
        login = new Login();
        try {
            music = new Music();
            music.start();
            //music.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        System.out.println("      *.! Welcome to Taroro ..*!       ");
        System.out.println("        * ~.\"  *'~  *.'  -.*          ");
        System.out.println("-------------------------------------------");
    }

    public Boolean AskMemberInfo() {
        return login.AskMemberInfo();
    }
    public Member Login(){
        login.AskPersonalInfo();
        return login.getCustomer();
    }
    public void Logout(){
        login.Logout();
        music.interrupt();
    }

}
