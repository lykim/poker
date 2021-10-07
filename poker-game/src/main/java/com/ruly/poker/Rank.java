package com.ruly.poker;

public enum Rank {
	ACE(0),
	TWO(1),
	THREE(2),
	FOUR(3),
	FIVE(4),
	SIX(5),
	SEVEN(6),
	EIGHT(7),
	NINE(8),
	TENTH(9),
	JACK(10),
	QUEEN(11),
	KING(12);
	private final int value;
	
	private Rank(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public static Rank getRank(int value) {
		switch(value) {
			case 1: 
				return Rank.TWO;
			case 2: 
				return Rank.THREE;
			case 3: 
				return Rank.FOUR;
			case 4: 
				return Rank.FIVE;
			case 5: 
				return Rank.SIX;
			case 6: 
				return Rank.SEVEN;
			case 7: 
				return Rank.EIGHT;
			case 8: 
				return Rank.NINE;
			case 9: 
				return Rank.TENTH;
			case 10: 
				return Rank.JACK;
			case 11: 
				return Rank.QUEEN;
			case 12: 
				return Rank.KING;
			default:
				return Rank.ACE;
		}
	}
	public String getLabel() {
		switch(this.value) {
			case 1: 
				return "Two";
			case 2: 
				return "Three";
			case 3: 
				return "Four";
			case 4: 
				return "Five";
			case 5: 
				return "Six";
			case 6: 
				return "Seven";
			case 7: 
				return "Eight";
			case 8: 
				return "Nine";
			case 9: 
				return "TEN";
			case 10: 
				return "Jack";
			case 11: 
				return "Queen";
			case 12: 
				return "King";
			default:
				return "Ace";
		}
	}
}
