package Menu;

import Member.Member;

import java.util.Scanner;

public class Login extends Menu {
    Scanner sc=new Scanner(System.in);
    Member customer;

    public Login(){
        customer=new Member();
    }

    public Member getCustomer() {
        return customer;
    }

    public void AskPersonalInfo(){
        while(!isAskName()){
            System.out.println("   적절한 이름이 아니에요.ㅠㅜ");
        }
        while(!isAskBirthday()){
            System.out.println("   형식을 지켜주세요.ㅠㅜ");
        }
        customer.setAge();
        while(!isAskEmail()){
            System.out.println("   유효한 이메일 주소가 아니에요.ㅠㅜ");
        }
    }
    public boolean isAskName(){
        System.out.println("   이름을 말해주세요.");
        System.out.print(">>  ");
        String name=sc.next();
        return customer.isSetName(name);
    }
    public boolean isAskBirthday(){
        int birthday;
        System.out.println("   생년월일을 YYYYMMDD 형식으로 말씀해주세요.");
        while(true) {
            System.out.print(">>  ");
            try {
                birthday = sc.nextInt();
                return customer.isSetBirthday(birthday);
            }catch (Exception e){
                System.out.println("   숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
    }
    public boolean isAskEmail(){
        System.out.println("   결과를 전송해드릴 수 있게 이메일을 말씀해주세요.");
        System.out.print(">>  ");
        String email=sc.next();
        return customer.isSetEmail(email);
    }

    public boolean isAskMemberInfo(){
        System.out.println("   타로로의 회원이신가요?(y/n)");
        System.out.print(">>  ");
        String isMember=sc.next();
        switch (isMember){
            case "y":
                this.isAskVisited();
                return true;
            case "n":
                customer.setMemberType("nonregistered");
                customer.PrintNotification();
                return false;
            default:
                System.out.println("   대답은 y, n로 해주세요. 다시 한 번 대답해주세요.");
                return this.isAskMemberInfo();
        }
    }
    public void isAskVisited() {
        System.out.println("   몇 번째 방문이신가요?");
        int visited= this.PickNum(1,Integer.MAX_VALUE);
        if(visited>5){
            customer.setMemberType("vip");
            customer.setVisited(visited);
            customer.PrintNotification();
        }
        else{
            customer.setMemberType("newbie");
            customer.setVisited(visited);
            customer.PrintNotification();
        }
    }


    public void Logout() {
        System.out.println("-------------------------------------------");
        if(!customer.getMemberType().equals("nonregistered")){
            System.out.println("   안녕히 가세요 "+customer.getName()+"님.");
            if(customer.getMemberType().equals("vip")){
                System.out.println("   다음에 또 뵙겠습니다.");
            }
        }
        else{
            System.out.println("   안녕히 가세요.");
        }
        System.out.println("* ~.\"  *'~  *.'  -.* * ~.\"  *'~  *.'_ -.*");
        System.out.println("-------------------------------------------");
    }
}
