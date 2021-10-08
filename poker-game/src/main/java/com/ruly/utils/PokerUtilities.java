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
		}else if( isFourOfAKind(cards) ) {
			return PokerConstant.FOUR_OF_A_KIND;
		}else if ( isFullHouse(cards)) {
			return PokerConstant.FULL_HOUSE;
		}else if( isFlush(cards)) {
			return PokerConstant.FLUSH;
		}else if (isStraight(cards)) {
			return PokerConstant.STRAIGHT;
		}else if (isThreeOfAKind(cards)) {
			return PokerConstant.THREE_OF_A_KIND;
		}else if( isCardsHaveTwoPairs(cards)) {
			return PokerConstant.TWO_PAIRS;
		} else if( isOnePair(cards) ) {
			return PokerConstant.ONE_PAIR;
		}
		return PokerConstant.NOTHING;
	}
	
	private static boolean isStraight(Set<Card> cards) {
		if(!isAllCardsHaveSameSuit(cards)) {
				if(isCardsInSequence(cards)) return true;
		}
		return false;
	}
	
	private static boolean isFourOfAKind(Set<Card> cards) {
		if(isCardsHaveSameRank(cards,4)) {
			return true;
		}
		return false;
	}
	
	private static boolean isOnePair(Set<Card> cards) {
		if(!isCardsHaveSameRank(cards,3))
			if(isCardsHaveSameRank(cards,2))
				if(!isCardsHaveTwoPairs(cards)) return true;
		return false;		
	}
	
	private static boolean isFullHouse(Set<Card> cards) {
		if(isCardsHaveSameRank(cards,3))
			if(isCardsHaveSameRank(cards,2)) return true;
		return false;
	}
	
	private static boolean isThreeOfAKind(Set<Card> cards) {
		if(isCardsHaveSameRank(cards,3))
			if(!isCardsHaveSameRank(cards,2)) return true;
		return false;
	}
	
	private static boolean isRoyalFlush(Set<Card> cards) {
		if(isAllCardsHaveSameSuit(cards))
			if(isRoyalFlushRank(cards)) return true;
		return false;
	}
	
	private static boolean isStraightFlush(Set<Card> cards) {
		if(isAllCardsHaveSameSuit(cards)) {
			if(!isRoyalFlushRank(cards))
				if(isCardsInSequence(cards)) return true;
		}
		return false;
	}
	
	private static boolean isFlush(Set<Card> cards) {
		if(isAllCardsHaveSameSuit(cards)) {
			if(!isRoyalFlushRank(cards))
				if(!isCardsInSequence(cards)) return true;
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
	
	private static boolean isCardsHaveSameRank(Set<Card> cards, int occurenceNum) {
		Map<String,Integer> mapOfOccurence = new HashMap<>();
		for(Card card: cards) {
			int occurence =  mapOfOccurence.getOrDefault(card.getRank().getLabel(), 0);
			mapOfOccurence.put(card.getRank().getLabel(), ++occurence);
		}
		for(Integer value : mapOfOccurence.values()) {
			if(value == occurenceNum) return true;
		}
		return false;
	}
	
	private static boolean isCardsHaveTwoPairs(Set<Card> cards) {
		Map<String,Integer> mapOfOccurence = new HashMap<>();
		for(Card card: cards) {
			int occurence =  mapOfOccurence.getOrDefault(card.getRank().getLabel(), 0);
			mapOfOccurence.put(card.getRank().getLabel(), ++occurence);
		}
		int occurence = 0;
		for(Integer value : mapOfOccurence.values()) {
			if(value == 2) {
				++occurence;
			}
		}
		if(occurence == 2) return true;
		return false;
	}
	
	
}
