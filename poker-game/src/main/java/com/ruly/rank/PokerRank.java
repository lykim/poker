package com.ruly.rank;

public enum PokerRank implements Rank{
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
	
	private PokerRank(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public static Rank getRank(int value) {
		switch(value) {
			case 1: 
				return PokerRank.TWO;
			case 2: 
				return PokerRank.THREE;
			case 3: 
				return PokerRank.FOUR;
			case 4: 
				return PokerRank.FIVE;
			case 5: 
				return PokerRank.SIX;
			case 6: 
				return PokerRank.SEVEN;
			case 7: 
				return PokerRank.EIGHT;
			case 8: 
				return PokerRank.NINE;
			case 9: 
				return PokerRank.TENTH;
			case 10: 
				return PokerRank.JACK;
			case 11: 
				return PokerRank.QUEEN;
			case 12: 
				return PokerRank.KING;
			default:
				return PokerRank.ACE;
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
