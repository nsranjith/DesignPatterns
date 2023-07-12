package LLD.Practice.snakeAndLadder.factory;

import LLD.Practice.snakeAndLadder.strategy.NormalWinningStrategy;
import LLD.Practice.snakeAndLadder.strategy.WinningStrategy;

public class StrategySelector {
    public static WinningStrategy getStrategy(String type){
        switch (type){
            case "NORMAL":
                return new NormalWinningStrategy();
        }
        return null;
    }
}
