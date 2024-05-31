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

    @Override
    public String toString() {
        return number + " of " + cardtype;
    }
}
