package com.ruly.poker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ruly.player.Player;
import com.ruly.table.PokerTable;
import com.ruly.table.Table;
import com.ruly.utils.PlayerUtils;

public class TableTest {
	@Test
	public void givenNoPlayer_whenStart_thenReturnMessage() {
		Table table = new PokerTable();
		table.start();
		assertEquals("Game Cannot Start without player", table.getMessage());
	}
	
	@Test
	public void givenPlayerMoreThan10_whenStart_thenReturnMessage() {
		Table table = new PokerTable();
		table.setPlayers(PlayerUtils.createPlayers(11));
		table.start();
		assertEquals("Max number of player is 10", table.getMessage());
	}
	
	@Test
	public void givenAvailablePlayer_whenStart_thenAllPlayerGet5Cards() {
		Table table = new PokerTable();
		table.setPlayers(PlayerUtils.createPlayers(10));
		table.start();
		Player[] players =  table.getPlayers();
		for(int i=0; i < players.length; i++) {
			assertEquals(table.getMaximumCard(), players[i].getCards().size());
		}
	}
}
