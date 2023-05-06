package LLD.TicTacToe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {

    int dimension;
    List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
        this.board=new ArrayList<>();
        for(int i=0;i<dimension;i++){
            this.board.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void display() {
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board.get(0).size();j++){
                CellState cellState = board.get(i).get(j).getCellState();
                if(cellState.equals(CellState.FILLED)){
                    char symbol=board.get(i).get(j).getPlayer().getSymbol();
                    System.out.print("| "+ symbol + " |");
                }else{
                    System.out.print("|  |");
                }
            }
            System.out.println("\n");
        }
    }
}
