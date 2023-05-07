package LLD.TicTacToe.models;

import LLD.TicTacToe.Exception.InvalidGame;
import LLD.TicTacToe.Exception.InvalidMove;
import LLD.TicTacToe.Strategies.GameWinningStrategy;
import LLD.TicTacToe.Strategies.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;

    public WinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    List<Player> playerList;
    List<Move> moves;
    int nextPlayerIndex;
    Player winner;
    GameState gameState;
    WinningStrategy gameWinningStrategy;

    public static Builder getBuilder(){
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void displayBoard(){
        this.board.display();
    }
    public void makeNextMove() throws InvalidMove {
        Player playerToMove=this.playerList.get(nextPlayerIndex);
        System.out.println("Player "+playerToMove.getName() +" is making the move");
        Move move=playerToMove.decideMove(this.board);
        Cell cell=move.getCell();
        if(cell.getCellState().equals(CellState.EMPTY)){
            this.getMoves().add(move);
            cell.setCellState(CellState.FILLED);
            cell.setPlayer(playerToMove);
            board.getBoard().get(cell.row).set(cell.col, cell);
            if(gameWinningStrategy.checkWinner(board,cell)){
                this.gameState=GameState.END;
                winner=playerToMove;
            }
        }else{
            throw new InvalidMove("Invalid Move exception");
        }
        nextPlayerIndex=(nextPlayerIndex+1)%(playerList.size());
    }

    public static class Builder{
        //Board board; as board is not required
        int dimensions;
        List<Player> playerList;
//        List<Move> moves;
//        int nextPlayerIndex;  can be set to deafult
        Player winner;
//        GameState gameState; can be set to deafult
        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }
        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }
        public Builder setWinner(Player winner) {
            this.winner = winner;
            return this;
        }
        boolean isValid() throws InvalidGame {
            if(dimensions<3){
                return false;
            }
            if(playerList.size()!=dimensions-1){
                throw new InvalidGame("Number of players should be equal to dimesnion -1");
            }
            return true;
        }
        public Game build() throws InvalidGame {
            try {
                 isValid();
            }catch (Exception e){
                throw  e;
            }
            Game game=new Game();
            game.setGameState(GameState.INPROGRESS);
            game.setPlayerList(playerList);
            game.setNextPlayerIndex(0);
            game.setBoard(new Board(dimensions));
            game.setMoves(new ArrayList<>());
            game.setGameWinningStrategy(new GameWinningStrategy(dimensions));
            return game;
        }
    }
}
