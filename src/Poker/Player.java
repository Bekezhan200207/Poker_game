package Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    public List<Card> dealtCards = new ArrayList<>();

    public String name;

    public Player(String name) {
        this.name = name;
    }

    public List getDealtCards() {
        return dealtCards;
    }

    public String getName() {
        return name;
    }

    public void setDealtCards(List dealtCards) {
        this.dealtCards = dealtCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeCard(Card card){
        this.dealtCards.add(card);
    }

    @Override
    public String toString() {
        return name + " have " + dealtCards.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" and " ));
    }
}
