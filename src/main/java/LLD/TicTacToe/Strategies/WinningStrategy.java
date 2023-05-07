package LLD.TicTacToe.Strategies;

import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Cell;

public interface WinningStrategy{
    public boolean checkWinner(Board board, Cell cell);
}
