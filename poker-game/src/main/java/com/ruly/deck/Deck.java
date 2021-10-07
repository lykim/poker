package com.ruly.deck;

import com.ruly.card.Card;

public abstract class Deck {
	protected Card[][] cards;
	private int suitSize;
	private int rankSize;
	
	public Deck(int suitSize, int rankSize) {
		this.cards = new Card[suitSize][rankSize];
		this.suitSize = suitSize;
		this.rankSize = rankSize;
		fillDeckWithDefaultOrderOfCards();
	}
	
	public int getMaximumCards() {
		return suitSize * rankSize;
	}
	public int getSuitSize() {
		return this.suitSize;
	}
	
	public int getRankSize() {
		return this.rankSize;
	}
	
	
	protected abstract void fillDeckWithDefaultOrderOfCards(); 
		
	public abstract int getTotalCards();
	
	public abstract Card[][] getCards();
	
	public abstract void suffle();
}
