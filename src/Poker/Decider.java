package Poker;

import java.util.*;

public class Decider {
    public final List<CardType> combo;
    Decider(List<CardType> combo) {
        this.combo = combo;
    }


    public static boolean pair(List<Card> listDealer, List<Card> listplayer){
        Combos val = null;
        Map<Integer,Integer> pair = new HashMap<>();
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card card : allCards) {
            pair.merge(card.cardvalue, 1, Integer::sum);
        }
        Optional<Map.Entry<Integer, Integer>> first = pair.entrySet().stream().filter(x -> x.getValue() == 2).findFirst();
        if (first.isPresent()) {
            Map.Entry<Integer,Integer> entry = first.get();
            for (Card card : listplayer) {
                if(card.cardtype.equals(entry.getKey())){
                    return true;
                }
            }
        }


        return false;
    }
    public static boolean twoPairs(List<Card> listDealer, List<Card> listplayer){
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
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean threes(List<Card> listDealer, List<Card> listplayer){
        Set<Card> three = new HashSet<>();

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
                return true;
            }
        }
        return false;
    }

    public static boolean flash(List<Card> listDealer, List<Card> listplayer){
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
                    return true;

                }
            }
        }
        return false;
    }

    public static boolean street(List<Card> listDealer, List<Card> listplayer){
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
            return true;
        }


        return false;
    }
    public static boolean fullHouse(List<Card> listDealer, List<Card> listplayer){
        Boolean threes = threes(listDealer,listplayer);;
        Boolean pair = pair(listDealer,listplayer);;
        if(pair && threes){
            return true;
        }
        return false;
    }
    public static boolean quads(List<Card> listDealer, List<Card> listplayer){
        Map<Integer,Integer> pair = new HashMap<>();
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card card : allCards) {
            pair.merge(card.cardvalue, 1, Integer::sum);
        }
        Optional<Map.Entry<Integer, Integer>> first = pair.entrySet().stream().filter(x -> x.getValue() == 4).findFirst();
        if (first.isPresent()) {
            Map.Entry<Integer,Integer> entry = first.get();
            for (Card card : listplayer) {
                if(card.cardtype.equals(entry.getKey())){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean streetFLash(List<Card> listDealer, List<Card> listplayer){
        Boolean Flash = flash(listDealer,listplayer);;
        Boolean Street = street(listDealer,listplayer);;
        if(Flash && Street){
            return true;
        }
        return false;
    }
}
