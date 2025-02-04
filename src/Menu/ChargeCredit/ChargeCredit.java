package Menu.ChargeCredit;

import member.Member;

import java.util.Scanner;

public class ChargeCredit {
    Scanner sc=new Scanner(System.in);

    Member customer;
    int pickNum=0;
    public ChargeCredit(Member customer){
        this.customer=customer;
    }

    public void WelcomeChargeCredit(){
        System.out.println("---------------------------------------");
        System.out.println("     *.!  회원권 충전페이지 입니다  ..*!      ");
        System.out.println("            (1크레딧 = 1원)               ");
        System.out.println("         * ~.\"  *'~  *.' -.*          ");
        System.out.println();
        System.out.println("*'~  1. 회원권 충전");
        System.out.println("*'~  2. 회원권 금액 조회");
        System.out.println("*'~  3. 나가기");
        while(pickNum!=3){
            this.PickNum();
            this.GoTo();
        }

    }

    public void PickNum(){
        System.out.print(">>  ");
        int num=sc.nextInt();
        if(num<1|| num>3) {
            System.out.println("   잘못된 번호 입니다. 다시 입력해주세요.");
            this.PickNum();
            return;
        }
        this.pickNum=num;
    }
    public void GoTo(){
        switch(pickNum){
            case 1:
                this.Charge();
                break;
            case 2:
                this.ViewBalance();
                break;
            default:
                break;
        }
    }

    public void Charge(){
        System.out.println("   얼마를 충전할까요?");
        int input=sc.nextInt();
        while(input<0){
            System.out.println("   충전 금액은 양수이어야 합니다.");
            input=sc.nextInt();
        }
        customer.UpdateBalance(input*(-1));
    }
    public void ViewBalance(){
        System.out.println("   회원권 잔액은 "+customer.getBalance()+"크레딧 입니다.");
    }
}
