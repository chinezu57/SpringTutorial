package spring.tutorial.domain;

import spring.tutorial.dto.Cell;
import spring.tutorial.dto.Identifiable;
import spring.tutorial.dto.PlayerDto;

import java.util.List;

/**
 * Created by Robert on 10/15/2015.
 */
public class GameState implements Identifiable{

    private Long id;
    private String roomId;
    private boolean isFinished;
    private List<Cell> gameBoard;
    private String winnerName;
    private String nextPlayer;
    private PlayerDto firstPlayerDto;
    private PlayerDto secondPlayerDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public List<Cell> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(List<Cell> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(String nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public PlayerDto getFirstPlayerDto() {
        return firstPlayerDto;
    }

    public void setFirstPlayerDto(PlayerDto firstPlayerDto) {
        this.firstPlayerDto = firstPlayerDto;
    }

    public PlayerDto getSecondPlayerDto() {
        return secondPlayerDto;
    }

    public void setSecondPlayerDto(PlayerDto secondPlayerDto) {
        this.secondPlayerDto = secondPlayerDto;
    }
}
