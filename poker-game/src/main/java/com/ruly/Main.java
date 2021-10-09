package com.ruly;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ruly.card.Card;
import com.ruly.player.Player;
import com.ruly.table.PokerTable;
import com.ruly.table.Table;
import com.ruly.utils.CardRankUtilities;
import com.ruly.utils.PlayerUtils;

public class Main {
	public static void main(String args[]) {
        Scanner inputReader = new Scanner(System.in);
        printWelcomeMessage();
        
        int numOfPlayer = getNumOfPlayers(inputReader, 0);
        Player[] players = PlayerUtils.createPlayers(numOfPlayer);
        Table table = new PokerTable();
        table.setPlayers(players);
        System.out.println("");
        System.out.println("We Play with " + numOfPlayer + " player(s)");

        String isNamingPlayers = askIsNamingPlayer(inputReader, "");
        if("y".equalsIgnoreCase(isNamingPlayers)) {
        	System.out.println("You Choose to naming player ");
        	for(int i=0; i<players.length; i++) {
        		System.out.println("player "+ (i+1) + " name is : ");
            	players[i].setName(inputReader.nextLine());
        	}
        }
        
        table.start();
        System.out.println("Game is Ready, and card have been suffled");
        System.out.println("All player had been given 5 cards");
        table.rankPlayersHand();        
        System.out.println("Ranked is :");
        
        Player[] winners = table.getPlayersByHandRank();
        for(int i = 0;i < winners.length; i++) {
        	Player player = winners[i];
        	System.out.print((i+1) + " - " +  player.getName() + " - " + 
        			CardRankUtilities.getCardRankName(player.getCardRank()) );
        	int cardIndex = 0;
        	int length = player.getCards().size();
			System.out.print("[");
        	for(Card card: player.getCards()) {
        		if(cardIndex < length-1) {
        			System.out.print(card.getAbbreviation()+", ");
        		}else {
        			System.out.print(card.getAbbreviation());
        		}
        		cardIndex++;
        	}
        	System.out.println("]");
        }
        System.out.println("------");
        System.out.println("Thanks for playing");
    	inputReader.close();
	}
	
	private static String askIsNamingPlayer(Scanner inputReader, String isNamingPlayers) {
		while(!("y".equalsIgnoreCase(isNamingPlayers) || "n".equalsIgnoreCase(isNamingPlayers ))) {
            try {
                System.out.println("will the player get default name (y/n): ");
            	isNamingPlayers = inputReader.nextLine();
            } catch (InputMismatchException e) {
            	inputReader.nextLine(); 
            }
        }
		return isNamingPlayers;
	}
	
	private static int getNumOfPlayers(Scanner inputReader, int numOfPlayer) {
		while (numOfPlayer <= 0) {
            System.out.print("How Many Player ( max is 10 ): ");
            try {
            	numOfPlayer = Math.min(inputReader.nextInt(), 10);
                inputReader.nextLine();
            } catch (InputMismatchException e) {
            	numOfPlayer = 0;
            	inputReader.nextLine(); 
            }
        }
		return numOfPlayer;
	}
	
	private static void printWelcomeMessage() {
        System.out.println("**Welcome To Poker Game**");
        System.out.println("-------------------------");		
	}
	
}
