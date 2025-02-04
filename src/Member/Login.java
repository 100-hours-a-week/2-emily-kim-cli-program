package Member;

import java.util.Scanner;

public class Login {
    Scanner sc=new Scanner(System.in);
    Member customer;

    public Login(){
        customer=new Member();
    }

    public Member getCustomer() {
        return customer;
    }

    public void AskPersonalInfo(){
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
        System.out.println("   이름을 말해주세요.");
        System.out.print(">>  ");
        String name=sc.next();
        return customer.setName(name);
    }
    public boolean AskBirthday(){
        System.out.println("   생년월일을 YYYYMMDD 형식으로 말씀해주세요.");
        System.out.print(">>  ");
        int birthday=sc.nextInt();
        return customer.setBirthday(birthday);
    }
    public boolean AskEmail(){
        System.out.println("   결과를 전송해드릴 수 있게 이메일을 말씀해주세요.");
        System.out.print(">>  ");
        String email=sc.next();
        return customer.setEmail(email);
    }

    public boolean AskMemberInfo(){
        System.out.println("   타로로의 회원이신가요?(y/n)");
        System.out.print(">>  ");
        String isMember=sc.next();
        switch (isMember){
            case "y":
                this.AskVisited();
                return true;
            case "n":
                NonRegistered nonRegistered=new NonRegistered();
                customer.setType("nonregistered");
               nonRegistered.PrintNotification();
                return false;
            default:
                System.out.println("   대답은 y, n로 해주세요. 다시 한 번 대답해주세요.");
                return this.AskMemberInfo();
        }
    }
    public void AskVisited() {
        System.out.println("   몇 번째 방문이신가요?");
        System.out.print(">>  ");
        int visited= sc.nextInt();
        if(visited < 1){
            System.out.println("   방문 횟수는 1 이상이어야 합니다.");
            this.AskVisited();
        }
        else if(visited>5){
            customer.setType("vip");
            customer.setVisited(visited);
            Vip vip=new Vip();
            vip.PrintNotification();
            customer.setBalance(vip.getBalance());
        }
        else{
            customer.setType("newbie");
            customer.setVisited(visited);
            Newbie newbie=new Newbie();
            newbie.PrintNotification();
        }
    }
}
