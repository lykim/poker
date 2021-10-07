package com.ruly.deck;

import java.util.HashMap;
import java.util.Map;

import com.ruly.card.Card;
import com.ruly.card.PokerCard;
import com.ruly.rank.PokerRank;
import com.ruly.rank.Rank;
import com.ruly.suit.PokerSuit;
import com.ruly.suit.Suit;
import com.ruly.utils.CommonUtilities;

public class PokerDeck extends Deck{
	private final static int SUIT_SIZE = 4;
	private final static int RANK_SIZE = 13;
	
	public PokerDeck() {
		super(SUIT_SIZE, RANK_SIZE);
	}	
	
	protected void fillDeckWithDefaultOrderOfCards() {
		for(int suit=0; suit < SUIT_SIZE; suit++) {
			for(int rank=0; rank < RANK_SIZE; rank++) {
				cards[suit][rank] = new PokerCard(PokerSuit.getSuit(suit), 
						PokerRank.getRank(rank) );
			}
		}
	}
	
	public int getTotalCards() {
		return this.cards.length * this.cards[0].length;
	}
	
	public Card[][] getCards(){
		return this.cards;
	}
	
	public void suffle() {
		Map<String,Card> cardsOnMap = new HashMap<>();
		for(int suit=0; suit < getSuitSize(); suit++) {
			for(int rank=0; rank < getRankSize(); rank++) {
				suffling(cardsOnMap, suit, rank);
			}
		}
	}
	
	private void suffling(Map<String,Card> cardsOnMap, int suit, int rank) {
		Card suffledCard = new PokerCard(PokerSuit.getSuit(CommonUtilities.getRandomNumberBeetween(0,getSuitSize()-1)), 
				PokerRank.getRank(CommonUtilities.getRandomNumberBeetween(0,getRankSize()-1)));
		if( cardsOnMap.get(suffledCard.getLabel()) == null){
			this.cards[suit][rank] = suffledCard;
			cardsOnMap.put(suffledCard.getLabel(), suffledCard);
		}else {
			suffling(cardsOnMap, suit, rank);
		}
	}
}
