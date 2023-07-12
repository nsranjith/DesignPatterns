package LLD.Practice.snakeAndLadder.strategy;

import LLD.Practice.snakeAndLadder.models.Board;
import LLD.Practice.snakeAndLadder.models.Move;

public class NormalWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinner(Move move, Board board) {
       if(move.getCell().getIndex()==board.getSize()-1) return true;
       return false;
    }
}
