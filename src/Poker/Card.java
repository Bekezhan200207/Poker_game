package Poker;

public class Card {
    public String number;

    public CardType cardtype;
    public Integer cardvalue;

    public Card(String number, CardType cardtype, Integer cardvalue) {
        this.number = number;
        this.cardtype = cardtype;
        this.cardvalue = cardvalue;
    }

    public Integer getCardvalue() {
        return cardvalue;
    }

    public void setCardvalue(Integer cardvalue) {
        this.cardvalue = cardvalue;
    }

    public String getNumber() {
        return number;
    }

    public CardType getCardtype() {
        return cardtype;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCardtype(CardType cardtype) {
        this.cardtype = cardtype;
    }

    @Override
    public String toString() {
        return number + " of " + cardtype;
    }
}
