package LLD.TicTacToe.models;

import lombok.Getter;

@Getter
public class Move {
    Cell cell;

    public Move(Cell cell) {
        this.cell = cell;
    }
}
