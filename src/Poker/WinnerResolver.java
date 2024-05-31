package Poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerResolver {
    public static void resolve(List<Player> list){
        Map<Combos, List<Player>> map = new HashMap<>();
        for (Player player : list) {
            System.out.println(player);
            if (map.containsKey(player.combination)) {
                List<Player> players = map.get(player.combination);
                players.add(player);
                map.put(player.combination, players);
            }
            else{
                List<Player> listplayers = new ArrayList<>();
                listplayers.add(player);
                map.put(player.combination, listplayers);
            }
        }
        System.out.println();
        List<Combos> list1 = map.keySet().stream().sorted().toList();
        Combos combos = list1.get(0);
        List<Player> players = map.get(combos);
        System.out.print("Winners are - ");
        System.out.println(players.stream().map(x -> x.name).collect(Collectors.joining(", ")));
        for (Player player : players) {
            System.out.println(player + " with " + player.combination + " combination");
        }



    }
}




//        if (player2.getCombination().ordinal() < player1.getCombination().ordinal()) {
//            System.out.println("Winner is " + player2.getName() + " with " + player2.getCombination() + " combination");
//        } else if (player1.getCombination().ordinal() < player2.getCombination().ordinal()) {
//            System.out.println("Winner is " + player1.getName() + " with " + player1.getCombination() + " combination");
//        } else {
//            Integer val1 = player1.dealtCards.stream().map(x -> x.cardvalue).max(Comparator.comparing(i -> i)).orElseThrow();
//            Integer val2 = player2.dealtCards.stream().map(x -> x.cardvalue).max(Comparator.comparing(i -> i)).orElseThrow();
//            if (val1 < val2) {
//                System.out.println("Winner is " + player2.getName() + " with " + player2.getCombination() + " combination");
//            } else if (val1 > val2) {
//                System.out.println("Winner is " + player1.getName() + " with " + player1.getCombination() + " combination");
//            } else {
//                System.out.println("Draw. No one wins nor loses.");
//            }
