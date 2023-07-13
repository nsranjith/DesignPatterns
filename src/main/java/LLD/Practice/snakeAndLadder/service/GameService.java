package LLD.Practice.snakeAndLadder.service;

import LLD.Practice.snakeAndLadder.factory.StrategySelector;
import LLD.Practice.snakeAndLadder.models.*;

import java.util.List;

public class GameService {
    public Game move(Game game){
        List<Player> players=game.getPlayers();
        Player currPlayer=players.get(game.getNextPlayerIndex());
        Move move=((HumanPlayer)currPlayer).makeMove(currPlayer,game.getDice());
        if(StrategySelector.getStrategy("NORMAL").isWinner(move,game.getBoard())){
            game.setWinner(currPlayer);
            game.setGameState(GameState.COMPLETED);
            return game;
        }else{
            game.getMoves().add(move);
            game.setNextPlayerIndex((game.getNextPlayerIndex()+1)%game.getPlayers().size());
            return game;
        }
    }
}
