package spring.tutorial.dto;

/**
 * Created by Robert on 10/15/2015.
 */
public class Cell {
    private CellState cellState;
    private boolean isCorrect;

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
