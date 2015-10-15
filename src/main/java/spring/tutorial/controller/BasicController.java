package spring.tutorial.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import spring.tutorial.dto.GameState;

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
    @SendTo("/game/grettings")
    public GameState nextTurn(String message){
        GameState gameState = new GameState();
        gameState.setIsFinished(true);
        gameState.setNextPlayer("batman");
        gameState.setWinnerName("batman");
        return gameState;
    }


}
