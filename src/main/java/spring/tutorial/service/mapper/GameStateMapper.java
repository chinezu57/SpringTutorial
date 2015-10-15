package spring.tutorial.service.mapper;

import spring.tutorial.domain.GameState;
import spring.tutorial.dto.GameStateDto;

/**
 * Created by Robert on 10/15/2015.
 */
public class GameStateMapper extends AbstractMapper<GameStateDto,GameState> {
    @Override
    public GameStateDto map(GameState gameState) {
        return null;
    }

    @Override
    public void map(GameStateDto gameStateDto, GameState gameState) {
        gameState.setNextPlayer(gameStateDto.getNextPlayer());
        gameState.setWinnerName(gameStateDto.getWinnerName());
        gameState.setIsFinished(gameStateDto.isFinished());
        gameState.setFirstPlayerDto(gameStateDto.getFirstPlayerDto());
        gameState.setSecondPlayerDto(gameStateDto.getSecondPlayerDto());
        gameState.setGameBoard(gameStateDto.getGameBoard());
        gameState.setRoomId(gameStateDto.getRoomId());
    }
}
