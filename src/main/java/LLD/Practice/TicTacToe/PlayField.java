package LLD.Practice.TicTacToe;

import LLD.Practice.TicTacToe.Controller.GameContoller;
import LLD.Practice.TicTacToe.model.Game;
import LLD.Practice.TicTacToe.model.GameState;
import LLD.Practice.TicTacToe.model.Player;
import LLD.Practice.TicTacToe.model.PlayerType;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayField {
    public static void main(String[] args) {
        GameContoller gameContoller=new GameContoller();
        ArrayList<Player> players=new ArrayList<Player>();
        Player p1=new Player("Ranjith",'X', PlayerType.HUMAN);
        Player p2=new Player("Ajith",'O', PlayerType.HUMAN);
        players.add(p1);
        players.add(p2);
        Game game=gameContoller.createGame(3,players);
        int c=0;
        int target=9;
        while(game.getGameState().equals(GameState.INPROGRESS)){
            Scanner sc=new Scanner(System.in);
            System.out.println("Undo?");
            boolean x=sc.nextBoolean();
            if(x){
                game=gameContoller.undo(game);
                c--;
                continue;
            }

            try {
                game = gameContoller.makeMove(game);
            }catch (Exception e) {
                System.out.println("Exception encountered"+e.getMessage());
                continue;
            }
            c++;
            if(c==target){
                game.setGameState(GameState.DRAWN);
                System.out.println(" Game is DRAWN");
                return;
            }
        }
        System.out.println("Winner is "+game.getWinner().getName());
    }
}

