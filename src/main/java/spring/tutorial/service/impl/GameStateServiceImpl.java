package spring.tutorial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.tutorial.domain.GameState;
import spring.tutorial.domain.Player;
import spring.tutorial.dto.CellState;
import spring.tutorial.dto.GameStateDto;
import spring.tutorial.dto.PlayerDto;
import spring.tutorial.repository.GameStateRepository;
import spring.tutorial.repository.PlayerRepository;
import spring.tutorial.service.GameStateService;

/**
 * @author Cristian Ilca, Catalysts Romania on 16-Oct-15.
 */
@Service
public class GameStateServiceImpl implements GameStateService{

    private GameStateRepository gameStateRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public GameStateServiceImpl(GameStateRepository gameStateRepository, PlayerRepository playerRepository) {
        this.gameStateRepository = gameStateRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public boolean gameStateFinishedCheck(GameStateDto gameStateDto) {
        if(gameStateDto.getGameBoard().contains(CellState.EMPTY)) {

            return true;
        }
        return false;
    }

    @Override
    public GameState createNewGame(String roomId) {
        GameState gameState = gameStateRepository.findByRoomId(roomId);
        if(gameState == null) {
            gameState = new GameState();
            PlayerDto player = new PlayerDto();
            player.setName(roomId);
            player.setWeapon(CellState.X.toString());
            gameState.setFirstPlayerDto(player);
        }

        return null;
    }

    @Override
    public Player saveUser(String username) {
        Player player = playerRepository.findByName(username);
        if(player == null) {
            player = new Player();
            player.setName(username);
            playerRepository.save(player);
        }
        return player;
    }
}
