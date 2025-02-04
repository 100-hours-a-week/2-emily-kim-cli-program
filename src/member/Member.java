package member;

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

    public String getEmail(){
        return this.email;
    }
    public boolean setEmail(String email) {
        if(!email.contains("@") || !email.contains(".com")){
            return false;
        }
        this.email = email;
        return true;
    }

    public LocalDate getBirthday(){
        return this.birthday;
    }
    public boolean setBirthday(int birthdayInt) {
        int year=birthdayInt/10000;
        if(year>2025 || year<1900){
            return false;
        }
        int month=(birthdayInt/100)%100;
        if(month>12 || month<1){
            return false;
        }
        int date=birthdayInt%100;
        if(date>31 || date<1){
            return false;
        }
        this.birthday = LocalDate.of(year,month,date);
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

    public int getAge() {
        return this.age;
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
            return false;
        }
    }

    public int getVisited() {
        return visited;
    }
    public void setVisited(int visited) {
        this.visited = visited;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isNonRegistered(){
        return getType().equals("nonregistered");
    }
}
