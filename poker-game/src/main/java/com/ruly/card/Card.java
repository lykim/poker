package com.ruly.card;

import com.ruly.rank.Rank;
import com.ruly.suit.Suit;

public abstract class Card {
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public String getLabel() {
		return rank.getLabel() + " of " + suit.getLabel();
	}
}
