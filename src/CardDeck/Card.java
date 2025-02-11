package CardDeck;

public class Card {
    int num;
    String cardNameKor;
    String cardNameEng;
    String cardText;
    String luckyCharm;

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

    public String getCardNameKor() {
        return cardNameKor;
    }

    public String getCardNameEng() {
        return cardNameEng;
    }

    public String getCardText() {
        return cardText;
    }

    public String getLuckyCharm() {
        return luckyCharm;
    }

    //업데이트 시 사용
//    public void setLuckyCharm(String luckyCharm) {
//        this.luckyCharm = luckyCharm;
//    }
}
