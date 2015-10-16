package spring.tutorial.domain;

import spring.tutorial.dto.Cell;
import spring.tutorial.dto.Identifiable;

import javax.persistence.*;

/**
 * Created by Robert on 10/15/2015.
 */
@Entity
public class GameState implements Identifiable {
    @Id
    @GeneratedValue
    private Long id;
    private String roomId;
    private boolean isFinished;
    @OrderColumn
    private Cell[] gameBoard;
    private String winnerName;
    private String nextPlayer;
    @OneToOne
    private Player firstPlayer;
    @OneToOne
    private Player secondPlayer;

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

    public Cell[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Cell[] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
