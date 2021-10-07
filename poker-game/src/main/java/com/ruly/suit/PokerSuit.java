package com.ruly.suit;

public enum PokerSuit implements Suit{
	SPADES(0), HEARTS(1), CLUBS(2), DIAMONDS(3);
	
	private final int value;

	private PokerSuit(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public static Suit getSuit(int value) {
		switch(value) {
			case 1: 
				return PokerSuit.HEARTS;
			case 2: 
				return PokerSuit.CLUBS;
			case 3: 
				return PokerSuit.DIAMONDS;
			default:
				return PokerSuit.SPADES;
		}
	}
	public String getLabel() {
		switch(value) {
			case 1: 
				return "Heart";
			case 2: 
				return "Club";
			case 3: 
				return "Diamond";
			default:
				return "Spade";
		}
	}
}
