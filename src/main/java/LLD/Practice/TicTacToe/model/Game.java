package LLD.Practice.TicTacToe.model;

import LLD.Practice.TicTacToe.factories.StrategySelector;
import LLD.TicTacToe.models.CellState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Game {
    Board board;
    List<Player> playersList;
    List<Move> moves;
    Player winner;
    List<Board> boards;

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public GameBuilder getGameBuilder() {
        return gameBuilder;
    }

    public int getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    int nextPlayer;
    GameState gameState;
    GameBuilder gameBuilder;

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setGameBuilder(GameBuilder gameBuilder) {
        this.gameBuilder = gameBuilder;
    }

    public void nextmove(Game game) throws Exception {
        Player curr=game.playersList.get(nextPlayer);
        Move move=curr.decideMove();
        Board board=game.board;
        Cell cells=board.cells.get(move.cell.row).get(move.cell.col);
        if(cells.cellState.equals(CellState.EMPTY)){
            game.getMoves().add(move);
            move.cell.cellState=CellState.FILLED;
            Cell cell=move.cell;
            cell.setPlayer(curr);
            game.board.cells.get(cell.row).set(cell.col,cell);
            //check winner
            if(StrategySelector.getStrategy("ROW", board.dimesnsion).isWinner(board,cell)){
                game.setGameState(GameState.COMPLETED);
                game.setWinner(curr);
                return;
            }
        }else{
            throw new Exception("Illegal Move exception");
        }
        game.getBoards().add(new Board(board,board.getDimesnsion()));
        nextPlayer=(nextPlayer+1)%playersList.size();
    }

    public static class GameBuilder{
        List<Player> playersList;
        int dimension;

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayersList(List<Player> playerList) {
            this.playersList=playerList;
            return this;
        }

        public Game build() {
            //we can have validations here
            Game game=new Game();
            Board board=new Board(this.dimension);
            game.setBoard(board);
            game.setMoves(new ArrayList<>());
            game.setPlayersList(this.playersList);
            ArrayList<Board> boards=new ArrayList<>();
            boards.add(new Board(board,dimension));
            game.setBoards(boards);
            game.setGameState(GameState.INPROGRESS);
            return game;
        }
    }
}