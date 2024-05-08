package Poker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PokerRunner {
    public static void main(String[] args) {
        Cards deck = new Cards();
        deck.stackCards();
        deck.shuffle();

        Card card1 = deck.takeCard();
        Card card2 = deck.takeCard();
        Card card3 = deck.takeCard();
        Card card4 = deck.takeCard();
        Card card5 = deck.takeCard();
        List<Card> dealersCards = List.of(card1, card2, card3, card4, card5);

        Player player1 = new Player("Alex");
        Player player2 = new Player("John");
        for (int i = 0; i < 2; i++) {
            player1.takeCard(deck.takeCard());
            player2.takeCard(deck.takeCard());
        }
        System.out.println("Dealers` cards are: ");
        for (Card dealersCard : dealersCards) {
            System.out.println(dealersCard);
        }
        System.out.println();

        System.out.println(player1);
        System.out.println(player2);

        player1.setCombination(Combo.getCombo(dealersCards, player1.getDealtCards()));
        player2.setCombination(Combo.getCombo(dealersCards, player2.getDealtCards()));

        if(player2.getCombination().ordinal() < player1.getCombination().ordinal()){
            System.out.println("Winner is " + player2.getName() + " with " + player2.getCombination() + " combination");
        } else if (player1.getCombination().ordinal() < player2.getCombination().ordinal()) {
            System.out.println("Winner is " + player1.getName() + " with " + player1.getCombination() + " combination");
        }else{
            Integer val1 = player1.dealtCards.stream().map(x -> x.cardvalue).max(Comparator.comparing(i -> i)).orElseThrow();
            Integer val2 = player2.dealtCards.stream().map(x -> x.cardvalue).max(Comparator.comparing(i -> i)).orElseThrow();
            if(val1 < val2){
                System.out.println("Winner is " + player2.getName() + " with " + player2.getCombination() + " combination");
            } else if (val1 > val2) {
                System.out.println("Winner is " + player1.getName() + " with " + player1.getCombination() + " combination");
            }
            else{
                    System.out.println("Draw. No one wins nor loses.");
            }

        }


    }

}

//Integer val1 = pl1_cards.stream().map(x -> x.cardvalue).max(Comparator.comparing(i -> i)).orElseThrow();
//Integer val2 = pl2_cards.stream().map(x -> x.cardvalue).max(Comparator.comparing(i -> i)).orElseThrow();
//две пары не реализованы как и старшая карта