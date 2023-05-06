package LLD.TicTacToe.Controllers;

import LLD.TicTacToe.Exception.InvalidGame;
import LLD.TicTacToe.Exception.InvalidMove;
import LLD.TicTacToe.models.*;

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
    public void undo(Game game){
    }


}
