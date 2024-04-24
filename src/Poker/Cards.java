package Poker;

import java.util.Collections;
import java.util.Stack;

public class Cards {



    Stack<Card> cardStack= new Stack<>();
    public void stackCards(){
        String[] cardsVal = {"2", "3", "4", "5", "6", "7", "8" ,"9", "10", "Jack", "Queen", "King","Ace"};
        Integer[] intValue = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        CardType[] values = CardType.values();
        for (String s : cardsVal) {
            for (CardType value : values) {
                for (Integer i : intValue) {
                    cardStack.push(new Card(s, value, i));
                }
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cardStack);
    }

    public Card takeCard(){
        return cardStack.pop();
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cardStack=" + cardStack +
                '}';
    }
}