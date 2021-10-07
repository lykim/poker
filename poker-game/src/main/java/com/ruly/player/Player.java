package com.ruly.player;

import java.util.HashSet;
import java.util.Set;

import com.ruly.card.Card;

public class Player {
	private String name;
	private Set<Card> cards;
	
	public Player(String name) {
		this.name = name;
		this.cards = new HashSet<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public Set<Card> getCards() {
		return this.cards;
	}
}
