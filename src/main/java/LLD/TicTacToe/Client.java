package LLD.TicTacToe;

import LLD.TicTacToe.Controllers.GameController;
import LLD.TicTacToe.Exception.InvalidGame;
import LLD.TicTacToe.Exception.InvalidMove;
import LLD.TicTacToe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidGame, InvalidMove {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter dimensions of the board");
        int dimension=scanner.nextInt();

        System.out.println("Are you playing with Computer?");
        String isBot=scanner.next();

        List<Player> playerList=new ArrayList<>();
        int size=dimension-1;
        if(isBot.equals("Y")){
            size-=1;
        }
        for(int i=0;i<size;i++){
            System.out.println("Enter details of player" + i);
            String playerName= scanner.next();
            System.out.println("Enter teh symbol for player"+ i);
            String symbol=scanner.next();
            Player player=new Player(playerName, PlayerType.HUMAN, symbol.charAt(0));
            playerList.add(player);
        }
        if(isBot.equals("Y")){
            System.out.println("Enter details of Bot" );
            String playerName= scanner.next();
            System.out.println("Enter teh symbol for Bot");
            String symbol=scanner.next();
            Player player=new Bot(playerName,PlayerType.BOT, symbol.charAt(0), BotDifficulty.EASY);
            playerList.add(player);
        }
        GameController gameController=new GameController();
        Game game=gameController.creatGame(dimension, playerList);
        while (game.getGameState().equals(GameState.INPROGRESS)){
            gameController.displayBoard(game);
            System.out.println("Do you want to undo ? y/n");
            String input=scanner.next();
            if(input.equals("Y")){
                gameController.undo(game);
            }else{
                gameController.makeMove(game);

            }
        }
        System.out.println("Game  has eneded, Result is: ");
        if(gameController.getGameStatus(game).equals(GameState.END)){
            System.out.println(gameController.getWinner(game).getName()+" won the game");
        }
    }
}
