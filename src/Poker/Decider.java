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

    public Combos Pair(List<Card> listDealer, List<Card> listplayer){
        Combos val = null;
        List<Integer> pair = new ArrayList<>();
        Set<Integer> nums = new HashSet<>();
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card allCard : allCards) {
            nums.add(allCard.cardvalue);
            pair.add(allCard.cardvalue);
        }
        for (Integer num : nums) {
            if(pair.stream().filter(x -> pair.count(x) == 2)){ // я хочу посчитать количество значений "Х" в "PAIR" но не выходит
                val = Combos.Pair;
                break;
            }
        }
        return val;

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

    public Combos Flash(List<Card> listDealer, List<Card> listplayer){
        Combos val;
        List<Card> allCards = new ArrayList<>();
        Map<CardType, Integer> Flashcombo = new HashMap<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card allCard : allCards) {
            Flashcombo.merge(allCard.cardtype, 1, Integer::sum);
        }
        Optional<Map.Entry<CardType, Integer>> any = Flashcombo.entrySet().stream().filter(x -> x.getValue() == 4).findFirst();
        if (any.isPresent()){
            Map.Entry<CardType, Integer> entry = any.get();
            for (Card card : listplayer) {
                if(card.cardtype.equals(entry.getKey())){
                    val = Combos.Flash;

                }
            }
        }
        return val;
    }

    public void Street(List<Card> listDealer, List<Card> listplayer){
        Combos val;
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);

    }
}
