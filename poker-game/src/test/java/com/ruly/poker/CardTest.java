package com.ruly.poker;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.ruly.card.Card;
import com.ruly.card.PokerCard;
import com.ruly.rank.PokerRank;
import com.ruly.suit.PokerSuit;

public class CardTest {
	
	@Test
	public void whenInitialize_shouldHaveSuit() {
		Card card = new PokerCard(PokerSuit.CLUBS, PokerRank.ACE);
		assertNotNull(card.getSuit());
	}
	
	@Test
	public void whenInitialize_shouldHaveRanks() {
		Card card = new PokerCard(PokerSuit.CLUBS, PokerRank.ACE);
		assertNotNull(card.getRank());
	}
	
}