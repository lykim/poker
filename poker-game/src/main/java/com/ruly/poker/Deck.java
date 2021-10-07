package com.ruly.poker;

public class Deck {
	public final static int SUIT_SIZE = 4;
	public final static int RANK_SIZE = 13;
	public Card[][] cards;
	
	public Deck() {
		this.cards = new Card[SUIT_SIZE][RANK_SIZE];
		fillDeckWithDefaultOrderOfCards();
	}
	
	private void fillDeckWithDefaultOrderOfCards() {
		for(int suit=0; suit < Deck.SUIT_SIZE; suit++) {
			for(int rank=0; rank < Deck.RANK_SIZE; rank++) {
				cards[suit][rank] = new Card(Suit.getSuit(suit), Rank.getRank(rank) );
			}
		}
	}
	
	public int getTotalCards() {
		return this.cards.length * this.cards[0].length;
	}
	
	public Card[][] getCards(){
		return this.cards;
	}
}
