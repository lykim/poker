package com.ruly.deck;

import com.ruly.card.Card;
import com.ruly.card.PokerCard;
import com.ruly.rank.PokerRank;
import com.ruly.suit.PokerSuit;

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
		
	}
}
