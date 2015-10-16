package spring.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.TextMessage;
import spring.tutorial.domain.GameState;
import spring.tutorial.dto.GameStateDto;
import spring.tutorial.service.GameStateService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robert on 10/11/2015.
 */

@Controller
public class BasicController extends WebMvcConfigurerAdapter {

    private GameStateService gameStateService;
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public BasicController(GameStateService gameStateService, SimpMessagingTemplate simpMessagingTemplate) {
        this.gameStateService = gameStateService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "index";
    }

    @MessageMapping("/nextTurn")
    @SendTo("/game/{roomId}/nextTurn")
    public GameStateDto nextTurn(@DestinationVariable String roomId, GameStateDto message) {
        GameStateDto gameStateDto = new GameStateDto();
        gameStateDto.setIsFinished(true);
        gameStateDto.setNextPlayer("batman");
        gameStateDto.setWinnerName("batman");
        gameStateDto.setIsFinished(gameStateService.gameStateFinishedCheck(gameStateDto));
        return gameStateDto;
    }

    @MessageMapping("/createNewGame/{roomId}")
    @SendTo("/game/{roomId}/newGame")
    public String createNewGame(@DestinationVariable String roomId, String room) {
        GameState gameState = gameStateService.createNewGame(room);
        return room;
    }

    @MessageMapping("/getAllRooms")
    @SendTo("/game/allRooms")
    public List<GameStateDto> getAllRooms() {
        return gameStateService.getAllActiveGames();
    }

    @MessageMapping("/joinGame")
    @SendTo("/game/{roomId}/joinGame")
    public String joinGame(@DestinationVariable String roomId, String userName) {
        gameStateService.joinGame(roomId, userName);
        return "Successfully Joined game";
    }

    @MessageMapping("/rematch")
    @SendTo("/game/{roomId}/rematch")
    public GameStateDto rematch(@DestinationVariable String roomId) {
        gameStateService.rematch(roomId);
        return new GameStateDto();
    }

    @MessageMapping("/createNewUser")
    @SendTo("/game/public")
    public String createNewUser(String userName) {
        gameStateService.saveUser(userName);
        return userName;
    }
}
