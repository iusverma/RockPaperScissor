package com.rps.app;

import com.rps.game.util.GameProcessorUtil;
import com.rps.model.Player;
import com.rps.model.enums.CommonStrings;
import com.rps.model.enums.Move;
import com.rps.responses.Response;

/**
 * @author Ayush Verma
 * Game handler class, this class will take care of
 * running and flow of game.
 */
public class RPSGameHandler {

	/** private handle instance, so that we can maintain single instane */
	private static RPSGameHandler rpsGameHandler = new RPSGameHandler();

	/** Player 1 computer */
	private Player player1;

	/** Player 2 human */
	private Player player2;

	/**
	 * Private constructor for handler
	 * Also initializes players
	 */
	private RPSGameHandler() {
		player1 = new Player();
		player1.setName("COMPUTER");
		player1.setWinningCounter(0);

		player2 = new Player();
		player2.setName("HUMAN");
		player2.setWinningCounter(0);
	}

	/**
	 * Get instance method for handler
	 * @return handler
	 */
	public static RPSGameHandler getInstance() {
		return rpsGameHandler;
	}

	/**
	 * Getter for player 1
	 * @return player - computer
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * Setter for player 1
	 * @param player - computer
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	/**
	 * Getter for player 2
	 * @return player - human
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * Setter for player 2
	 * @param player - human
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	/**
	 * Method for handling the default welcome page
	 * and return welcome message with games instruction.
	 * @return
	 */
	public Response initializeGame() {
		Response response = new Response();
		response.setMessage(getWelcomeMessage());
		return response;
	}

	/**
	 * The method will be called with user will choose a move
	 * @param userAction
	 * @return round/game status response
	 */
	public Response processUserAction(Move userAction) {
		/** Users move */
		player1.setRandomMove();
		/** Set random move for computer */
		player2.setCurrentMove(userAction);
		/** Evaluate round and game */
		return GameProcessorUtil.evaluateMoves(player1, player2);
	}

	/**
	 * Method to create welcome message.
	 * @return welcome message
	 */
	private String getWelcomeMessage() {
		/** Games instructions should come here */
		return CommonStrings.WELCOME_MESSAGE;
	}
}
