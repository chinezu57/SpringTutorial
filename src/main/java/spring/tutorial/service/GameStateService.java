package spring.tutorial.service;

import spring.tutorial.domain.GameState;
import spring.tutorial.domain.Player;
import spring.tutorial.dto.GameStateDto;

/**
 * @author Cristian Ilca, Catalysts Romania on 16-Oct-15.
 */
public interface GameStateService {
    boolean gameStateFinishedCheck(GameStateDto gameStateDto);

    GameState createNewGame(String roomId);

    Player saveUser(String username);
}
