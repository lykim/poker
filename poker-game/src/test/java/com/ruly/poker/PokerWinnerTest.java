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
		players[0].setCards(CardGeneratorUtilities.generateOnePair(PokerRank.ACE));
		players[1].setCards(CardGeneratorUtilities.generateFourOfAKind(PokerRank.FIVE, PokerRank.FOUR));
		players[2].setCards(CardGeneratorUtilities.generateFullHouse(PokerRank.JACK, PokerRank.EIGHT));
		players[3].setCards(CardGeneratorUtilities.generateNothing());
		players[4].setCards(CardGeneratorUtilities.generateSetOfRoyalFlush(PokerSuit.DIAMONDS));
		players[5].setCards(CardGeneratorUtilities.generateSetOfStraightFlush(PokerSuit.HEARTS, 5));
		players[6].setCards(CardGeneratorUtilities.generateTwoPairs(PokerRank.ACE, PokerRank.EIGHT, PokerRank.FIVE));
		players[7].setCards(CardGeneratorUtilities.generateSameSuitWithIncrement(PokerSuit.CLUBS, 3));
		players[8].setCards(CardGeneratorUtilities.generateThreeOfAKind(PokerRank.JACK, PokerRank.EIGHT, PokerRank.FIVE));
		players[9].setCards(CardGeneratorUtilities.generateStraight(PokerSuit.SPADES, 7));
		table.rankPlayersHand();
		table.getPlayersByHandRank();
		Player[] rankedPlayer = table.getPlayersByHandRank();
		assertEquals(rankedPlayer[0], players[4]);
		assertEquals(rankedPlayer[1], players[5]);
		assertEquals(rankedPlayer[2], players[1]);
		assertEquals(rankedPlayer[3], players[2]);
		assertEquals(rankedPlayer[4], players[7]);
		assertEquals(rankedPlayer[5], players[9]);
		assertEquals(rankedPlayer[6], players[8]);
		assertEquals(rankedPlayer[7], players[6]);
		assertEquals(rankedPlayer[8], players[0]);
		assertEquals(rankedPlayer[9], players[3]);
	}
	
	@Test
	public void given4PlayerWith4RoyalFlush_thenReturnListOfPlayerByHandRank() {
		Table table = new PokerTable();
		Player[] players = PlayerUtils.createPlayers(4);
		table.setPlayers(players);
		players[0].setCards(CardGeneratorUtilities.generateSetOfRoyalFlush(PokerSuit.HEARTS));
		players[1].setCards(CardGeneratorUtilities.generateSetOfRoyalFlush(PokerSuit.SPADES));
		players[2].setCards(CardGeneratorUtilities.generateSetOfRoyalFlush(PokerSuit.DIAMONDS));
		players[3].setCards(CardGeneratorUtilities.generateSetOfRoyalFlush(PokerSuit.CLUBS));

		table.rankPlayersHand();
		table.getPlayersByHandRank();
		Player[] rankedPlayer = table.getPlayersByHandRank();
		assertEquals(rankedPlayer[0], players[1]);
		assertEquals(rankedPlayer[1], players[0]);
		assertEquals(rankedPlayer[2], players[3]);
		assertEquals(rankedPlayer[3], players[2]);
	}
	
	@Test
	public void given5PlayerWith4StraigthFlush_thenReturnListOfPlayerByHandRank() {
		Table table = new PokerTable();
		Player[] players = PlayerUtils.createPlayers(5);
		table.setPlayers(players);
		players[0].setCards(CardGeneratorUtilities.generateSetOfRoyalFlush(PokerSuit.DIAMONDS));
		players[1].setCards(CardGeneratorUtilities.generateSetOfStraightFlush(PokerSuit.DIAMONDS, 5));
		players[2].setCards(CardGeneratorUtilities.generateSetOfStraightFlush(PokerSuit.CLUBS, 7));
		players[3].setCards(CardGeneratorUtilities.generateSetOfStraightFlush(PokerSuit.CLUBS, 3));
		players[4].setCards(CardGeneratorUtilities.generateSetOfStraightFlush(PokerSuit.SPADES, 5));
		table.rankPlayersHand();
		table.getPlayersByHandRank();
		Player[] rankedPlayer = table.getPlayersByHandRank();
		assertEquals(rankedPlayer[0], players[0]);
		assertEquals(rankedPlayer[1], players[4]);
		assertEquals(rankedPlayer[2], players[2]);
		assertEquals(rankedPlayer[3], players[3]);
		assertEquals(rankedPlayer[4], players[1]);
	}
}
