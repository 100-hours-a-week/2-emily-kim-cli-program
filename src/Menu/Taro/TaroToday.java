package Menu.Taro;

import CardDeck.CardDeck;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TaroToday extends Taro{
    Scanner sc=new Scanner(System.in);

    public TaroToday() throws FileNotFoundException {
        this.lucky=1;
        this.price=2000;
        cardDeck=new CardDeck("today");
    }
    public void WelcomeToday() throws InterruptedException, FileNotFoundException {
        System.out.println("---------------------------------------");
        System.out.println("        * ~.\"  *'~  *.'  -.*          ");
        this.PrepareCard();
        this.PickCard();
        this.CalculateResult();
        this.Loading();
        this.PrintToday();
        System.out.println("        * ~.\"  *'~  *.'  -.*          ");
    }
    public void PrepareCard() throws FileNotFoundException {
        cardDeck=new CardDeck("today");
    }
    public void CalculateResult(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int rand = random.nextInt(10) + 1;
        this.finalCardIdx=(this.cardChoose*rand+lucky)%22;
    }
    public void PrintToday() throws InterruptedException {
        this.PrintMessage();
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getNum());
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getCardNameEng());
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getCardNameKor());
        System.out.println("  * 이 카드는 " + cardDeck.getCard(this.finalCardIdx).getCardText());
        System.out.println("  * 오늘의 행운의 물건은? " + cardDeck.getCard(this.finalCardIdx).getLuckyCharm());
        this.WaitABit();
    }

}
