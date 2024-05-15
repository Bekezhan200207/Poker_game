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
        Boolean present = false;
        for (Card card : allCards) {
            pair.merge(card.cardvalue, 1, Integer::sum);
        }
        long counter = pair.values().stream().filter(x -> x == 2).count();
        boolean active = false;
        for (Card card : listplayer) {
            active = pair.entrySet().stream().filter(x -> x.getValue() == 2).anyMatch(x -> x.getKey().equals(card.cardvalue));
        }

        return counter == 1 && active;

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
        boolean active = false;
        for (Integer i : keyList) {
            twoPairs.remove(i);
        }
        for (Integer i : twoPairs.keySet()) {
            for (Card card : listplayer) {
                if(card.cardvalue.equals(i)) {
                    active = true;
                    break;
                }
            }
        }
        return counter == 2 && active;
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
        List<Card> allCards = new ArrayList<>();
        Map<CardType, Integer> Flashcombo = new HashMap<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card allCard : allCards) {
            Flashcombo.merge(allCard.cardtype, 1, Integer::sum);
        }
        long counter = Flashcombo.values().stream().filter(x -> x == 5).count();
        Optional<Map.Entry<CardType, Integer>> first = Flashcombo.entrySet().stream().filter(x -> x.getValue() == 2).findFirst();
        boolean active = false;
        if(first.isPresent()) {
            Map.Entry<CardType, Integer> second = first.get();
            for (Card card : listplayer) {
                if (second.getKey() == card.cardtype) {
                    active = true;
                }
            }
        }
        if(counter == 1 && active){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean street(List<Card> listDealer, List<Card> listplayer){
        List<Card> allCards = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        allCards.addAll(listDealer);
        allCards.addAll(listplayer);
        for (Card allCard : allCards) {
            nums.add(allCard.cardvalue);
        }
        nums.sort(Comparator.naturalOrder());
        Integer number = nums.getFirst();
        int counter = 0;
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
        return counter >= 5 && playercard;
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
        boolean active = false;
        for (Integer i : keyList) {
            quads.remove(i);
        }
        for (Integer i : quads.keySet()) {
            for (Card card : listplayer) {
                if(card.cardvalue.equals(i)) {
                    active = true;
                    break;
                }
            }
        }
        return counter == 1 && active;
    }

    public static boolean streetFLash(List<Card> listDealer, List<Card> listplayer){
        Boolean Flash = flash(listDealer,listplayer);
        Boolean Street = street(listDealer,listplayer);
        return Flash && Street;
    }
}
