package LLD.TicTacToe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    Player player;
    int row;
    int col;
    CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState=CellState.EMPTY;
    }
}
