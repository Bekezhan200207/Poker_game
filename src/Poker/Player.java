package Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    public List<Card> dealtCards = new ArrayList<>();

    public String name;
    public Combos combination;

    public Player(String name) {
        this.name = name;
    }

    public void setCombination(Combos combination) {
        this.combination = combination;
    }

    public List<Card> getDealtCards() {
        return dealtCards;
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
