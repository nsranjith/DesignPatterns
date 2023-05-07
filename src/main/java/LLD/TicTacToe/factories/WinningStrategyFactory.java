package LLD.TicTacToe.factories;

import LLD.TicTacToe.Strategies.GameWinningStrategy;
import LLD.TicTacToe.Strategies.WinningStrategy;
import LLD.TicTacToe.models.Board;
import LLD.TicTacToe.models.Cell;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategyFor(String strategy, int dimension){
        switch (strategy){
            case "ROW":
                return GameWinningStrategy.getGameWinningStrategy(dimension);
        }
        return GameWinningStrategy.getGameWinningStrategy(dimension);
    }

}
