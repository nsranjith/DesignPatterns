package LLD.Practice.snakeAndLadder.strategy;

import LLD.Practice.snakeAndLadder.models.Board;
import LLD.Practice.snakeAndLadder.models.Move;

public interface WinningStrategy {
    boolean isWinner(Move move, Board board);
}
