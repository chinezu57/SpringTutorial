package spring.tutorial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.tutorial.domain.GameState;
import spring.tutorial.domain.Player;
import spring.tutorial.dto.Cell;
import spring.tutorial.dto.CellState;
import spring.tutorial.dto.GameStateDto;
import spring.tutorial.dto.PlayerDto;
import spring.tutorial.repository.GameStateRepository;
import spring.tutorial.repository.PlayerRepository;
import spring.tutorial.service.GameStateService;
import spring.tutorial.service.mapper.GameStateMapper;
import spring.tutorial.service.mapper.PlayerMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cristian Ilca, Catalysts Romania on 16-Oct-15.
 */
@Service
public class GameStateServiceImpl implements GameStateService{

    private GameStateRepository gameStateRepository;
    private PlayerRepository playerRepository;
    private GameStateMapper gameStateMapper;
    private PlayerMapper playerMapper;

    @Autowired
    public GameStateServiceImpl(GameStateRepository gameStateRepository, PlayerRepository playerRepository, GameStateMapper gameStateMapper, PlayerMapper playerMapper) {
        this.gameStateRepository = gameStateRepository;
        this.playerRepository = playerRepository;
        this.gameStateMapper = gameStateMapper;
        this.playerMapper = playerMapper;
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
            Player player1 = new Player();
            playerMapper.map(player, player1);
            gameState.setFirstPlayer(player1);
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

    @Override
    public List<GameStateDto> getAllActiveGames() {
        LinkedList<GameStateDto> gameStateDtos = (LinkedList<GameStateDto>) gameStateMapper.map(gameStateRepository.findByIsFinished(false));
        return gameStateDtos;
    }

    @Override
    public GameState joinGame(String roomId, String userName) {
        GameState gameState = gameStateRepository.findByRoomId(roomId);
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName(userName);
        playerDto.setWeapon("O");
        Player player1 = new Player();
        playerMapper.map(playerDto, player1);
        gameState.setSecondPlayer(player1);
        return gameStateRepository.save(gameState);
    }

    @Override
    public GameStateDto rematch(String roomId) {
        GameState gameState = gameStateRepository.findByRoomId(roomId);
        GameState newGameState = new GameState();
        newGameState.setRoomId(roomId);
        newGameState.setFirstPlayer(gameState.getFirstPlayer());
        newGameState.setSecondPlayer(gameState.getSecondPlayer());
        newGameState.setIsFinished(false);
        newGameState.setGameBoard(new LinkedList<Cell>());
        newGameState.setNextPlayer(gameState.getFirstPlayer().getName());
        return gameStateMapper.map(gameStateRepository.save(newGameState));
    }
}
