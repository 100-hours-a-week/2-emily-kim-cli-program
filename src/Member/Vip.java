package Member;

public class Vip extends Member{
    public Vip(){}

    public void PrintNotification(){
        System.out.println("-------------------------------------------");
        System.out.println("* ~.\"  *'~  *.'  -.* * ~.\"  *'~  *.'_ -.*");
        System.out.println("   당신은 VIP 회원입니다!!");
        System.out.println("   오늘도 방문해 주셔서 감사합니다.");
        System.out.println("   웰컴백 바우처 2000 크레딧이 제공됩니다.");
        System.out.println("* ~.\"  *'~  *.'  -.* * ~.\"  *'~  *.'_ -.*");
        this.setBalance(2000);
    }

}
