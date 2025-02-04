package CardDeck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class CardDeck {
    Scanner cardSc;

    Card[] card=new Card[22];
    String type;

    public CardDeck(){}
    public CardDeck(String type) throws FileNotFoundException {
        this.type=type;
        switch(type){
            case "today":
                cardSc = new Scanner(new File("src/CardDeck/todaycard.txt"));
                this.TodayCard();
                break;
            case "health":
                cardSc = new Scanner(new File("src/CardDeck/healthcard.txt"));
                this.TodayCard();
                break;
            case "love":
                cardSc = new Scanner(new File("src/CardDeck/lovecard.txt"));
                this.TodayCard();
                break;
            default:
                break;
        }
    }

    public Card getCard(int idx) {
        return card[idx];
    }

    public void setCard(Card[] card) {
        this.card = card;
    }

    public void TodayCard(){
        int idx=0;
        while (cardSc.hasNextLine()){
            String num=cardSc.nextLine();
            String cardNameKor=cardSc.nextLine();
            String cardNameEng=cardSc.nextLine();
            String cardText=cardSc.nextLine();
            String luckyCharm=cardSc.nextLine();
            this.card[idx]=new Card(idx,cardNameKor,cardNameEng, cardText,luckyCharm);
            idx = idx+1;
        }
    }
}
