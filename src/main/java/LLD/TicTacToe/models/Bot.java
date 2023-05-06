package LLD.TicTacToe.models;

import LLD.TicTacToe.BotPlayingStrategyFactory;
import LLD.TicTacToe.Exception.InvalidMove;
import LLD.TicTacToe.Strategies.BotPlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bot extends  Player{
    BotDifficulty botDifficulty;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, PlayerType type, char symbol, BotDifficulty botDifficulty) {
        super(name, type, symbol);
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyFactory(botDifficulty);
    }

    public Move decideMove(Board board) throws InvalidMove {
        return botPlayingStrategy.decideMove(board);
    }



}
