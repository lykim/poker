package com.ruly.utils;

public class CardRankUtilities {
	public static String getCardRankName(int cardRank) {
		switch(cardRank) {
			case 1: return "Royal Flush";
			case 2: return "Straight Flush";
			case 3: return "Four Of A Kind";
			case 4: return "Full House";
			case 5: return "Flush";
			case 6: return "Straight";
			case 7: return "Three Of A Kind";
			case 8: return "Two Pairs";
			case 9: return "One Pair";
			case 10: return "Nothing";
			default: return "Nothing";		
		}
	}
}
