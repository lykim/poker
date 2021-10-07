package com.ruly.deck;

import com.ruly.card.Card;

public abstract class Deck {
	protected Card[][] cards;
	private int suitSize;
	private int rankSize;
	private int peekIndexSuit;
	private int peekIndexRank;
	
	public Deck(int suitSize, int rankSize) {
		this.cards = new Card[suitSize][rankSize];
		this.suitSize = suitSize;
		this.rankSize = rankSize;
		peekIndexSuit = suitSize-1;
		peekIndexRank = rankSize-1;
		fillDeckWithDefaultOrderOfCards();
	}
	
	public Card pop() {
		Card card = cards[peekIndexSuit][peekIndexRank];
		recalculatePeekIndex();
		return card;
	}
	
	private void recalculatePeekIndex() {
		if(peekIndexRank == 0) {
			peekIndexSuit -= 1;
			peekIndexRank = rankSize-1;
		}else {
			peekIndexRank -= 1;			
		}
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
