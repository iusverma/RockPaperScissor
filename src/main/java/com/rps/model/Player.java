package com.rps.model;

import com.rps.game.util.GameProcessorUtil;
import com.rps.model.enums.Move;

/**
 * @author Ayush Verma
 * Player class for the game
 */
public class Player implements Comparable<Player>{
	/** Name of the player */
	private String name;

	/** Player's current move */
	private Move currentMove;

	/** Number of wins player had in game */
	private int winningCounter;

	/**
	 * Getter for name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for winning counter
	 * @return winningCounter
	 */
	public int getWinningCounter() {
		return winningCounter;
	}

	/**
	 * Setter for winning counter
	 * @param winningCounter
	 */
	public void setWinningCounter(int winningCounter) {
		this.winningCounter = winningCounter;
	}

	/**
	 * Increments winning counter by one
	 * when a player wins a round
	 */
	public void incrementWinningCounter() {
		this.winningCounter++;
	}

	/**
	 * Resets counter to 0, when game is finished
	 * i.e. one player secure 3 wins
	 */
	public void resetCounter() {
		this.winningCounter = 0;
	}

	/**
	 * Getter for currentMove
	 * @return currentMove
	 */
	public Move getCurrentMove() {
		return currentMove;
	}

	/**
	 * Setter for currentMove
	 * @param currentMove
	 */
	public void setCurrentMove(Move currentMove) {
		this.currentMove = currentMove;
	}

	/**
	 * This function calculate a random move
	 * for computer player.
	 */
	public void setRandomMove() {
		this.currentMove =  GameProcessorUtil.getRandomMove();
	}

	/**
	 * Overriding comparison logic for player's move
	 */
	@Override
	public int compareTo(Player o) {
		/** If both moves are same, player score equal */
		if(this.currentMove.equals(o.currentMove))
			return 0;

		/**
		 * rock-paper-scissor is based on following conditions
		 * 1. Rock wins over Scissor
		 * 2. Paper wins over Rock
		 * 3. Scissor wins over Paper
		 */
		if(this.currentMove.equals(Move.ROCK) && o.currentMove.equals(Move.SCISSOR))
			return 1;
		if(this.currentMove.equals(Move.PAPER) && o.currentMove.equals(Move.ROCK))
			return 1;
		if(this.currentMove.equals(Move.SCISSOR) && o.currentMove.equals(Move.PAPER))
			return 1;
		return -1;
	}

	/**
	 * Override string representation on Player class
	 * @return player string
	 */
	@Override
	public String toString() {
		return "Name:"+this.name+", move:"+this.currentMove+", wins:"+this.winningCounter;
	}
}