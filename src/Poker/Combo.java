package Poker;

import java.util.List;

public class Combo {
    public static Combos getCombo(List<Card> listDealer, List<Card> listplayer){
        Decider.Pair(listDealer, listplayer);
        if (Decider.streetFLash(listDealer, listplayer)){
            return Combos.StreetFlash;
        }
        if (Decider.quads(listDealer, listplayer)){
            return Combos.Quads;
        }
        if (Decider.FullHouse(listDealer, listplayer)){
            return Combos.FullHouse;
        }
        if (Decider.Flash(listDealer, listplayer)){
            return Combos.Flash;
        }
        if (Decider.Street(listDealer, listplayer)){
            return Combos.Street;
        }
        if (Decider.threes(listDealer, listplayer)){
            return Combos.Threes;
        }
        if (Decider.twoPairs(listDealer, listplayer)){
            return Combos.TwoPairs;
        }
        if (Decider.Pair(listDealer, listplayer)){
            return Combos.Pair;
        }
        return Combos.HighCard;
    }
}
