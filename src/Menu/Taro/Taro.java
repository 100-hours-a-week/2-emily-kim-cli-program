package Menu.Taro;
import CardDeck.CardDeck;
import Menu.Menu;
import Member.Member;
import Member.NonRegistered;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Taro extends Menu {
    Scanner sc=new Scanner(System.in);

    Member customer;
    int taroChoose;
    int lucky;
    int cardChoose;
    int finalCardIdx;
    CardDeck cardDeck;
    int price;

    public Taro(){}
    public Taro(Member customer){
        this.customer=customer;
    }
    public int WelcomeTaro(){
        System.out.println("-------------------------------------------");
        System.out.println("          *.! It's Taro Time..*!           ");
        System.out.println("          * ~.\"  *'~  *.'  -.*            ");
        System.out.println();
        return this.PickTaro();
    }

    public int PickTaro(){
        System.out.println("-------------------------------------------");
        System.out.println("       *.! 원하시는 타로를 골라보세요 ..*!        ");
        System.out.println("*'~  1. 오늘의 타로\t\t\t 2000");
        System.out.println("*'~  2. 건강의 타로\t\t\t 3000");
        System.out.println("*'~  3. 사랑의 타로\t\t\t 4000");
        System.out.println("*'~  4. 나가기");
        System.out.print(">> ");
        int taroChoose=sc.nextInt();
        if(taroChoose<1 || taroChoose>4){
            System.out.println("   잘못된 타로 번호 입니다. 다시 입력해주세요.");
            return this.PickTaro();
        }
        this.taroChoose=taroChoose;

        return taroChoose;
    }
    public void GoTo() throws FileNotFoundException, InterruptedException {
        NonRegistered nonRegistered=new NonRegistered();
        switch (this.taroChoose){
            case 1:
                TaroToday taroToday =new TaroToday();
                if(customer==null){
                    nonRegistered.Charge(taroToday.price);
                }
                else{
                    while(!customer.UpdateBalance(taroToday.price));
                }
                taroToday.WelcomeToday();
                break;
            case 2:
                TaroHealth taroHealth =new TaroHealth();
                if(customer==null){
                    nonRegistered.Charge(taroHealth.price);
                }
                else{
                    while(!customer.UpdateBalance(taroHealth.price));
                }
                taroHealth.WelcomeHealth();
                break;
            case 3:
                TaroLove taroLove =new TaroLove();
                if(customer==null){
                    nonRegistered.Charge(taroLove.price);
                }
                else{
                    while(!customer.UpdateBalance(taroLove.price));
                }
                taroLove.WelcomeLove();
                break;
            case 4:
                System.out.println("안녕히 가세요!");
                break;
            default:
                break;
        }
    }


    public void PickCard(){
        System.out.println("    *.! 0에서 21까지 중 숫자를 골라보세요 ..*!    ");
        System.out.print(">> ");
        int cardChoose=sc.nextInt();
        if(cardChoose<0 || cardChoose>21){
            System.out.println("   잘못된 카드 번호 입니다. 다시 입력해주세요.");
            this.PickCard();
            return;
        }
        this.cardChoose=cardChoose;
    }

    public void PrintMessage(){
        System.out.println("          * ~.\"  *'~  *.'  -.*            ");
        System.out.println("        *.! 당신의 결과를 확인하세요! ..*!       ");
    }
}
