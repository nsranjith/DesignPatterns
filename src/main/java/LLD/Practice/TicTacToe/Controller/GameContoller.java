package LLD.Practice.TicTacToe.Controller;

import LLD.Practice.TicTacToe.model.Board;
import LLD.Practice.TicTacToe.model.Game;
import LLD.Practice.TicTacToe.model.Player;

import java.util.List;

public class GameContoller {

    public Game createGame(int dimension, List<Player> playerList){
        Game game= Game.getBuilder()
                .setDimension(dimension)
                .setPlayersList(playerList)
                .build();
        return game;
    }
    public Game makeMove(Game game) throws Exception {
        game.nextmove(game);
        return game;
    }
    public Game undo(Game game){
        if(game.getMoves().size()==0) {
            throw new IllegalCallerException("Invalid op");
        }
        Board board=game.getBoards().get(game.getBoards().size()-2);
        game.setBoard(board);
        game.getBoards().remove(game.getBoards().size()-1);
        game.getMoves().remove(game.getMoves().size()-1);
        if(game.getNextPlayer()==0)
            game.setNextPlayer(game.getPlayersList().size()-1);
        else
            game.setNextPlayer(game.getNextPlayer()-1); //0
        return game;
    }

}
