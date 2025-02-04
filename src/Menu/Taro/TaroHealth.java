package Menu.Taro;

import CardDeck.CardDeck;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class TaroHealth extends Taro{
    Scanner sc=new Scanner(System.in);

    public TaroHealth() throws FileNotFoundException {
        this.lucky=6;
        cardDeck=new CardDeck("health");
    };
    public void WelcomeHealth() throws InterruptedException, FileNotFoundException {
        System.out.println("---------------------------------------");
        System.out.println("        * ~.\"  *'~  *.'  -.*          ");
        this.PrepareCard();
        this.PickCard();
        this.CalculateResult();
        this.Loading();
        this.PrintHealth();
        System.out.println("        * ~.\"  *'~  *.'  -.*          ");
    }
    public void PrepareCard() throws FileNotFoundException {
        cardDeck=new CardDeck("health");
    }
    public void CalculateResult(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int rand = random.nextInt(10) + 1;
        this.finalCardIdx=(this.cardChoose*rand+lucky)%22;
    }
    public void PrintHealth() throws InterruptedException {
        this.PrintMessage();
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getNum());
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getCardNameEng());
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getCardNameKor());
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getCardText());
        System.out.println("  * 행운의 " + cardDeck.getCard(this.finalCardIdx).getLuckyCharm() + "을 먹어보세요!");
        this.WaitABit();
    }

}
