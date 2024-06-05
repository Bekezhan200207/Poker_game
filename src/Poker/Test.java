package Poker;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        quads();
    }

    private static void testPair() {
        Card card1 = new Card("2", CardType.Clubs, 2);
        Card card2 = new Card("3", CardType.Diamonds, 3);
        Card card3 = new Card("4", CardType.Hearts, 4);
        Card card4 = new Card("5", CardType.Clubs, 5);
        Card card5 = new Card("6", CardType.Spades, 6);

        Card cardplayer1 = new Card("2", CardType.Hearts, 2);
        Card cardplayer2 = new Card("King", CardType.Spades, 13);


        Combos combination = Combo.getCombo(List.of(card1, card2, card3, card4, card5), List.of(cardplayer1, cardplayer2));
        System.out.println(combination);
    }

    private static void testTwoPair() {
        Card card1 = new Card("2", CardType.Clubs, 2);
        Card card2 = new Card("3", CardType.Diamonds, 3);
        Card card3 = new Card("4", CardType.Hearts, 4);
        Card card4 = new Card("5", CardType.Clubs, 5);
        Card card5 = new Card("6", CardType.Spades, 6);

        Card cardplayer1 = new Card("2", CardType.Hearts,2);
        Card cardplayer2 = new Card("3", CardType.Clubs,3);


        Combos combination = Combo.getCombo(List.of(card1, card2, card3, card4, card5), List.of(cardplayer1, cardplayer2));
        System.out.println(combination);
    }
    private static void testThrees() {
        Card card1 = new Card("2", CardType.Clubs, 2);
        Card card2 = new Card("3", CardType.Diamonds, 3);
        Card card3 = new Card("4", CardType.Hearts, 4);
        Card card4 = new Card("5", CardType.Clubs, 5);
        Card card5 = new Card("6", CardType.Spades, 6);

        Card cardplayer1 = new Card("2", CardType.Hearts, 2);
        Card cardplayer2 = new Card("2", CardType.Spades, 2);


        Combos combination = Combo.getCombo(List.of(card1, card2, card3, card4, card5), List.of(cardplayer1, cardplayer2));
        System.out.println(combination);
    }

    private static void testFlash() {
        Card card1 = new Card("2", CardType.Clubs, 2);
        Card card2 = new Card("3", CardType.Spades, 3);
        Card card3 = new Card("4", CardType.Spades, 4);
        Card card4 = new Card("5", CardType.Clubs, 5);
        Card card5 = new Card("6", CardType.Spades, 6);

        Card cardplayer1 = new Card("5", CardType.Hearts, 5);
        Card cardplayer2 = new Card("2", CardType.Spades, 2);


        Combos combination = Combo.getCombo(List.of(card1, card2, card3, card4, card5), List.of(cardplayer1, cardplayer2));
        System.out.println(combination);
    }

    private static void testStreet() {
        Card card1 = new Card("9", CardType.Clubs, 9);
        Card card2 = new Card("8", CardType.Spades, 8);
        Card card3 = new Card("6", CardType.Spades, 6);
        Card card4 = new Card("10", CardType.Clubs, 10);
        Card card5 = new Card("9", CardType.Spades, 9);

        Card cardplayer1 = new Card("3", CardType.Hearts, 3);
        Card cardplayer2 = new Card("7", CardType.Spades, 7);


        Combos combination = Combo.getCombo(List.of(card1, card2, card3, card4, card5), List.of(cardplayer1, cardplayer2));
        System.out.println(combination);
    }

    private static void testFullhouse() {
        Card card1 = new Card("2", CardType.Clubs, 2);
        Card card2 = new Card("3", CardType.Spades, 3);
        Card card3 = new Card("4", CardType.Spades, 4);
        Card card4 = new Card("5", CardType.Clubs, 5);
        Card card5 = new Card("6", CardType.Spades, 6);

        Card cardplayer1 = new Card("5", CardType.Hearts, 5);
        Card cardplayer2 = new Card("2", CardType.Spades, 2);


        Combos combination = Combo.getCombo(List.of(card1, card2, card3, card4, card5), List.of(cardplayer1, cardplayer2));
        System.out.println(combination);
    }

    private static void quads() {
        Card card1 = new Card("2", CardType.Clubs, 2);
        Card card2 = new Card("5", CardType.Diamonds, 5);
        Card card3 = new Card("5", CardType.Spades, 5);
        Card card4 = new Card("5", CardType.Clubs, 5);
        Card card5 = new Card("6", CardType.Spades, 6);

        Card cardplayer1 = new Card("5", CardType.Hearts, 5);
        Card cardplayer2 = new Card("2", CardType.Spades, 2);


        Combos combination = Combo.getCombo(List.of(card1, card2, card3, card4, card5), List.of(cardplayer1, cardplayer2));
        System.out.println(combination);
    }
    private static void streetFlash() {
        Card card1 = new Card("2", CardType.Clubs, 2);
        Card card2 = new Card("5", CardType.Diamonds, 5);
        Card card3 = new Card("5", CardType.Spades, 5);
        Card card4 = new Card("5", CardType.Clubs, 5);
        Card card5 = new Card("6", CardType.Spades, 6);

        Card cardplayer1 = new Card("5", CardType.Hearts, 5);
        Card cardplayer2 = new Card("2", CardType.Spades, 2);


        Combos combination = Combo.getCombo(List.of(card1, card2, card3, card4, card5), List.of(cardplayer1, cardplayer2));
        System.out.println(combination);
    }

}
