package com.ruly.table;

import com.ruly.deck.PokerDeck;

public class PokerTable extends Table {

	public static int NUM_OF_PLAYER_CARDS = 5;
	private static int MAXIMUM_PLAYER = 10;	
	
	public PokerTable() {
		super(NUM_OF_PLAYER_CARDS, MAXIMUM_PLAYER);
	}
	
	protected void initializeDeck() {
		deck = new PokerDeck();
		deck.suffle();
	}

	@Override
	public void rankPlayersHand() {
		
	}
}
