package com.ruly.table;

import java.util.Arrays;
import java.util.Comparator;

import com.ruly.deck.PokerDeck;
import com.ruly.player.Player;
import com.ruly.utils.PokerUtilities;

public class PokerTable extends Table {

	public static int NUM_OF_PLAYER_CARDS = 5;
	private static int MAXIMUM_PLAYER = 10;	
	
	public PokerTable() {
		super(NUM_OF_PLAYER_CARDS, MAXIMUM_PLAYER);
	}
	
	protected void initializeDeck() {
		deck = new PokerDeck();
		deck.suffle();
	}

	@Override
	public void rankPlayersHand() {
		playersByHandRank = Arrays.stream(players).map(player -> {
				player.setCardRank(PokerUtilities.getHand(player.getCards()));
				player.setSecondRank(PokerUtilities.setSecondRank(player));
				player.setThirdRank(PokerUtilities.setThirdRank(player));
				return player;
			}).sorted(Comparator.comparingInt(Player::getCardRank)
					.thenComparing(Player::getSecondRank, Comparator.reverseOrder())
					.thenComparing(Player::getThirdRank, Comparator.reverseOrder()))
				.toArray(size-> new Player[size]);
		
		
		
		Arrays.stream(playersByHandRank).forEach(player -> {
			System.out.println(player.getCardRank() + " - " +player.getName());
		});
	}
}
