package Member;

import Menu.ChargeCredit.ChargeCredit;

import java.time.LocalDate;
import java.util.Scanner;

public class Member {
    String name;
    String email;
    LocalDate birthday;
    int age;
    int balance;
    int visited;
    String memberType;
    Scanner sc=new Scanner(System.in);

    //생성자
    public Member(){}

    //getter, setter
    public String getName(){
        return this.name;
    }
    public boolean isSetName(String name) {
        this.name = name;
        return true;
    }

    public boolean isSetEmail(String email) {
        if(!email.contains("@") || !email.contains(".com")){
            return false;
        }
        this.email = email;
        return true;
    }

    public boolean isSetBirthday(int birthdayInt) {
        LocalDate today = LocalDate.now();
        int year = birthdayInt / 10000;
        int month = (birthdayInt / 100) % 100;
        int date = birthdayInt % 100;

        if (!isValidDate(year, month, date, today)) {
            return false;
        }

        this.birthday = LocalDate.of(year, month, date);
        return true;
    }

    private boolean isValidDate(int year, int month, int date, LocalDate today) {
        if (year > today.getYear() || year < 1900) {
            return false;
        }
        if (month > 12 || month < 1) {
            return false;
        }
        if (date > 31 || date < 1) {
            return false;
        }
        if (year == today.getYear()) {
            if (month > today.getMonthValue()) {
                return false;
            } else if (month == today.getMonthValue()) {
                if (date > today.getDayOfMonth()) {
                    return false;
                }
            }
        }
        return true;
    }
    public int getYear(){
        return this.birthday.getYear();
    }
    public int getMonth(){
        return this.birthday.getMonthValue();
    }
    public int getDate(){
        return this.birthday.getDayOfMonth();
    }

    public void setAge() {
        LocalDate today=LocalDate.now();
        int age;
        age=today.getYear()-this.getYear()+1;

        if(today.getMonthValue()<this.getMonth()){
            age=age-1;
        }
        else if(today.getMonthValue()==this.getMonth()){
            if(today.getDayOfMonth()<this.getDate()){
                age=age-1;
            }
        }
        this.age=age;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isUpdateBalance(int price){
        if(this.balance>=price){
            this.balance -= price;
            System.out.println("-------------------------------------------");
            System.out.println("   회원권 잔액은 " + this.balance +"크레딧 입니다.");
            return true;
        }
        else {
            System.out.println("   회원권 금액이 부족합니다. 회원권을 충전하세요");
            ChargeCredit chargeCredit=new ChargeCredit(this);
            chargeCredit.Charge();
            return false;
        }
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    public String getMemberType() {
        return this.memberType;
    }

    public void PrintNotification(){
        System.out.println("-------------------------------------------");
        switch(this.getMemberType()){
            case "vip":
                System.out.println("* ~.\"  *'~  *.'  -.* * ~.\"  *'~  *.'_ -.*");
                System.out.println("   당신은 VIP 회원입니다!!");
                System.out.println("   오늘도 방문해 주셔서 감사합니다.");
                System.out.println("   웰컴백 바우처 2000 크레딧이 제공됩니다.");
                System.out.println("* ~.\"  *'~  *.'  -.* * ~.\"  *'~  *.'_ -.*");
                this.setBalance(2000);
                break;
            case "newbie":
                System.out.println("   당신은 뉴비 회원입니다!");
                break;
            case "nonregistered":
                System.out.println("   당신은 임시 회원입니다.");
                break;
            default:
                System.out.println("   당신 누구야....?");
                break;
        }
    }

    //비회원 목록
    public void ChargingError() {
        if(getMemberType().equals("nonregistered")) {
            System.out.println("   임시 회원은 회원권을 충전할 수 없습니다.");
        }
    }

    public void Pay(int price){
        if(getMemberType().equals("nonregistered")) {
            System.out.println("   가격을 지불하세요.     " + price + "크레딧");
            System.out.println("   (1원은 1크레딧입니다.)");
            while(true) {
                System.out.print(">>  ");
                try {
                    int input = sc.nextInt();
                    if (input < 0) {
                        System.out.println("   잘못된 입력입니다.");
                        this.Pay(price);
                        return;
                    } else if (input > price) {
                        System.out.println("   거스름돈을 받으세요.\t" + (input - price) + "원");
                        return;
                    } else if (input < price) {
                        System.out.println("   돈이 더 필요합니다! ");
                        this.Pay(price - input);
                        return;
                    }
                    else{
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("   숫자를 입력해주세요.");
                    sc.nextLine();
                }
            }
        }
    }
}
