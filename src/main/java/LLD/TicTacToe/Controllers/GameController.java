package LLD.TicTacToe.Controllers;

import LLD.TicTacToe.Exception.InvalidGame;
import LLD.TicTacToe.Exception.InvalidMove;
import LLD.TicTacToe.models.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    // should have all the methods for game
    public Game creatGame(int dimension, List<Player> playerList) throws InvalidGame {
        return Game.getBuilder()
                .setDimensions(dimension)
                .setPlayerList(playerList)
                .build();
    }
    public void displayBoard(Game game){
        game.displayBoard();
    }
    public GameState getGameStatus(Game game){
        return game.getGameState();
    }
    public void makeMove(Game game) throws InvalidMove {
        game.makeNextMove();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void undo(Game game) throws InvalidMove {
        if(game.getMoves().size()==0){
            throw new InvalidMove("UNDO is Invalid");
        }else{
            game.setBoard(game.getBoards().get(game.getBoards().size()-2));
            game.getMoves().remove(game.getMoves().size()-1);
            game.getBoards().remove(game.getBoards().size()-1);
            System.out.println("Undo completed");
            game.setNextPlayerIndex(game.getNextPlayerIndex()-1);
        }
    }
}
