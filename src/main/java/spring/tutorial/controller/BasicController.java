package spring.tutorial.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spring.tutorial.dto.GameStateDto;

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
    @SendTo("/game/{roomId}/nextTurn")
    public GameStateDto nextTurn(@DestinationVariable String roomId, GameStateDto message) {
        GameStateDto gameStateDto = new GameStateDto();
        gameStateDto.setIsFinished(true);
        gameStateDto.setNextPlayer("batman");
        gameStateDto.setWinnerName("batman");
        //check if game is finished
        //if finished update accordingly including gameboard with correct
        return gameStateDto;
    }

    @MessageMapping("/createNewGame")
    @SendTo("/game/{roomId}/newGame")
    public String createNewGame(@DestinationVariable String roomId) {
        //create a room with a unique id
        //create the gamestate roomId = first player name
        // select first player as X
        //save to db
        //return roomId
        return roomId;
    }

    @MessageMapping("/getAllRooms")
    @SendTo("/game/allRooms")
    public List<String> getAllRooms() {
        return new LinkedList<>();
    }

    @MessageMapping("/joinGame")
    @SendTo("/game/{roomId}/joinGame")
    public String joinGame(@DestinationVariable String roomId) {
        //search for gameState in db that has this roomId
        return "Successfully Joined game";
    }

    @MessageMapping("/rematch")
    @SendTo("game/{roomId}/rematch")
    public GameStateDto rematch(@DestinationVariable String roomId) {
        return new GameStateDto();
    }

    @MessageMapping("/createNewUser")
    @SendTo("game/public")
    public String createNewUser(String userName) {
        //save user (Player in db)
        return "User: "+ userName + " registered.";
    }
}
