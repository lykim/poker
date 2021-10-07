package com.ruly.poker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class CardTest {
	
	@Test
	public void whenInitialize_shouldHaveSuit() {
		Card card = new Card(Suit.CLUBS, Rank.ACE);
		assertNotNull(card.getSuit());
	}
	
	@Test
	public void whenInitialize_shouldHaveRanks() {
		Card card = new Card(Suit.CLUBS, Rank.ACE);
		assertNotNull(card.getRank());
	}
	
}