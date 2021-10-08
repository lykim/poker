package com.ruly.poker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.ruly.card.Card;
import com.ruly.card.PokerCard;
import com.ruly.constant.PokerConstant;
import com.ruly.rank.PokerRank;
import com.ruly.rank.Rank;
import com.ruly.suit.PokerSuit;
import com.ruly.suit.Suit;
import com.ruly.table.PokerTable;
import com.ruly.utils.PokerUtilities;

public class PokerRuleTest {
	@Test
	public void givenRoyalFlush_thenGetRoyalFlush() {
		Set<Card> cards = generateSetOfRoyalFlush(PokerSuit.CLUBS);
		assertEquals(PokerConstant.ROYAL_FLUSH, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenStraightFlush_thenGetStraightFlush() {
		Set<Card> cards = generateSetOfStraightFlush(PokerSuit.CLUBS, PokerRank.FOUR.getValue());
		assertEquals(PokerConstant.STRAIGHT_FLUSH, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenFourOfAKind_thenGetFourOfAKind() {
		Set<Card> cards = generateSameRanks(PokerRank.KING, 4);
		cards.add(new PokerCard(PokerSuit.CLUBS, PokerRank.ACE));
		assertEquals(PokerConstant.FOUR_OF_A_KIND, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenFullHouse_thenGetFullHouse() {
		Set<Card> threeCardsSameRank = generateSameRanks(PokerRank.KING, 3);
		Set<Card> twoCardsSameRank = generateSameRanks(PokerRank.QUEEN, 2);
		Set<Card> cards = new HashSet<Card>(threeCardsSameRank);
		cards.addAll(twoCardsSameRank);
		assertEquals(PokerConstant.FULL_HOUSE, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenFlush_thenGetFlush() {
		Set<Card> cards = generateSameSuitWithIncrement(PokerSuit.CLUBS, 2);
		assertEquals(PokerConstant.FLUSH, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenStraight_thenGeStraight() {
		Set<Card> cards = generateSetOfStraightFlush(PokerSuit.CLUBS, PokerRank.FOUR.getValue());
		assertEquals(PokerConstant.STRAIGHT, PokerUtilities.getHand(scrambleSuit(cards)));
	}
	
	@Test
	public void givenThreeOfAKind_thenGetThreeOfAKind() {
		Set<Card> threeCardsSameRank = generateSameRanks(PokerRank.KING, 3);
		threeCardsSameRank.add(new PokerCard(PokerSuit.CLUBS, PokerRank.FIVE));
		threeCardsSameRank.add(new PokerCard(PokerSuit.DIAMONDS, PokerRank.FOUR));
		assertEquals(PokerConstant.THREE_OF_A_KIND, PokerUtilities.getHand(threeCardsSameRank));
	}
	
	@Test
	public void givenTwoPairs_thenGetTwoPairs() {
		Set<Card> twoCardsSameRankKing = generateSameRanks(PokerRank.KING, 2);
		Set<Card> twoCardsSameRankQueen = generateSameRanks(PokerRank.QUEEN, 2);
		Set<Card> cards = new HashSet<Card>(twoCardsSameRankKing);
		cards.addAll(twoCardsSameRankQueen);
		cards.add(new PokerCard(PokerSuit.SPADES, PokerRank.FIVE));
		assertEquals(PokerConstant.TWO_PAIRS, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenOnePair_thenGetOnePair() {
		Set<Card> twoCardsSameRankKing = generateSameRanks(PokerRank.KING, 2);
		Set<Card> cards = new HashSet<Card>(twoCardsSameRankKing);
		cards.add(new PokerCard(PokerSuit.CLUBS, PokerRank.FIVE));
		cards.add(new PokerCard(PokerSuit.DIAMONDS, PokerRank.EIGHT));
		cards.add(new PokerCard(PokerSuit.SPADES, PokerRank.NINE));
		assertEquals(PokerConstant.ONE_PAIR, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenNothing_thenGetNothing() {
		Set<Card> cards = new HashSet<>();
		cards.add(new PokerCard(PokerSuit.SPADES, PokerRank.TWO));
		cards.add(new PokerCard(PokerSuit.DIAMONDS, PokerRank.FOUR));
		cards.add(new PokerCard(PokerSuit.HEARTS, PokerRank.SIX));
		cards.add(new PokerCard(PokerSuit.CLUBS, PokerRank.KING));
		cards.add(new PokerCard(PokerSuit.SPADES, PokerRank.TENTH));
		assertEquals(PokerConstant.NOTHING, PokerUtilities.getHand(cards));
	}
	
	private Set<Card> scrambleSuit(Set<Card> cards) {
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
	
	private Set<Card> generateSameSuitWithIncrement(Suit suit, int increment){
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
	
	private static Set<Card> generateSameRanks(Rank rank, int numberOfCards){
		Set<Card> cards = new HashSet<>();
		for(int i=0; i < numberOfCards; i++) {
			cards.add(new PokerCard(PokerSuit.getSuit(i), rank));
		}
		return cards;
	}
	
	private static Set<Card> generateSetOfStraightFlush(Suit suit, int minNumber){
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
	
	
	
	private Set<Card> generateSetOfRoyalFlush(Suit suit){
		Set<Card> cards = new HashSet<>();
		cards.add(new PokerCard(suit, PokerRank.ACE));
		cards.add(new PokerCard(suit, PokerRank.JACK));
		cards.add(new PokerCard(suit, PokerRank.QUEEN));
		cards.add(new PokerCard(suit, PokerRank.KING));
		cards.add(new PokerCard(suit, PokerRank.TENTH));	
		return cards;
	}
	
	
}
