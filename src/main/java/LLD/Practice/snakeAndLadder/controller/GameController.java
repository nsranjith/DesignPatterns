package LLD.Practice.snakeAndLadder.controller;

import LLD.Practice.snakeAndLadder.models.Game;
import LLD.Practice.snakeAndLadder.models.Player;
import LLD.Practice.snakeAndLadder.service.GameService;

import java.util.List;

public class GameController {
    GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    public Game createGame(int size, List<Player> players){
        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .build();
    }
    public Game move(Game game){
        return gameService.move(game);
    }
}
