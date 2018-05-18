package com.rps.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rps.model.enums.Move;
import com.rps.responses.Response;

/**
 * @author Ayush Verma
 * Rest API controller for service, all calls to service
 * will land here and than mapped to corresponding flows.
 */
@RestController
public class RPSController {

	/**
	 * Maps the default game API,
	 * @return Welcome message
	 */
	@RequestMapping(value="/game", method=RequestMethod.GET)
	public Response initilizeGame() {
		RPSGameHandler handler = RPSGameHandler.getInstance();
		return handler.initializeGame();
	}

	/**
	 * Maps when user chose to play ROCK
	 * @return current status as response
	 */
	@RequestMapping(value="/rock", method=RequestMethod.GET)
	public Response processRock() {
		RPSGameHandler handler = RPSGameHandler.getInstance();
		return handler.processUserAction(Move.ROCK);
	}

	/**
	 * Maps when user chose to play PAPER
	 * @return current status as response
	 */
	@RequestMapping(value="/paper", method=RequestMethod.GET)
	public Response processPaper() {
		RPSGameHandler handler = RPSGameHandler.getInstance();
		return handler.processUserAction(Move.PAPER);
	}

	/**
	 * Maps when user chose to play SCISSOR
	 * @return current status as response
	 */
	@RequestMapping(value="/scissor", method=RequestMethod.GET)
	public Response processScissor() {
		RPSGameHandler handler = RPSGameHandler.getInstance();
		return handler.processUserAction(Move.SCISSOR);
	}
}
