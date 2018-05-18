package com.rps.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rps.model.enums.Move;

public class PlayerTest {

	@Test
	public void testScenarioBothPlayerHaveSameMove() {
		Player player1 = new Player();
		player1.setName("player1");
		player1.setCurrentMove(Move.PAPER);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.PAPER);
		
		Assert.assertEquals(player1.compareTo(player2), 0);
		Assert.assertEquals(player2.compareTo(player1), 0);

		player1.setCurrentMove(Move.ROCK);
		player2.setCurrentMove(Move.ROCK);
		Assert.assertEquals(player1.compareTo(player2), 0);
		Assert.assertEquals(player2.compareTo(player1), 0);
		
		player1.setCurrentMove(Move.SCISSOR);
		player2.setCurrentMove(Move.SCISSOR);
		Assert.assertEquals(player1.compareTo(player2), 0);
		Assert.assertEquals(player2.compareTo(player1), 0);
	}
	
	@Test
	public void testScenarioPlayer1HasRockPlayer2HasScissor() {
		Player player1 = new Player();
		player1.setName("player1");
		player1.setCurrentMove(Move.ROCK);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.SCISSOR);
		
		Assert.assertEquals(player1.compareTo(player2), 1);
		Assert.assertEquals(player2.compareTo(player1), -1);
	}

	@Test
	public void testScenarioPlayer1HasPaperPlayer2HasRock() {
		Player player1 = new Player();
		player1.setName("player1");
		player1.setCurrentMove(Move.PAPER);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.ROCK);
		
		Assert.assertEquals(player1.compareTo(player2), 1);
		Assert.assertEquals(player2.compareTo(player1), -1);
	}

	@Test
	public void testScenarioPlayer1HasScissorPlayer2HasPaper() {
		Player player1 = new Player();
		player1.setName("player1");
		player1.setCurrentMove(Move.SCISSOR);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.PAPER);
		
		Assert.assertEquals(player1.compareTo(player2), 1);
		Assert.assertEquals(player2.compareTo(player1), -1);
	}
	
	@Test
	public void testToString() {
		String playerStatus = "Name:player, move:SCISSOR, wins:1";
		Player player = new Player();
		player.setName("player");
		player.setCurrentMove(Move.SCISSOR);
		player.setWinningCounter(1);
		Assert.assertEquals(player.toString(), playerStatus);
	}
}
