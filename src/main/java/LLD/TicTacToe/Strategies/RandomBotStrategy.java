package LLD.TicTacToe.Strategies;

import LLD.TicTacToe.Exception.InvalidMove;
import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Cell;
import LLD.TicTacToe.models.CellState;
import LLD.TicTacToe.models.Move;

public class RandomBotStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Board board) throws InvalidMove {
        for(int i=0;i<board.getDimension();i++){
            for(int j=0;j<board.getDimension();j++){
                Cell cell= board.getBoard().get(i).get(j);
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell);
                }
            }
        }
        throw  new InvalidMove("No Moves decided");
    }
}
