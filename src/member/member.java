package member;

import java.time.LocalDate;
import java.util.Scanner;

public class member{
    public String name;
    public int age;
    String email;
    int birthdayInt;
    LocalDate birthday=setBirthday(birthdayInt);

    public void setBirthday(){
        System.out.println("Enter your birthday in YYMMDD format: ");
        Scanner sc=new Scanner(System.in);

        sc.nextInt();

        //형식 잘못됨 오류 로직 추가
    }

    public LocalDate setBirthday(int birthdayInt){
        int year=birthdayInt/10000;
        int month=(birthdayInt/100)%100;
        int day=birthdayInt%100;

        return LocalDate.of(year,month,day);
    }


}
