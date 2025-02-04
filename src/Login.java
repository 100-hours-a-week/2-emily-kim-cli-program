import member.Member;
import member.Newbie;
import member.Vip;

import java.util.Scanner;

public class Login {
    Scanner sc=new Scanner(System.in);
    public Member customer;
//    Vip mem;
//    Newbie mem;
    public Login(){}

    public void AskPersonalInfo(){
        customer=new Member();

        while(!AskName()){
            System.out.println("   적절한 이름이 아니에요.ㅠㅜ");
        }
        while(!AskBirthday()){
            System.out.println("   형식을 지켜주세요.ㅠㅜ");
        }
        customer.setAge();
        while(!AskEmail()){
            System.out.println("   유효한 이메일 주소가 아니에요.ㅠㅜ");
        }
    }

    public boolean AskName(){
        System.out.println(">> 이름을 말해주세요.");
        String name=sc.next();
        return customer.setName(name);
    }
    public boolean AskBirthday(){
        System.out.println(">> 생년월일을 YYYYMMDD 형식으로 말씀해주세요.");
        int birthday=sc.nextInt();
        return customer.setBirthday(birthday);
    }
    public boolean AskEmail(){
        System.out.println(">> 결과를 전송해드릴 수 있게 이메일을 말씀해주세요.");
        String email=sc.next();
        return customer.setEmail(email);
    }


    public void AskMemberInfo(){
        System.out.println(">> 타로로의 회원이신가요?(y/n)");
        String isMember=sc.next();
        switch (isMember){
            case "y":
                this.AskVisited();
                break;
            case "n":
                String register= this.AskMemberRegister();
                switch(register){
                    case "y":

                }
                break;
            default:
                System.out.println("   대답은 y, n로 해주세요. 다시 한 번 대답해주세요.");
        }
    }
    public void AskVisited() {
        System.out.println(">> 몇 번째 방문이신가요?");
        int visited= sc.nextInt();
        if(visited < 1){
            System.out.println("   방문 횟수는 1 이상이어야 합니다.");
            this.AskVisited();
        }
        else if(visited>5){
            Vip vip = new Vip();
            vip.setVisited(visited);
        }
        else{
            Newbie newbie = new Newbie();
            newbie.setVisited(visited);
        }
    }

    public String AskMemberRegister(){
        System.out.println(">> 타로로 회원 등록을 하시겠습니까?");
        return sc.next();
    }

}
