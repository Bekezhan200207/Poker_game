package Poker;

import java.util.ArrayList;
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

        Player player1 = new Player("Alex");
        Player player2 = new Player("John");
        for (int i = 0; i < 2; i++) {
            player1.takeCard(deck.takeCard());
            player2.takeCard(deck.takeCard());
        }
        List<Card> comboList1 = List.of(card1, card2, card3, card4, card5, player1.dealtCards.get(1),player1.dealtCards.get(2));
        List<Card> comboList2 = List.of(card1, card2, card3, card4, card5, player2.dealtCards.get(1),player2.dealtCards.get(2));
        System.out.println("Dealers` cards are: ");
        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
        System.out.println(card4);
        System.out.println(card5);
        System.out.println();

        System.out.println(player1);
        System.out.println(player2);
    }

}
