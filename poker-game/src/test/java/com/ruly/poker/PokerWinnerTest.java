package com.ruly.poker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ruly.player.Player;
import com.ruly.rank.PokerRank;
import com.ruly.suit.PokerSuit;
import com.ruly.table.PokerTable;
import com.ruly.table.Table;
import com.ruly.utils.CardGeneratorUtilities;
import com.ruly.utils.PlayerUtils;

public class PokerWinnerTest {
	
	@Test
	public void given10ConditionRankOnEachPlayer_thenReturnListOfPlayerByHandRank() {
		Table table = new PokerTable();
		Player[] players = PlayerUtils.createPlayers(10);
		table.setPlayers(players);
		players[0].setCards(CardGeneratorUtilities.generateOnePair(PokerRank.FIVE));
		players[1].setCards(CardGeneratorUtilities.generateFourOfAKind(PokerRank.FIVE, PokerRank.FOUR));
		players[2].setCards(CardGeneratorUtilities.generateFullHouse(PokerRank.JACK, PokerRank.EIGHT));
		players[3].setCards(CardGeneratorUtilities.generateNothing());
		players[4].setCards(CardGeneratorUtilities.generateSetOfRoyalFlush(PokerSuit.DIAMONDS));
		players[5].setCards(CardGeneratorUtilities.generateSetOfStraightFlush(PokerSuit.HEARTS, 5));
		players[6].setCards(CardGeneratorUtilities.generateTwoPairs(PokerRank.ACE, PokerRank.EIGHT, PokerRank.FIVE));
		players[7].setCards(CardGeneratorUtilities.generateSameSuitWithIncrement(PokerSuit.CLUBS, 2));
		players[8].setCards(CardGeneratorUtilities.generateThreeOfAKind(PokerRank.JACK, PokerRank.EIGHT, PokerRank.FIVE));
		players[9].setCards(CardGeneratorUtilities.generateStraight(PokerSuit.SPADES, 7));
		table.rankPlayersHand();
		table.getPlayersByHandRank();
		Player[] rankedPlayer = table.getPlayersByHandRank();
		assertEquals(players[4], rankedPlayer[0]);
		assertEquals(players[5], rankedPlayer[1]);
		assertEquals(players[1], rankedPlayer[2]);
		assertEquals(players[2], rankedPlayer[3]);
		assertEquals(players[7], rankedPlayer[4]);
		assertEquals(players[0], rankedPlayer[5]);
		assertEquals(players[9], rankedPlayer[6]);
		assertEquals(players[8], rankedPlayer[7]);
		assertEquals(players[6], rankedPlayer[8]);
		assertEquals(players[3], rankedPlayer[9]);
	}
	
	
}
