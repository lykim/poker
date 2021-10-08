package com.ruly.table;

import com.ruly.deck.Deck;
import com.ruly.exception.BusinessException;
import com.ruly.player.Player;

public abstract class Table {
	protected String message;
	protected Player[] players;
	protected Player[] playersByHandRank;
	protected Deck deck;
	private int maximumCard;
	private int maximumPlayers;
	
	public Table(int maximumCard, int maximumPlayers) {
		this.maximumCard = maximumCard;
		this.maximumPlayers = maximumPlayers;
	}
	
	public int getMaximumCard() {
		return this.maximumCard;
	}
	
	public String getMessage() {
		return message;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public Player[] getPlayers() {
		return this.players;
	}
	
	public void start() {
		try {
			checkIsPlayerExist();
			checkIsPlayerExceedMax();
			initializeDeck();
			giveCardsToPlayers();
		}catch (BusinessException e) {
			message = e.getMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public abstract void rankPlayersHand();
	
	public Player[] getPlayersByHandRank() {
		return this.playersByHandRank;
	}
	
	private void giveCardsToPlayers() {
		for(int i=0; i < getMaximumCard(); i++) {
			for(int playerIndex = 0; playerIndex < players.length; playerIndex++) {
				players[playerIndex].addCard(deck.pop());
			}			
		}
	}
	protected void checkIsPlayerExceedMax() {
		if(players.length > maximumPlayers) throw new BusinessException("Max number of player is " + maximumPlayers);
	}
	
	protected void checkIsPlayerExist() {
		if(players == null)	throw new BusinessException("Game Cannot Start without player");
	}
	
	protected abstract void initializeDeck();
	
}
