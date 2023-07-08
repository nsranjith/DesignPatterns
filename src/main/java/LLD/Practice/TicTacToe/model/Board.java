package LLD.Practice.TicTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    int dimesnsion;
    List<List<Cell>> cells;

    public Board(Board board, int dimension) {
        this.cells=new ArrayList<>();
        this.dimesnsion=dimension;
        for(int i=0;i<dimesnsion;i++){
            this.cells.add(new ArrayList<>());
            for(int j=0;j<dimesnsion;j++){
                Cell old=board.getCells().get(i).get(j);
                Cell newCell=new Cell(i,j);
                newCell.cellState=old.cellState;
                this.cells.get(i).add(newCell);
            }
        }
    }

    public int getDimesnsion() {
        return dimesnsion;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setDimesnsion(int dimesnsion) {
        this.dimesnsion = dimesnsion;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public Board(int dimesnsion) {
        this.dimesnsion = dimesnsion;
        this.cells=new ArrayList<>();
        for(int i=0;i<dimesnsion;i++){
            this.cells.add(new ArrayList<>());
            for(int j=0;j<dimesnsion;j++){
                this.cells.get(i).add(new Cell(i,j));
            }
        }
    }
}
