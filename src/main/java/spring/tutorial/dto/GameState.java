package spring.tutorial.dto;

import java.util.List;

/**
 * Created by Robert on 10/15/2015.
 */
public class GameState {

    private boolean isFinished;
    private List<CellState> gameBoard;
    private String winnerName;
    private String nextPlayer;

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public List<CellState> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(List<CellState> gameBoard) {
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
}
