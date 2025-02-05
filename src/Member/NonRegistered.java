package Member;

import java.util.Scanner;

public class NonRegistered extends Member {
    Scanner sc=new Scanner(System.in);

    public NonRegistered(){}

    public void PrintNotification(){
        System.out.println("-------------------------------------------");
        System.out.println("   당신은 임시 회원입니다.");
    }

    public void ChargingError() {
        System.out.println("   임시 회원은 회원권을 충전할 수 없습니다.");
    }

    public void Charge(int price){
        System.out.println("   가격을 지불하세요.     " + price+"크레딧");
        System.out.println("   (1원은 1크레딧입니다.)");
        int input=sc.nextInt();
        if(input<0){
            System.out.println("   잘못된 입력입니다.");
            this.Charge(price);
        }
        else if(input < price){
            System.out.println("   돈이 더 필요합니다! ");
            this.Charge(price-input);
        }
    }

}
