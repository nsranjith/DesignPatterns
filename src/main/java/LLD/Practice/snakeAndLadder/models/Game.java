package LLD.Practice.snakeAndLadder.models;

import LLD.Practice.snakeAndLadder.DiceImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Game {
    Board board;
    int nextPlayerIndex;
    List<Player> players;
    List<Move> moves;
    Player winner;
    Dice dice;
    GameState gameState;

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public static class GameBuilder {
        List<Player> players;
        int size;

        public int getSize() {
            return size;
        }

        public GameBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build() {
            Game game = new Game();
            Board board = buildBoard(size);
            Dice dice = new DiceImpl();
            game.setBoard(board);
            game.setDice(dice);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setGameState(GameState.INPROGRESS);
            return game;
        }
    }

    private static Board buildBoard(int size) {
        HashMap<Integer,SpecialEntity> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int snakeSize=sc.nextInt();
        ArrayList<SpecialEntity> specialEntities=new ArrayList<>();
        for(int i=0;i<snakeSize;i++) {
            System.out.println("Enter start and end position for Snakes");
            int start = sc.nextInt();
            int end = sc.nextInt();
            SpecialEntity specialEntity=new Snake(start,end);
            map.put(start,specialEntity);
            specialEntities.add(specialEntity);
        }
        System.out.println("Enter the number of ladders");
        int ladderSize=sc.nextInt();
        for(int i=0;i<ladderSize;i++) {
            System.out.println("Enter start and end position for Snakes");
            int start = sc.nextInt();
            int end = sc.nextInt();
            SpecialEntity specialEntity=new Ladder(start,end);
            map.put(start,specialEntity);
            specialEntities.add(specialEntity);
        }
        ArrayList<Cell> cellArrayList=new ArrayList<>();
        for(int i=0;i<size;i++){
            cellArrayList.add(new Cell(i));
        }
        return new Board(size,cellArrayList,specialEntities,map);
    }
}
