package com.ruly.poker;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeckTest {

	@Test
	public void whenInitialize_deckWillHaveMaximumCards() {
		Deck deck = new Deck();
		assertEquals(Deck.SUIT_SIZE * Deck.RANK_SIZE, deck.getTotalCards());
	}
	
	@Test
	public void whenInitialiaze_allCardsInDeckIsNotEmpty() {
		Deck deck = new Deck();
		Card[][] cardsOnDeck = deck.getCards();
		for(int suit=0; suit < Deck.SUIT_SIZE; suit++) {
			for(int rank=0; rank < Deck.RANK_SIZE; rank++) {
				assertNotNull(cardsOnDeck[suit][rank]);
			}
		}
	}
	
}
