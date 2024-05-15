package Poker;

import java.util.List;

public class Combo {
    public static Combos getCombo(List<Card> listDealer, List<Card> listplayer){
        if (Decider.streetFLash(listDealer, listplayer)){
            return Combos.StreetFlash;
        }
        if (Decider.quads(listDealer, listplayer)){
            return Combos.Quads;
        }
        if (Decider.fullHouse(listDealer, listplayer)){
            return Combos.FullHouse;
        }
        if (Decider.flash(listDealer, listplayer)){
            return Combos.Flash;
        }
        if (Decider.street(listDealer, listplayer)){
            return Combos.Street;
        }
        if (Decider.threes(listDealer, listplayer)){
            return Combos.Threes;
        }
        if (Decider.twoPairs(listDealer, listplayer)){
            return Combos.TwoPairs;
        }
        if (Decider.pair(listDealer, listplayer)){
            return Combos.Pair;
        }
        return Combos.HighCard;
    }
}
