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
        /*for (Integer num : nums) {
            if(pair.stream().filter(x -> pair.count(x) == 2)){ // я хочу посчитать количество значений "Х" в "PAIR" но не выходит
                val = Combos.Pair;
                break;
            }
        }
        */return val;

    }
    public Combos twoPairs(List<Card> listDealer, List<Card> listplayer){
        Map<Card, Card> pair1 = null;
        Map<Card, Card> pair2 = null;

        for (Card card : listplayer) {
            for (Card card1 : listDealer) {
                if (card.cardvalue.equals(card1.cardvalue)){
                    if(pair1 == null) {
                        pair1.put(card, card1);
                    }
                    else{
                        pair1.put(card, card1);
                    }
                    return Combos.TwoPairs;
                    break;
                }
            }
        }
    }

    public Combos three(List<Card> listDealer, List<Card> listplayer){
        Set<Card> three = null;

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
                return Combos.Three;
            }
        }
    }

    public Combos Flash(List<Card> listDealer, List<Card> listplayer){
        Combos val = null;
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

    public Combos Street(List<Card> listDealer, List<Card> listplayer){
        Combos val;
        List<Card> allCards = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card allCard : allCards) {
            nums.add(allCard.cardvalue);
        }
        nums.sort(Comparator.naturalOrder());
        Integer number = nums.get(0);
        Integer counter = 0;
        for (int i = 1; i < 7; i++) {
            if(nums.get(i) == number + 1){
                number = nums.get(i);
                counter++;
            }
            else{
                counter = 0;
                number = nums.get(i);
            }
        }
        boolean playercard = false;
        for (Card card : listplayer) {
            if(nums.contains(card.cardvalue)){
                playercard = true;
                break;
            }
        }
        if (counter >= 5 && playercard){
            return Combos.Street;
        }



    }
    public Combos FullHouse(List<Card> listDealer, List<Card> listplayer){
        Combos threes = three(listDealer,listplayer);;
        return null;
    }
}
