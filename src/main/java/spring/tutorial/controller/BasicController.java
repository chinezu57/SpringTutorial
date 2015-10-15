package spring.tutorial.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spring.tutorial.dto.GameState;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Robert on 10/11/2015.
 */

@Controller
public class BasicController extends WebMvcConfigurerAdapter {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "index";
    }

    @MessageMapping("/nextTurn")
    @SendTo("/game/{greetings}")
    public GameState nextTurn(String message) {
        GameState gameState = new GameState();
        gameState.setIsFinished(true);
        gameState.setNextPlayer("batman");
        gameState.setWinnerName("batman");
        return gameState;
    }

    @MessageMapping("/createNewGame")
    @SendTo("/game/{roomId}")
    public String createNewGame(@DestinationVariable String roomId) {
        //create a room with a unique id
        return roomId;
    }

    @MessageMapping("/getAllRooms")
    @SendTo("/game/allRooms")
    public List<String> getAllRooms() {
        return new LinkedList<>();
    }

    @MessageMapping("/joinGame")
    @SendTo("/game/{roomId}")
    public String joinGame(@DestinationVariable String roomId) {
        return "Successfully Joined game";
    }

    @MessageMapping("/rematch")
    @SendTo("game/{roomId}")
    public GameState rematch(@DestinationVariable String roomId) {
        return new GameState();
    }

    @MessageMapping("/createNewUser")
    @SendTo("game/public")
    public String createNewUser(String userName) {
        return "User: "+ userName + " registered.";
    }
}
