package spring.tutorial.dto;

import java.util.List;

/**
 * Created by Robert on 10/15/2015.
 */
public class GameState {

    private String roomId;
    private boolean isFinished;
    private List<Cell> gameBoard;
    private String winnerName;
    private String nextPlayer;
    private Player firstPlayer;
    private Player secondPlayer;

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

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
