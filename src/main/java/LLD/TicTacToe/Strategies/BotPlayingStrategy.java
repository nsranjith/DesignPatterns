package LLD.TicTacToe.Strategies;

import LLD.TicTacToe.Exception.InvalidMove;
import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Move;

public interface BotPlayingStrategy {

    public Move decideMove(Board board) throws InvalidMove;
}
