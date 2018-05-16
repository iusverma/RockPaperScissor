package com.rps.model;

import com.rps.game.util.GameProcessorUtil;
import com.rps.model.enums.Move;

public class Player implements Comparable<Player>{
	private String name;
	private int winningCounter;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWinningCounter() {
		return winningCounter;
	}
	public void setWinningCounter(int winningCounter) {
		this.winningCounter = winningCounter;
	}
	public void incrementWinningCounter() {
		this.winningCounter++;
	}
	public void resetCounter() {
		this.winningCounter = 0;
	}
	public Move getCurrentMove() {
		return currentMove;
	}
	public void setCurrentMove(Move currentMove) {
		this.currentMove = currentMove;
	}
	public void setRandomMove() {
		this.currentMove =  GameProcessorUtil.getRandomMove();
	}
	private Move currentMove;
	@Override
	public int compareTo(Player o) {
		if(this.currentMove.equals(o.currentMove))
			return 0;
		if(this.currentMove.equals(Move.ROCK) && o.currentMove.equals(Move.SCISSOR))
			return 1;
		if(this.currentMove.equals(Move.PAPER) && o.currentMove.equals(Move.ROCK))
			return 1;
		if(this.currentMove.equals(Move.SCISSOR) && o.currentMove.equals(Move.PAPER))
			return 1;
		return -1;
	}
	@Override
	public String toString() {
		return "Name:"+this.name+", move:"+this.currentMove+", wins:"+this.winningCounter;
	}
}