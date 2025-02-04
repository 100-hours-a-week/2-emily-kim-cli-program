package CardDeck;

public class Card {
    int num;
    String cardNameKor;
    String cardNameEng;
    String cardText;
    String luckyCharm;

    public Card(){}

    public Card(int num, String cardNameKor, String cardNameEng, String cardText, String luckyCharm){
        this.num=num;
        this.cardNameKor=cardNameKor;
        this.cardNameEng=cardNameEng;
        this.cardText=cardText;
        this.luckyCharm=luckyCharm;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCardNameKor() {
        return cardNameKor;
    }

    public void setCardNameKor(String cardNameKor) {
        this.cardNameKor = cardNameKor;
    }

    public String getCardNameEng() {
        return cardNameEng;
    }

    public void setCardNameEng(String cardNameEng) {
        this.cardNameEng = cardNameEng;
    }

    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    public String getLuckyCharm() {
        return luckyCharm;
    }

    public void setLuckyCharm(String luckyCharm) {
        this.luckyCharm = luckyCharm;
    }
}
