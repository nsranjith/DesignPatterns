package LLD.Practice.TicTacToe.factories;

import LLD.Practice.TicTacToe.strategy.RowWinningStrategy;
import LLD.Practice.TicTacToe.strategy.WinningStrategy;

public class StrategySelector {
    public static WinningStrategy getStrategy(String type,int dim){
        WinningStrategy winningStrategy=null;
        switch (type){
            case "ROW":
                winningStrategy=RowWinningStrategy.getInstance(dim);
                break;
        }
        return winningStrategy;
    }
}
