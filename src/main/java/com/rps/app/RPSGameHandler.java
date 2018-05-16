package com.rps.app;

import com.rps.game.util.GameProcessorUtil;
import com.rps.model.Player;
import com.rps.model.enums.Move;
import com.rps.responses.Response;

public class RPSGameHandler {

	private static RPSGameHandler rpsGameHandler = new RPSGameHandler();

	private Player player1;

	private Player player2;

	private RPSGameHandler() {
		player1 = new Player();
		player1.setName("COMPUTER");
		player1.setWinningCounter(0);

		player2 = new Player();
		player2.setName("HUMAN");
		player2.setWinningCounter(0);
	}

	public static RPSGameHandler getInstance() {
		return rpsGameHandler;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Response initializeGame() {
		Response response = new Response();
		response.setMessage(getWelcomeMessage());
		return response;
	}
	
	public Response processUserAction(Move userAction) {
		player1.setRandomMove();
		player2.setCurrentMove(userAction);
		return GameProcessorUtil.evaluateMoves(player1, player2);
	}

	private String getWelcomeMessage() {
		return "Welcome to the game of Rock-Paper-Scissor!";
	}
}
