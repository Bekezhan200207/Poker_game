package Poker;

import java.util.*;

public class PokerRunner {
    public static void main(String[] args) {
        Cards deck = new Cards();
        Scanner in = new Scanner(System.in);
        List<Player> playersList= new ArrayList<>();
        System.out.println("Enter number of players. 2 - minimum, 6 - maximum");
        int n = in.nextInt();
        for (int i = 1; i < n + 1; i++) {
            System.out.println("Enter name of the " + i +" player.");
            String name = in.next();
            playersList.add(new Player(name));
        }


        while (true) {

            deck.stackCards();
            deck.shuffle();


            Card card1 = deck.takeCard();
            Card card2 = deck.takeCard();
            Card card3 = deck.takeCard();
            Card card4 = deck.takeCard();
            Card card5 = deck.takeCard();

            List<Card> dealersCards = List.of(card1, card2, card3, card4, card5);

            for (Player player : playersList) {
                for (int i = 0; i < 2; i++) {
                    player.takeCard(deck.takeCard());
                }
            }


            System.out.println("Dealers` cards are: ");
            for (Card dealersCard : dealersCards) {
                System.out.println(dealersCard);
            }
            System.out.println();


            for (Player player : playersList) {
                player.setCombination(Combo.getCombo(dealersCards, player.getDealtCards()));
            }


            WinnerResolver.resolve(playersList);
            System.out.println();

            for (Player player : playersList) {
                player.dealtCards.clear();
            }

            System.out.println("Would you like to restart the game? Y/N");
            String restart = in.next();
            if (Objects.equals(restart, "N")) {
                break;
            }
            if (!Objects.equals(restart, "N") && !Objects.equals(restart, "Y")){
                System.out.println("Invalid command. Game will shut down");
                break;
            }
        }

    }

}

