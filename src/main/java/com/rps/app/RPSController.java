package com.rps.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rps.model.enums.Move;
import com.rps.responses.Response;

@RestController
public class RPSController {

	@RequestMapping(value="/game", method=RequestMethod.GET)
	public Response initilizeGame() {
		RPSGameHandler handler = RPSGameHandler.getInstance();
		return handler.initializeGame();
	}
	
	@RequestMapping(value="/rock", method=RequestMethod.GET)
	public Response processRock() {
		RPSGameHandler handler = RPSGameHandler.getInstance();
		return handler.processUserAction(Move.ROCK);
	}
	
	@RequestMapping(value="/paper", method=RequestMethod.GET)
	public Response processPaper() {
		RPSGameHandler handler = RPSGameHandler.getInstance();
		return handler.processUserAction(Move.PAPER);
	}
	
	@RequestMapping(value="/scissor", method=RequestMethod.GET)
	public Response processScissor() {
		RPSGameHandler handler = RPSGameHandler.getInstance();
		return handler.processUserAction(Move.SCISSOR);
	}
}
