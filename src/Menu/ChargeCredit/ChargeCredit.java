package Menu.ChargeCredit;

import Member.Member;
import Menu.Menu;

import java.util.Scanner;

public class ChargeCredit extends Menu {
    Scanner sc=new Scanner(System.in);

    Member customer;
    public ChargeCredit(Member customer){
        this.customer=customer;
    }

    public int WelcomeChargeCredit(){
        System.out.println("-------------------------------------------");
        System.out.println("       *.!  회원권 충전페이지 입니다  ..*!        ");
        System.out.println("              (1크레딧 = 1원)                 ");
        System.out.println("           * ~.\"  *'~  *.' -.*            ");
        System.out.println();
        System.out.println("*'~  1. 회원권 충전");
        System.out.println("*'~  2. 회원권 금액 조회");
        System.out.println("*'~  3. 나가기");

        return this.PickNum(1,3);
    }

    public void GoTo(){
        while(true) {
            switch (this.WelcomeChargeCredit()) {
                case 1:
                    this.Charge();
                    break;
                case 2:
                    this.ViewBalance();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }

    public void Charge(){
        int input;
        System.out.println("   얼마를 충전할까요?");
        while(true){
            System.out.print(">>  ");
            try{
                input=sc.nextInt();
                if(input>0)
                    break;
                System.out.println("   충전 금액은 양수이어야 합니다.");
            } catch (Exception e) {
                System.out.println("   숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
        customer.isUpdateBalance(input*(-1));
    }
    public void ViewBalance(){
        System.out.println("-------------------------------------------");
        System.out.println("   회원권 잔액은 "+customer.getBalance()+"크레딧 입니다.");
    }
}
