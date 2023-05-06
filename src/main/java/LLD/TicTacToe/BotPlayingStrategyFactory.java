package LLD.TicTacToe;

import LLD.TicTacToe.Strategies.BotPlayingStrategy;
import LLD.TicTacToe.Strategies.RandomBotStrategy;
import LLD.TicTacToe.models.BotDifficulty;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficulty botDifficulty){
        return new RandomBotStrategy();
    }
}
