package Menu.Taro;

import CardDeck.CardDeck;

import java.io.FileNotFoundException;
import java.util.Random;

public class TaroLove extends Taro{

    public TaroLove() throws FileNotFoundException {
        this.lucky=12;
        this.price=4000;
        cardDeck=new CardDeck("love");
    }
    public void WelcomeLove() throws InterruptedException, FileNotFoundException {
        System.out.println("-------------------------------------------");
        System.out.println("          * ~.\"  *'~  *.'  -.*            ");
        this.PrepareCard();
        this.PickCard();
        this.CalculateResult();
        this.Loading();
        this.PrintLove();
        System.out.println("          * ~.\"  *'~  *.'  -.*            ");
    }
    public void PrepareCard() throws FileNotFoundException {
        cardDeck=new CardDeck("love");
    }
    public void CalculateResult(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int rand = random.nextInt(12) + 1;
        this.finalCardIdx=(this.cardChoose*rand+lucky)%22;
    }
    public void PrintLove() throws InterruptedException {
        this.PrintMessage();
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getNum());
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getCardNameEng());
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getCardNameKor());
        System.out.println("  * " + cardDeck.getCard(this.finalCardIdx).getCardText());
        System.out.println("  * 오늘의 OOTD는 " + cardDeck.getCard(this.finalCardIdx).getLuckyCharm() + " 어때요?");
        this.WaitABit();
    }

}
