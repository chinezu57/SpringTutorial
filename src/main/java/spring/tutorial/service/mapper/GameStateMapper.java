package spring.tutorial.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.tutorial.domain.GameState;
import spring.tutorial.domain.Player;
import spring.tutorial.dto.GameStateDto;

/**
 * Created by Robert on 10/15/2015.
 */
@Component
public class GameStateMapper extends AbstractMapper<GameStateDto, GameState> {

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public GameStateDto map(GameState gameState) {
        return null;
    }

    @Override
    public void map(GameStateDto gameStateDto, GameState gameState) {
        gameState.setNextPlayer(gameStateDto.getNextPlayer());
        gameState.setWinnerName(gameStateDto.getWinnerName());
        gameState.setIsFinished(gameStateDto.isFinished());
        Player player1 = new Player();
        playerMapper.map(gameStateDto.getFirstPlayerDto(), player1);
        gameState.setFirstPlayer(player1);
        playerMapper.map(gameStateDto.getSecondPlayerDto(), player1);
        gameState.setSecondPlayer(player1);
        gameState.setGameBoard(gameStateDto.getGameBoard());
        gameState.setRoomId(gameStateDto.getRoomId());
    }
}
