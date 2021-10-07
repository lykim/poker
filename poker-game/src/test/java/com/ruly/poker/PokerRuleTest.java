package com.ruly.poker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.ruly.card.Card;
import com.ruly.card.PokerCard;
import com.ruly.constant.PokerConstant;
import com.ruly.rank.PokerRank;
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
	public void givenStraightFlush_thenGetNoRoyalFlush() {
		Set<Card> cards = generateSetOfStraightFlush(PokerSuit.CLUBS, PokerRank.FOUR.getValue());
		assertEquals(PokerConstant.STRAIGHT_FLUSH, PokerUtilities.getHand(cards));
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
