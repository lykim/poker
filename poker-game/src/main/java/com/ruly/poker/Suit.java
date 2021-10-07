package com.ruly.poker;

public enum Suit {
	SPADES(0), HEARTS(1), CLUBS(2), DIAMONDS(3);
	
	private final int value;

	private Suit(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public static Suit getSuit(int value) {
		switch(value) {
			case 1: 
				return Suit.HEARTS;
			case 2: 
				return Suit.CLUBS;
			case 3: 
				return Suit.DIAMONDS;
			default:
				return Suit.SPADES;
		}
	}
}
