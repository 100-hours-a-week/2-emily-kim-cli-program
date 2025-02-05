package Member;

import Menu.ChargeCredit.ChargeCredit;

import java.time.LocalDate;

public class Member {
    String name;
    String email;
    LocalDate birthday;
    int age;
    int balance;
    int visited;
    String type;

    //생성자
    public Member(){}

    //getter, setter
    public String getName(){
        return this.name;
    }
    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public boolean setEmail(String email) {
        if(!email.contains("@") || !email.contains(".com")){
            return false;
        }
        this.email = email;
        return true;
    }

    public boolean setBirthday(int birthdayInt) {
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
    public boolean UpdateBalance(int price){
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
            //회원권 충전 후 축하메세지 출력
            //print congrats meesage after charging credits

            return false;
        }
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
}
