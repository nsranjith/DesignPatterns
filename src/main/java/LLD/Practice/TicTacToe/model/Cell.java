package LLD.Practice.TicTacToe.model;

import LLD.TicTacToe.models.CellState;
import lombok.AllArgsConstructor;
import lombok.Builder;

public class Cell {
    int row;
    int col;
    char Symbol;
    Player player;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    CellState cellState;

    public Cell(int row, int col) {
        this.row=row;
        this.col=col;
        this.cellState=CellState.EMPTY;
    }
}
