package com.rps.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rps.model.enums.CommonStrings;
import com.rps.responses.GameResponse;
import com.rps.responses.Response;

public class RPSControllerTest {
	@Test
	public void testWelcomeMessage() {
		RPSController controller = new RPSController();
		Response response = controller.initilizeGame();
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getMessage(), CommonStrings.WELCOME_MESSAGE);
	}

	@Test
	public void testRockMessage() {
		RPSController controller = new RPSController();
		GameResponse response = (GameResponse) controller.processRock();
		Assert.assertNotNull(response);
		Assert.assertTrue(response.getPlayer2Status().contains("Name:HUMAN, move:ROCK"));
	}

	@Test
	public void testPaperMessage() {
		RPSController controller = new RPSController();
		GameResponse response = (GameResponse) controller.processPaper();
		Assert.assertNotNull(response);
		Assert.assertTrue(response.getPlayer2Status().contains("Name:HUMAN, move:PAPER"));
	}

	@Test
	public void testScissorMessage() {
		RPSController controller = new RPSController();
		GameResponse response = (GameResponse) controller.processScissor();
		Assert.assertNotNull(response);
		Assert.assertTrue(response.getPlayer2Status().contains("Name:HUMAN, move:SCISSOR"));
	}
}
