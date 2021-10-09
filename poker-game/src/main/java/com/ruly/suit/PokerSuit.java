package com.ruly.suit;

public enum PokerSuit implements Suit{
	SPADES(0, "S"), HEARTS(1, "H"), CLUBS(2, "C"), DIAMONDS(3, "D");
	
	private final int value;
	private final String abbreviation;
	
	private PokerSuit(int value, String abbreviation) {
		this.value = value;
		this.abbreviation = abbreviation;
	}
	public int getValue() {
		return this.value;
	}
	@Override
	public String getAbbreviation() {
		return this.abbreviation;
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
