package Poker;

import java.util.*;

public class Decider {
    public final List<CardType> combo;
    public String winner;

    Decider(List<CardType> combo, String winner) {
        this.combo = combo;
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }

    public void HighCard(List<Card> pl1_cards, List<Card> pl2_cards){
        Integer val1 = pl1_cards.stream().map(x -> x.cardvalue).max(Comparator.comparing(i -> i)).orElseThrow();
        Integer val2 = pl2_cards.stream().map(x -> x.cardvalue).max(Comparator.comparing(i -> i)).orElseThrow();
        if(val1 == val2){
            winner = "Tie";
        }
        else if (val1 > val2) {
            winner = "player1";
        }
        else{
            winner = "player2";
        }

    }

    public void Pair(List<Card> listDealer, List<Card> listplayer){
        Map<Card, Card> pair = null;
        Combos val;
        for (Card card : listplayer) {
            for (Card card1 : listDealer) {
                if (card.cardvalue.equals(card1.cardvalue)){
                     pair.put(card, card1);
                     val = Combos.Pair;
                     break;
                }
            }
        }
        
    }
    public void twoPairs(List<Card> listDealer, List<Card> listplayer){
        Map<Card, Card> pair1 = null;
        Map<Card, Card> pair2 = null;
        Combos val;
        for (Card card : listplayer) {
            for (Card card1 : listDealer) {
                if (card.cardvalue.equals(card1.cardvalue)){
                    if(pair1 == null) {
                        pair1.put(card, card1);
                    }
                    else{
                        pair1.put(card, card1);
                    }
                    val = Combos.TwoPairs;
                    break;
                }
            }
        }
    }

    public void three(List<Card> listDealer, List<Card> listplayer){
        Set<Card> three = null;
        Combos val;
        for (Card card : listplayer) {
            three.add(card);
            for (Card card1 : listDealer) {
                if(card.cardvalue.equals(card1.cardvalue)){
                    three.add(card1);
                }
            }
            if(three.size() != 3){
                three.clear();
            }
            else{
                val = Combos.Three;
            }
        }
    }

    public void Flash(List<Card> listDealer, List<Card> listplayer){
        Combos val;
        Map<CardType, Card> Flash = null;
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        allCards.stream().sorted(Comparator.comparing(i -> i.cardtype.ordinal())).toList();


    }
}
