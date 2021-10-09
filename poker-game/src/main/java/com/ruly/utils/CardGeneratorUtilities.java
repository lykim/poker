package com.ruly.utils;

import java.util.HashSet;
import java.util.Set;

import com.ruly.card.Card;
import com.ruly.card.PokerCard;
import com.ruly.rank.PokerRank;
import com.ruly.rank.Rank;
import com.ruly.suit.PokerSuit;
import com.ruly.suit.Suit;
import com.ruly.table.PokerTable;

public class CardGeneratorUtilities {
	
	public static Set<Card> scrambleSuit(Set<Card> cards) {
		int suitIndex = 0;
		int maxPokerSuit = PokerSuit.values().length -1;
		Set<Card> scrambledCards = new HashSet<Card>();
		for(Card card :  cards) {
			if(suitIndex > maxPokerSuit) {
				suitIndex = suitIndex % maxPokerSuit;
			}
			scrambledCards.add(new PokerCard(PokerSuit.getSuit(suitIndex), card.getRank()));
			suitIndex++;
		}
		return scrambledCards;
	}
	
	public static Set<Card> generateSameSuitWithIncrement(Suit suit, int increment){
		Set<Card> cards = new HashSet<>();
		int maxPokerRank = PokerRank.values().length -1;
		for(int i=0; i < PokerTable.NUM_OF_PLAYER_CARDS; i++) {
			int rankIndex = i * increment;
			if( i > maxPokerRank) {
				rankIndex = rankIndex % maxPokerRank;
			}
			cards.add(new PokerCard(suit, PokerRank.getRank(rankIndex)));
		}
		return cards;
	}
	
	public static Set<Card> generateTwoPairs(Rank rank1, Rank rank2, Rank extra){
		Set<Card> twoCardsSameRankKing = generateSameRanks(rank1, 2);
		Set<Card> twoCardsSameRankQueen = generateSameRanks(rank2, 2);
		Set<Card> cards = new HashSet<Card>(twoCardsSameRankKing);
		cards.addAll(twoCardsSameRankQueen);
		cards.add(new PokerCard(PokerSuit.getSuit(3), extra));
		return cards;
	}
	
	public static Set<Card> generateTwoPairsWithDefinedSuit(Rank rank1, Rank rank2, Rank extra, Suit suit1, Suit suit2){
		Set<Card> twoCardsSameRankKing = generateSameRanks(rank1, 2);
		Set<Card> newTwoCardA = resetSuitOfCards(twoCardsSameRankKing, suit1);
		Set<Card> twoCardsSameRankQueen = generateSameRanks(rank2, 2);
		Set<Card> newTwoCardB = resetSuitOfCards(twoCardsSameRankQueen, suit1);
		Set<Card> cards = new HashSet<Card>(newTwoCardA);
		cards.addAll(newTwoCardB);
		cards.add(new PokerCard(PokerSuit.getSuit(3), extra));
		return cards;
	}
	
	private static Set<Card> resetSuitOfCards(Set<Card> cards, Suit suit){
		Set<Card> resetCards = new HashSet<>();
		for(Card card: cards) {
			resetCards.add(new PokerCard(suit, card.getRank()));
		}
		return resetCards;
	}
	
	public static Set<Card> generateSameRanks(Rank rank, int numberOfCards){
		Set<Card> cards = new HashSet<>();
		for(int i=0; i < numberOfCards; i++) {
			cards.add(new PokerCard(PokerSuit.getSuit(i), rank));
		}
		return cards;
	}
	
	public static Set<Card> generateFourOfAKind(Rank rank, Rank extra){
		Set<Card> cards = generateSameRanks(rank, 4);
		cards.add(new PokerCard(PokerSuit.CLUBS, extra));
		return cards;
	}
	
	public static Set<Card> generateThreeOfAKind(PokerRank rank, PokerRank extra1, PokerRank extra2){
		Set<Card> threeCardsSameRank = generateSameRanks(rank, 3);
		threeCardsSameRank.add(new PokerCard(PokerSuit.CLUBS, extra1));
		threeCardsSameRank.add(new PokerCard(PokerSuit.DIAMONDS, extra2));
		return threeCardsSameRank;
	}
	
	public static Set<Card> generateFullHouse(Rank rank2, Rank rank3){
		Set<Card> threeCardsSameRank = generateSameRanks(rank3, 3);
		Set<Card> twoCardsSameRank = generateSameRanks(rank2, 2);
		Set<Card> cards = new HashSet<Card>(threeCardsSameRank);
		cards.addAll(twoCardsSameRank);
		return cards;
	}
	
	public static Set<Card> generateSetOfStraightFlush(Suit suit, int minNumber){
		if(minNumber == 10) {
			--minNumber;
		}
		Set<Card> cards = new HashSet<>();
		int endNumber = minNumber + PokerTable.NUM_OF_PLAYER_CARDS;
		for(int i=minNumber; i < endNumber; i++) {
			cards.add(new PokerCard(suit, PokerRank.getRank(i)));
		}
		return cards;
	}
	
	public static Set<Card> generateStraight(Suit suit, int minNumber){
		Set<Card> cards = generateSetOfStraightFlush(suit, minNumber);
		return scrambleSuit(cards);
	}
	
	public static Set<Card> generateSetOfRoyalFlush(Suit suit){
		Set<Card> cards = new HashSet<>();
		cards.add(new PokerCard(suit, PokerRank.ACE));
		cards.add(new PokerCard(suit, PokerRank.JACK));
		cards.add(new PokerCard(suit, PokerRank.QUEEN));
		cards.add(new PokerCard(suit, PokerRank.KING));
		cards.add(new PokerCard(suit, PokerRank.TENTH));	
		return cards;
	}
	
	public static Set<Card> generateOnePair(Rank rank){
		Set<Card> twoCardsSameRankKing = generateSameRanks(rank, 2);
		Set<Card> cards = new HashSet<Card>(twoCardsSameRankKing);
		int maxIndex = PokerRank.values().length -1;
		for(int i=2; i < 5; i++) {
			int rankIndex = i * 3;
			if(rankIndex == rank.getValue()) {
				++rankIndex;
			}
			if(rankIndex > maxIndex) {
				rankIndex = rankIndex % maxIndex; 
			}
			int suitIndex = i % 3;
			cards.add(new PokerCard(PokerSuit.getSuit(suitIndex), PokerRank.getRank(rankIndex)));
		}
		return cards;
	}
	
	public static Set<Card> generateNothing(){
		Set<Card> cards = new HashSet<>();
		cards.add(new PokerCard(PokerSuit.SPADES, PokerRank.TWO));
		cards.add(new PokerCard(PokerSuit.DIAMONDS, PokerRank.FOUR));
		cards.add(new PokerCard(PokerSuit.HEARTS, PokerRank.SIX));
		cards.add(new PokerCard(PokerSuit.CLUBS, PokerRank.KING));
		cards.add(new PokerCard(PokerSuit.SPADES, PokerRank.TENTH));
		return cards;
	}
}
