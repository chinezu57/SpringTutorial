package spring.tutorial.dto;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Robert on 10/15/2015.
 */
public class GameStateDto implements Identifiable {

    private Long id;
    private String roomId;
    private boolean isFinished;
    private List<Cell> gameBoard;
    private String winnerName;
    private String nextPlayer;
    private PlayerDto firstPlayerDto;
    private PlayerDto secondPlayerDto;

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Cell[] getGameBoard() {
        return gameBoard.toArray(new Cell[9]);
    }

    public void setGameBoard(Cell[] gameBoard) {
        this.gameBoard = Arrays.asList(gameBoard);
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cell> getGameBoardList() {
        return gameBoard;
    }
}
