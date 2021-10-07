package com.ruly.poker;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.ruly.card.Card;
import com.ruly.deck.Deck;
import com.ruly.deck.PokerDeck;

public class DeckTest {

	@Test
	public void whenInitialize_deckWillHaveMaximumCards() {
		Deck deck = new PokerDeck();
		assertEquals(deck.getMaximumCards(), deck.getTotalCards());
	}
	
	@Test
	public void whenInitialiaze_allCardsInDeckIsNotEmpty() {
		Deck deck = new PokerDeck();
		assertAllCardsNotNull(deck);
	}
	
	@Test
	public void whenInitialize_allCardsInDeckIsUnique() {
		Deck deck = new PokerDeck();
		assertCardsIsUnique(deck);
	}
	
	@Test
	public void whenSuffling_deckWillHaveMaximumCards() {
		Deck deck = new PokerDeck();
		deck.suffle();
		assertEquals(deck.getMaximumCards(), deck.getTotalCards());
	}
	
	@Test
	public void whenSuffling_allCardsInDeckIsNotEmpty() {
		Deck deck = new PokerDeck();
		deck.suffle();
		assertAllCardsNotNull(deck);
	}
	
	@Test
	public void whenSuffle_allCardsInDeckIsUnique() {
		Deck deck = new PokerDeck();
		deck.suffle();
		assertCardsIsUnique(deck);
	}
	
	private void assertCardsIsUnique(Deck deck) {
		Map<String,Card> cardsOnMap = new HashMap<>();
		Card[][] cardsOnDeck = deck.getCards();
		for(int suit=0; suit < deck.getSuitSize(); suit++) {
			for(int rank=0; rank < deck.getRankSize(); rank++) {
				Card presentCard = cardsOnDeck[suit][rank];
				String key = presentCard.getLabel();
				assertNull(cardsOnMap.getOrDefault(key, null));
				cardsOnMap.put(key, presentCard);
			}
		}
		assertEquals(deck.getTotalCards(), cardsOnMap.size());
	}
	
	private void assertAllCardsNotNull(Deck deck) {
		Card[][] cardsOnDeck = deck.getCards();
		for(int suit=0; suit < deck.getSuitSize(); suit++) {
			for(int rank=0; rank < deck.getRankSize(); rank++) {
				assertNotNull(cardsOnDeck[suit][rank]);
			}
		}
	}
}
