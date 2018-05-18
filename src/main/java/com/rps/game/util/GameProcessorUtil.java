package com.rps.game.util;

import com.rps.model.Player;
import com.rps.model.enums.CommonStrings;
import com.rps.model.enums.Move;
import com.rps.responses.GameResponse;
import com.rps.responses.Response;

/**
 * @author Ayush Verma
 * GameProcessorUtil helps in evaluating varius function of game
 */
public class GameProcessorUtil {

	/**
	 * This method generates a random number, make sure random number
	 * is less than 3 (because we have one 3 moves) and then returns
	 * corresponding move.
	 * @return Move
	 */
	public static Move getRandomMove() {
		int num = (int) (Math.ceil((Math.random()*10))%3);
		return Move.values()[num];
	}

	/**
	 * This functions evaluate a winning round based on players data,
	 * this also decided whether the game is finished or not.
	 * Game = 3 winning round for one players.
	 * Once a game is finished, winning counter are reset.
	 * @param player1
	 * @param player2
	 * @return GameResponse, contains status of both player and
	 *         message for winner
	 */
	public static Response evaluateMoves(Player player1, Player player2) {
		GameResponse response = new GameResponse();

		/** Checking current round */
		if(player1.compareTo(player2)>0) {
			player1.incrementWinningCounter();
			response.setMessage(player1.getName() + CommonStrings.WINS_MOVE);
		}else if(player1.compareTo(player2)<0) {
			player2.incrementWinningCounter();
			response.setMessage(player2.getName()  +CommonStrings.WINS_MOVE);
		}else {
			response.setMessage(CommonStrings.DRAW+player1.getCurrentMove());
		}

		/** evaluating the games status */
		boolean gameFinish = false;
		if(player1.getWinningCounter()==3) {
			response.setMessage(player1.getName() + CommonStrings.WINS_GAME);
			gameFinish = true;
		}else if(player2.getWinningCounter()==3) {
			response.setMessage(player2.getName() + CommonStrings.WINS_GAME);
			gameFinish = true;
		}

		/** if game is finished reset the counters */
		if(gameFinish) {
			player1.resetCounter();
			player2.resetCounter();
		}

		/** update status for each players */
		response.setPlayer1Status(player1.toString());
		response.setPlayer2Status(player2.toString());
		return response;
	}
}