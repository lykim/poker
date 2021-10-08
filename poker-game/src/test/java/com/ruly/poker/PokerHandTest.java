package com.ruly.poker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.ruly.card.Card;
import com.ruly.card.PokerCard;
import com.ruly.constant.PokerConstant;
import com.ruly.rank.PokerRank;
import com.ruly.suit.PokerSuit;
import com.ruly.utils.CardGeneratorUtilities;
import com.ruly.utils.PokerUtilities;

public class PokerHandTest {
	@Test
	public void givenRoyalFlush_thenGetRoyalFlush() {
		Set<Card> cards = CardGeneratorUtilities.generateSetOfRoyalFlush(PokerSuit.CLUBS);
		assertEquals(PokerConstant.ROYAL_FLUSH, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenStraightFlush_thenGetStraightFlush() {
		Set<Card> cards = CardGeneratorUtilities.generateSetOfStraightFlush(PokerSuit.CLUBS, PokerRank.FOUR.getValue());
		assertEquals(PokerConstant.STRAIGHT_FLUSH, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenFourOfAKind_thenGetFourOfAKind() {
		Set<Card> cards = CardGeneratorUtilities.generateFourOfAKind(PokerRank.KING, PokerRank.FIVE);
		assertEquals(PokerConstant.FOUR_OF_A_KIND, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenFullHouse_thenGetFullHouse() {
		Set<Card> cards = CardGeneratorUtilities.generateFullHouse(PokerRank.KING, PokerRank.QUEEN);
		assertEquals(PokerConstant.FULL_HOUSE, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenFlush_thenGetFlush() {
		Set<Card> cards = CardGeneratorUtilities.generateSameSuitWithIncrement(PokerSuit.CLUBS, 2);
		assertEquals(PokerConstant.FLUSH, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenStraight_thenGeStraight() {
		Set<Card> cards = CardGeneratorUtilities.generateStraight(PokerSuit.CLUBS, PokerRank.FOUR.getValue());
		assertEquals(PokerConstant.STRAIGHT, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenThreeOfAKind_thenGetThreeOfAKind() {
		Set<Card> threeCardsSameRank = CardGeneratorUtilities.generateThreeOfAKind(PokerRank.KING, PokerRank.FIVE, PokerRank.FOUR);
		assertEquals(PokerConstant.THREE_OF_A_KIND, PokerUtilities.getHand(threeCardsSameRank));
	}
	
	@Test
	public void givenTwoPairs_thenGetTwoPairs() {
		Set<Card> cards = CardGeneratorUtilities.generateTwoPairs(PokerRank.KING, PokerRank.QUEEN, PokerRank.ACE);
		assertEquals(PokerConstant.TWO_PAIRS, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenOnePair_thenGetOnePair() {
		Set<Card> cards = CardGeneratorUtilities.generateOnePair(PokerRank.ACE);
		assertEquals(PokerConstant.ONE_PAIR, PokerUtilities.getHand(cards));
	}
	
	@Test
	public void givenNothing_thenGetNothing() {
		Set<Card> cards = CardGeneratorUtilities.generateNothing();
		assertEquals(PokerConstant.NOTHING, PokerUtilities.getHand(cards));
	}
}
