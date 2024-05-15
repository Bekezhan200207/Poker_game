package Poker;

import java.util.Collections;
import java.util.Stack;

public class Cards {



    Stack<Card> cardStack= new Stack<>();
    public void stackCards(){
        String[] cardsVal = {"2", "3", "4", "5", "6", "7", "8" ,"9", "10", "Jack", "Queen", "King","Ace"};
        Integer[] intValue = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        CardType[] values = CardType.values();
        for (CardType value : values) {
            for (int i = 0; i < cardsVal.length; i++) {
                Integer num = intValue[i];
                cardStack.push(new Card(cardsVal[i],value,num));
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