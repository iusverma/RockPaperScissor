package com.rps.game.util;

import com.rps.model.Player;
import com.rps.model.enums.Move;
import com.rps.responses.GameResponse;
import com.rps.responses.Response;

public class GameProcessorUtil {

	public static Move getRandomMove() {
		int num = (int) (Math.ceil((Math.random()*10))/3);
		return Move.values()[num];
	}
	
	public static Response evaluateMoves(Player player1, Player player2) {
		GameResponse response = new GameResponse();

		if(player1.compareTo(player2)>0) {
			player1.incrementWinningCounter();
			response.setMessage("Computer wins this move!");
		}else if(player1.compareTo(player2)<0) {
			player2.incrementWinningCounter();
			response.setMessage("You win this move!");
		}else {
			response.setMessage("Draw! Both choose: "+player1.getCurrentMove());
		}
		response.setPlayer1Status(player1.toString());
		response.setPlayer2Status(player2.toString());

		boolean gameFinish = false;
		if(player1.getWinningCounter()==3) {
			response.setMessage("Computer wins the game!");
			gameFinish = true;
		}else if(player2.getWinningCounter()==3) {
			response.setMessage("Human wins this game!");
			gameFinish = true;
		}
		if(gameFinish) {
			player1.resetCounter();
			player2.resetCounter();
		}
		return response;
	}
}