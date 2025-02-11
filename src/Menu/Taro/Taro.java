package Menu.Taro;
import CardDeck.CardDeck;
import Menu.Menu;
import Member.Member;
import Member.NonRegistered;

import java.io.FileNotFoundException;

public class Taro extends Menu {
    Member customer;
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
        System.out.println("-------------------------------------------");
        System.out.println("       *.! 원하시는 타로를 골라보세요 ..*!      ");
        System.out.println("*'~  1. 오늘의 타로\t\t\t 2000");
        System.out.println("*'~  2. 건강의 타로\t\t\t 3000");
        System.out.println("*'~  3. 사랑의 타로\t\t\t 4000");
        System.out.println("*'~  4. 나가기");

        return this.PickNum(1,4);
    }

    public void GoTo() throws FileNotFoundException, InterruptedException {
        NonRegistered nonRegistered=new NonRegistered();
        while(true) {
            switch (this.WelcomeTaro()) {
                case 1:
                    TaroToday taroToday = new TaroToday();
                    if (customer == null) {
                        nonRegistered.Charge(taroToday.price);
                    } else {
                        while (!customer.isUpdateBalance(taroToday.price)) ;
                    }
                    taroToday.WelcomeToday();
                    break;
                case 2:
                    TaroHealth taroHealth = new TaroHealth();
                    if (customer == null) {
                        nonRegistered.Charge(taroHealth.price);
                    } else {
                        while (!customer.isUpdateBalance(taroHealth.price)) ;
                    }
                    taroHealth.WelcomeHealth();
                    break;
                case 3:
                    TaroLove taroLove = new TaroLove();
                    if (customer == null) {
                        nonRegistered.Charge(taroLove.price);
                    } else {
                        while (!customer.isUpdateBalance(taroLove.price)) ;
                    }
                    taroLove.WelcomeLove();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    public void PrintMessage(){
        System.out.println("          * ~.\"  *'~  *.'  -.*            ");
        System.out.println("        *.! 당신의 결과를 확인하세요! ..*!       ");
    }
}
