package com.ruly.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ruly.card.Card;
import com.ruly.constant.PokerConstant;
import com.ruly.rank.PokerRank;
import com.ruly.rank.Rank;

public class PokerUtilities {
	private static List<Rank> ROYAL_FLUSH_RANK = Arrays.asList(new Rank[]{PokerRank.ACE, PokerRank.JACK, 
			PokerRank.TENTH, PokerRank.QUEEN, PokerRank.KING });
	
	public static int getHand(Set<Card> cards) {
		if( isRoyalFlush(cards) ) {
			return PokerConstant.ROYAL_FLUSH;
		}else if( isStraightFlush(cards) ) {
			return PokerConstant.STRAIGHT_FLUSH;
		}
		return 0;
	}
	
	private static boolean isRoyalFlush(Set<Card> cards) {
		if(isAllCardsHaveSameSuit(cards))
			if(isRoyalFlushRank(cards)) return true;
		return false;
	}
	
	private static boolean isStraightFlush(Set<Card> cards) {
		if(isAllCardsHaveSameSuit(cards)) {
			if(isCardsInSequence(cards)) return true;
		}
		return false;
	}
	
	private static boolean isCardsInSequence(Set<Card> cards) {
		int minValue = 13;
		int maxValue = 0;
		for(Card card: cards) {
			minValue = Math.min(minValue, card.getRank().getValue());
			maxValue = Math.max(maxValue, card.getRank().getValue());
		}
		if((maxValue - 4) == minValue) return true;
		return false;
	}
	
	private static boolean isRoyalFlushRank(Set<Card> cards) {
		Map<Rank,Card> mapCard = new HashMap<>();
		for(Card card: cards) {
			mapCard.put(card.getRank(), card);
		}
		for(Rank rank: ROYAL_FLUSH_RANK) {
			if(mapCard.get(rank) == null) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isAllCardsHaveSameSuit(Set<Card> cards) {
		Card initialCard = null;
		for(Card card: cards) {
			if(initialCard == null) {
				initialCard = card;
			}else {
				if(initialCard.getSuit() != card.getSuit()) {
					return false;
				}
			}
		}
		return true;
	}
}
