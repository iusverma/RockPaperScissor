package com.rps.responses;

/**
 * @author ayverma
 *  Extended response for the game, it contains status of players
 */
public class GameResponse extends Response {
	/** Status of player 1 computer */
	private String player1Status;

	/** Status of player 2 human */
	private String player2Status;

	/**
	 * Getter for player 1 status
	 * @return status
	 */
	public String getPlayer1Status() {
		return player1Status;
	}

	/**
	 * Setter for player 1 status
	 * @param player1Status
	 */
	public void setPlayer1Status(String player1Status) {
		this.player1Status = player1Status;
	}

	/**
	 * Getter for player 2 status
	 * @return status
	 */
	public String getPlayer2Status() {
		return player2Status;
	}

	/**
	 * Setter for player 2 status
	 * @param player1Status
	 */
	public void setPlayer2Status(String player2Status) {
		this.player2Status = player2Status;
	}
}
