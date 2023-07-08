package LLD.Practice.TicTacToe.strategy;

import LLD.Practice.TicTacToe.model.Board;
import LLD.Practice.TicTacToe.model.Cell;

public interface WinningStrategy {
    boolean isWinner(Board board, Cell cell);
}
