package com.rps.game.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rps.model.Player;
import com.rps.model.enums.CommonStrings;
import com.rps.model.enums.Move;
import com.rps.responses.GameResponse;

/**
 * Test class for GameProcessorUtil class
 * @author Ayush Verma
 *
 */
public class GameProcessorUtilTest {

	/**
	 * Testing scenarios
	 * 1. Both player choose same move, no one gets point, no one wins
	 * 2. Player 1 chooses winning move, and wins (3,2)
	 * 3. Player 2 chooses winning move, and wins (2,3)
	 * 4, Player 1 chooses winning move, but no one wins (2,2)
	 * 5. Player 2 choose winning move but no one wins (2,2)
	 */
	@Test
	public void scenarioPlayerDrawTheGame() {
		Player player1 = new Player();
		player1.setName("player1");
		player1.setCurrentMove(Move.PAPER);
		player1.setWinningCounter(2);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.PAPER);
		player2.setWinningCounter(2);

		GameResponse response = (GameResponse) GameProcessorUtil.evaluateMoves(player1, player2);
		Assert.assertNotNull(response);
		validateStatuses(response, CommonStrings.DRAW+player1.getCurrentMove(), player1, player2);
	}

	@Test
	public void scenarioPlayer1WinGame() {
		Player player1 = new Player();
		player1.setName("computer");
		player1.setCurrentMove(Move.SCISSOR);
		player1.setWinningCounter(2);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.PAPER);
		player2.setWinningCounter(2);

		GameResponse response = (GameResponse) GameProcessorUtil.evaluateMoves(player1, player2);
		Assert.assertNotNull(response);
		validateStatuses(response, player1.getName()+CommonStrings.WINS_GAME, player1, player2);
	}

	@Test
	public void scenarioPlayer2WinGame() {
		Player player1 = new Player();
		player1.setName("computer");
		player1.setCurrentMove(Move.SCISSOR);
		player1.setWinningCounter(2);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.ROCK);
		player2.setWinningCounter(2);

		GameResponse response = (GameResponse) GameProcessorUtil.evaluateMoves(player1, player2);
		Assert.assertNotNull(response);
		validateStatuses(response, player2.getName()+CommonStrings.WINS_GAME, player1, player2);
	}

	@Test
	public void scenarioPlayer1WinsMove() {
		Player player1 = new Player();
		player1.setName("computer");
		player1.setCurrentMove(Move.SCISSOR);
		player1.setWinningCounter(1);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.PAPER);
		player2.setWinningCounter(2);

		GameResponse response = (GameResponse) GameProcessorUtil.evaluateMoves(player1, player2);
		Assert.assertNotNull(response);
		validateStatuses(response, player1.getName()+ CommonStrings.WINS_MOVE, player1, player2);
	}
	
	@Test
	public void scenarioPlayer2WinsMove() {
		Player player1 = new Player();
		player1.setName("computer");
		player1.setCurrentMove(Move.ROCK);
		player1.setWinningCounter(2);
		
		Player player2 = new Player();
		player2.setName("player2");
		player2.setCurrentMove(Move.PAPER);
		player2.setWinningCounter(1);

		GameResponse response = (GameResponse) GameProcessorUtil.evaluateMoves(player1, player2);
		Assert.assertNotNull(response);
		validateStatuses(response, player2.getName()+ CommonStrings.WINS_MOVE, player1, player2);
	}

	private void validateStatuses(GameResponse response, String message,
			Player player1, Player player2) {
		Assert.assertEquals(response.getMessage(), message);
		Assert.assertEquals(response.getPlayer1Status(),player1.toString());
		Assert.assertEquals(response.getPlayer2Status(),player2.toString());
	}

	@Test
	public void getRandomMove() {
		Move move = GameProcessorUtil.getRandomMove();
		if( move == Move.PAPER || move == Move.ROCK || move == Move.SCISSOR) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}
}
