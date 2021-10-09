package com.ruly.rank;

public enum PokerRank implements Rank{
	ACE(0, "A"),
	TWO(1, "2"),
	THREE(2, "3"),
	FOUR(3, "4"),
	FIVE(4, "5"),
	SIX(5, "6"),
	SEVEN(6, "7"),
	EIGHT(7, "8"),
	NINE(8, "9"),
	TENTH(9, "10"),
	JACK(10, "J"),
	QUEEN(11, "Q"),
	KING(12, "K");
	private final int value;
	private final String abbreviation;
	
	private PokerRank(int value, String abbreviation) {
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
