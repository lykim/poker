package com.ruly.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import com.ruly.card.Card;
import com.ruly.constant.PokerConstant;
import com.ruly.player.Player;
import com.ruly.rank.PokerRank;
import com.ruly.rank.Rank;
import com.ruly.suit.Suit;

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
	
	public static int setSecondRank(Player player) {
		int cardRank = player.getCardRank();
		if(cardRank ==  PokerConstant.ROYAL_FLUSH) {
			return getSuitValueFromFirstCard(player.getCards());
		}else if(cardRank ==  PokerConstant.STRAIGHT_FLUSH) {
			return getSuitValueFromFirstCard(player.getCards());
		}else if(cardRank == PokerConstant.FULL_HOUSE) {
			return getMaxSuit(player.getCards());
		}else if(cardRank == PokerConstant.FLUSH) {
			return getSuitValueFromFirstCard(player.getCards());
		}else if(cardRank == PokerConstant.STRAIGHT) {
			return getMaxRankedValue(player.getCards());
		}else if(cardRank == PokerConstant.THREE_OF_A_KIND) {
			return getMaxRankFromSuit(player.getCards());
		}else if(cardRank == PokerConstant.TWO_PAIRS) {
			return getMaxRankedValueFromPairs(player.getCards());
		}else if(cardRank == PokerConstant.ONE_PAIR) {
			return getRankValueFromOnePair(player.getCards());
		}else if(cardRank == PokerConstant.NOTHING) {
			return getHighesRankValue(player.getCards());
		}
		return 99;
	}
	
	
	public static int setThirdRank(Player player) {
		int cardRank = player.getCardRank();
		if(cardRank ==  PokerConstant.STRAIGHT_FLUSH) {
			return getMaxRankedValue(player.getCards());
		}else if( cardRank == PokerConstant.FOUR_OF_A_KIND ) {
			return getMaxRankedValue(player.getCards());
		}else if(cardRank == PokerConstant.FULL_HOUSE) {
			return getMaxRankFromMaxSuit(player.getCards());
		}else if(cardRank == PokerConstant.FLUSH) {
			return getMaxRankFromSuit(player.getCards());
		}else if(cardRank == PokerConstant.STRAIGHT) {
			return getMaxSuit(player.getCards());
		}else if(cardRank == PokerConstant.TWO_PAIRS) {
			return getMaxSuitValueFromPairs(player.getCards());
		}else if(cardRank == PokerConstant.ONE_PAIR) {
			return getSuitValueFromOnePair(player.getCards());
		}else if(cardRank == PokerConstant.NOTHING) {
			return getHighesSuitValue(player.getCards());
		}
		return 0;
	}
	
	private static int getHighesSuitValue(Set<Card> cards) {
		Rank rank = getHighestRank(cards);
		for(Card card: cards) {
			if(card.getRank() == rank) return card.getSuit().getValue();
		}
		return 0;
	}
	
	private static int getHighesRankValue(Set<Card> cards) {
		Rank rank = getHighestRank(cards);
		return getRankValue(rank);
	}
	
	private static Rank getHighestRank(Set<Card> cards) {
		int max = 0;
		Rank result = null;
		for(Card card: cards) {
			int value = aceToHighest(card);
			if(value > max) {
				max = value;
				result = card.getRank();
			}
		}
		return result;
	}
	
	private static int aceToHighest(Card card) {
		return card.getRank().getValue() == 0 ? 13 : card.getRank().getValue();
	}
	
	private static Rank getRankFromOnePair(Collection<Card> cards) {
		Map<Rank,Integer> mapRank = new HashMap<Rank, Integer>();
		for(Card card : cards) {
			int counter = mapRank.getOrDefault(card.getRank(), 0);
			mapRank.put(card.getRank(), ++counter);
		}
		Rank result = null;
		for(Entry<Rank, Integer> entry : mapRank.entrySet()) {
			if(entry.getValue() == 2) {
				result = entry.getKey();
				break;
			}
		}
		return result;
	}
	
	private static int getMaxRankedValueFromPairs(Collection<Card> cards) {
		Set<Rank> ranks = getRanksValueFromPairs(cards);
		int result = 0;
		for(Rank rank: ranks) {
			result +=getRankValue(rank);
		}
		return result;
	}
	
	private static int getMaxSuitValueFromPairs(Collection<Card> cards) {
		Set<Rank> ranks = getRanksValueFromPairs(cards);
		int result = 0;
		for(Card card: cards) {
			if(ranks.contains(card.getRank())) {
				result += card.getSuit().getValue() ;
			}
		}
		return result;
	}
	
	private static Set<Rank> getRanksValueFromPairs(Collection<Card> cards) {
		Map<Rank,Integer> mapRank = new HashMap<Rank, Integer>();
		for(Card card : cards) {
			int counter = mapRank.getOrDefault(card.getRank(), 0);
			mapRank.put(card.getRank(), ++counter);
		}
		int result = 0;
		Set<Rank> ranks = new HashSet<Rank>();
		for(Entry<Rank, Integer> entry : mapRank.entrySet()) {
			if(entry.getValue() == 2) {
				ranks.add(entry.getKey());
			}
		}
		return ranks;
	}
	
	private static int getRankValue(Rank rank) {
		return rank.getValue() == 0 ? 13 : rank.getValue();
	}
	
	private static int getSuitValueFromOnePair(Collection<Card> cards) {
		Rank rank = getRankFromOnePair(cards);
		for(Card card: cards) {
			if(card.getRank() == rank) {
				return card.getSuit().getValue() ;
			}
		}
		return 0;
	}
	
	private static int getRankValueFromOnePair(Collection<Card> cards) {
		Rank result = getRankFromOnePair(cards);
		return result.getValue() == 0 ? 13 : result.getValue();
	}
	
	private static int getSuitValueFromFirstCard(Collection<Card> cards) {
		Card card = cards.stream().findFirst().get();
		return card.getSuit().getValue();
	}
	
	private static int getMaxSuit(Collection<Card> cards) {
		return cards.stream().mapToInt(card -> card.getSuit().getValue())
		.max().getAsInt();
	}
	
	private static int getMaxRankFromSuit(Collection<Card> cards) {
		int maxSuitVal =  getSuitValueFromFirstCard(cards);
		int max = 0;
		for(Card card : cards) {
			if(card.getSuit().getValue() == maxSuitVal) {
				int rankValue = card.getRank().getValue() == PokerRank.ACE.getValue() ? 99 : card.getRank().getValue();
				max = Math.max(max, rankValue);
			}
		}
		return max;
	}
		
	private static int getMaxRankFromMaxSuit(Collection<Card> cards) {
		int maxSuitVal =  getMaxSuit(cards);
		int max = 0;
		for(Card card : cards) {
			if(card.getSuit().getValue() == maxSuitVal) {
				int rankValue = card.getRank().getValue() == PokerRank.ACE.getValue() ? 99 : card.getRank().getValue();
				max = Math.max(max, rankValue);
			}
		}
		return max;
	}
	
	private static int getMaxRankedValue(Collection<Card> cards) {
		Optional<Card> optCard = cards.stream().filter(card -> card.getRank() == PokerRank.ACE).findAny();
		if(optCard.isPresent()) return 99;
		return cards.stream()
				.mapToInt(card -> card.getRank().getValue())
				.max().getAsInt();
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
