package com.ruly.poker;

import org.junit.jupiter.api.Test;

import com.ruly.player.Player;
import com.ruly.table.PokerTable;
import com.ruly.table.Table;
import com.ruly.utils.PlayerUtils;

public class PokerWinnerTest {
	
	@Test
	public void given10ConditionRankOnEachPlayer_thenReturnListOfPlayerByHandRank() {
		Table table = new PokerTable();
		Player[] players = PlayerUtils.createPlayers(10);
		table.setPlayers(players);
//		players[0].
	}
	
	
}
