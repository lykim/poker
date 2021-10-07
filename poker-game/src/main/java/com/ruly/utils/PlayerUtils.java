package com.ruly.utils;

import com.ruly.player.Player;

public class PlayerUtils {
	public static Player[] createPlayers(int numOfPlayer) {
		Player[] players = new Player[numOfPlayer];
		for(int i=0; i < numOfPlayer; i++) {
			players[i] = new Player("player_"+ (i+1));
		}	
		return players;
	}
}
