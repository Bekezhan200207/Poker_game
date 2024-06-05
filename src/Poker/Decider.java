package Poker;

import java.util.*;

public class Decider {
    public final List<CardType> combo;
    Decider(List<CardType> combo) {
        this.combo = combo;
    }


    public static boolean pair(List<Card> listDealer, List<Card> listplayer){
        Map<Integer,Integer> pair = new HashMap<>();
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card card : allCards) {
            pair.merge(card.cardvalue, 1, Integer::sum);
        }
        long counter = pair.values().stream().filter(x -> x == 2).count();
        return counter == 1;

    }
    public static boolean twoPairs(List<Card> listDealer, List<Card> listplayer){
        Map<Integer,Integer> twoPairs = new HashMap<>();
        List<Card> allCards = new ArrayList<>();
        List<Integer> keyList = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card card : allCards) {
            twoPairs.merge(card.cardvalue, 1, Integer::sum);
        }
        long counter = twoPairs.values().stream().filter(x -> x == 2).count();
        for (Map.Entry<Integer, Integer> e : twoPairs.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            if(value == 1){
                keyList.add(key);
            }
        }

        return counter == 2 ;
    }

    public static boolean threes(List<Card> listDealer, List<Card> listplayer){
        Set<Card> three = new HashSet<>();
        if (listplayer.get(0).cardvalue == listplayer.get(1).cardvalue){
            three.add(listplayer.get(0));
            three.add(listplayer.get(1));
            for (Card card1 : listDealer) {
                if(listplayer.get(0).cardvalue.equals(card1.cardvalue)){
                    three.add(card1);
                }
            }
        }
        else {
            for (Card card : listplayer) {
                three.add(card);
                for (Card card1 : listDealer) {
                    if (card.cardvalue.equals(card1.cardvalue)) {
                        three.add(card1);
                    }
                }
                if(three.size() != 3){
                    three.clear();
                }
            }

        }
        if (three.size() == 3){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean flash(List<Card> listDealer, List<Card> listplayer){
        List<Card> allCards = new ArrayList<>();
        Map<CardType, Integer> Flashcombo = new HashMap<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card allCard : allCards) {
            Flashcombo.merge(allCard.cardtype, 1, Integer::sum);
        }
        long counter = Flashcombo.values().stream().filter(x -> x == 5).count();
        Optional<Map.Entry<CardType, Integer>> first = Flashcombo.entrySet().stream().filter(x -> x.getValue() == 5).findFirst();
        if(counter == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean street(List<Card> listDealer, List<Card> listplayer){
        List<Card> allCards = new ArrayList<>();
        List<Integer> street = new ArrayList<>();
        List<Integer> exsess = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card allCard : allCards) {
            street.add(allCard.cardvalue);
        }
        street.sort(Comparator.naturalOrder());
        int counter = 2;
        for (int i = 0; i < street.size() - 1; i++) {
           if(street.get(i) == street.get(i + 1)){
               exsess.add(street.get(i));
           }
        }
        for (int i = exsess.size() - 1; i >= 0; i--) {
            street.remove(exsess.get(i));
        }
        for (int i = 0; i < street.size() - 1; i++) {
            if(street.get(i) == street.get(i + 1) - 1){

                counter++;
            } else if (counter == 6) {
                break;
            }
            else{
                counter = 2;
            }
        }
        return counter >= 5;
    }
    public static boolean fullHouse(List<Card> listDealer, List<Card> listplayer){
        Boolean threes = threes(listDealer,listplayer);
        Boolean pair = pair(listDealer,listplayer);
        return pair && threes;
    }
    public static boolean quads(List<Card> listDealer, List<Card> listplayer){
        Map<Integer,Integer> quads = new HashMap<>();
        List<Card> allCards = new ArrayList<>();
        List<Integer> keyList = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card card : allCards) {
            quads.merge(card.cardvalue, 1, Integer::sum);
        }
        long counter = quads.values().stream().filter(x -> x == 4).count();
        for (Map.Entry<Integer, Integer> e : quads.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            if(value == 1){
                keyList.add(key);
            }
        }

        return counter == 1;
    }

    public static boolean streetFLash(List<Card> listDealer, List<Card> listplayer){
        Boolean Flash = flash(listDealer,listplayer);
        Boolean Street = street(listDealer,listplayer);
        return Flash && Street;
    }
}
