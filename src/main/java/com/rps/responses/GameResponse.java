package com.rps.responses;

public class GameResponse extends Response {
	private String player1Status;
	private String player2Status;
	public String getPlayer1Status() {
		return player1Status;
	}
	public void setPlayer1Status(String player1Status) {
		this.player1Status = player1Status;
	}
	public String getPlayer2Status() {
		return player2Status;
	}
	public void setPlayer2Status(String player2Status) {
		this.player2Status = player2Status;
	}
}
