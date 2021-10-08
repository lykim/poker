package com.ruly.player;

import java.util.HashSet;
import java.util.Set;

import com.ruly.card.Card;

public class Player {
	private String name;
	private Set<Card> cards;
	private int cardRank;
	private int secondRank;
	private int thirdRank;
	
	public Player(String name) {
		this.name = name;
		this.cards = new HashSet<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	public int getSecondRank() {
		return secondRank;
	}

	public void setSecondRank(int secondRank) {
		this.secondRank = secondRank;
	}

	public Set<Card> getCards() {
		return this.cards;
	}
	
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
	
	public void setCardRank(int cardRank) {
		this.cardRank = cardRank;
	}
	
	public int getCardRank() {
		return this.cardRank;
	}
	
	

	public int getThirdRank() {
		return thirdRank;
	}

	public void setThirdRank(int thirdRank) {
		this.thirdRank = thirdRank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", cardRank=" + cardRank + ", secondRank=" + secondRank + "]";
	}
	
	
}
